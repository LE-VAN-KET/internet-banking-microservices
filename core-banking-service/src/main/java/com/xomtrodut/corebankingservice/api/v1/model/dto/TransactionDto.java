package com.xomtrodut.corebankingservice.api.v1.model.dto;

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
public class TransactionDto {
    private UUID id;
    private BigDecimal amount;
    private String referenceNumber;
    private BankAccountDto bankAccount;
}
