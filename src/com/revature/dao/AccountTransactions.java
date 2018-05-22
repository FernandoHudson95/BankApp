package com.revature.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import com.revature.bean.AccountInfo;

public class AccountTransactions {
	//private Logger log = Logger.getRootLogger();
	    
	    private double balance;

	    public AccountTransactions(double initialBalance) {

	        if (initialBalance < 0) {
	            throw new IllegalArgumentException(
	                    "Accounts with a negative balance cannot be created!");
	        }
	        balance = initialBalance;
	        
	    }

	    public void deposit(double amount) {
	        if (amount < 0) {
	            throw new IllegalArgumentException(
	                    "Don't deposit negative amounts!");
	        }
	        
	        try (ObjectInputStream inStream = new ObjectInputStream(new FileInputStream("accountTransactions.txt"))) {
				 String balance = (inStream.readObject()).toString();
				//System.out.println("Your balance is: $" + balance);
				 
				balance+=amount;
				System.out.println("Your balance is: $" + balance);
				
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("accountTransactions.txt")); 
		        	oos.writeObject(balance);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
			}
	        
	    }

	    public void withdraw(double amount) {
	        if (amount < 0) {
	            throw new IllegalArgumentException(
	                    "Don't withdraw a negative amount!");
	        }


	        try (ObjectInputStream inStream = new ObjectInputStream(new FileInputStream("accountTransactions.txt"))) {
				 String balance = (inStream.readObject()).toString();
				//System.out.println("Your balance is: $" + balance);
				 
				balance= balance + (amount*-1);
				System.out.println("Your balance is: $" + balance);
				
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("accountTransactions.txt")); 
		        	oos.writeObject(balance);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }

	    public void getBalance() {
	    	try (ObjectInputStream inStream = new ObjectInputStream(new FileInputStream("accountTransactions.txt"))) {
				 String balance = (inStream.readObject()).toString();
				System.out.println("Your balance is: $" + balance);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
			}
	    }

	    public String toString () {
	        return " $" + balance;
	    }
	    
	  
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
