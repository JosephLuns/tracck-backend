package com.avviotech.labs.service;

import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.avviotech.labs.model.AmazonModel;

@RestController
@RequestMapping("/public/rest/amazon")
public class AmazonService {

	@RequestMapping(value = "/getProfile", method = RequestMethod.POST)
    public String getCustomerProfile(@RequestHeader("accesstoken")  String accesstoken){
        return AmazonModel.getCustomerProfileData(accesstoken);
    }
}
