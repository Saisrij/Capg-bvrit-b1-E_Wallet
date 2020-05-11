package com.capg.ewallet.gateway.util;

import org.springframework.stereotype.Component;

import com.capg.ewallet.gateway.model.UserCredentials;

@Component
public class TokenUtil {

	public String generateToken(String userName,String password) {
		
			StringBuilder userNameSB=new StringBuilder(userName);
			StringBuilder passwordSB=new StringBuilder(password);
			String encoded=userNameSB.reverse()+","+passwordSB.reverse();
			return encoded;
			
	}
	
	public UserCredentials decode(String token) {
		String []cred=token.split(",");
		StringBuilder userNameSB=new StringBuilder(cred[0]);
		StringBuilder passwordSB=new StringBuilder(cred[1]);
		return new UserCredentials(userNameSB.reverse().toString(),passwordSB.reverse().toString());
		
		
	}
}
