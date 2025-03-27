package com.example.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.Customer;
import com.example.repositories.CustomerRepo;

@RestController
public class CustomerRestController {
	@Autowired
	private CustomerRepo customerRepo;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private AuthenticationManager authManager;

	@PostMapping("/register")
	public ResponseEntity<String> registration(@RequestBody Customer customer) {
		Customer cust = customerRepo.findByEmail(customer.getEmail());
			if(cust==null) {
			String encodedPassword = passwordEncoder.encode(customer.getPassword());
			customer.setPassword(encodedPassword);
			customerRepo.save(customer);
			return new ResponseEntity<>("Registration Successful", HttpStatus.CREATED);
		}
			return new ResponseEntity<>("Customer exist, Please login", HttpStatus.BAD_REQUEST);
	}

	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody Customer customer) {
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(customer.getEmail(),
				customer.getPassword());
		try {
			Authentication authenticate = authManager.authenticate(token);
			if (authenticate.isAuthenticated())
				return new ResponseEntity<>("Welcome to My World", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>("Invalid Credentials", HttpStatus.BAD_REQUEST);
	}
}
