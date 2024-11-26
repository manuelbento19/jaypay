package com.bentoo.jaypay.service;

import com.bentoo.jaypay.dto.transfer.TransferDTO;
import com.bentoo.jaypay.model.Transfer;

public interface ITransferService {
    Transfer create(TransferDTO transfer) throws Exception;
}
