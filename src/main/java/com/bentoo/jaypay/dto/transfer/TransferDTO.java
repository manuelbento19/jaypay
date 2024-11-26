package com.bentoo.jaypay.dto.transfer;

import lombok.Getter;
import lombok.Setter;
import java.util.UUID;

@Getter
@Setter
public class TransferDTO {
    private UUID sender;
    private UUID receiver;
    private double amount;
}
