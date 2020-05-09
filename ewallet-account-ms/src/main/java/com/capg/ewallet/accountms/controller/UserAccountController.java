package com.capg.ewallet.accountms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.ewallet.accountms.model.WalletAccount;
import com.capg.ewallet.accountms.model.WalletTransactions;
import com.capg.ewallet.accountms.model.WalletUser;
import com.capg.ewallet.accountms.service.IUserService;

@RestController
@RequestMapping("/account")
@CrossOrigin(origins = "http://localhost:4200")
public class UserAccountController {
	
	@Autowired
	IUserService userService;
	
	
	@PostMapping("/user/add")
	public WalletUser createUserAccount(@RequestBody WalletUser newUser) {
		return userService.createUserAccount(newUser);
	}
	

	@GetMapping("/admin/account/id/{accountId}")
	public WalletAccount getAccountById(@PathVariable("accountId") int accountId) {
		return userService.getAccountById(accountId);
	}
	
	@PutMapping("/user/update")
	public WalletUser updateUserDetails(@RequestBody WalletUser newUserData) {
		return userService.updateUserDetails(newUserData);
	}
	
	@DeleteMapping("/user/delete/id/{userId}")
	public boolean deleteUser(@PathVariable("userId") int userId) {
		return userService.deleteUser(userId);
	}
	
	@GetMapping("/admin/get-accounts")
	public List<WalletAccount> getAllAccounts(){
		return userService.getAllAccounts();
	}
	@GetMapping("/admin/get-users")
	public List<WalletUser> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@GetMapping("/user/balance/{accountId}")
	public double getAccountBalance(@PathVariable("accountId") int accountId) {
		return userService.getAccountBalance(accountId);
	}
	@GetMapping("/user/transactions/{accountId}")
	public List<WalletTransactions> getAllTransactions(@PathVariable("accountId") int accountId){
		return userService.getAllTransactions(accountId);
	}
	
	
	@GetMapping("/user/from-id/{fromId}/to-id/{toId}/amount/{amount}")
	public WalletAccount fundtransfer(@PathVariable ("fromId") int fromAccountId,@PathVariable ("toId") int toAccountId,
			@PathVariable("amount") double amount) {
		return userService.fundtransfer(amount, fromAccountId,toAccountId);
	}
	@GetMapping("/user/addamount/id/{id}/amount/{amount}")
	public double addAmount(@PathVariable int id, @PathVariable("amount") double amount) {
		return userService.addAmount(amount, id);
	}
	
	@GetMapping("/user/get-accountid/{userId}")
	public int getUserAccountId(@PathVariable("userId")int userId) {
		return userService.getUserAccountId(userId);
	}
	
	@GetMapping("/p/get-account/{loginName}")
	public WalletAccount getAccountByLoginName(@PathVariable("loginName") String loginName) {
		return userService.getAccountByLoginName(loginName);
	}
}

