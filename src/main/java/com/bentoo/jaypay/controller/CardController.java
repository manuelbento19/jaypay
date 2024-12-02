package com.bentoo.jaypay.controller;

import com.bentoo.jaypay.dto.card.CardDTO;
import com.bentoo.jaypay.model.Card;
import com.bentoo.jaypay.service.ICardService;
import jakarta.servlet.ServletRequest;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/card")
public class CardController {
    @Autowired
    private ICardService cardService;

    @PostMapping
    public ResponseEntity<Card> createCard(@RequestBody CardDTO cardDTO) throws Exception {
        var result = cardService.create(cardDTO);
        var uri = UriComponentsBuilder.fromPath("/card").build().toUri();
        return ResponseEntity.created(uri).body(result);
    }

    @GetMapping
    public ResponseEntity<List<Card>> getAccountCards(ServletRequest request) throws Exception{
        var accountNumber = request.getParameter("accountNumber");
        if(accountNumber == null){
            return ResponseEntity.ok(List.of());
        }
        var result = cardService.getAccountCards(accountNumber);
        return ResponseEntity.ok(result);
    }
    @GetMapping("/activate/:{cardId}")
    public ResponseEntity<Card> activate(@PathVariable UUID cardId) throws Exception{
        var result = cardService.activate(cardId);
        return ResponseEntity.ok(result);
    }
    @GetMapping("/deactivate/{cardId}")
    public ResponseEntity<Card> deactivate(@PathVariable UUID cardId) throws Exception{
        var result = cardService.deactivate(cardId);
        return ResponseEntity.ok(result);
    }
}