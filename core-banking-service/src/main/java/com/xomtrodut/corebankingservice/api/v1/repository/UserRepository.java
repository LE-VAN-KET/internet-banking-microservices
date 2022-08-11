package com.xomtrodut.corebankingservice.api.v1.repository;

import com.xomtrodut.corebankingservice.api.v1.model.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {
    @Query("SELECT u FROM UserEntity u JOIN FETCH u.accounts WHERE u.identificationNumber = :identificationNumber")
    Optional<UserEntity> findByIdentificationNumber(String identificationNumber);

    @Query("SELECT u FROM UserEntity u WHERE u.lastName LIKE %:keyword%")
    Page<UserEntity> search(@Param("keyword") String keyword, Pageable pageable);
}
