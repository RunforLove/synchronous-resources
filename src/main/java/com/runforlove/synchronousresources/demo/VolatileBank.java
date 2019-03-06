package com.runforlove.synchronousresources.demo;

public class VolatileBank implements Bank {
	
        // 保证了可见性，不保证原子性，有写操作的场景，使用它，对资源同步无效；
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
