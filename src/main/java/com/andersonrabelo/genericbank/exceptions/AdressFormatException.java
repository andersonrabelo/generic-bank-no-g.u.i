package com.andersonrabelo.genericbank.exceptions;

public class AdressFormatException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public AdressFormatException (String msg) {
		super(msg);
	}

}
