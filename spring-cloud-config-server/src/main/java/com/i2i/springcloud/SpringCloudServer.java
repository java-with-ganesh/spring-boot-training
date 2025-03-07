package com.i2i.springcloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class SpringCloudServer {
    public static void main(String[] a){
        SpringApplication.run(SpringCloudServer.class);
    }

}
