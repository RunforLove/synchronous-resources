package com.runforlove.synchronousresources.demo;

public interface Bank {
	
	void saveMoney(double money);
	
	void withdrawMoney(double money);
	
	double queryMoney();
}
