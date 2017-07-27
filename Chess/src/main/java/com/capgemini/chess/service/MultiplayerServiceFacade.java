package com.capgemini.chess.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.capgemini.chess.service.to.ChallengeTO;
import com.capgemini.chess.service.to.StatisticTO;
import com.capgemini.chess.service.to.UserTO;

@Service
public interface MultiplayerServiceFacade {

	List<ChallengeTO> getPotentialChallenges(UserTO user);

	ChallengeTO sendNewChallenge(Long challenger, Long opponent);
	
	StatisticTO getPlayersStatistics(Long playerID);

}
