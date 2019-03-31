package com.jumia.jumiapay.infrastructure.dto;

import lombok.Data;

/**
 * Created by bruno on
 * Sat, 30 Mar, 2019
 */
//@Data
public class BankCardDTO {

    private String bank;

    private String type;

    private String scheme;

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getScheme() {
        return scheme;
    }

    public void setScheme(String scheme) {
        this.scheme = scheme;
    }
}
