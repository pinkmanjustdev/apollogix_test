package com.apollogix.exam.modules.account.authenication.repository;

import com.apollogix.exam.modules.account.authenication.entity.TokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface TokenRepository extends JpaRepository<TokenEntity, UUID> {
    Optional<TokenEntity> findByToken(String token);
}
