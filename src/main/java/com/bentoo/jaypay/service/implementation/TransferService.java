package com.bentoo.jaypay.service.implementation;

import com.bentoo.jaypay.dto.transfer.TransferDTO;
import com.bentoo.jaypay.model.Transfer;
import com.bentoo.jaypay.repository.ICardRepository;
import com.bentoo.jaypay.repository.ITransferRepository;
import com.bentoo.jaypay.service.ITransferService;
import com.bentoo.jaypay.utils.Utils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class TransferService implements ITransferService {
    @Autowired
    private ITransferRepository transferRepository;

    @Autowired
    private ICardRepository cardRepository;
    @Autowired
    private Utils utils;
    private final ModelMapper modelMapper;

    public TransferService(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }
    public Transfer create(TransferDTO transferDTO) throws Exception {
        final double amount = transferDTO.getAmount();
        if(amount<0){
            throw new Exception("Transfer amount cannot be negative.");
        }

        var sender = this.cardRepository.findById(transferDTO.getSender()).orElseThrow(()->new Exception("Sender card doesn't exists"));
        var receiver = this.cardRepository.findById(transferDTO.getSender()).orElseThrow(()->new Exception("Receiver card doesn't exists"));

        if(amount > sender.getAmount()){
            throw new Exception("Insufficient funds. transfer amount exceeds available balance.");
        }

        receiver.setAmount(receiver.getAmount()+amount);
        sender.setAmount(sender.getAmount() - amount);

        var transferResult = transferRepository.save(new Transfer(sender,receiver,amount));
        cardRepository.saveAll(Arrays.asList(sender,receiver));
        return transferResult;
    }

    public Transfer convertToEntity(TransferDTO dto) {
        return modelMapper.map(dto, Transfer.class);
    }

    public TransferDTO convertToDTO(Transfer entity) {
        return modelMapper.map(entity, TransferDTO.class);
    }
}
