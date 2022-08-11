package com.xomtrodut.corebankingservice.api.v1.service;

import com.xomtrodut.corebankingservice.api.v1.model.dto.UserDto;
import org.springframework.data.domain.Page;

public interface UserService {
    UserDto getUser(String identification);
    Page<UserDto> getUsers(int page, int size, String[] sort, String keyword);
}
