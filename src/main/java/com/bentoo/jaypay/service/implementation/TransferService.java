package com.bentoo.jaypay.service.implementation;

import com.bentoo.jaypay.dto.transfer.TransferDTO;
import com.bentoo.jaypay.model.Card;
import com.bentoo.jaypay.model.Transfer;
import com.bentoo.jaypay.repository.ICardRepository;
import com.bentoo.jaypay.repository.ITransferRepository;
import com.bentoo.jaypay.service.ITransferService;
import com.bentoo.jaypay.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
public class TransferService implements ITransferService {
    @Autowired
    private ITransferRepository transferRepository;

    @Autowired
    private ICardRepository cardRepository;
    @Autowired
    private Utils utils;

    public Card create(Card card) throws Exception {
        var expireDate = LocalDateTime.now().plusYears(1);
        card.setExpireAt(expireDate);
        String cvv = utils.generateCVV();
        card.setCvv(cvv);

        String cardNumber = utils.generateCardNumber();
        card.setCardNumber(cardNumber);
        return cardRepository.save(card);
    }

    public Transfer create(TransferDTO transfer) throws Exception {
        final double amount = transfer.getAmount();
        if(amount<0){
            throw new Exception("Transfer amount cannot be negative.");
        }

        var senderCardExists = this.cardRepository.findById(transfer.getSender());
        if(senderCardExists.isEmpty()){
            throw new Exception("Sender card doesn't exists");
        }

        var receiverCardExists = this.cardRepository.findById(transfer.getSender());
        if(receiverCardExists.isEmpty()){
            throw new Exception("Receiver card doesn't exists");
        }
        if(amount > senderCardExists.get().getAmount()){
            throw new Exception("Insufficient funds. transfer amount exceeds available balance.");
        }
        // I'll need decrement available balance of  sender card, but not now
        //

        var receiver = receiverCardExists.get();
        receiver.setAmount(receiver.getAmount()+amount);

        var sender = senderCardExists.get();
        sender.setAmount(sender.getAmount() - amount);

        var transferResult = transferRepository.save(new Transfer(sender,receiver,amount));

        cardRepository.saveAll(Arrays.asList(sender,receiver));
        return transferResult;
    }
}
