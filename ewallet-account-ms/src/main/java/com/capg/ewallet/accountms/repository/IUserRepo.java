package com.capg.ewallet.accountms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.capg.ewallet.accountms.model.WalletUser;


public interface IUserRepo extends JpaRepository<WalletUser, Integer> {
	
	@Query(value = "from WalletUser where loginName=:loginName")
	public WalletUser getUserByLoginName(String loginName);

}

