package com.example.springjpamanytoone;

import com.example.springjpamanytoone.repository.impl.BaseRepositoryImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@EnableJpaAuditing
@EnableJpaRepositories(repositoryBaseClass = BaseRepositoryImpl.class)
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringJpaManyToOneApplication implements CommandLineRunner {

    private final PasswordEncoder passwordEncoder;

    public SpringJpaManyToOneApplication(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringJpaManyToOneApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(passwordEncoder.encode("bek96"));
    }
}
