package com.bentoo.jaypay.controller;

import com.bentoo.jaypay.dto.card.CardDTO;
import com.bentoo.jaypay.model.Card;
import com.bentoo.jaypay.service.ICardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/card")
public class CardController {
    @Autowired
    private ICardService cardService;

    @PostMapping("")
    public ResponseEntity<Card> createCard(@RequestBody CardDTO cardDTO) throws Exception {
        var result = cardService.create(cardDTO);
        var uri = UriComponentsBuilder.fromPath("/card").build().toUri();
        return ResponseEntity.created(uri).body(result);
    }
}