package com.nsarvar.revolut.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author nsarvar
 * Messages model stores error or success messages
 */
@XmlRootElement
public class Message {
	
	private String message;
	private int code;
	
	
	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Message(String message, int code) {
		super();
		this.message = message;
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
}