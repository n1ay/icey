package com.github.n1ay.icey.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
public class Home {
    @Bean
    @Profile("dev")
    public String testIndex() {
        return "test";
    }

    @Bean
    @Profile("prod")
    String index() {
        return "Hello World!";
    }
}
