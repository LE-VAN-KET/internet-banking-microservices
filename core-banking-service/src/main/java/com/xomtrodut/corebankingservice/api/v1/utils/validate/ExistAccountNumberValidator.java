package com.xomtrodut.corebankingservice.api.v1.utils.validate;

import com.xomtrodut.corebankingservice.api.v1.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ExistAccountNumberValidator implements ConstraintValidator<ExistAccountNumber, String> {
    @Autowired
    private AccountService accountService;

    @Override
    public boolean isValid(String accountNumber, ConstraintValidatorContext constraintValidatorContext) {
        return accountService.existAccountNumber(accountNumber);
    }
}
