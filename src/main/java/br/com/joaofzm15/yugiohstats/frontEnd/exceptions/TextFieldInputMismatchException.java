package br.com.joaofzm15.yugiohstats.frontEnd.exceptions;

public class TextFieldInputMismatchException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public TextFieldInputMismatchException(String msg) {
		super(msg);
	}
}
