package com.capg.ewallet.accountms.service;

import java.util.List;
import java.util.Random;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.ewallet.accountms.exceptions.LoginNameExistsException;
import com.capg.ewallet.accountms.exceptions.UserAccountNotFoundException;
import com.capg.ewallet.accountms.model.WalletAccount;
import com.capg.ewallet.accountms.model.WalletTransactions;
import com.capg.ewallet.accountms.model.WalletUser;
import com.capg.ewallet.accountms.repository.IAccountRepo;
import com.capg.ewallet.accountms.repository.IUserRepo;

@Service
public class UserServiceImpl implements IUserService{
	
	@Autowired
	IUserRepo userRepo;
	
	@Autowired
	IAccountRepo accountRepo;
	
	@Transactional
	public WalletUser createUserAccount(WalletUser newUser) {
		
		String loginName=newUser.getLoginName();
		List<WalletUser> usersList=getAllUsers();
		for(WalletUser user: usersList) {
			if(loginName==user.getLoginName()) {
				throw new LoginNameExistsException("Name already exists: Enter other login name");
			}
		}
		
		Random randomNumber=new Random();
		int newUserId=randomNumber.nextInt(1000);
		int newAccountId=randomNumber.nextInt(1000);

		newUser.setUserId(newUserId);
		WalletUser addUser=userRepo.save(newUser);
	
		WalletAccount newAccount=new WalletAccount();
	    newAccount.setAccountId(newAccountId);
	    newAccount.setAccountBalance(0);
	    newAccount.setTransactions(null);
	    newAccount.setWalletUser(addUser);
	    accountRepo.save(newAccount);   
		return addUser;
	}
	
	
	@Transactional
	public WalletAccount getAccountById(int accountId) {
		if(!accountRepo.existsById(accountId)) {
			throw new UserAccountNotFoundException("Account Not Found with ID ["+accountId+"]");
		}
		return accountRepo.getOne(accountId);
	}
	
	@Transactional
	public WalletUser getUserById(int userId) {
		if(!userRepo.existsById(userId)) {
			throw new UserAccountNotFoundException("User Not Found with ID ["+userId+"]");
		}
		return userRepo.getOne(userId);
	}
	
	@Transactional
	public WalletUser updateUserDetails(int userId,WalletUser newUserData) {
		if(!userRepo.existsById(userId)) {
			throw new UserAccountNotFoundException("User Not Found with ID ["+userId+"]");
		}
		WalletUser oldUser=userRepo.getOne(userId);
		newUserData.setUserName(oldUser.getUserName());
		newUserData.setPassword(oldUser.getPassword());
		newUserData.setPhoneNumber(oldUser.getPhoneNumber());
		return userRepo.save(newUserData);
	}
	
	@Transactional
	public boolean deleteUser(int userId) {
		if(!userRepo.existsById(userId)) {
			throw new UserAccountNotFoundException("User Not Found with ID ["+userId+"]");
		}
		userRepo.deleteById(userId);
		if(!userRepo.existsById(userId)) {
			return true;
		}
		return false;
	}
	
	@Transactional
	public List<WalletUser> getAllUsers(){
		return userRepo.findAll();
	}
	
	@Transactional
	public List<WalletAccount> getAllAccounts(){
		return accountRepo.findAll();
	}
	
	@Transactional
	public double getAccountBalance(int accountId) {
		if(!accountRepo.existsById(accountId)) {
			throw new UserAccountNotFoundException("Account Not Found with ID ["+accountId+"]");
		}
		WalletAccount account=accountRepo.getOne(accountId);
		return account.getAccountBalance();
	}
	
	@Transactional
	public List<WalletTransactions> getAllTransactions(int accountId){
		if(!accountRepo.existsById(accountId)) {
			throw new UserAccountNotFoundException("Account Not Found with ID ["+accountId+"]");
		}
		WalletAccount account=accountRepo.getOne(accountId);
		return account.getTransactions();
	}

}
