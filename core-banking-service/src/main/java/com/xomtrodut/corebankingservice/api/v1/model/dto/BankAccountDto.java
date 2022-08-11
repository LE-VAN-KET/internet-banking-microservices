package com.xomtrodut.corebankingservice.api.v1.model.dto;

import com.xomtrodut.corebankingservice.api.v1.enums.AccountStatus;
import com.xomtrodut.corebankingservice.api.v1.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BankAccountDto {
    private UUID id;
    private String number;
    private AccountType type;
    private AccountStatus status;
    private BigDecimal availableBalance;
    private BigDecimal actualBalance;
    private UserDto user;
}
