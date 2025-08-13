package com.example.rest.web.model.response;

import com.example.rest.web.model.dto.StatusDto;
import com.example.rest.web.model.dto.TransactionResponseDto;
import lombok.Data;

import java.util.List;

@Data
public class TransactionListResponse {
    private List<TransactionResponseDto> data;
    private List<StatusDto> status;

    public TransactionListResponse() {}

    public TransactionListResponse(List<TransactionResponseDto> data, List<StatusDto> status) {
        this.data = data;
        this.status = status;
    }
}
