package com.nsarvar.revolut.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.ws.rs.WebApplicationException;
import com.nsarvar.revolut.db.DbClass;
import com.nsarvar.revolut.exception.DataNotFoundException;
import com.nsarvar.revolut.model.Account;
import com.nsarvar.revolut.model.Transfer;

/**
 * @author nsarvar
 * Transfer service is used by Transfer Response class 
 */
public class TransferService {

	List<Transfer> transfers = DbClass.getTrasfers();
	Map<Long, Account> accounts = DbClass.getAccounts();
	/**
	 * @return List<Account> This returns the list of all accounts saved.
	 */
	
	/**
	 * Constructor
	 */
	public TransferService() {
		super();
//		transfers.add(new Transfer("1001", "10002", 500.00, "for hotel", new Date()));
	}

	/**
	 * return List of all transfers
	 * @return
	 */
	public List<Transfer> getAll(){
		return new ArrayList<Transfer>(transfers);
	}

	public List<Transfer> get(long id){
		List<Transfer> tlist = DbClass.getTrasfers();
		List<Transfer> temp = new ArrayList<>();
		for(Transfer t : tlist){
			if(Long.parseLong(t.getFromAccountID())==id || Long.parseLong(t.getToAccountID())==id){
				temp.add(t);
			}
		}
		return temp;
	}
	/**
	 * Transfer from one accaunt to the other one. 
	 * Checks the balance of the sender whether it has enough balance to send
	 * Sender and received must be different accaunts
	 * @param transfer Transfer object that holds sender id, receiver id, amount of transfer and the note
	 * @return returns transfer object
	 */
	public Transfer newTransfer(Transfer transfer){
		
		Account fromAccount = accounts.get(Long.parseLong(transfer.getFromAccountID()));
		Account toAccount = accounts.get(Long.parseLong(transfer.getToAccountID()));
		
		// validation
		if(transfer.getFromAccountID().equals(transfer.getToAccountID())){
			throw new WebApplicationException("Sender and receiver is the same account!");
		}
		else if(fromAccount == null){
			throw new DataNotFoundException("Account #"+ transfer.getFromAccountID() + " not found!");
		}
		else if(toAccount == null){
			throw new DataNotFoundException("Account #"+ transfer.getToAccountID() + " not found!");
		}
		else if(fromAccount.getBalance()-transfer.getAmount() < 0.0){
			throw new WebApplicationException("Balance is not enought");
		}
		
		// updating the balance of sender and receiver
		fromAccount.setBalance(fromAccount.getBalance()-transfer.getAmount());
		toAccount.setBalance(toAccount.getBalance() + transfer.getAmount());
		
		// set current time on transfer
		transfer.setDate(new Date());
		transfers.add(transfer);
		
		return transfer;
	}
}
