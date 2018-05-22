package com.revature.dao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import com.revature.bean.AccountInfo;

public class AccountInfoSerializer implements AccountInfoDao{

	@Override
	public void deposit(AccountInfo ai) {

		AccountInfo[] accountInfo = findAll(); // gets all the accounts we already have
		AccountInfo[] updatedAccountInfoList = new AccountInfo[accountInfo.length + 1];
		//log.trace("populating a new list with old accounts");
		
		// populate a new list with everything we already had
		for(int i = 0; i < accountInfo.length; i++) {
			updatedAccountInfoList[i] = accountInfo[i];
		}
		//log.trace("adding new account to the updated list");
		updatedAccountInfoList[accountInfo.length] = ai;
		
		// write new list to file
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("accountInfo.txt"))) {
			oos.writeObject(updatedAccountInfoList);
			oos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void withdraw(AccountInfo ai) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void viewBalance(AccountInfo ai) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void viewTransactionHistory(AccountInfo ai) {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public AccountInfo[] findAll() {
		try (ObjectInputStream inStream = new ObjectInputStream(new FileInputStream("accountInfo.txt"))) {
			AccountInfo[] accountInfo = (AccountInfo[]) inStream.readObject();
			return accountInfo;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
		}
		
		return new AccountInfo[0];
	}

	

	
	
	
	
}
