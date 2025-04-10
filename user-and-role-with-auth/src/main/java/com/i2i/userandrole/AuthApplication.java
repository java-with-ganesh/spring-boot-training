package com.i2i.userandrole;


import com.i2i.ExceptionHandler;
import com.i2i.userandrole.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
@ExceptionHandler
public class AuthApplication {

    public static void main(String[] a){
        SpringApplication.run(AuthApplication.class);
    }
}


