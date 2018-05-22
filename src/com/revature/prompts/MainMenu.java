package com.revature.prompts;

import java.util.Scanner;

public class MainMenu implements Prompt {

	@Override
	public Prompt run() {
		
		System.out.println("Welcome to Lucky Bank!\n");

		System.out.println("Enter 1 to Log In\n or \n");
		System.out.println("Enter 2 to Create a new Account!");

		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		switch (input) {
		case "1":
			return new LogInPrompt();
		case "2":
			return new CreateAccountPrompt();
		default:
			System.out.println("Invalid option");
			break;
		}
		
		
		return this;
	}

}
