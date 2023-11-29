package com.cmsbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
<<<<<<< HEAD
<<<<<<< HEAD
=======
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
>>>>>>> dev_mumu

=======
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
>>>>>>> 1f8703219cb13c8f44d4207e495aa073de7758dc
@SpringBootApplication
@EnableJpaRepositories
public class CmsbackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(CmsbackendApplication.class, args);
    }

}
