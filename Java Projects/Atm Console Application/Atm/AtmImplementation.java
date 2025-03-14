package com.atm;

import com.account.UserAccount;

public class AtmImplementation implements Atm {
	private UserAccount userAccount;
	
	public UserAccount getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}

	@Override
	public void withdraw(int amount) {
		if (amount <= userAccount.getBalance()) {
			userAccount.setBalance(userAccount.getBalance() - amount);
			System.out.println("Take Your Cash Now!");
		} else {
			System.out.println("Insufficient Balance! Check the Balance and try again");
		}
		
	}

	@Override
	public void deposit(int amount) {
		if (amount > 0) {
			userAccount.setBalance(userAccount.getBalance() + amount);
			System.out.println("Your amount has been successfully deposited!");
		} else {
			System.out.println("Deposit amount has been greater than zero!");
		}
		
	}

	@Override
	public void checkBalance() {
		// TODO Auto-generated method stub
		System.out.println("Your Balance is: " + userAccount.getBalance());
	}
	
	public int checkPin() {
		return userAccount.getPin();
	}
}
