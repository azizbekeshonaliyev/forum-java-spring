package com.example.springjpamanytoone.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;

@Configuration
@EnableGlobalAuthentication
public class AuthorizeServerConfig extends AuthorizationServerConfigurerAdapter {
    AuthenticationManager authenticationManager;

    @Value("${spring.security.oauth2.resourceserver.opaquetoken.client-id}")
    private String clientId;

    @Value("${spring.security.oauth2.resourceserver.opaquetoken.client-secret}")
    private String clientSecret;
    public AuthorizeServerConfig(
            AuthenticationConfiguration authenticationConfiguration
    ) throws Exception {
        this.authenticationManager =
                authenticationConfiguration.getAuthenticationManager();
    }

    @Override
    public void configure(
            ClientDetailsServiceConfigurer clients
    ) throws Exception {
        clients.inMemory()
                .withClient(clientId)
                .authorizedGrantTypes("password")
                .secret(clientSecret)
                .scopes("all");
    }

    @Override
    public void configure(
            AuthorizationServerEndpointsConfigurer endpoints
    ) throws Exception {
        endpoints.authenticationManager(authenticationManager);
    }
}
