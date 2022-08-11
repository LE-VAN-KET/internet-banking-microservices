package com.xomtrodut.corebankingservice.api.v1.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UtilityAccountDto {
    private UUID id;
    private String number;
    private String providerName;
}
