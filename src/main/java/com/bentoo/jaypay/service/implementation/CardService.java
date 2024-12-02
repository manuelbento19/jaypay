package com.bentoo.jaypay.service.implementation;

import com.bentoo.jaypay.dto.card.CardDTO;
import com.bentoo.jaypay.exception.AppError;
import com.bentoo.jaypay.model.Card;
import com.bentoo.jaypay.repository.IAccountRepository;
import com.bentoo.jaypay.repository.ICardRepository;
import com.bentoo.jaypay.service.ICardService;
import com.bentoo.jaypay.utils.Utils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

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
        var account = accountRepository.findByAccountNumber(cardDTO.getAccountId()).orElseThrow(() -> new AppError("Account doesn't exists"));
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

    public List<Card> getAccountCards(String accountNumber) throws Exception {
        var account = accountRepository.findByAccountNumber(accountNumber).orElseThrow(() -> new AppError("Account doesn't exists"));
        return cardRepository.findAll().stream().filter(item->item.getAccount()==account).toList();
    }

    public Card convertToEntity(CardDTO dto) {
        return modelMapper.map(dto, Card.class);
    }

    public CardDTO convertToDTO(Card entity) {
        return modelMapper.map(entity, CardDTO.class);
    }

}
