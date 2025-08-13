package com.example.service.impl;

import com.example.dao.TransactionRepositoryCustom;
import com.example.entity.dto.TransactionDetailDto;
import com.example.service.api.TransactionService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;


@Service
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepositoryCustom transactionRepositoryCustom;
    public TransactionServiceImpl(TransactionRepositoryCustom transactionRepositoryCustom) {
        this.transactionRepositoryCustom = transactionRepositoryCustom;
    }
    @Override
    public Flux<TransactionDetailDto> getAllTransactions() {
        return transactionRepositoryCustom.findAllTransactionDetails();
    }
}
