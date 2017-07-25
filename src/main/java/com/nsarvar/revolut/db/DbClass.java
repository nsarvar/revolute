package com.nsarvar.revolut.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.nsarvar.revolut.model.Account;
import com.nsarvar.revolut.model.Transfer;

/**
 * @author nsarvar
 * 
 * This class represents 
 */

public class DbClass {
	private static Map<Long, Account> accounts = new HashMap<>();
	private static List<Transfer> transfers = new ArrayList<Transfer>();
	
	public static long lastAccountID = 1000;
	
	public static Map<Long, Account> getAccounts() {
		return accounts;
	}
	
	public static List<Transfer> getTrasfers() {
		return transfers;
	}
}
