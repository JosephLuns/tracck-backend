package com.avviotech.labs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.avviotech.labs.model.CustomerModel;
import com.avviotech.labs.repository.UserRepository;

@RestController
@RequestMapping("/public/rest/amazon")
public class AmazonService {
	
	@Autowired
	private UserRepository userRepository;
	@RequestMapping(value = "/login", method = RequestMethod.POST)
    public CustomerModel loginCustomer(@RequestHeader("userid")  String userid,@RequestHeader("password")  String password
    		,@RequestHeader("locale")  String locale,@RequestHeader("otp")  String otp){
		return Automate.automate(userid, password,otp,userRepository);
    }
}
