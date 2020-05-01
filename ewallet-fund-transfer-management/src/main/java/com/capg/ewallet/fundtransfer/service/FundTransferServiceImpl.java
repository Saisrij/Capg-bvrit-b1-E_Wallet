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

@Service
public class FundTransferServiceImpl implements FundTransferService {
	@Autowired
	FundTransferRepo repo;

	@Transactional
	public WalletAccount getAccountById(int accountId) {
		if (!repo.existsById(accountId)) {
			throw new UserNotFoundException("Account Not Found with ID [" + accountId + "]");
		}
		return repo.getOne(accountId);
	}

	@Transactional
	public WalletAccount addAmount(double amount, WalletAccount accountId) {
		WalletAccount account1 = repo.getOne(accountId.getAccountId());

		if (amount < 0) {
			throw new NameDoesNotExistsException("Enter valid amount");
		} else {
			double newAmount = amount + account1.getAccountBalance();
			account1.setAccountBalance(newAmount);
		}
		return account1;
	}

	public WalletTransactions createBasicTransaction() {
		WalletTransactions transaction = new WalletTransactions();
		Random r = new Random();
		LocalDateTime now = LocalDateTime.now();
		int transactionId = r.nextInt(1000);
		transaction.setTransactionId(transactionId);
		transaction.setDateOfTransaction(now);
		return transaction;

	}

	public List<WalletAccount> fundtransfer(double amount, WalletAccount fromAccount, WalletAccount toAccount) {
		List<WalletAccount> list = new ArrayList<WalletAccount>();

		List<WalletTransactions> fromTransactionList = fromAccount.getTransactions();
		List<WalletTransactions> toTransactionList = toAccount.getTransactions();
		if(amount>fromAccount.getAccountBalance()) {
			throw new NameDoesNotExistsException("Balance insufficient");
		}
		if ((fromAccount.getAccountBalance() < 0) || (fromAccount.getAccountBalance() < 500)) {
			throw new NameDoesNotExistsException("Transaction failed because account does not contain minimum balance");
		} else {

			fromAccount.setAccountBalance(fromAccount.getAccountBalance() - amount);
			toAccount.setAccountBalance(toAccount.getAccountBalance() + amount);

			WalletTransactions fromTransaction = createBasicTransaction();
			fromTransaction.setDescription("Transaction Successfull: Amount Debited");
			fromTransaction.setAccountBalance(fromAccount.getAccountBalance());
			fromTransaction.setAmount(amount);
			System.out.println("From transactions" + fromTransaction);
			fromTransactionList.add(fromTransaction);
			fromAccount.setTransactions(fromTransactionList);

			WalletTransactions toTransaction = createBasicTransaction();
			toTransaction.setTransactionId(fromTransaction.getTransactionId());
			toTransaction.setDescription("Transaction Successfull: Amount Credited");
			toTransaction.setAccountBalance(toAccount.getAccountBalance());
			toTransaction.setAmount(amount);
			System.out.println("To transactions" + toTransaction);
			toTransactionList.add(toTransaction);
			toAccount.setTransactions(toTransactionList);
			list.add(fromAccount);
			list.add(toAccount);
		}
		return list;
	}
	}



