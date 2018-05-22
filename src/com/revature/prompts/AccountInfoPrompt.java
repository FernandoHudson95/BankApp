package com.revature.prompts;

import java.util.Scanner;
import com.revature.dao.AccountTransactions;

public class AccountInfoPrompt implements Prompt {


	@Override
	public Prompt run() {
		
		System.out.println("Hello user!\n");
		System.out.println("Enter 1 to Make a Deposit");
		System.out.println("Enter 2 to Make a Withdraw");
		System.out.println("Enter 3 to View Balance");
		System.out.println("Enter 4 to View Transaction History");

		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		// Integer amount = scan.nextInt();

		//int initialBalance = 0;
		AccountTransactions account = new AccountTransactions(0);

			switch (input) {
			case "1":
				System.out.println("How much money would you like to deposit?");
				Integer amount = scan.nextInt();
				System.out.println("You would like to deposit $" + amount + "?\n");
				account.deposit(amount);
				account.getBalance();
				break;

			case "2":
				System.out.println("How much money would you like you like to withdraw?");
				amount = scan.nextInt();
				System.out.println("You would like to withdraw $" + amount + "?\n");
				account.withdraw(amount);
				account.getBalance();
				// System.out.println("Your new balance is $"+ (balance = balance - amount));
				// return new CreateBookPrompt();
				break;
			case "3":
				account.getBalance();

				break;
			case "4":
				System.out.println("Here is a history of your transactions:\n");
				// return new CreateBookPrompt();
				break;
			default:
				System.out.println("Invalid option\n");
				break;
			}
	return new AccountInfoPrompt();
	}
}
