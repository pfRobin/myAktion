package com.example.myAktion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.myAktion.domain.Campaign;
import com.example.myAktion.domain.CampaignRep;
import com.example.myAktion.domain.Donation;
import com.example.myAktion.service.CampaignService;
import com.example.myAktion.service.DonationService;

@SpringBootApplication
public class MyAktionApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyAktionApplication.class, args);
	}

	@Autowired
	CampaignService campaignService;

	@Autowired
	DonationService donationService;

	@Bean
	CommandLineRunner runner() {
		return (args)->{
			Campaign campaign1 = new Campaign();
			Donation donation1 = new Donation();
			Donation donation2 = new Donation();
		
			Campaign savedCampaign = campaignService.addCampaign(campaign1);

			donationService.addDonation(donation1, savedCampaign.getId());
			donationService.addDonation(donation2, savedCampaign.getId());

			System.out.println(campaignService.getCampaigns());

		};
		
	}

}
