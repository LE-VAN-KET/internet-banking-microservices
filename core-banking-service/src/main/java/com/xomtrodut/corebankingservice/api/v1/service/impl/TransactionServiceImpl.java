package com.xomtrodut.corebankingservice.api.v1.service.impl;

import com.xomtrodut.corebankingservice.api.v1.common.ErrorsConstant;
import com.xomtrodut.corebankingservice.api.v1.common.Messages;
import com.xomtrodut.corebankingservice.api.v1.enums.TransactionType;
import com.xomtrodut.corebankingservice.api.v1.exception.BankAccountNotFoundException;
import com.xomtrodut.corebankingservice.api.v1.exception.FundTransferException;
import com.xomtrodut.corebankingservice.api.v1.model.dto.BankAccountDto;
import com.xomtrodut.corebankingservice.api.v1.model.dto.request.FundTransferRequest;
import com.xomtrodut.corebankingservice.api.v1.model.dto.request.UtilityPaymentRequest;
import com.xomtrodut.corebankingservice.api.v1.model.dto.response.FundTransferResponse;
import com.xomtrodut.corebankingservice.api.v1.model.dto.response.UtilityPaymentResponse;
import com.xomtrodut.corebankingservice.api.v1.model.entity.BankAccountEntity;
import com.xomtrodut.corebankingservice.api.v1.model.entity.TransactionEntity;
import com.xomtrodut.corebankingservice.api.v1.repository.BankAccountRepository;
import com.xomtrodut.corebankingservice.api.v1.repository.TransactionRepository;
import com.xomtrodut.corebankingservice.api.v1.service.AccountService;
import com.xomtrodut.corebankingservice.api.v1.service.TransactionService;
import com.xomtrodut.corebankingservice.api.v1.service.UtilityAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.UUID;

@Service
@Transactional(rollbackFor = {Exception.class, Throwable.class})
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Autowired
    private AccountService accountService;

    @Autowired
    private UtilityAccountService utilityAccountService;

    @Override
    public FundTransferResponse fundTransfer(FundTransferRequest fundTransferRequest) {
        BankAccountDto fromBankAccount = accountService.getBankAccount(fundTransferRequest.getFromAccount());
        BankAccountDto toBankAccount = accountService.getBankAccount(fundTransferRequest.getToAccount());
        // validate account balances
        validateBalance(fromBankAccount, fundTransferRequest.getAmount());
        String transactionId = internalFundTransfer(fromBankAccount, toBankAccount, fundTransferRequest.getAmount());
        return FundTransferResponse.builder().transactionId(transactionId)
                .message(Messages.TRANSACTION_SUCCESS).build();
    }

    @Override
    public UtilityPaymentResponse utilPayment(UtilityPaymentRequest utilityPaymentRequest) {
        String transactionId = UUID.randomUUID().toString();
        BankAccountDto bankAccountDto = accountService.getBankAccount(utilityPaymentRequest.getAccount());

        BankAccountEntity fromAccount = bankAccountRepository.findByNumber(bankAccountDto.getNumber())
                .orElseThrow(BankAccountNotFoundException::new);

        fromAccount.setActualBalance(fromAccount.getActualBalance().subtract(utilityPaymentRequest.getAmount()));
        fromAccount.setAvailableBalance(fromAccount.getAvailableBalance().subtract(utilityPaymentRequest.getAmount()));

        // save transaction util payment
        TransactionEntity transactionEntity = TransactionEntity.builder().transactionId(transactionId)
                .transactionType(TransactionType.UTILITY_PAYMENT)
                .account(fromAccount)
                .referenceNumber(utilityPaymentRequest.getReferenceNumber())
                .amount(utilityPaymentRequest.getAmount().negate()).build();

        transactionRepository.save(transactionEntity);
        return UtilityPaymentResponse.builder().transactionId(transactionId)
                .message(Messages.UTILITY_PAYMENT_SUCCESS).build();
    }

    private void validateBalance(BankAccountDto bankAccount, BigDecimal amount) {
        if (bankAccount.getActualBalance().compareTo(amount) < 0
                || bankAccount.getActualBalance().compareTo(BigDecimal.ZERO) < 0) {
            throw new FundTransferException(ErrorsConstant.BANK_ACCOUNT_BALANCE_NOT_ENOUGH);
        }
    }

    /**
    * @param fromBankAccount: account transfer
    * @param toBankAccount: account receive
    * @param amount: amount money
     * @return transactionId*/
    private String internalFundTransfer(BankAccountDto fromBankAccount, BankAccountDto toBankAccount,
                                               BigDecimal amount) {
        BankAccountEntity fromBankAccountEntity = bankAccountRepository.findByNumber(fromBankAccount.getNumber())
                .orElseThrow(BankAccountNotFoundException::new);
        BankAccountEntity toBankAccountEntity = bankAccountRepository.findByNumber(toBankAccount.getNumber())
                .orElseThrow(BankAccountNotFoundException::new);

        String transactionId = UUID.randomUUID().toString();

        fromBankAccountEntity.setActualBalance(fromBankAccountEntity.getActualBalance().subtract(amount));
        fromBankAccountEntity.setAvailableBalance(fromBankAccountEntity.getAvailableBalance().subtract(amount));
        bankAccountRepository.save(fromBankAccountEntity);

        TransactionEntity transactionEntity = TransactionEntity.builder().transactionId(transactionId)
                .referenceNumber(toBankAccountEntity.getNumber())
                .account(fromBankAccountEntity)
                .transactionType(TransactionType.FUND_TRANSFER)
                .amount(amount.negate()).build();

        transactionRepository.save(transactionEntity);

        toBankAccountEntity.setActualBalance(toBankAccountEntity.getActualBalance().add(amount));
        toBankAccountEntity.setAvailableBalance(toBankAccountEntity.getAvailableBalance().add(amount));
        bankAccountRepository.save(toBankAccountEntity);

        TransactionEntity transactionEntity1 = TransactionEntity.builder().transactionId(transactionId)
                .referenceNumber(toBankAccountEntity.getNumber())
                .account(toBankAccountEntity)
                .transactionType(TransactionType.FUND_TRANSFER)
                .amount(amount).build();

        transactionRepository.save(transactionEntity1);

        return transactionId;
    }
}
