package com.example.myAktion.domain.exceptions;

public class CampaignNotFoundException extends RuntimeException{
    
    public CampaignNotFoundException(String errorMessage){
        super(errorMessage);
    }


    
}
