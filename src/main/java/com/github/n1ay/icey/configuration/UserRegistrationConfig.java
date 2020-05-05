package com.github.n1ay.icey.configuration;

import com.github.n1ay.icey.data.repository.UserRepository;
import com.github.n1ay.icey.service.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class UserRegistrationConfig {

    private final UserRepository userRepository;

    @Autowired
    public UserRegistrationConfig(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserRegistrationService userRegistrationService() {
        return new UserRegistrationService(userRepository, passwordEncoder());
    }
}
