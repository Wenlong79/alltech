package com.wl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@ComponentScan({"com.wl.controller", "com.wl.service"})
@EntityScan("com.wl.entity")
@EnableJpaRepositories("com.wl.repository")
public class MicroserviceCustomerOrderBothApplication {

    @Value("${address.service.url}")
    private String customerServiceUrl;

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceCustomerOrderBothApplication.class, args);
    }

    @Bean
    public WebClient webClient () {
        WebClient webClient =WebClient.builder()
                .baseUrl(customerServiceUrl).build();

        return webClient;
    }

}
