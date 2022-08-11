package com.xomtrodut.corebankingservice.api.v1.service.impl;

import com.xomtrodut.corebankingservice.api.v1.model.dto.UtilityAccountDto;
import com.xomtrodut.corebankingservice.api.v1.model.entity.UtilityAccountEntity;
import com.xomtrodut.corebankingservice.api.v1.model.mapper.UtilityAccountMapper;
import com.xomtrodut.corebankingservice.api.v1.repository.UtilityAccountRepository;
import com.xomtrodut.corebankingservice.api.v1.service.UtilityAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UtilityAccountServiceImpl implements UtilityAccountService {
    @Autowired
    private UtilityAccountRepository utilityAccountRepository;

    @Autowired
    private UtilityAccountMapper utilityAccountMapper;

    @Override
    public UtilityAccountDto getUtilityAccount(String provider) {
        UtilityAccountEntity utilityAccountEntity = utilityAccountRepository.findByProviderName(provider).get();
        return utilityAccountMapper.convertToDto(utilityAccountEntity);
    }

    @Override
    public UtilityAccountDto getUtilityAccount(UUID accountId) {
        UtilityAccountEntity utilityAccountEntity = utilityAccountRepository.findById(accountId).get();
        return utilityAccountMapper.convertToDto(utilityAccountEntity);
    }
}
