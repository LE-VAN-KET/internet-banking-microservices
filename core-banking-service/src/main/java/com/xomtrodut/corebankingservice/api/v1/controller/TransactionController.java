package com.xomtrodut.corebankingservice.api.v1.controller;

import com.xomtrodut.corebankingservice.api.v1.model.dto.request.FundTransferRequest;
import com.xomtrodut.corebankingservice.api.v1.model.dto.request.UtilityPaymentRequest;
import com.xomtrodut.corebankingservice.api.v1.model.dto.response.FundTransferResponse;
import com.xomtrodut.corebankingservice.api.v1.model.dto.response.UtilityPaymentResponse;
import com.xomtrodut.corebankingservice.api.v1.service.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/transaction")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    private static final Logger log = LoggerFactory.getLogger(TransactionController.class);

    @GetMapping("/fund-transfer")
    public FundTransferResponse fundTransfer(@RequestBody FundTransferRequest fundTransferRequest) {
        log.info("Fund transfer initiated in core  bank");
        return transactionService.fundTransfer(fundTransferRequest);
    }

    @GetMapping("/util-payment")
    public UtilityPaymentResponse utilPayment(@RequestBody UtilityPaymentRequest utilityPaymentRequest) {
        log.info("Utility payment initiated in core bank");
        return transactionService.utilPayment(utilityPaymentRequest);
    }
}
