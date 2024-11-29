package com.bentoo.jaypay.service;

import com.bentoo.jaypay.dto.transfer.TransferDTO;
import com.bentoo.jaypay.model.Transfer;

public interface ITransferService extends IServiceBase<Transfer,TransferDTO> {
    Transfer create(TransferDTO transfer) throws Exception;
}
