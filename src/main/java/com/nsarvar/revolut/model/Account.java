package com.nsarvar.revolut.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import com.nsarvar.revolut.db.DbClass;

/**
 * @author nsarvar
 *
 * Account model
 * 
 */
@XmlRootElement
public class Account {
	private long accountID;
	private String name;
	private double balance;
	private Date created;
	
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(long accountID, String name, double balance) {
		super();
		this.accountID = accountID;
		this.name = name;
		this.balance = balance;
		this.created = new Date();
		DbClass.lastAccountID = accountID;
	}

	public long getAccountID() {
		return accountID;
	}

	public void setAccountID(long accountID) {
		this.accountID = accountID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}
}
