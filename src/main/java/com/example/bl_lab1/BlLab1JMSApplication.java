package com.example.bl_lab1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class BlLab1JMSApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlLab1JMSApplication.class, args);
        System.out.println("SWAGGER: http://localhost:9090/api/swagger-ui/index.html#/");
    
    }

}
