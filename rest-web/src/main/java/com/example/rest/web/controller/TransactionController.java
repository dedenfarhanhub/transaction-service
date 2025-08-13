package com.example.rest.web.controller;

import com.example.rest.web.model.dto.StatusDto;
import com.example.rest.web.model.dto.TransactionResponseDto;
import com.example.rest.web.model.response.TransactionListResponse;
import com.example.service.api.TransactionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
public class TransactionController {
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/transactions")
    public Mono<TransactionListResponse> getTransactions() {

        List<StatusDto> statusList = List.of(
                new StatusDto(0, "SUCCESS"),
                new StatusDto(1, "FAILED")
        );

        return transactionService.getAllTransactions()
                .map(dto -> new TransactionResponseDto(
                        dto.getId(),
                        String.valueOf(dto.getProductID()),
                        dto.getProductName(),
                        String.valueOf(dto.getAmount()),
                        dto.getCustomerName(),
                        dto.getStatus(),
                        dto.getTransactionDate(),
                        dto.getCreateBy(),
                        dto.getCreateOn()
                ))
                .collectList()
                .map(transactionResponseList -> new TransactionListResponse(transactionResponseList, statusList));
    }
}
