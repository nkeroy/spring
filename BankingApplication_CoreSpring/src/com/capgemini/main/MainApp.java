package com.capgemini.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.capgemini.beans.*;
import com.capgemini.exceptions.*;
import com.capgemini.repository.*;
import com.capgemini.service.*;

public class MainApp {
	
	public static void main(String[] args) {
	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	Service service = (Service)context.getBean("service");
	RepositoryInterface repository = (RepositoryMap)context.getBean("repository");
	Account a = (Account)context.getBean("accountRoy");
	Account a1 = (Account)context.getBean("accountDylan");
	Account a2 = (Account)context.getBean("accountSanjay");
	
	try {
		// save accounts in repository
		repository.save(a); // saves account with amount 500, without exception
		repository.save(a1); // saves account with amount 300, without exception
		repository.save(a2); // saves account with amount 250, without exception
		
		// deposit process
		service.depositAmount(1, 200); // deposits 200 into account number 1 (Roy)
		service.depositAmount(3, 500); // deposits 500 into account number 3 (Sanjay)
		
		// withdrawal process
		service.withdrawAmount(2, 300); // withdraw 300 from account number 2 (Dylan), should have 0 now
		
		// fund transfer process
		service.fundTransfer(1, 3, 500); // funds transfer from 1 (Roy) to 3 (Sanjay)
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
