package com.revature.menu;

public class MainMenu implements Menu {

	@Override
	public void display() {
		while (true) {
			System.out.println("=== WELCOME TO THE APPLICATION ===");
			System.out.println("=== Here are your options ===");
			System.out.println("1.) Login");
			System.out.println("2.) Exit");
			
			String choice = Menu.sc.nextLine();
			
			switch (choice) {
				case "1":
					(new LoginMenu()).display();
					break;
				case "2":
					System.exit(0);
					break;
				default:
					break;
			}
		}
	}

}
