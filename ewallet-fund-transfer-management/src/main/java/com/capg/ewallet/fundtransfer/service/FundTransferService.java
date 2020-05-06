package com.capg.ewallet.fundtransfer.service;

import com.capg.ewallet.fundtransfer.model.WalletAccount;
import com.capg.ewallet.fundtransfer.model.WalletTransactions;

public interface FundTransferService {

	public WalletAccount getAccountById(int accountId);
	public WalletTransactions createBasicTransaction();
	public WalletAccount fundtransfer(double amount, int fromAccountId, int toAccountId);
	public WalletAccount addAmount(double amount, int accountId);

}
