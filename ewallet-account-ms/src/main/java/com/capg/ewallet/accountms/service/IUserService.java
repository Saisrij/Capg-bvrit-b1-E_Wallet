<<<<<<< HEAD
package com.capg.ewallet.accountms.service;

import java.util.List;

import com.capg.ewallet.accountms.model.WalletAccount;
import com.capg.ewallet.accountms.model.WalletTransactions;
import com.capg.ewallet.accountms.model.WalletUser;

public interface IUserService {
	
	public WalletUser createUserAccount(WalletUser user);
	public WalletAccount getAccountById(int accountId);
	public WalletUser getUserById(int userId);
	public WalletUser updateUserDetails(int userId,WalletUser newUserData);
	public boolean deleteUser(int userId);
	public List<WalletUser> getAllUsers();
	public List<WalletAccount> getAllAccounts();
	public double getAccountBalance(int accountId);
	public List<WalletTransactions> getAllTransactions(int accountId);
	
	public WalletAccount fundtransfer(double amount, int fromAccountId, int toAccountId);
    public double addAmount(double amount, int accountId);
    public int getUserAccountId(int userId);
	

}
=======
package com.capg.ewallet.accountms.service;

import java.util.List;

import com.capg.ewallet.accountms.model.WalletAccount;
import com.capg.ewallet.accountms.model.WalletTransactions;
import com.capg.ewallet.accountms.model.WalletUser;

public interface IUserService {
	
	public WalletUser createUserAccount(WalletUser user);
	public WalletAccount getAccountById(int accountId);
	public WalletUser getUserById(int userId);
	public WalletUser updateUserDetails(int userId,WalletUser newUserData);
	public boolean deleteUser(int userId);
	public List<WalletUser> getAllUsers();
	public List<WalletAccount> getAllAccounts();
	public double getAccountBalance(int accountId);
	public List<WalletTransactions> getAllTransactions(int accountId);
	
	public WalletAccount fundtransfer(double amount, int fromAccountId, int toAccountId);
    public double addAmount(double amount, int accountId);
    public int getUserAccountId(int userId);
	

}
>>>>>>> branch 'master' of https://github.com/Saisrij/Capg-bvrit-b1-E_Wallet.git
