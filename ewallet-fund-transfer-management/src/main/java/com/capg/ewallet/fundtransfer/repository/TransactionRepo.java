package com.capg.ewallet.fundtransfer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.ewallet.fundtransfer.model.WalletTransactions;

public interface TransactionRepo extends JpaRepository<WalletTransactions, Integer> {

}
