package com.github.n1ay.icey.controller.dto.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueValueValidator.class)
public @interface UniqueValue {
    String message() default "Field value is not unique for selected class";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    String getterMethodName();
    Class<?> modelClass();
    Class<?> repositoryClass();
}
