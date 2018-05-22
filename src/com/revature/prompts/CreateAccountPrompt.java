package com.revature.prompts;

import java.util.Scanner;

import com.revature.bean.Account;
import com.revature.dao.AccountDao;
import com.revature.dao.AccountSerializer;

public class CreateAccountPrompt implements Prompt {

	private Scanner scan = new Scanner(System.in);
	private Scanner scan2 = new Scanner(System.in);
	private AccountDao accountDao = new AccountSerializer();

	@Override
	public Prompt run() {

			System.out.println("Enter your full name:");
			String userName = scan.nextLine();
			
			if (userName.length() == 0) {
	            //throw new IllegalArgumentException("Pleae enter your name.");
	           return new CreateAccountPrompt();
	        }
			
			System.out.println("Choose your account type:\n Enter 1 for Checking or 2 for Savings");
			//int number = scan.nextInt();
			String accountType = "";
			
			while(true) {
				String number = scan.nextLine();
				 if (number.equals("1")) {
					 System.out.println("You chose Checking.\n");
						accountType += "Checking";
						break;
				      } else if (number.equals("2")) {
				    	  System.out.println("You chose Savings.\n");
							accountType += "Savings";
							break;
				      } else if (number.isEmpty()){
				         System.out.print("\tPlease choose 1 or 2.");
				      }
			}
			
			int accountNumber = (int) (Math.random() * 50 + 1);
			System.out.println("Your new Account Number is: " + accountNumber);
			System.out.println("Your Account number " + accountNumber + " will be your user log in.\n");
	
			System.out.println("Enter your password:");
			String password = scan2.nextLine();
			
			System.out.println("Your input shows: \nName: " + userName + "\nAccount: " + accountType + "\nPassword: " + password);
			System.out.println("Is this correct? Enter yes or no.");
			//String question = scan2.nextLine();
			while(true) {
				String question = scan2.nextLine();
				 if (question.equals("yes")) {
					 System.out.println("New account Created. Welcome to Lucky Bank!\n");
					 break;
				      } else if (question.equals("no")) {
				    	  System.out.println("Okay, try again.");
				    	  return new CreateAccountPrompt();
				      } else {
				         System.out.print("\tPlease answer yes or no.");
				      }
			}
			
			Account newAccount = new Account(userName, accountType, accountNumber, password);
			accountDao.save(newAccount);

		return new MainMenu();
	}

}
