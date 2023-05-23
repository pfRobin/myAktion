package com.example.myAktion.controller;

import java.util.List;

import javax.persistence.AttributeOverride;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.myAktion.domain.Campaign;
import com.example.myAktion.domain.CampaignRep;
import com.example.myAktion.service.CampaignService;

@RestController
public class CampaignController {
    
    @Autowired
    private CampaignService campaignService;

    @GetMapping("/campaigns")
    public List<Campaign> getAllCampaigns(){
        return campaignService.getCampaigns();
    }

    @PostMapping("/campaigns")
    public Campaign newCampaign(@RequestBody Campaign newCampaign){
        return campaignService.addCampaign(newCampaign);
    }

    @GetMapping("/campaigns/{id}")
    public Campaign getCampaignById(@PathVariable String id){
        return campaignService.getCampaignById(Long.parseLong(id));
    }

    @PutMapping("campaigns/{id}")
    public Campaign updatesCampaignId(@PathVariable String id, @RequestBody Campaign idNew){
        return campaignService.updateCampaignId(Long.parseLong(id), idNew);
    }

    @DeleteMapping("campaigns/{id}")
    void deleteCampaign(@PathVariable String id){
        campaignService.deleteCampaign(Long.parseLong(id)); 
    }

}
