package com.capgemini.service;

import com.capgemini.beans.Account;
import com.capgemini.repository.*;

import java.util.HashMap;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {
	@Bean
	public Service service() {
		RepositoryInterface repository = new RepositoryMap(new HashMap<Integer,Account>());
		// For testing purposes in MainApp.java
		repository.save(new Account("Dylan", 600));
		repository.save(new Account("Sanjay", 700));
		return new Service(repository);
	}
}
