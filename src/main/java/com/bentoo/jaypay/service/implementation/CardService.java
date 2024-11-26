package com.bentoo.jaypay.service.implementation;

import com.bentoo.jaypay.model.Card;
import com.bentoo.jaypay.repository.ICardRepository;
import com.bentoo.jaypay.service.ICardService;
import com.bentoo.jaypay.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CardService implements ICardService {
    @Autowired
    private ICardRepository cardRepository;
    @Autowired
    private Utils utils;

    public Card create(Card card) throws Exception {
        var expireDate = LocalDateTime.now().plusYears(1);
        card.setExpireAt(expireDate);
        String cvv = utils.generateCVV();
        card.setCvv(cvv);

        String cardNumber = "";

        return cardRepository.save(card);
    }
}
