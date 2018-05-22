package com.revature.launcher;


import com.revature.prompts.MainMenu;
import com.revature.prompts.Prompt;

public class BankLauncher {
	
	public static void main(String[] args) {
		Prompt currentPromp = (Prompt) new MainMenu();
		while (true) {
			currentPromp = currentPromp.run();
		}
	}

}
