package com.example.myAktion.domain;

import javax.persistence.Embeddable;

@Embeddable
public class Account {
    private String iban;
    private String name;
    private String nameOfBank;
    
    public String getIban() {
        return this.iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameOfBank() {
        return this.nameOfBank;
    }

    public void setNameOfBank(String nameOfBank) {
        this.nameOfBank = nameOfBank;
    }

}