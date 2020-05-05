package com.github.n1ay.icey.controller.dto;

import com.github.n1ay.icey.controller.dto.validator.PasswordMatches;
import com.github.n1ay.icey.controller.dto.validator.UniqueValue;
import com.github.n1ay.icey.data.model.User;
import com.github.n1ay.icey.data.repository.UserRepository;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@PasswordMatches
public class UserRegistrationDto {

    @UniqueValue(getterMethodName = "getEmail", modelClass = User.class, repositoryClass = UserRepository.class)
    @Email
    @NotEmpty
    private String email;

    @NotEmpty
    private String password;

    @NotEmpty
    private String confirmPassword;

    @AssertTrue
    private boolean termsAccepted;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public boolean isTermsAccepted() {
        return termsAccepted;
    }

    public void setTermsAccepted(boolean termsAccepted) {
        this.termsAccepted = termsAccepted;
    }
}
