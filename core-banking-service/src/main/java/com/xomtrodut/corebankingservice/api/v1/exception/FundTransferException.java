package com.xomtrodut.corebankingservice.api.v1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class FundTransferException extends RuntimeException{
    public FundTransferException(String message) {
        super(message);
    }
}
