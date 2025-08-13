package com.example.dao;

import com.example.entity.dto.TransactionDetailDto;
import reactor.core.publisher.Flux;

public interface TransactionRepositoryCustom {
    Flux<TransactionDetailDto> findAllTransactionDetails();
}
