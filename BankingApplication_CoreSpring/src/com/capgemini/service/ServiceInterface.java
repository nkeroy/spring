package com.capgemini.service;

import com.capgemini.exceptions.*;

public interface ServiceInterface {
	public void createAccount(String name, double openingAmount) throws InsufficientOpeningBalanceException;
	public void depositAmount(int accountNumber, double amount) throws InvalidAccountNumberException;
	public void withdrawAmount(int accountNumber, double amount) throws InsufficientBalanceException, InvalidAccountNumberException;
	public void fundTransfer(int accountNumberFrom, int accountNumberTo, double amount) throws InsufficientBalanceException, InvalidAccountNumberException;
}
