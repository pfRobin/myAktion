package com.example.myAktion.domain;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.FetchType;


import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import javax.persistence.Column;


@Entity
public class Campaign {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @JsonProperty(access=Access.READ_ONLY)
    private Long id;
    private String name;
    private double donationMinimum;
    private double targetAmount;


    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name="name", column = @Column(name="accountName"))
    })
    private Account account;
    
    @OneToMany(mappedBy="campaign", cascade= CascadeType.ALL, fetch= FetchType.EAGER)
    private List<Donation> donations = new LinkedList<Donation>();

    public void addDonation(Donation donation){
        donations.add(donation);
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", donationMinimum='" + getDonationMinimum() + "'" +
            ", targetAmount='" + getTargetAmount() + "'" +
            ", account='" + getAccount() + "'" +
            ", donations='" + donations.size() + "'" +
            "}";
    }


    private String getName() {
        return name;
    }


    public Long getId() {
        return id;
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

    public List<Donation> getDonations() {
        return this.donations;
    }

    public void setDonations(List<Donation> donations) {
        this.donations = donations;
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
