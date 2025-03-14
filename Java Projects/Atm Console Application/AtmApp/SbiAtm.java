package com.atmapp;
import java.util.*;
import com.account.UserAccount;
import com.atm.AtmImplementation;

public class SbiAtm {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		AtmImplementation atm = new AtmImplementation();
		System.out.println("Insert Your Card?insert/enter");
		String cardInsert = sc.next();
		if (cardInsert.equals("insert")) {
			UserAccount user1 = new UserAccount();
			atm.setUserAccount(user1);
			System.out.println("Enter Your Pin");
			int pin = sc.nextInt();
			if (pin == atm.checkPin()) {
				while (true) {
					System.out.println("Press 1 for Deposit");
					System.out.println("Press 2 for Withdraw");
					System.out.println("Press 3 for check balance");
					System.out.println("Press 4 for Exit");
					
					int choice = sc.nextInt();
					
					if (choice == 4) {
						break;
					}
					
					switch(choice) {
						case 1:
							System.out.print("Enter your Deposit Amount: ");
							int amount = sc.nextInt();
							atm.deposit(amount);
							break;
						case 2:
							System.out.print("Enter your withdrawl Amount: ");
							amount = sc.nextInt();
							atm.withdraw(amount);
							break;
						case 3:
							atm.checkBalance();
							break;
					}  
				}
			} else {
				System.out.println("Invalid pin  please enter  valid pin number. ");
			}
			System.out.println("Thank your for using xyz Atm");
		}
		sc.close();
	}
}

