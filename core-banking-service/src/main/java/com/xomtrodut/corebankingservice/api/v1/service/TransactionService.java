package com.xomtrodut.corebankingservice.api.v1.service;

import com.xomtrodut.corebankingservice.api.v1.model.dto.request.FundTransferRequest;
import com.xomtrodut.corebankingservice.api.v1.model.dto.request.UtilityPaymentRequest;
import com.xomtrodut.corebankingservice.api.v1.model.dto.response.FundTransferResponse;
import com.xomtrodut.corebankingservice.api.v1.model.dto.response.UtilityPaymentResponse;

public interface TransactionService {
    FundTransferResponse fundTransfer(FundTransferRequest fundTransferRequest);
    UtilityPaymentResponse utilPayment(UtilityPaymentRequest utilityPaymentRequest);
}
