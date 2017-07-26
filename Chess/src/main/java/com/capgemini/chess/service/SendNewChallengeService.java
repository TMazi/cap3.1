package com.capgemini.chess.service;

import com.capgemini.chess.service.to.ChallengeTO;

public interface SendNewChallengeService {
	
	ChallengeTO sendNewChallenge(Long challenger, Long opponent);

}
