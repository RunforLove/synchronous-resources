package com.runforlove.synchronousresources.demo;

import java.util.concurrent.locks.ReentrantLock;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReentrantLockBank implements Bank {
	
	private Double money;
	private ReentrantLock reentrantLock = new ReentrantLock();
	
	@Override
	public void saveMoney(double money) {
		reentrantLock.lock();
		try{
			this.money += money;
		}finally {
			reentrantLock.unlock();
		}
	}
	
	@Override
	public void withdrawMoney(double money) {
		reentrantLock.lock();
		try{
			this.money -= money;
		}finally {
			reentrantLock.unlock();
		}
	}
	
	@Override
	public double queryMoney() {
		return this.money;
	}
}
