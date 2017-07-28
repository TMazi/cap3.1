package com.capgemini.chess.service;

import org.springframework.stereotype.Service;

@Service
public interface ValidateChallengeService {
	
	void validateChallenge(long firstPlayer, long secondPlayer);

}
