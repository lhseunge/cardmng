package com.seung.cardmng.repository;

import com.seung.cardmng.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CardRepository extends JpaRepository<Card, Integer> {

    @Override
    List<Card> findAll();

    @Override
    Optional<Card> findById(Integer id);

    @Override
    Card save(Card card);
}
