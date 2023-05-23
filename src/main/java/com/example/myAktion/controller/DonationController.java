package com.example.myAktion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.myAktion.domain.Donation;
import com.example.myAktion.service.DonationService;

@RestController
public class DonationController {
    @Autowired
    DonationService donationService;

    @PostMapping("/campaigns/{id}/donations")
    public Donation addDonationToCampaignWithId(@RequestBody Donation donation, @PathVariable String id){
        return donationService.addDonation(donation, Long.parseLong(id));
    }
}
