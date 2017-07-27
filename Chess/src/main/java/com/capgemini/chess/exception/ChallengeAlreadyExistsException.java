package com.capgemini.chess.exception;

public class ChallengeAlreadyExistsException extends RuntimeException {

	
	private static final long serialVersionUID = 1086093474404185183L;

	public ChallengeAlreadyExistsException() {
		super("There is already challenge between players");
	}
}
