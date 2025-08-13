package com.example.entity.dao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "status")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Status {

    @Id
    private Integer id;

    @Column(nullable = false, length = 50)
    private String name;
}
