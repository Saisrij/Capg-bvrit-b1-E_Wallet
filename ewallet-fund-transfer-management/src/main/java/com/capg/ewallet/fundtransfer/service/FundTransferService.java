package com.capg.ewallet.fundtransfer.service;

import java.util.List;

import com.capg.ewallet.fundtransfer.model.WalletAccount;
import com.capg.ewallet.fundtransfer.model.WalletTransactions;

public interface FundTransferService {


	public List<WalletAccount> fundtransfer(double amount, WalletAccount fromaccount, WalletAccount toaccount);


	public WalletAccount addAmount(double amount, WalletAccount account);

	public WalletAccount getAccountById(int accountId);

}
