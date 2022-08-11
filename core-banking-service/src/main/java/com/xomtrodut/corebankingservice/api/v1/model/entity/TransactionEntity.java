package com.xomtrodut.corebankingservice.api.v1.model.entity;

import com.xomtrodut.corebankingservice.api.v1.enums.TransactionType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;


@Builder
@Entity
@Table(name = "banking_core_transaction")
@Setter
@Getter
@EntityListeners(AuditingEntityListener.class)
public class TransactionEntity extends BaseEntity{
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;

    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    private String referenceNumber;

    private String transactionId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private BankAccountEntity account;

    public TransactionEntity() {

    }

    public TransactionEntity(UUID id, BigDecimal amount, TransactionType transactionType, String referenceNumber, String transactionId, BankAccountEntity account) {
        this.id = id;
        this.amount = amount;
        this.transactionType = transactionType;
        this.referenceNumber = referenceNumber;
        this.transactionId = transactionId;
        this.account = account;
    }
}
