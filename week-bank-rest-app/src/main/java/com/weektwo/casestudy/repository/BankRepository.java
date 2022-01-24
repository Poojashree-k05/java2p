package com.weektwo.casestudy.repository;

import com.weektwo.casestudy.domain.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BankRepository extends JpaRepository<BankAccount,Long> {
    @Modifying


    List<BankAccount> findByAcHldNmStartingWith(String prefix);

    List<BankAccount> findByAcNum(Long acNum);

    List<BankAccount> findByStatusTrue();

    @Override
    List<BankAccount> findAll();

    Optional<BankAccount> findById(Long acNum);



}