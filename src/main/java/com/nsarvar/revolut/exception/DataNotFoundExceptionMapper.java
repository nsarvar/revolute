package com.nsarvar.revolut.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.nsarvar.revolut.model.Message;


/**
 * @author nsarvar
 *
 */
// provider annotation registers the class in Jax-rs
@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException>{

	@Override
	public Response toResponse(DataNotFoundException exception) {
		Message errorMessage = new Message(exception.getMessage(), 404);
		
		return Response.status(Status.NOT_FOUND)
				.entity(errorMessage)
				.build();
	}
}
