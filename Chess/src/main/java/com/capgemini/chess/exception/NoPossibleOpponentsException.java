package com.capgemini.chess.exception;

public class NoPossibleOpponentsException extends RuntimeException {

	private static final long serialVersionUID = 512016714498672024L;

	public NoPossibleOpponentsException(String message) {
		super(message);
	}
}
