package com.example.services;

import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.entities.Customer;
import com.example.repositories.CustomerRepo;

@Service
public class CustomerService implements UserDetailsService{

	@Autowired
	private CustomerRepo customerRepo; 
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Customer cust=customerRepo.findByEmail(username);
		return new User(cust.getEmail(), cust.getPassword(), Collections.emptyList());
	}

}
