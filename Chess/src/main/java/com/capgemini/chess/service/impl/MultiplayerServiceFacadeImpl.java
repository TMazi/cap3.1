package com.capgemini.chess.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chess.service.MultiplayerServiceFacade;
import com.capgemini.chess.service.PendingChallengesService;
import com.capgemini.chess.service.PotentialOpponentsService;
import com.capgemini.chess.service.to.ChallengeTO;
import com.capgemini.chess.service.to.OpponentTO;
import com.capgemini.chess.service.to.UserTO;

@Service
public class MultiplayerServiceFacadeImpl implements MultiplayerServiceFacade {

	private PotentialOpponentsService potentialOpponentsService = null;
	private PendingChallengesService pendingChallengesService = null;

	@Autowired
	MultiplayerServiceFacadeImpl(PotentialOpponentsService potentialOpponentsService,
			PendingChallengesService pendingChallengesService) {

		this.potentialOpponentsService = potentialOpponentsService;
		this.pendingChallengesService = pendingChallengesService;
	}

	@Override
	public List<OpponentTO> getPotentialChallenges(UserTO user) {

		List<OpponentTO> result = new ArrayList<>();
		result.addAll(potentialOpponentsService.getPotentialOpponents(user));
		result.addAll(pendingChallengesService.getPendingChallenges(user));
		return result;

	}

	@Override
	public ChallengeTO setNewChallenge(Long firstID, Long secondID) {
		// TODO Auto-generated method stub
		return null;
	}

}
