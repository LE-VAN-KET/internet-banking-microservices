package com.xomtrodut.corebankingservice.api.v1.exception;

import com.xomtrodut.corebankingservice.api.v1.common.ErrorsConstant;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BankAccountNotFoundException extends RuntimeException{
    public BankAccountNotFoundException() {
        super(ErrorsConstant.BANK_ACCOUNT_NOT_FOUND);
    }
}
