package com.xomtrodut.corebankingservice.api.v1.service.impl;

import com.xomtrodut.corebankingservice.api.v1.common.ErrorsConstant;
import com.xomtrodut.corebankingservice.api.v1.exception.UserNotFoundException;
import com.xomtrodut.corebankingservice.api.v1.model.dto.UserDto;
import com.xomtrodut.corebankingservice.api.v1.model.entity.UserEntity;
import com.xomtrodut.corebankingservice.api.v1.model.mapper.UserMapper;
import com.xomtrodut.corebankingservice.api.v1.repository.UserRepository;
import com.xomtrodut.corebankingservice.api.v1.service.UserService;
import com.xomtrodut.corebankingservice.api.v1.utils.PaginationAndSortUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;
    private final PaginationAndSortUtil paginationAndSortUtil = new PaginationAndSortUtil();

    public UserServiceImpl() {
    }

    @Override
    public UserDto getUser(String identification) {
        UserEntity userEntity = userRepository.findByIdentificationNumber(identification)
                .orElseThrow(() -> new UserNotFoundException(ErrorsConstant.USER_NOT_FOUND));
        return userMapper.convertToDto(userEntity);
    }

    @Override
    public Page<UserDto> getUsers(int page, int size, String[] sort, String keyword) {
        Pageable pageable = paginationAndSortUtil.paginate(page, size, sort);
        Page<UserEntity> userEntityPage;

        if (keyword == null || keyword.isBlank()) {
            userEntityPage = userRepository.findAll(pageable);
        } else {
            userEntityPage = userRepository.search(keyword, pageable);
        }

        return new PageImpl<>(userMapper.convertToDtoList(userEntityPage.getContent()), pageable,
                userEntityPage.getTotalElements());
    }
}
