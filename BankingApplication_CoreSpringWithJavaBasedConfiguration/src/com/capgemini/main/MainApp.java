package com.capgemini.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.capgemini.beans.*;
import com.capgemini.exceptions.*;
import com.capgemini.repository.*;
import com.capgemini.service.*;

public class MainApp {
	
	public static void main(String[] args) throws Exception {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(AccountConfig.class, ServiceConfig.class);
		
		// create accounts with context.getBean
		Account accountRoy = (Account)context.getBean("accountOne");
		Account accountRussell = (Account)context.getBean("accountTwo");	
		System.out.println("-------------------For Account Beans--------------------");
		System.out.println(accountRoy);
		System.out.println(accountRussell);

		// create service with context.getBean
		Service service = context.getBean(Service.class);
		System.out.println("-------------------For Service Bean--------------------");
		
		// funds transfer process with two pre-defined accounts created in advance
		// account 1 has 600 while account 2 has 700 initially
		service.fundTransfer(3,4,250);
	}
}
