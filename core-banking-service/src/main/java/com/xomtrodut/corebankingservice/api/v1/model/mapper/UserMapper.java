package com.xomtrodut.corebankingservice.api.v1.model.mapper;

import com.xomtrodut.corebankingservice.api.v1.model.dto.UserDto;
import com.xomtrodut.corebankingservice.api.v1.model.entity.UserEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMapper extends BaseMapper<UserEntity, UserDto> {
    @Autowired
    private BankAccountMapper bankAccountMapper;

    @Override
    public UserEntity convertToEntity(UserDto userDto, Object... args) {
        UserEntity userEntity = new UserEntity();
        if (userDto != null) {
            BeanUtils.copyProperties(userDto, userEntity, "accounts");
            userEntity.setAccounts(bankAccountMapper.convertToEntitySet(userDto.getAccounts()));
        }
        return userEntity;
    }

    @Override
    public UserDto convertToDto(UserEntity entity, Object... args) {
        UserDto userDto = new UserDto();
        if (entity != null) {
            BeanUtils.copyProperties(entity, userDto, "accounts");
            userDto.setAccounts(bankAccountMapper.convertToDtoList(entity.getAccounts()));
        }
        return userDto;
    }
}
