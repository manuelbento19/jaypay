package com.bentoo.jaypay.repository;

import com.bentoo.jaypay.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ICardRepository extends JpaRepository<Card, UUID> {

}
