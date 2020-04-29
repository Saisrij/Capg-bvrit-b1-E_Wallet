package com.capg.ewallet.accountms.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class WalletTransactions {
	
	@Id
	private int transactionId;
	private String description;
	private LocalDateTime dateOfTransaction;
	private double amount;
	private double accountBalance;
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDateTime getDateOfTransaction() {
		return dateOfTransaction;
	}
	public void setDateOfTransaction(LocalDateTime dateOfTransaction) {
		this.dateOfTransaction = dateOfTransaction;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
	
	public WalletTransactions() {
		// TODO Auto-generated constructor stub
	}
	public WalletTransactions(int transactionId, String description, LocalDateTime dateOfTransaction, double amount,
			double accountBalance) {
		super();
		this.transactionId = transactionId;
		this.description = description;
		this.dateOfTransaction = dateOfTransaction;
		this.amount = amount;
		this.accountBalance = accountBalance;
	}
	@Override
	public String toString() {
		return "WalletTransactions [transactionId=" + transactionId + ", description=" + description
				+ ", dateOfTransaction=" + dateOfTransaction + ", amount=" + amount + ", accountBalance="
				+ accountBalance + "]";
	}
	
	

}
