package com.seung.cardmng.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CardRepository<T, ID> extends JpaRepository<T, ID> {

    @Override
    List<T> findAll();

    @Override
    Optional<T> findById(ID id);
}
