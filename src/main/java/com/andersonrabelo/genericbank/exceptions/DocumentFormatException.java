package com.andersonrabelo.genericbank.exceptions;

public class DocumentFormatException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public DocumentFormatException(String msg) {
		super(msg);
	}
}
