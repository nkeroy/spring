package com.capgemini.repository;

import java.util.Map;

import com.capgemini.beans.Account;

public class RepositoryMap implements RepositoryInterface{
	
	private Map<Integer,Account> repository; // store account number as key, account instance as value
	
	

	public RepositoryMap(Map<Integer,Account> repository) {
		this.repository = repository;
		// TODO Auto-generated constructor stub
	}

	@Override
	public Account save(Account newAccount) {
		repository.put(newAccount.getAccountNumber(), newAccount);
		return newAccount;
	}

	@Override
	public Account retrieve(int accountNumber) {
		Account account = repository.containsKey(accountNumber) ? repository.get(accountNumber) : null;
		return account;
	}

}
