package com.example.dao;

import com.example.entity.dao.Status;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface StatusRepository extends ReactiveCrudRepository<Status, Integer> {
}
