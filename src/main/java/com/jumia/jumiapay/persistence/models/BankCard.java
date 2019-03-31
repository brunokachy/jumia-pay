package com.jumia.jumiapay.persistence.models;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by bruno on
 * Sat, 30 Mar, 2019
 */

@Entity
@Table(name = "bank_card")
public class BankCard implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false, unique = true)
    private String cardNumber;

    @Column(nullable = false)
    private String scheme;

    @Column(nullable = false)
    private String type;

    private String bank;

    private long totalRequest = 1;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getScheme() {
        return scheme;
    }

    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public long getTotalRequest() {
        return totalRequest;
    }

    public void setTotalRequest(long totalRequest) {
        this.totalRequest = totalRequest;
    }
}
