package com.capg.ewallet.fundtransfer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capg.ewallet.fundtransfer.model.WalletAccount;
import com.capg.ewallet.fundtransfer.model.WalletTransactions;
import com.capg.ewallet.fundtransfer.repository.FundTransferRepo;
import com.capg.ewallet.fundtransfer.service.FundTransferServiceImpl;


@RestController
@RequestMapping("/transfer")
public class FundTransferController {
	@Autowired
	FundTransferServiceImpl service;
	@Autowired
	FundTransferRepo repo;
	
	@GetMapping("/message")
	public String printMessage() {
		return "Hello";
	}
	
	@GetMapping("/account/id/{fromId}/id/{toId}/amount/{amount}")
	public List<WalletAccount> fundtransfer(@PathVariable ("fromId") int fromAccountId,@PathVariable ("toId") int toAccountId,
			@PathVariable("amount") double amount) {
		System.out.println(fromAccountId);
		System.out.println(toAccountId);
		System.out.println(amount);
		WalletAccount fromAcc=new WalletAccount(101,500);
		WalletAccount toAcc=new WalletAccount(102,300);
		//repo.save(fromAcc);
		//repo.save(toAcc);

		WalletAccount fromAccount=service.getAccountById(fromAccountId);
		WalletAccount toAccount=service.getAccountById(toAccountId);
		return service.fundtransfer(amount, fromAccount,toAccount);
	}
	@GetMapping("/account/id/{id}")
	public WalletAccount addAmount(@PathVariable int id, @RequestBody double amount) {
		WalletAccount fromAcc=new WalletAccount(101,500);
		WalletAccount account1=service.getAccountById(id);
		return service.addAmount(amount, account1);
	}
}
