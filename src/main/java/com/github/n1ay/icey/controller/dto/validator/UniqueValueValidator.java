package com.github.n1ay.icey.controller.dto.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.repository.CrudRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.ValidationException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class UniqueValueValidator implements ConstraintValidator<UniqueValue, Object> {
    private final ApplicationContext context;
    private String getterMethodName;
    private Class<?> modelClass;
    private Class<?> repositoryClass;

    @Autowired
    public UniqueValueValidator(ApplicationContext context) {
        this.context = context;
    }

    @Override
    public void initialize(UniqueValue constraintAnnotation) {
        this.getterMethodName = constraintAnnotation.getterMethodName();
        this.modelClass = constraintAnnotation.modelClass();
        this.repositoryClass = constraintAnnotation.repositoryClass();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        checkPropertiesInitialized();
        try {
            CrudRepository repository = (CrudRepository) this.context.getBean(repositoryClass);
            Iterable objects = repository.findAll();
            for (Object object: objects) {
                Method getterMethod = modelClass.getMethod(getterMethodName);
                Object fieldValue = getterMethod.invoke(object);
                if (value.equals(fieldValue)) {
                    return false;
                }
            }
        } catch (ClassCastException
                | NoSuchMethodException
                | IllegalAccessException
                | InvocationTargetException e) {
            throw new ValidationException("Unexpected exception occurred during field processing: " + e.getMessage());
        }

        return true;
    }

    private void checkPropertiesInitialized() {
        if (getterMethodName == null) {
            throw new ValidationException(getNotInitializedPropertyMessage("getterMethodName"));
        } else if (modelClass == null) {
            throw new ValidationException(getNotInitializedPropertyMessage("modelClass"));
        } else if (repositoryClass == null) {
            throw new ValidationException(getNotInitializedPropertyMessage("repositoryClass"));
        }
    }

    private String getNotInitializedPropertyMessage(String propertyName) {
        return "Missing " + propertyName + " for " + UniqueValue.class.getSimpleName() + "annotation";
    }
}
