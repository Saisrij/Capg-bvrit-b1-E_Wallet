package com.capg.ewallet.fundtransfer.model;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class WalletAccount {
@Id
	private int accountId;
	private double accountBalance;
	private enum status{ };
	@ElementCollection
	@OneToMany(targetEntity = WalletTransactions.class)
	private List<WalletTransactions> transactions;
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
	public List<WalletTransactions> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<WalletTransactions> transactions) {
	
		this.transactions = transactions;
	}
	
	public WalletAccount() {
		// TODO Auto-generated constructor stub
	}
	public WalletAccount(int accountId, double accountBalance) {
		super();
		this.accountId = accountId;
		this.accountBalance = accountBalance;
	}
	
	
	

}
