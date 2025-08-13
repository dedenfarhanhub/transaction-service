package com.example.entity.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class TransactionDetailDto {
    private Long id;
    private Long productID;
    private String productName;
    private BigDecimal amount;
    private String customerName;
    private Integer status;
    private LocalDateTime transactionDate;
    private String createBy;
    private LocalDateTime createOn;

    public TransactionDetailDto(Long id, Long productID, String productName, BigDecimal amount, String customerName,
                                Integer status, LocalDateTime transactionDate, String createBy, LocalDateTime createOn) {
        this.id = id;
        this.productID = productID;
        this.productName = productName;
        this.amount = amount;
        this.customerName = customerName;
        this.status = status;
        this.transactionDate = transactionDate;
        this.createBy = createBy;
        this.createOn = createOn;
    }
}
