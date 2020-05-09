package com.capg.ewallet.createaccount;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
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
	
	@BeforeAll
	public WalletAccount getAccountById() {
		return repo.getOne(945);
	}
	

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
		WalletAccount bean =getAccountById();
		double balance=bean.getAccountBalance()+300;
		assertEquals(balance,service.addAmount(300,945));
		
	}
	@Test
	public void showbalancetest() {
		assertEquals(true,repo.getOne(101)!=null);
	}
	@Test
	public void fundTransfertest() {
		
	}
}



//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//
//@SpringBootTest
//class EwalletCreateAccountApplicationTests {
//
//	@Test
//	void contextLoads() {
//	}
//
//}

