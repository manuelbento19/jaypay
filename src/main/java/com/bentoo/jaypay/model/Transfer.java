package com.bentoo.jaypay.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity(name = "transfers")
public class Transfer {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "senderId")
    private Card sender;

    @ManyToOne
    @JoinColumn(name = "receiverId")
    private Card receiver;

    @Column(nullable = false)
    private double amount;

    @CreationTimestamp
    private LocalDateTime createdAt;

    public Transfer(Card sender, Card receiver, double amount){
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
    }
}
