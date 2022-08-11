package com.xomtrodut.corebankingservice.api.v1.controller;

import com.xomtrodut.corebankingservice.api.v1.model.dto.BankAccountDto;
import com.xomtrodut.corebankingservice.api.v1.model.dto.UtilityAccountDto;
import com.xomtrodut.corebankingservice.api.v1.service.AccountService;
import com.xomtrodut.corebankingservice.api.v1.service.UtilityAccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @Autowired
    private UtilityAccountService utilityAccountService;

    private static final Logger log = LoggerFactory.getLogger(AccountController.class);

    @GetMapping("/bank-account/{account_number}")
    public BankAccountDto getBankAccount(@PathVariable("account_number") String accountNumber) {
        log.info("Reading account by account number {}", accountNumber);
        return accountService.getBankAccount(accountNumber);
    }

    @GetMapping("/bank-account/provider/{provider_name}")
    public UtilityAccountDto getUtilityAccount(@PathVariable("provider_name") String providerName) {
        log.info("Reading utility by provider name {}", providerName);
        return utilityAccountService.getUtilityAccount(providerName);
    }
}
