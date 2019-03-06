package com.runforlove.synchronousresources.demo;

public class ThreadInsecurityBankTest {
	
	public static void main(String[] args) {
		Bank bank = new ThreadInsecurityBank(1000.00);
		SaveMoneyThread saveMoneyThread = new SaveMoneyThread(() -> bank);
		WithdrawMoneyThread withdrawMoneyThread = new WithdrawMoneyThread(() -> bank);
		
		for (int i = 0; i < 10; i++) {
			new Thread(withdrawMoneyThread).start();
			new Thread(saveMoneyThread).start();
		}
	}
}