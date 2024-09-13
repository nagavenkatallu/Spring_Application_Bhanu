package com.wipro.training.home_fin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.training.home_fin.model.Customer;
import com.wipro.training.home_fin.service.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	@PostMapping("/register")
	public ResponseEntity<String> registerCustomer(@RequestBody Customer customer)
	{
//		ResponseEntity<String> responseEntity;
//		try {
//            customerService.registerCustomer(customer);
//            responseEntity.ok("Customer registered successfully");
//        } catch (Exception e) {
//            responseEntity.badRequest().body(e.getMessage());
//        }
//		return responseEntity;
		customerService.registerCustomer(customer);
        return ResponseEntity.ok("Customer registered successfully");
	}
	
	 @PostMapping("/login")
	    public ResponseEntity<String> login(@RequestBody Customer customer) {
		 if(customerService.login(customer.getEmail(), customer.getPassword()).isEmpty()) {
			 return ResponseEntity.badRequest().body("Wrong credentials");
		 }
		 else {
			return ResponseEntity.ok("Logged in successfully");
		}
	 }
}
