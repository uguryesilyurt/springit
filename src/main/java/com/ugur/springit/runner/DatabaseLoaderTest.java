package com.ugur.springit.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class DatabaseLoaderTest implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        // do some database work
        System.out.println("Database Loader...");
    }
}
