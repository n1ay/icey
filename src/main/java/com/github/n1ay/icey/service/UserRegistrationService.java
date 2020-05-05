package com.github.n1ay.icey.service;

import com.github.n1ay.icey.controller.dto.UserRegistrationDto;
import com.github.n1ay.icey.data.model.Role;
import com.github.n1ay.icey.data.model.User;
import com.github.n1ay.icey.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserRegistrationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserRegistrationService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerUser(UserRegistrationDto userRegistrationDto) {
        User user = new User();
        user.setEmail(userRegistrationDto.getEmail());
        user.setPassword(passwordEncoder.encode(userRegistrationDto.getPassword()));
        user.setRoles(Role.getUserRoleSet());
        userRepository.save(user);
    }
}
