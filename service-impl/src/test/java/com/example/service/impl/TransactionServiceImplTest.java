package com.example.service.impl;

import com.example.dao.TransactionRepositoryCustom;
import com.example.entity.dto.TransactionDetailDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.mockito.Mockito.*;

class TransactionServiceImplTest {

    private TransactionRepositoryCustom repositoryMock;
    private TransactionServiceImpl service;

    @BeforeEach
    void setUp() {
        repositoryMock = mock(TransactionRepositoryCustom.class);
        service = new TransactionServiceImpl(repositoryMock);
    }

    @Test
    void testGetAllTransactions() {
        TransactionDetailDto dto1 = new TransactionDetailDto(
                1L, 101L, "Product A", new BigDecimal("100.00"),
                "Customer A", 0, LocalDateTime.now(), "Admin", LocalDateTime.now()
        );

        TransactionDetailDto dto2 = new TransactionDetailDto(
                2L, 102L, "Product B", new BigDecimal("200.00"),
                "Customer B", 1, LocalDateTime.now(), "Admin", LocalDateTime.now()
        );

        when(repositoryMock.findAllTransactionDetails()).thenReturn(Flux.just(dto1, dto2));

        StepVerifier.create(service.getAllTransactions())
                .expectNext(dto1)
                .expectNext(dto2)
                .verifyComplete();

        verify(repositoryMock, times(1)).findAllTransactionDetails();
    }
}
