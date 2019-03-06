package com.runforlove.synchronousresources.demo;

public class VolatileBank implements Bank {
	
	private volatile Double money;
	
	@Override
	public void saveMoney(double money) {
		synchronized (this){
			this.money +=money;
		}
	}
	
	@Override
	public void withdrawMoney(double money) {
		synchronized (this){
			this.money -= money;
		}
	}
	
	@Override
	public double queryMoney() {
		return this.money;
	}
}
