package com.capg.ewallet.fundtransfer.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.ewallet.fundtransfer.model.WalletAccount;
import com.capg.ewallet.fundtransfer.model.WalletTransactions;
import com.capg.ewallet.fundtransfer.repository.FundTransferRepo;
@Service
public class FundTransferServiceImpl implements FundTransferService {
	@Autowired
	FundTransferRepo repo;
	
	
	public WalletAccount getAccountById(int id) {
		return repo.getOne(id);
	}
	
	@Transactional
	public WalletAccount addAmount(double amount,WalletAccount account) {
		WalletAccount account1=repo.getOne(account.getAccountId());
		double newAmount=amount+account1.getAccountBalance();
		account1.setAccountBalance(newAmount);
		return account1;
	}
	
	
	
	public WalletTransactions createBasicTransaction() {
		WalletTransactions transaction=new WalletTransactions();
		Random r=new Random();
		LocalDateTime now=LocalDateTime.now();
		int transactionId=r.nextInt(1000);
		transaction.setTransactionId(transactionId);
		transaction.setDateOfTransaction(now);
		return transaction;
		
	}

	public WalletAccount fundtransfer(double amount, WalletAccount fromAccount, WalletAccount toAccount) {
		
		List<WalletTransactions> fromTransactionList=fromAccount.getTransactions();
		List<WalletTransactions> toTransactionList=toAccount.getTransactions();
		
		fromAccount.setAccountBalance(fromAccount.getAccountBalance() - amount);
		toAccount.setAccountBalance(toAccount.getAccountBalance() + amount);
		
		
		WalletTransactions fromTransaction=createBasicTransaction();
		fromTransaction.setDescription("Transaction Successfull: Amount Debited");
		fromTransaction.setAccountBalance(fromAccount.getAccountBalance());
		fromTransaction.setAmount(amount);
		System.out.println("From transactions"+fromTransaction);
		fromTransactionList.add(fromTransaction);
		fromAccount.setTransactionHistory(fromTransactionList);
		
		WalletTransactions toTransaction=createBasicTransaction();
		toTransaction.setTransactionId(fromTransaction.getTransactionId());
		toTransaction.setDescription("Transaction Successfull: Amount Credited");
		toTransaction.setAccountBalance(toAccount.getAccountBalance());
		toTransaction.setAmount(amount);
		System.out.println("To transactions"+toTransaction);
		toTransactionList.add(toTransaction);
		toAccount.setTransactionHistory(toTransactionList);
		return fromAccount;

	}


}
