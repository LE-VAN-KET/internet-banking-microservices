package com.xomtrodut.corebankingservice.api.v1.exception;

import com.xomtrodut.corebankingservice.api.v1.common.ApiErrors;

import java.util.ArrayList;
import java.util.List;

public class ApiException {
    private List<ApiErrors> errors;

    public ApiException() {
        super();
        errors = new ArrayList<>();
    }

    public ApiException(List<ApiErrors> errors) {
        this.errors = errors;
    }

    public void add(ApiErrors error) {
        this.errors.add(error);
    }

    public List<ApiErrors> getErrors() {
        return errors;
    }
}
