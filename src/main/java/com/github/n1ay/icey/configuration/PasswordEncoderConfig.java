package com.github.n1ay.icey.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class PasswordEncoderConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new PasswordEncoder() {
            @Override
            public String encode(CharSequence plaintextPassword) {
                return BCrypt.hashpw(plaintextPassword.toString(), BCrypt.gensalt());
            }

            @Override
            public boolean matches(CharSequence plaintextPassword, String hashedPassword) {
                return BCrypt.checkpw(plaintextPassword.toString(), hashedPassword);
            }
        };
    }
}
