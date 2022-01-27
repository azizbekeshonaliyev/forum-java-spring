package com.example.springjpamanytoone;

import com.example.springjpamanytoone.repository.impl.BaseRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaAuditing
@EnableJpaRepositories(repositoryBaseClass = BaseRepositoryImpl.class)
public class SpringJpaManyToOneApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringJpaManyToOneApplication.class, args);
    }

}
