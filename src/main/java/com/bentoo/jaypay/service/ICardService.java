package com.bentoo.jaypay.service;

import com.bentoo.jaypay.dto.card.CardDTO;
import com.bentoo.jaypay.model.Card;

import java.util.List;

public interface ICardService extends IServiceBase<Card, CardDTO> {
    Card create(CardDTO cardDTO) throws Exception;
    List<Card> getAccountCards(String accountNumber) throws Exception;
}
