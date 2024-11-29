package com.bentoo.jaypay.repository;

import com.bentoo.jaypay.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface IAccountRepository  extends JpaRepository<Account, UUID> {
    Optional<Account> findByEmail(String email);
}
