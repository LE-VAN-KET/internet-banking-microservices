package com.xomtrodut.corebankingservice.api.v1.model.mapper;

import com.xomtrodut.corebankingservice.api.v1.model.dto.BankAccountDto;
import com.xomtrodut.corebankingservice.api.v1.model.entity.BankAccountEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class BankAccountMapper extends BaseMapper<BankAccountEntity, BankAccountDto> {
    @Override
    public BankAccountEntity convertToEntity(BankAccountDto dto, Object... args) {
        BankAccountEntity bankAccountEntity = new BankAccountEntity();
        if (dto != null) {
            BeanUtils.copyProperties(dto, bankAccountEntity, "user");
        }
        return bankAccountEntity;
    }

    @Override
    public BankAccountDto convertToDto(BankAccountEntity entity, Object... args) {
        BankAccountDto bankAccountDto = new BankAccountDto();
        if (entity != null) {
            BeanUtils.copyProperties(entity, bankAccountDto, "user");
        }
        return bankAccountDto;
    }
}
