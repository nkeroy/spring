package com.capgemini.beans;

public class Account {
	private static int counter = 1; // accountNumber to be assigned automatically with counter
	String name;
	double amount;
	int accountNumber;
	
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Account(String name, double amount) {
		this.accountNumber = counter;
		this.name = name;
		this.amount = amount;
		counter++;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", name=" + name + ", amount=" + amount + "]";
	}
	
}
