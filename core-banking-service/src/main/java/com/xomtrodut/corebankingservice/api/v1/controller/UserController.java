package com.xomtrodut.corebankingservice.api.v1.controller;

import com.xomtrodut.corebankingservice.api.v1.model.dto.UserDto;
import com.xomtrodut.corebankingservice.api.v1.model.dto.request.PaginationRequest;
import com.xomtrodut.corebankingservice.api.v1.model.dto.response.PaginationResponse;
import com.xomtrodut.corebankingservice.api.v1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{identification}")
    public UserDto getUser(@PathVariable("identification") String identification) {
        return userService.getUser(identification);
    }

    @GetMapping
    public PaginationResponse<UserDto> getUser(@Valid PaginationRequest paginationRequest) {
        Page<UserDto> userDtoList = userService.getUsers(paginationRequest.getPage(), paginationRequest.getSize(),
                paginationRequest.getSort(), paginationRequest.getKeyword());

        return new PaginationResponse<>(userDtoList.getContent(), paginationRequest.getPage() + 1,
                paginationRequest.getSize(), userDtoList.getTotalPages());
    }
}
