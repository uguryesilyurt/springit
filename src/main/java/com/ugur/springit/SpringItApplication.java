package com.ugur.springit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringItApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringItApplication.class, args);
        System.out.println("Welcome to Springit!");
    }

}
