package com.bentoo.jaypay.service.implementation;

import com.bentoo.jaypay.dto.card.CardDTO;
import com.bentoo.jaypay.model.Card;
import com.bentoo.jaypay.repository.IAccountRepository;
import com.bentoo.jaypay.repository.ICardRepository;
import com.bentoo.jaypay.service.ICardService;
import com.bentoo.jaypay.utils.Utils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CardService implements ICardService {
    @Autowired
    private ICardRepository cardRepository;
    @Autowired
    private IAccountRepository accountRepository;
    @Autowired
    private Utils utils;
    private final ModelMapper modelMapper;

    public CardService(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

    public Card create(CardDTO cardDTO) throws Exception {
        var account = accountRepository.findByAccountNumber(cardDTO.getAccountId()).orElseThrow(() -> new Exception("Account doesn't exists"));
        Card card = this.convertToEntity(cardDTO);
        card.setAccount(account);

        var expireDate = LocalDateTime.now().plusYears(1);
        card.setExpireAt(expireDate);
        String cvv = utils.generateCVV();
        card.setCvv(cvv);

        String cardNumber = utils.generateCardNumber();
        card.setCardNumber(cardNumber);
        return cardRepository.save(card);
    }

    public Card convertToEntity(CardDTO dto) {
        return modelMapper.map(dto, Card.class);
    }

    public CardDTO convertToDTO(Card entity) {
        return modelMapper.map(entity, CardDTO.class);
    }

}
