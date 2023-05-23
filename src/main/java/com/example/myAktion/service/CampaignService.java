package com.example.myAktion.service;

import org.hibernate.mapping.List;

import com.example.myAktion.domain.Campaign;
import com.example.myAktion.domain.CampaignRep;
import com.example.myAktion.domain.DonationRep;
import java.util.Objects;


public class CampaignService {

    private CampaignRep campaignRep;
    private DonationRep donationRep;


public Campaign addCampaign(Campaign campaign){
    return campaignRep.save(campaign);

}


public java.util.List<Campaign> getCampaigns(){
    return campaignRep.findAll();
}


}
