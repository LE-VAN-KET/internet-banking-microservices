package com.xomtrodut.corebankingservice.api.v1.repository;

import com.xomtrodut.corebankingservice.api.v1.model.entity.UtilityAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UtilityAccountRepository extends JpaRepository<UtilityAccountEntity, UUID> {
    @Query("SELECT utility FROM UtilityAccountEntity utility WHERE utility.providerName = :provider")
    Optional<UtilityAccountEntity> findByProviderName(@Param("provider") String provider);
}
