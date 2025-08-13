package com.example.service.api;

import com.example.entity.dto.TransactionDetailDto;
import reactor.core.publisher.Flux;

public interface TransactionService {
    Flux<TransactionDetailDto> getAllTransactions();
}
