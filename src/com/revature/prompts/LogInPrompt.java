package com.revature.prompts;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.util.Arrays;
import java.util.Scanner;

import com.revature.bean.Account;

public class LogInPrompt implements Prompt{

	private Scanner scan = new Scanner(System.in);
	String record = null;
	
	@Override
	public Prompt run() {
		
		try {
			
			ObjectInputStream inStream = new ObjectInputStream(new FileInputStream("accounts.txt"));
			Account[] accounts = (Account[]) inStream.readObject();
			//System.out.println(Arrays.toString(accounts));
			
			System.out.println("Enter your account number: ");
			String a_num = scan.nextLine();
			
			System.out.println("Enter your password: ");
			String pass = scan.nextLine();
			
			if(pass.isEmpty()) {
				System.out.println("Account number or Password is incorect. Try again.\n");

			}
			else if (Arrays.toString(accounts).contains(a_num) && Arrays.toString(accounts).contains(pass)){
				String userName = a_num;
				System.out.println("Account number is valid.\n");
				return new AccountInfoPrompt();
			}
			else {
				System.out.println("Account number or Password is incorect. Try again.\n");

			}
		}catch (Exception e){//Catch exception if any
            System.err.println("Error: " + e.getMessage());
			
		}

		return new LogInPrompt();
		}
}
