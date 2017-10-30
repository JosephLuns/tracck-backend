package com.avviotech.labs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.avviotech.labs.dto.User;
import com.avviotech.labs.model.CustomerModel;
import com.avviotech.labs.repository.UserRepository;

@RestController
@RequestMapping("/public/rest/user")
public class UserService {

	@Autowired
	private UserRepository userRepository;
	@RequestMapping(value = "/register", method = RequestMethod.POST)
    public CustomerModel getCustomerProfile(@RequestParam("username")  String username,@RequestParam("mobile")  String mobile){
        User t = userRepository.findBymobile(mobile);
        if(t != null)
        {
        	CustomerModel m = new CustomerModel();
        	m.setUser(t);
        	m.setStatus("success");
        	m.setError("");
        	
        	return m;
        }
        else
        {
        	t = new User();
        	t.setMobile(mobile);
        	t.setPassword("");
        	t.setUserName(username);
        	userRepository.save(t);
        	
        	CustomerModel m = new CustomerModel();
        	m.setUser(t);
        	m.setStatus("success");
        	m.setError("");
        	
        	return m;
        }
    }
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
    public CustomerModel loginCustomer(@RequestParam("mobile") String mobile){
		User t = userRepository.findBymobile(mobile);
		
		if(t != null)
        {
			CustomerModel m = new CustomerModel();
        	m.setUser(t);
        	m.setStatus("success");
        	m.setError("");
        	
        	return m;
        }
        else
        {
        	CustomerModel m = new CustomerModel();
        	m.setStatus("failure");
        	m.setError("Invalid Credentials");
        	
        	return m;
        }
		
    }
}
