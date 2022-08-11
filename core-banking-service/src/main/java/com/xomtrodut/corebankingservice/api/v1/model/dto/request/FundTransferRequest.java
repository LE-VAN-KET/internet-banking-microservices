package com.xomtrodut.corebankingservice.api.v1.model.dto.request;

import com.xomtrodut.corebankingservice.api.v1.utils.validate.ExistAccountNumber;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FundTransferRequest {
    @ExistAccountNumber
    private String fromAccount;
    @ExistAccountNumber
    private String toAccount;
    @Positive
    private BigDecimal amount;
}
