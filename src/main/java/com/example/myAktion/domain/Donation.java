package com.example.myAktion.domain;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
public class Donation {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @JsonProperty(access=Access.READ_ONLY)
    private Long id;
    private double amount;
    private boolean receiptRequested;
    private String donorName;

    @Embedded
    private Account account;

    @ManyToOne
    @JsonIgnore
    private Campaign campaign;


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Account getAccount() {
        return this.account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Campaign getCampaign() {
        return this.campaign;
    }

    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
    }

    public Status getStatus() {
        return this.status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }


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

    @Override
    public String toString() {
        return "Donation [id=" + id + ", amount=" + amount + ", receiptRequested=" + receiptRequested + ", donorName="
                + donorName + ", account=" + account + ", campaign=" + campaign + ", status=" + status + "]";
    }


    

}
