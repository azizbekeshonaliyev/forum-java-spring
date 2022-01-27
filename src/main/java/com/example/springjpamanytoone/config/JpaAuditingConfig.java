package com.example.springjpamanytoone.config;

import com.example.springjpamanytoone.entity.User;
import com.example.springjpamanytoone.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

@Configuration
public class JpaAuditingConfig {

    private final UserRepository userRepository;

    public JpaAuditingConfig(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Bean
    public AuditorAware<User> userAuditorAware(){
        return new AuditorAware<User>() {
            @Override
            public Optional<User> getCurrentAuditor() {
                return Optional.empty();
            }
        };
    }
}
