package com.capg.ewallet.createaccount;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.ewallet.fundtransfer.exceptions.NameDoesNotExistsException;
import com.capg.ewallet.fundtransfer.exceptions.UserNotFoundException;
import com.capg.ewallet.fundtransfer.model.WalletAccount;
import com.capg.ewallet.fundtransfer.repository.FundTransferRepo;
import com.capg.ewallet.fundtransfer.service.FundTransferService;

@SpringBootTest
class EwalletCreateAccountApplicationTests {
	
	@Autowired
	FundTransferService service;
	
	@Autowired
	FundTransferRepo accountRepo;

	@Test
	void contextLoads() {
	}
	@Test
	public void addmounttest() {
		WalletAccount bean = accountRepo.getOne(945);
		double balance=bean.getAccountBalance()+300;
		assertEquals(balance,service.addAmount(300,945));
	}   
	
	@Test
	public void addAmountException() {
		Assertions.assertThrows(NameDoesNotExistsException.class, () -> {
		      service.addAmount(0, 945);
		    });
	}
	
	@Test
	public void accountNotFoundException() {
		Assertions.assertThrows(UserNotFoundException.class, () -> {
		      service.getAccountById(123);
		    });
	}
	@Test
	public void fundTransfertest() {
		
	}

}
