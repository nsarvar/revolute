package com.nsarvar.revolut.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.NotFoundException;

import com.nsarvar.revolut.db.DbClass;
import com.nsarvar.revolut.exception.DataNotFoundException;
import com.nsarvar.revolut.model.Account;

/**
 * @author nsarvar
 *
 */
public class AccountService {
	private Map<Long, Account> accounts = DbClass.getAccounts();
	
	
	/**
	 * initializing default data
	 */
	public AccountService(){
	}
	
	/**
	 * @return List<Account> This returns the list of all accounts saved.
	 */
	public List<Account> getAll(){
		return new ArrayList<Account>(accounts.values());
	}
	
	/**
	 * This returns an account on given id
	 * @param id This is a AccountID 
	 * @return Account object
	 */
	public Account get(long id){
		Account a = accounts.get(id);
		if(a == null)
			throw new DataNotFoundException("Account #" + id + " not found!");
		return a;
	}
	
	/**
	 * Adding an account function
	 * @param account
	 * @return
	 */
	public Account add(Account account){
		if(account.getName()==null){
			throw new BadRequestException("Name cannot be null!");
		}
		else if(account.getBalance() < 0.0){
			throw new BadRequestException("Balance cannot be less than 0.0!");
		}
		
		DbClass.lastAccountID++;
		account.setCreated(new Date());
		account.setAccountID(DbClass.lastAccountID);
		accounts.put(account.getAccountID(), account);
		return account;
	}
	
	/**
	 * This method updates the paricular account 
	 * @param account This is an account to be updated 
	 * @return updated account
	 */
	public Account update(Account account){
		if(accounts.get(account.getAccountID()) == null){
			throw new DataNotFoundException("Account #" + account.getAccountID() + " not found!");
		}
		
		if(account.getName()!=null){
			accounts.get(account.getAccountID()).setName(account.getName());
		}
		
		if(account.getBalance() > 0.0){
			accounts.get(account.getAccountID()).setBalance(account.getBalance());
		}
		
		return account;
	}
	
	/**
	 * Deleting an accoung on given id from the List
	 * @param id
	 * @return deleted account
	 */
	public void delete(long id){
		Account a = accounts.get(id);
		if(a == null)
			throw new DataNotFoundException("Account #" + id + " not found!");
		accounts.remove(id);	
	}
}
