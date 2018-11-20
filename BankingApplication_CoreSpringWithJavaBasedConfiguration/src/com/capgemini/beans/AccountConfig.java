package com.capgemini.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AccountConfig {
	@Bean
	public Account accountOne() {
		return new Account("Roy",500);
	}
	
	@Bean
	public Account accountTwo() {
		return new Account("Russell",300);
	}
}
