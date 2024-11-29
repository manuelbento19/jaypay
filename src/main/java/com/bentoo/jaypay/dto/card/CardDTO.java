package com.bentoo.jaypay.dto.card;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CardDTO {
    private UUID accountId;
    private double amount;
}
