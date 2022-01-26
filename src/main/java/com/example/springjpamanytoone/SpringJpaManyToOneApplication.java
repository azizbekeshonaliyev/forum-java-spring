package com.example.springjpamanytoone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringJpaManyToOneApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringJpaManyToOneApplication.class, args);
    }

}
