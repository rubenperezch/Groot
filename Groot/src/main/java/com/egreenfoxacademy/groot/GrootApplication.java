package com.egreenfoxacademy.groot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GrootApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(GrootApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
