package com.example.springjpamanytoone;

import com.example.springjpamanytoone.repository.impl.BaseRepositoryImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@SpringBootApplication
@EnableJpaAuditing
@EnableAuthorizationServer
@EnableJpaRepositories(repositoryBaseClass = BaseRepositoryImpl.class)
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
