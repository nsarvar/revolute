package com.nsarvar.revolut.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.nsarvar.revolut.model.Account;
import com.nsarvar.revolut.model.Message;
import com.nsarvar.revolut.service.AccountService;

/**
 * @author nsarvar
 *
 */
@Path("accounts")
public class AccountResource {

	AccountService accountService = new AccountService();
	
	/**
	 * Get all accounts from the list on JSON fromat
	 * @return
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Account> getAll(){
		return accountService.getAll();
	}
	
	/**
	 * Get specific account using Account ID on Json format
	 * @param id AccountID
	 * @return it returns account which is found from the list 
	 */
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Account get(@PathParam("id") long id){
		return accountService.get(id);
	}
	
	
	/**
	 * Delete specific account
	 * If delete is successful, then 202 code returns otherwise if an account is not found, 404-not found error code returns
	 * @param id AccountID
	 * @return	it returns error or success message
	 */
	@DELETE
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response delete(@PathParam("id") long id){
		accountService.delete(id);
		return Response.status(200).entity("Account #" + id + " is deleted!").build();
	}
	
	
	/**
	 * Add new account
	 * @param account
	 * @return
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response add(Account account){		
		accountService.add(account);
		Message success = new Message("Account #"+account.getAccountID() + " is created!", 200);

		return Response.status(Status.CREATED).entity(success).build();
	}
	
	/**
	 * Update an account
	 * @param id
	 * @param account
	 * @return
	 */
	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response update(@PathParam("id") long id, Account account){
		account.setAccountID(id);
		accountService.update(account);
		
		Message success = new Message("Account #"+account.getAccountID() + " is updated!", 200);
		
		return Response.status(Status.OK).entity(success).build();
	}

	
}
