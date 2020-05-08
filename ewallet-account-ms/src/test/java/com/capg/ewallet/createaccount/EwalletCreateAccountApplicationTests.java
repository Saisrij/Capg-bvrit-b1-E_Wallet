package com.capg.ewallet.createaccount;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.ewallet.accountms.model.WalletAccount;
import com.capg.ewallet.accountms.model.WalletUser;
import com.capg.ewallet.accountms.repository.IAccountRepo;
import com.capg.ewallet.accountms.repository.IUserRepo;
import com.capg.ewallet.accountms.service.IUserService;

@SpringBootTest
class EwalletCreateAccountApplicationTests {
	@Autowired
	IUserService service;
	@Autowired
	IAccountRepo repo;
	IUserRepo repo1;
	

	@Test
	public void createaccounttest () {
		WalletUser bean = new WalletUser();
		bean.setUserId(101);
		bean.setUserName("Sai");
		bean.setPassword("12345");
		bean.setPhoneNumber(957355676);
		bean.setLoginName("Sai");
		assertThat(service.createUserAccount(bean)).isEqualTo(bean);
	}
	@Test
	public void addmounttest() {
		WalletAccount bean = new WalletAccount();
		double amount = 300;
		bean.setAccountId(101);
		bean.setAccountBalance(1200);
		double account = bean.getAccountBalance() + amount;
		assertEquals(true,service.addAmount(101,300)=account);
		
	}
	@Test
	public void showbalancetest() {
		assertEquals(true,repo.getOne(101)!=null);
	}
	@Test
	public void fundTransfertest() {
		WalletAccount bean = new WalletAccount();
		
		
	}
	
	}
	


