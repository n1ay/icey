package com.github.n1ay.icey.controller;

import com.github.n1ay.icey.controller.dto.UserRegistrationDto;
import com.github.n1ay.icey.data.model.User;
import com.github.n1ay.icey.data.repository.UserRepository;
import com.github.n1ay.icey.service.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class UserRegistrationController {

    private final UserRegistrationService userRegistrationService;

    @Autowired
    public UserRegistrationController(UserRegistrationService userRegistrationService) {
        this.userRegistrationService = userRegistrationService;
    }

    @ModelAttribute("user")
    public UserRegistrationDto userRegistartionDto() {
        return new UserRegistrationDto();
    }

    @GetMapping
    public String showRegisterForm() {
        return "register";
    }

    @PostMapping
    public String registerUser(@ModelAttribute("user") @Valid UserRegistrationDto userRegistrationDto,
                               BindingResult result) {
        if (result.hasErrors()) {
            return "register";
        }

        userRegistrationService.registerUser(userRegistrationDto);
        return "redirect:/register?success";
    }
}
