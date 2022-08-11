package com.xomtrodut.corebankingservice.api.v1.service;

import com.xomtrodut.corebankingservice.api.v1.model.dto.UtilityAccountDto;

import java.util.UUID;

public interface UtilityAccountService {
    UtilityAccountDto getUtilityAccount(String provider);
    UtilityAccountDto getUtilityAccount(UUID accountId);
}
