package com.example.finalexam.repository;

import com.example.finalexam.model.TransactionEntity;
import com.example.finalexam.model.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {
    List<TransactionEntity> findByAccountIdOrderByDateDesc(Long accountId);
    List<TransactionEntity> findByAccountIdAndTypeAndDateAfter(Long accountid, TransactionType type, LocalDateTime date);
}
