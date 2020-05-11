package com.capg.ewallet.gateway.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.capg.ewallet.gateway.model.UserCredentials;
import com.capg.ewallet.gateway.model.WalletAccount;
import com.capg.ewallet.gateway.util.TokenUtil;

@Service
public class MyUserDetailsService{
	
	@Autowired
	RestTemplate restTemplate;
	@Autowired
	TokenUtil tokenUtil;
	
	public WalletAccount  loadUserByUserCrenditials(UserCredentials cred) {
		// TODO Auto-generated method stub
		WalletAccount userAccount=null;
		try {
		userAccount = restTemplate.postForObject("http://localhost:8100/account/user/authenticate",cred, WalletAccount.class);
		}
		catch (Exception e) {
			//throw new ResponseStatusException(HttpStatus.FORBIDDEN,e.getMessage());
			return null;
			}
		if(userAccount==null) {
			return null;
		}
		return userAccount;
		
	}
}
