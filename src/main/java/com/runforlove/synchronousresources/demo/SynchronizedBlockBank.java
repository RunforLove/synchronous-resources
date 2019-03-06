package com.runforlove.synchronousresources.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import static java.lang.String.format;

@Slf4j
@Data
@AllArgsConstructor
public class SynchronizedBlockBank implements Bank {
	
	private Double money;
	
	@Override
	public void saveMoney(double money) {
		System.err.println(format("save money %s", money));
		synchronized (this){
			this.money += money;
		}
	}
	
	@Override
	public synchronized void withdrawMoney(double money) {
		System.err.println(format("withdraw money %s", money));
		synchronized (this) {
			this.money -= money;
		}
	}
	
	@Override
	public double queryMoney() {
		System.err.println(format("Current money is %s", this.money));
		return this.money;
	}
}
