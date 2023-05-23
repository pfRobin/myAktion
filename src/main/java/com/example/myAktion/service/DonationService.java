package com.example.myAktion.service;

import com.example.myAktion.domain.Campaign;
import com.example.myAktion.domain.CampaignRep;
import com.example.myAktion.domain.Donation;
import com.example.myAktion.domain.DonationRep;
import com.example.myAktion.domain.exceptions.CampaignNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class DonationService {
    @Autowired
    private CampaignRep campaignRep;
    @Autowired
    private DonationRep donationRep;


    public Donation addDonation(Donation donation, Long campaignId) throws CampaignNotFoundException{

        Campaign campaign = campaignRep.findById(campaignId).orElseThrow(()-> new CampaignNotFoundException(null));
        donation.setCampaign(campaign);
        return donationRep.save(donation);


    }

}
