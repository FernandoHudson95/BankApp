package com.revature.dao;


import com.revature.bean.Account;

public interface AccountDao {
	
	void save(Account a);
	
	 Account[] findAll();

}
