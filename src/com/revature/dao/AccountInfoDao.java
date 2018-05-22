package com.revature.dao;

import com.revature.bean.AccountInfo;

public interface AccountInfoDao {
	

	void deposit(AccountInfo ai);
	
	void withdraw(AccountInfo ai);
	
	void viewBalance(AccountInfo ai);
	
	void viewTransactionHistory(AccountInfo ai);
	
	AccountInfo[] findAll();

}
