package com.xomtrodut.corebankingservice.api.v1.repository;

import com.xomtrodut.corebankingservice.api.v1.model.entity.BankAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccountEntity, UUID> {
    @Query("SELECT acc FROM BankAccountEntity acc WHERE acc.number = :number")
    Optional<BankAccountEntity> findByNumber(@Param("number") String accountNumber);
}
