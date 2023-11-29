package com.cmsbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class CmsbackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(CmsbackendApplication.class, args);
    }

}
