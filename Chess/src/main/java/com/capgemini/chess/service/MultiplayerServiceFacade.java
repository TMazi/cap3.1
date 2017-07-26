package com.capgemini.chess.service;

import java.util.List;

import com.capgemini.chess.service.to.ChallengeTO;
import com.capgemini.chess.service.to.OpponentTO;
import com.capgemini.chess.service.to.UserTO;

public interface MultiplayerServiceFacade {

	List<OpponentTO> getPotentialChallenges(UserTO user);
	
	ChallengeTO setNewChallenge(Long challenger, Long opponent);

}
