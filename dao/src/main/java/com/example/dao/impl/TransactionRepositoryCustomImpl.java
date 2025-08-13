package com.example.dao.impl;

import com.example.dao.TransactionRepositoryCustom;
import com.example.entity.dto.TransactionDetailDto;
import io.r2dbc.spi.Row;
import io.r2dbc.spi.RowMetadata;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.math.BigDecimal;

@Repository
public class TransactionRepositoryCustomImpl  implements TransactionRepositoryCustom {
    private final DatabaseClient client;

    public TransactionRepositoryCustomImpl(DatabaseClient client) {
        this.client = client;
    }

    @Override
    public Flux<TransactionDetailDto> findAllTransactionDetails() {
        String sql = """
            SELECT t.id AS t_id,
                   p.id AS p_id,
                   p.name AS p_name,
                   t.amount AS t_amount,
                   t.customer_name AS t_customer,
                   s.id AS s_id,
                   t.transaction_date AS t_date,
                   t.create_by AS t_by,
                   t.create_on AS t_on
            FROM transaction t
            JOIN product p ON t.product_id = p.id
            JOIN status s ON t.status_id = s.id
            ORDER BY t.id
        """;

        return client.sql(sql)
                .map(this::toTransactionDetailDto)
                .all();
    }

    private TransactionDetailDto toTransactionDetailDto(Row row, RowMetadata meta) {
        return new TransactionDetailDto(
                row.get("t_id", Long.class),
                row.get("p_id", Long.class),
                row.get("p_name", String.class),
                row.get("t_amount", BigDecimal.class),
                row.get("t_customer", String.class),
                row.get("s_id", Integer.class),
                row.get("t_date", java.time.LocalDateTime.class),
                row.get("t_by", String.class),
                row.get("t_on", java.time.LocalDateTime.class)
        );
    }
}
