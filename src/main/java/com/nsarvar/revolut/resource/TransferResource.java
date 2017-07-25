package com.nsarvar.revolut.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.nsarvar.revolut.model.Message;
import com.nsarvar.revolut.model.Transfer;
import com.nsarvar.revolut.service.TransferService;

/**
 * @author nsarvar
 * 
 * Money Transfers between internal users
 * 
 */
@Path("transfers")
public class TransferResource {

	TransferService transferService = new TransferService();
	
	/**
	 * All transfers history 
	 * @return returns list of transfers
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Transfer> getAll(){
		return transferService.getAll();
	}
	
	/**
	 * Make a new transfer from one account to another
	 * @param transfer
	 * @return returns response whether it is successful or not
	 */
	@POST
	@Path("/make")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response makeTransfer(Transfer transfer){
		transferService.newTransfer(transfer);
		
		Message msg = new Message("Success", 200);
		return Response.status(Status.OK).entity(msg).build();
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Transfer> get(@PathParam("id") long id){
		return transferService.get(id);
	}
}
