package com.capg.ewallet.fundtransfer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.ewallet.fundtransfer.model.WalletAccount;
import com.capg.ewallet.fundtransfer.service.FundTransferServiceImpl;


@RestController
@RequestMapping("/transfer")
public class FundTransferController {
	
	@Autowired
	FundTransferServiceImpl service;
	
	
	@GetMapping("/account/id/{fromId}/id/{toId}/amount/{amount}")
	public WalletAccount fundtransfer(@PathVariable ("fromId") int fromAccountId,@PathVariable ("toId") int toAccountId,
			@PathVariable("amount") double amount) {
		return service.fundtransfer(amount, fromAccountId,toAccountId);
	}
	
	
	@GetMapping("/account/id/{id}/amount/{amount}")
	public WalletAccount addAmount(@PathVariable("id") int id, @PathVariable("amount") double amount) {
		return service.addAmount(amount, id);
	}
}
