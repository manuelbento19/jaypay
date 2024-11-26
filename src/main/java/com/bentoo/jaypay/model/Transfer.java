package com.bentoo.jaypay.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "transfers")
public class Transfer {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "sender_id")
    private Card sender;

    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private Card receiver;

    @Column(nullable = false)
    private double amount;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
