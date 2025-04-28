package com.Rushikesh.CreateBank.Repository;

import com.Rushikesh.CreateBank.Entity.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BankRepo extends JpaRepository<Bank, Integer> {
    Optional<Bank> findByCode(String code);
}
