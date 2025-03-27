package com.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.Customer;



@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {
	Customer findByEmail(String email);
}
