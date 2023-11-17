package com.wl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.wl.controller", "com.wl.service"})
@EntityScan("com.wl.entity")
@EnableJpaRepositories("com.wl.repository")
public class MicroserviceCustomerOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceCustomerOrderApplication.class, args);
    }

}
