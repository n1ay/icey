package com.github.n1ay.icey;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
public class Launcher {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Launcher.class);
        app.setDefaultProperties(Collections.singletonMap("server.port", 8880));
        app.run(args);
    }
}
