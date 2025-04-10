package com.i2i;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableFeignClients
@EnableJpaAuditing
@ExceptionHandler
@EnableJpaRepositories(basePackages = {"com.ideas2it.spring_source_service.repository", "com.ideas2it.audit.repository","com.i2i"})
@EntityScan(basePackages = {"com.ideas2it.spring_source_service.model", "com.ideas2it.audit.model","com.i2i"})
@ComponentScan(basePackages = {"com.ideas2it.spring_source_service", "com.ideas2it.audit","com.i2i"})
public class VitalSignApplication {

    public static void main(String[] args) {
        SpringApplication.run(VitalSignApplication.class);
    }
}
