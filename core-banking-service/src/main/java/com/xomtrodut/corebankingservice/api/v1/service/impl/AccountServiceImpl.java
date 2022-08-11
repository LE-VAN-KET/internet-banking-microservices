package com.xomtrodut.corebankingservice.api.v1.service.impl;

import com.xomtrodut.corebankingservice.api.v1.exception.BankAccountNotFoundException;
import com.xomtrodut.corebankingservice.api.v1.model.dto.BankAccountDto;
import com.xomtrodut.corebankingservice.api.v1.model.entity.BankAccountEntity;
import com.xomtrodut.corebankingservice.api.v1.model.mapper.BankAccountMapper;
import com.xomtrodut.corebankingservice.api.v1.repository.BankAccountRepository;
import com.xomtrodut.corebankingservice.api.v1.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Autowired
    private BankAccountMapper bankAccountMapper;

    @Override
    public BankAccountDto getBankAccount(String accountNumber) {
        BankAccountEntity bankAccountEntity = bankAccountRepository.findByNumber(accountNumber)
                .orElseThrow(BankAccountNotFoundException::new);
        return bankAccountMapper.convertToDto(bankAccountEntity);
    }

    @Override
    public boolean existAccountNumber(String accountNumber) {
        return bankAccountRepository.findByNumber(accountNumber).isPresent();
    }
}
