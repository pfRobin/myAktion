package com.example.myAktion.domain;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;


@Entity
public class Campaign {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)    
    private Long id;
    private String name;
    private double donationMinimum;
    private double targetAmount;


    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name="name", column = @Column(name="accountName"))
    })


    public void addDonation(Donation donation){
        
    }


    
    private Account account;
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDonationMinimum() {
        return this.donationMinimum;
    }

    public void setDonationMinimum(double donationMinimum) {
        this.donationMinimum = donationMinimum;
    }

    public double getTargetAmount() {
        return this.targetAmount;
    }

    public void setTargetAmount(double targetAmount) {
        this.targetAmount = targetAmount;
    }

}
