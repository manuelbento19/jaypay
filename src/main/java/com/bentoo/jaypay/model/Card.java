package com.bentoo.jaypay.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Table(name = "cards")
public class Card {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(nullable = false,unique = true)
    private String cardNumber;

    @ManyToOne
    @JoinColumn(name = "accountId",nullable = false)
    @JsonIgnore
    private Account account;

    private String cvv;

    @ColumnDefault("0.0")
    private double amount;
    @ColumnDefault("true")
    private boolean active;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    private LocalDateTime expireAt;

}
