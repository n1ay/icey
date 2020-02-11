package com.github.n1ay.icey;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import java.util.Collections;

@SpringBootApplication
public class Launcher extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Launcher.class);
        app.setDefaultProperties(Collections.singletonMap("server.port", 8880));
        app.run(args);
    }
}
