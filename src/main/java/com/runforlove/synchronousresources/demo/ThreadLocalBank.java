package com.runforlove.synchronousresources.demo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ThreadLocalBank implements Bank {
	
	private static ThreadLocal<Double> doubleThreadLocal = new ThreadLocal<>();
	
	@Override
	public void saveMoney(double money) {
		doubleThreadLocal.set(doubleThreadLocal.get() + money);
	}
	
	@Override
	public void withdrawMoney(double money) {
		doubleThreadLocal.set(doubleThreadLocal.get() - money);
	}
	
	@Override
	public double queryMoney() {
		return doubleThreadLocal.get();
	}
}
