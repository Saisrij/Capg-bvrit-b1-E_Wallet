package com.capg.ewallet.fundtransfer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.ewallet.fundtransfer.model.WalletAccount;

public interface FundTransferRepo extends JpaRepository<WalletAccount, Integer> {
	

}
