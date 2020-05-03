package com.capg.ewallet.accountms.model;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class WalletAccount {

	@Id
	private int accountId;
	private double accountBalance;
	public enum Status{ 
		SavingsAccount,CurrentAccount;
	}
	private Status accountStatus;

	@OneToMany(targetEntity = WalletTransactions.class)
	private List<WalletTransactions> transactions;
	
	@OneToOne(targetEntity = WalletUser.class)
	public WalletUser walletUser;
	
	
	public Status getAccountStatus() {
		return accountStatus;
	}
	public void setAccountStatus(Status accountStatus) {
		this.accountStatus = accountStatus;
	}
	public WalletUser getWalletUser() {
		return walletUser;
	}
	public void setWalletUser(WalletUser walletUser) {
		this.walletUser = walletUser;
	}
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
	public WalletAccount(int accountId, double accountBalance, List<WalletTransactions> transactions) {
		super();
		this.accountId = accountId;
		this.accountBalance = accountBalance;
		this.transactions = transactions;
	}
	public WalletAccount(int accountId, double accountBalance, List<WalletTransactions> transactions,
			WalletUser walletUser) {
		super();
		this.accountId = accountId;
		this.accountBalance = accountBalance;
		this.transactions = transactions;
		this.walletUser = walletUser;
	}
	@Override
	public String toString() {
		return "WalletAccount [accountId=" + accountId + ", accountBalance=" + accountBalance + ", transactions="
				+ transactions + ", walletUser=" + walletUser + "]";
	}
	
	
	
	
	

}
