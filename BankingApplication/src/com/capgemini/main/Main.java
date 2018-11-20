package com.capgemini.main;

import java.util.HashMap;

import com.capgemini.beans.*;
import com.capgemini.exceptions.*;
import com.capgemini.repository.*;
import com.capgemini.service.*;

public class Main {
	
	public static void main(String[] args) throws InsufficientBalanceException, InsufficientOpeningBalanceException, InvalidAccountNumberException {
		// TODO Auto-generated method stub
		ServiceInterface service = new Service(new RepositoryMap(new HashMap<Integer,Account>()));
		
		try {
		service.createAccount("Roy", 500); // creates account with amount 500, without exception
		service.createAccount("Sanjay", 250); // creates account with amount 250, without exception
		service.createAccount("Dylan", 300); // creates account with amount 300, without exception
		
		// deposit process
		service.depositAmount(1, 200); // deposits into account number 1 (Roy)
		service.depositAmount(3, 500); // deposits into account number 3 (Dylan)
		
		// withdrawal process
		//service.withdrawAmount(2, 300); // throws InsufficientBalanceException
		
		// fund transfer process
		service.fundTransfer(1, 3, 500); // funds transfer from 1 (Roy) to 3 (Dylan)
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
