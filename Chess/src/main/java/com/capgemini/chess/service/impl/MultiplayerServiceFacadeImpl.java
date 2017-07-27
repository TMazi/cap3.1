package com.capgemini.chess.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chess.service.GetPlayerStatisticsService;
import com.capgemini.chess.service.MultiplayerServiceFacade;
import com.capgemini.chess.service.PendingChallengesService;
import com.capgemini.chess.service.PotentialOpponentsService;
import com.capgemini.chess.service.SendNewChallengeService;
import com.capgemini.chess.service.to.ChallengeTO;
import com.capgemini.chess.service.to.StatisticTO;
import com.capgemini.chess.service.to.UserTO;

@Service
public class MultiplayerServiceFacadeImpl implements MultiplayerServiceFacade {

	private PotentialOpponentsService potentialOpponentsService = null;
	private PendingChallengesService pendingChallengesService = null;
	private SendNewChallengeService sendNewChallengeService = null;
	private GetPlayerStatisticsService statisticsService = null;

	@Autowired
	MultiplayerServiceFacadeImpl(PotentialOpponentsService potentialOpponentsService,
			PendingChallengesService pendingChallengesService, SendNewChallengeService sendNewChallengeService,
			GetPlayerStatisticsService statisticsService) {

		this.potentialOpponentsService = potentialOpponentsService;
		this.pendingChallengesService = pendingChallengesService;
		this.sendNewChallengeService = sendNewChallengeService;
		this.statisticsService = statisticsService;
	}

	@Override
	public List<ChallengeTO> getPotentialChallenges(UserTO user) {

		List<ChallengeTO> result = new ArrayList<>();
		result.addAll(potentialOpponentsService.getPotentialOpponents(user));
		result.addAll(pendingChallengesService.getPendingChallenges(user.getId()));
		return result;

	}

	@Override
	public ChallengeTO sendNewChallenge(Long firstID, Long secondID) {
		return sendNewChallengeService.sendNewChallenge(firstID, secondID);
	}

	@Override
	public StatisticTO getPlayersStatistics(Long playerID) {
		return statisticsService.getPlayersStatistics(playerID);
		
	}

}
