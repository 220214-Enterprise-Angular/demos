package com.revature.menu;

public class AdminMenu implements Menu {

	@Override
	public void display() {
		System.out.println("=== Welcome to the Admin Menu! ===");
		
		System.out.println("Select a choice:");
		System.out.println("1.) back");
		
		String choice = Menu.sc.nextLine();
		
		switch (choice) {
			case "1":
				break;
		}
		
	}

}
