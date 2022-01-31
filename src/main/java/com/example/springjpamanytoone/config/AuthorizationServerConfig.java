package com.example.springjpamanytoone.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
    private final AuthenticationManager authenticationManager;
    private final BCryptPasswordEncoder passwordEncoder;

    @Value("${spring.security.oauth2.resourceserver.opaquetoken.client-id}")
    private String clientId;

    @Value("${spring.security.oauth2.resourceserver.opaquetoken.client-secret}")
    private String clientSecret;

    @Value("${spring.security.oauth2.client.sign-in-key}")
    private String signKey;

    public AuthorizationServerConfig(
            AuthenticationConfiguration authenticationConfiguration,
            BCryptPasswordEncoder passwordEncoder) throws Exception {
        this.authenticationManager =
                authenticationConfiguration.getAuthenticationManager();
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void configure(
            ClientDetailsServiceConfigurer clients
    ) throws Exception {
        clients.inMemory()
                .withClient(clientId)
                .authorizedGrantTypes("password","refresh_token")
                .secret(passwordEncoder.encode(clientSecret))
                .scopes("all")
                .accessTokenValiditySeconds(1000)
                .refreshTokenValiditySeconds(24000)
                .resourceIds("api");
    }

    @Override
    public void configure(
            AuthorizationServerEndpointsConfigurer endpoints
    ) throws Exception {
        endpoints
                .tokenStore(new JwtTokenStore(createAccessTokenConverter()))
                .accessTokenConverter(createAccessTokenConverter())
                .authenticationManager(authenticationManager);
    }

    private JwtAccessTokenConverter createAccessTokenConverter() {
        JwtAccessTokenConverter jwt = new JwtAccessTokenConverter();
        jwt.setSigningKey(signKey);
        return jwt;
    }
}
