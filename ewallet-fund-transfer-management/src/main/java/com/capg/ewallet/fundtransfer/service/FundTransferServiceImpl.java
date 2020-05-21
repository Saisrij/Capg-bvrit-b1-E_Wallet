package com.capg.ewallet.fundtransfer.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.capg.ewallet.fundtransfer.exceptions.NameDoesNotExistsException;
import com.capg.ewallet.fundtransfer.exceptions.UserNotFoundException;
import com.capg.ewallet.fundtransfer.model.WalletAccount;
import com.capg.ewallet.fundtransfer.model.WalletTransactions;
import com.capg.ewallet.fundtransfer.repository.FundTransferRepo;
import com.capg.ewallet.fundtransfer.repository.TransactionRepo;

@Service
public class FundTransferServiceImpl implements FundTransferService {
	@Autowired
	FundTransferRepo accountRepo;
	
	@Autowired
	TransactionRepo transactionsRepo;

	@Transactional
	public WalletAccount getAccountById(int accountId) {
		if (!accountRepo.existsById(accountId)) {
			throw new UserNotFoundException("Account Not Found with ID [" + accountId + "]");
		}
		return accountRepo.getOne(accountId);
	}

	public WalletTransactions createBasicTransaction() {
		WalletTransactions transaction = new WalletTransactions();
		Random r = new Random();
		LocalDateTime now = LocalDateTime.now();
		int transactionId = r.nextInt(1000);
		transaction.setTransactionId(transactionId);
		transaction.setDateOfTransaction(now);
		return transactionsRepo.save(transaction);
		}
	
	
	@Transactional
	public WalletAccount addAmount(double amount, int accountId) {
		WalletAccount account = accountRepo.getOne(accountId);
		if (amount == 0 || amount<0 || amount>10000) {
			throw new NameDoesNotExistsException("Enter valid amount");
		}
		else
		{
			double newAmount = amount + account.getAccountBalance();
			WalletTransactions addTransaction=createBasicTransaction();
			addTransaction.setAccountBalance(newAmount);
			addTransaction.setAmount(amount);
			addTransaction.setDescription("Amount of Rs"+amount+"/- added successfully");
			List<WalletTransactions> transactionsList=account.getTransactions();
			transactionsList.add(addTransaction);
			account.setAccountBalance(newAmount);
			account.setTransactions(transactionsList);
			//transactionsRepo.save(addTransaction);
			accountRepo.save(account);
		}
		return account;
	}

	

	@Transactional
	public WalletAccount fundtransfer(double amount, int fromAccountId, int toAccountId) {
		//List<WalletAccount> list = new ArrayList<WalletAccount>();
		if(!accountRepo.existsById(toAccountId)) {
			throw new UserNotFoundException("Account Not found with id ["+toAccountId+"]");
		}
		WalletAccount fromAccount=getAccountById(fromAccountId);
		WalletAccount toAccount=getAccountById(toAccountId);

		List<WalletTransactions> fromTransactionList = fromAccount.getTransactions();
		List<WalletTransactions> toTransactionList = toAccount.getTransactions();
		if(amount>fromAccount.getAccountBalance()) {
			throw new NameDoesNotExistsException("Balance insufficient");
		}

		fromAccount.setAccountBalance(fromAccount.getAccountBalance() - amount);
		toAccount.setAccountBalance(toAccount.getAccountBalance() + amount);

		WalletTransactions fromTransaction = createBasicTransaction();
		fromTransaction.setDescription("Transaction Successfull: Amount of Rs:"+amount+" Debited from your account");
		fromTransaction.setAccountBalance(fromAccount.getAccountBalance());
		fromTransaction.setAmount(amount);
		fromTransactionList.add(fromTransaction);
		fromAccount.setTransactions(fromTransactionList);
		accountRepo.save(fromAccount);

		WalletTransactions toTransaction = createBasicTransaction();
		toTransaction.setDescription("Transaction Successfull: Amount of Rs:"+amount+" Credited to your account");
		toTransaction.setAccountBalance(toAccount.getAccountBalance());
		toTransaction.setAmount(amount);
		toTransactionList.add(toTransaction);
		toAccount.setTransactions(toTransactionList);
		accountRepo.save(toAccount);
	    //list.add(fromAccount);
		//list.add(toAccount);
		return fromAccount;
	}
	}



