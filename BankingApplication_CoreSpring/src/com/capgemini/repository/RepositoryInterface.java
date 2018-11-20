/**
 * 
 */
package com.capgemini.repository;

import com.capgemini.beans.*;

/**
 * @author royng
 *
 */
public interface RepositoryInterface {
	
	public Account save(Account newAccount); // saves new account into repository collection
	public Account retrieve(int accountNumber); // retrieve new account from repository collection

}
