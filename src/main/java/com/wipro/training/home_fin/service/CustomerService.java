package com.wipro.training.home_fin.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.wipro.training.home_fin.model.Customer;
import com.wipro.training.home_fin.repository.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public String registerCustomer(Customer customer)
	{
		if (!customer.getPassword().equals(customer.getConfirmPassword())) {
            return "Passwords do not match";
        }
		
		// Encode the password
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));

        // Remove the plain-text confirmPassword before saving
        customer.setConfirmPassword(null);

        // Set default role (e.g., USER) if not already set
        if (customer.getRoles() == null || customer.getRoles().isEmpty()) {
            Set<String> roles = new HashSet<>();
            roles.add("USER");
            customer.setRoles(roles);
        }

        // Save user to the repository
        customerRepository.save(customer);

        return "User registered successfully";
	}
	public Optional<Customer> login(String email, String password) {
        Optional<Customer> customer = customerRepository.findByEmail(email);
        if (customer.isPresent() && passwordEncoder.matches(password, customer.get().getPassword())) {
            return customer;
        }
        return Optional.empty();
    }
	
    
    
}
