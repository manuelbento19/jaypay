package com.bentoo.jaypay.service;

import com.bentoo.jaypay.model.Card;

public interface ICardService {
    Card create(Card card) throws Exception;
}
