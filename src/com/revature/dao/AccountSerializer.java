package com.revature.dao;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.revature.bean.Account;

public class AccountSerializer implements AccountDao{

	@Override
	public void save(Account a) {
		
		
		Account[] accounts = findAll(); // gets all the accounts we already have
		Account[] updatedAccountList = new Account[accounts.length + 1];
		//log.trace("populating a new list with old accounts");
		
		// populate a new list with everything we already had
		for(int i = 0; i < accounts.length; i++) {
			updatedAccountList[i] = accounts[i];
		}
		//log.trace("adding new account to the updated list");
		updatedAccountList[accounts.length] = a;
		
		// write new list to file
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("accounts.txt"))) {
			oos.writeObject(updatedAccountList);
			oos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	@Override
	public Account[] findAll() {
		try (ObjectInputStream inStream = new ObjectInputStream(new FileInputStream("accounts.txt"))) {
			Account[] accounts = (Account[]) inStream.readObject();
			return accounts;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
		}
		
		return new Account[0];
	}

}
