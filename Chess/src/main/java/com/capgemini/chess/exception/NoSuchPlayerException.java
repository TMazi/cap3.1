package com.capgemini.chess.exception;

public class NoSuchPlayerException extends RuntimeException {

	private static final long serialVersionUID = -4301705866824648005L;

	public NoSuchPlayerException() {
		super("Ther is no such player");
	}
}
