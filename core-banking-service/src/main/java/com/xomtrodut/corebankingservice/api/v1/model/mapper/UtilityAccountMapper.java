package com.xomtrodut.corebankingservice.api.v1.model.mapper;

import com.xomtrodut.corebankingservice.api.v1.model.dto.UtilityAccountDto;
import com.xomtrodut.corebankingservice.api.v1.model.entity.UtilityAccountEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class UtilityAccountMapper extends BaseMapper<UtilityAccountEntity, UtilityAccountDto> {
    @Override
    public UtilityAccountEntity convertToEntity(UtilityAccountDto dto, Object... args) {
        UtilityAccountEntity utilityAccountEntity = new UtilityAccountEntity();
        if (dto != null) {
            BeanUtils.copyProperties(dto, utilityAccountEntity);
        }
        return utilityAccountEntity;
    }

    @Override
    public UtilityAccountDto convertToDto(UtilityAccountEntity entity, Object... args) {
        UtilityAccountDto utilityAccountDto = new UtilityAccountDto();
        if (entity != null) {
            BeanUtils.copyProperties(entity, utilityAccountDto);
        }
        return utilityAccountDto;
    }
}
