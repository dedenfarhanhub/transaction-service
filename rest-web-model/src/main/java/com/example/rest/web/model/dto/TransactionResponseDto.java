package com.example.rest.web.model.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TransactionResponseDto {
    private Long id;
    private String productID;
    private String productName;
    private String amount;
    private String customerName;
    private Integer status;
    private String transactionDate;
    private String createBy;
    private String createOn;

    public TransactionResponseDto() {}

    public TransactionResponseDto(Long id, String productID, String productName, String amount,
                                  String customerName, Integer status,
                                  LocalDateTime transactionDate, String createBy, LocalDateTime createOn) {
        this.id = id;
        this.productID = productID;
        this.productName = productName;
        this.amount = amount;
        this.customerName = customerName;
        this.status = status;
        this.transactionDate = transactionDate != null ? transactionDate.toString().replace('T', ' ') : null;
        this.createBy = createBy;
        this.createOn = createOn != null ? createOn.toString().replace('T', ' ') : null;
    }
}
