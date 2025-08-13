package com.example.dao;

import com.example.entity.dao.Transaction;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository  extends ReactiveCrudRepository<Transaction, Long> {
}
