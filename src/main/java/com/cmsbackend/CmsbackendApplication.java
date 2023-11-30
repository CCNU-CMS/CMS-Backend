package com.cmsbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
<<<<<<< HEAD
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

=======

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


>>>>>>> b233bc2ca4da47574457eaab11cbf5f2655a94e3
@SpringBootApplication
@EnableJpaRepositories
public class CmsbackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(CmsbackendApplication.class, args);
    }

}
