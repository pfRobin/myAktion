package com.example.myAktion.domain;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Donation {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private double amount;
    private boolean receiptRequested;
    private String donorName;

    @Embedded
    private Account account;

    public enum Status {
        IN_PROCESS, TRANSFERRED
    }

    @Enumerated(EnumType.STRING)
    private Status status = Status.IN_PROCESS;

    public double getAmount() {
        return this.amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public boolean isReceiptRequested() {
        return this.receiptRequested;
    }

    public boolean getReceiptRequested() {
        return this.receiptRequested;
    }

    public void setReceiptRequested(boolean receiptRequested) {
        this.receiptRequested = receiptRequested;
    }

    public String getDonorName() {
        return this.donorName;
    }

    public void setDonorName(String donorName) {
        this.donorName = donorName;
    }

}
