package com.nsarvar.revolut.resource;

import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.nsarvar.revolut.db.DbClass;
import com.nsarvar.revolut.model.Account;

 
/**
 * @author nsarvar
 * 
 * This class is used only for Initializing default data
 */
@Path("myresource")
public class MyResource {

    /**
     * 
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
	private Map<Long, Account> accounts = DbClass.getAccounts();
	
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String initialize() {
    	accounts.put(1001L, new Account(1001, "John", 1000.00));
		accounts.put(1002L, new Account(1002, "Tom", 1500.00));
		accounts.put(1003L, new Account(1003, "Alex", 2500.00));
		
    	return "Done!";
    }
}
