package com.capg.ewallet.accountms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.ewallet.accountms.model.WalletAccount;
import com.capg.ewallet.accountms.model.WalletUser;
import com.capg.ewallet.accountms.service.UserServiceImpl;
import com.capg.ewallet.accountms.service.IUserService;

@RestController
@RequestMapping("/account-management")
public class CreateUserAccountController {
	
	@Autowired
	IUserService service;
	
	@PostMapping("/user/add")
	public WalletUser createUserAccount(@RequestBody WalletUser newUser) {
		return service.createUserAccount(newUser);
	}
	
	@GetMapping("/user/id/{userId}")
	public WalletUser getUserById(@PathVariable("userId")int userId) {
		return service.getUserById(userId);
	}

	@GetMapping("/account/id/{accountId}")
	public WalletAccount getAccountById(@PathVariable("accountId") int accountId) {
		return service.getAccountById(accountId);
	}
	
	@PutMapping("/user/update")
	public WalletUser updateUserDetails(@RequestBody WalletUser newUserData) {
		int userId=newUserData.getUserId();
		return service.updateUserDetails(userId, newUserData);
	}
	
	@DeleteMapping("/user/delete/id/{userId}")
	public boolean deleteUser(@PathVariable("userId") int userId) {
		return service.deleteUser(userId);
	}
	
	@GetMapping("/get-accounts")
	public List<WalletAccount> getAllAccounts(){
		return service.getAllAccounts();
	}
	@GetMapping("/get-users")
	public List<WalletUser> getAllUsers(){
		return service.getAllUsers();
	}
}
