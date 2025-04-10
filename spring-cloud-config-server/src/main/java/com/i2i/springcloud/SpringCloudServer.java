package com.i2i.springcloud;


import com.i2i.ExceptionHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
@ExceptionHandler
public class SpringCloudServer {
    public static void main(String[] a){
        SpringApplication.run(SpringCloudServer.class);
    }

}
