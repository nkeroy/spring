package com.capgemini.service;

import com.capgemini.beans.*;
import com.capgemini.repository.*;
import com.capgemini.exceptions.*;

public class Service implements ServiceInterface {

	private RepositoryInterface repository;
	
	public Service(RepositoryInterface repository) {
		this.repository = repository;
	}

	@Override
	public void createAccount(String name, double openingAmount) throws InsufficientOpeningBalanceException {
			if (openingAmount < 100) throw new InsufficientOpeningBalanceException();
			System.out.println(repository.save(new Account(name, openingAmount)));		
	}

	@Override
	public void depositAmount(int accountNumber, double amount) throws InvalidAccountNumberException {
		Account account = repository.retrieve(accountNumber);
		if (account == null) throw new InvalidAccountNumberException();
		account.setAmount(account.getAmount()+amount);
		System.out.println(account);
	}

	@Override
	public void withdrawAmount(int accountNumber, double amount)
			throws InsufficientBalanceException, InvalidAccountNumberException {
		Account account = repository.retrieve(accountNumber);
		if (account == null) {
			throw new InvalidAccountNumberException();
		} else if (account.getAmount() < amount) {
			throw new InsufficientBalanceException();
		} else {
			account.setAmount(account.getAmount()-amount);
		}
		System.out.println(account);
	}

	@Override
	public void fundTransfer(int accountNumberFrom, int accountNumberTo, double amount)
			throws InsufficientBalanceException, InvalidAccountNumberException {
		Account accountFrom = repository.retrieve(accountNumberFrom);
		Account accountTo = repository.retrieve(accountNumberTo);
		if (accountFrom == null || accountTo == null) {
			throw new InvalidAccountNumberException();
		} else if (accountFrom.getAmount() < amount) {
			throw new InsufficientBalanceException();
		} else {
			accountFrom.setAmount(accountFrom.getAmount()-amount);
			accountTo.setAmount(accountTo.getAmount()+amount);
		}
		System.out.println(accountFrom);
		System.out.println(accountTo);
	}
}
