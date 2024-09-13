package com.wipro.training.home_fin.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.wipro.training.home_fin.model.Customer;

import java.util.Optional;

public interface CustomerRepository extends MongoRepository<Customer, String> {
    Optional<Customer> findByEmail(String email);
}