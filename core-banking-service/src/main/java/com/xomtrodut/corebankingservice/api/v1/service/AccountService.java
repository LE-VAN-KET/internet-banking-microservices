package com.xomtrodut.corebankingservice.api.v1.service;

import com.xomtrodut.corebankingservice.api.v1.model.dto.BankAccountDto;

public interface AccountService {
    BankAccountDto getBankAccount(String accountNumber);
    boolean existAccountNumber(String accountNumber);
}
