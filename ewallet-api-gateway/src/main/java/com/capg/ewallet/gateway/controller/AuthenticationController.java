package com.capg.ewallet.gateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.capg.ewallet.gateway.model.AuthenticationResponse;
import com.capg.ewallet.gateway.model.UserCredentials;
import com.capg.ewallet.gateway.model.WalletAccount;
import com.capg.ewallet.gateway.service.MyUserDetailsService;
import com.capg.ewallet.gateway.util.TokenUtil;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AuthenticationController {
	
	@Autowired
	MyUserDetailsService userDetailsService;
	
	
	@Autowired
	TokenUtil tokenUtil;
	
	@PostMapping("/user/authenticate")
	public AuthenticationResponse authenticate(@RequestBody UserCredentials cred) {
		try {
		WalletAccount authenticatedUser=userDetailsService.loadUserByUserCrenditials(cred);
		System.err.println(authenticatedUser);
		 if(authenticatedUser==null) {
			 throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
		 }
			String token=tokenUtil.generateToken(cred.getUsername(), cred.getPassword());
			
			AuthenticationResponse tokenResponse=new AuthenticationResponse(token);
		
			return tokenResponse;
		}
		catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
		}
	}
	
}
