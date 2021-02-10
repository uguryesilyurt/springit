package com.ugur.springit.domain.validator;

import com.ugur.springit.domain.User;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordsMatchValidator implements ConstraintValidator<PasswordsMatch, User> {

    @Override
    public void initialize(PasswordsMatch passwordsMatch){
    }

    public boolean isValid(User user, ConstraintValidatorContext context) {
        return user.getPassword().equals(user.getConfirmPassword());
    }

}
