package com.capg.ewallet.accountms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.ewallet.accountms.model.WalletAccount;

public interface IAccountRepo extends JpaRepository<WalletAccount, Integer> {

}

