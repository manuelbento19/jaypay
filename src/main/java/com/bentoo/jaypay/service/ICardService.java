package com.bentoo.jaypay.service;

import com.bentoo.jaypay.dto.card.CardDTO;
import com.bentoo.jaypay.model.Card;

import java.util.List;
import java.util.UUID;

public interface ICardService extends IServiceBase<Card, CardDTO> {
    Card create(CardDTO cardDTO) throws Exception;
    List<Card> getAccountCards(String accountNumber) throws Exception;
    Card activate(UUID cardId) throws Exception;
    Card deactivate(UUID cardId) throws Exception;
    void remove(UUID cardId) throws Exception;
}
