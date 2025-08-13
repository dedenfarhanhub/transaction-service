package com.example.rest.web.model.dto;

import lombok.Data;

@Data
public class StatusDto {
    private Integer id;
    private String name;

    public StatusDto() {}

    public StatusDto(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
