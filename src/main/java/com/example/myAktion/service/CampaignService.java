package com.example.myAktion.service;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.myAktion.domain.Campaign;
import com.example.myAktion.domain.CampaignRep;
import com.example.myAktion.domain.DonationRep;
import com.example.myAktion.domain.exceptions.CampaignNotFoundException;

@Component
public class CampaignService {
    @Autowired
    private CampaignRep campaignRep;


    public Campaign addCampaign(Campaign campaign){
        return campaignRep.save(campaign);

    }

    public java.util.List<Campaign> getCampaigns(){
        return campaignRep.findAll();
    }

    public Campaign getCampaignById(Long id) throws CampaignNotFoundException{
        return campaignRep.findById(id).orElseThrow(()->new CampaignNotFoundException(null));
    }

    public Campaign updateCampaignId(Long id, Campaign camp) throws CampaignNotFoundException{
        Campaign campaign2 = campaignRep.findById(id).orElseThrow(()->new CampaignNotFoundException(null));
        campaignRep.deleteById(campaign2.getId());
        return campaignRep.save(camp);

    }

    public void deleteCampaign(Long id){
        campaignRep.deleteById(id);
    }

}
