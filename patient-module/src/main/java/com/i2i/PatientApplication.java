package com.i2i;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableFeignClients
@EnableJpaAuditing
@ExceptionHandler
public class PatientApplication {

    public static void main(String[] args){
        SpringApplication.run(PatientApplication.class);
    }
}
