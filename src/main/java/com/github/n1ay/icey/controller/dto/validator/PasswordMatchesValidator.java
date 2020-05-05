package com.github.n1ay.icey.controller.dto.validator;

import com.github.n1ay.icey.controller.dto.UserRegistrationDto;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, UserRegistrationDto> {

    @Override
    public boolean isValid(UserRegistrationDto userRegistrationDto, ConstraintValidatorContext context) {
        return StringUtils.equals(userRegistrationDto.getPassword(), userRegistrationDto.getConfirmPassword());
    }
}
