package com.xomtrodut.corebankingservice.api.v1.model.dto.request;

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
public class UtilityPaymentRequest {
    private UUID providerId;
    private BigDecimal amount;
    private String referenceNumber;
    private String account;
}
