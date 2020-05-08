<<<<<<< HEAD
package com.capg.ewallet.accountms.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UserAccountNotFoundException extends RuntimeException {
	
	public UserAccountNotFoundException(String message) {
		super(message);
	}
	
}
=======
package com.capg.ewallet.accountms.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UserAccountNotFoundException extends RuntimeException {
	
	public UserAccountNotFoundException(String message) {
		super(message);
	}
	
}
>>>>>>> branch 'master' of https://github.com/Saisrij/Capg-bvrit-b1-E_Wallet.git
