package com.capgemini.chess.mapper;

import com.capgemini.chess.dataaccess.entities.ChallengeEntity;
import com.capgemini.chess.service.to.ChallengeTO;
import com.capgemini.chess.service.to.StatisticTO;
import com.capgemini.chess.service.to.UserTO;

public class ChallengeMapper {

	
	public static ChallengeTO challengeMapper(UserTO opponent) {
		ChallengeTO challenge = new ChallengeTO();
		challenge.setOpponentPlayerId(opponent.getId());
		StatisticTO statistics = new StatisticTO();
		statistics.setId(opponent.getId());
		statistics.setPlayed(opponent.getStatistic().getPlayed());
		statistics.setWon(opponent.getStatistic().getWon());
		statistics.setDrawn(opponent.getStatistic().getDrawn());
		statistics.setLost(opponent.getStatistic().getLost());
		statistics.setPoints(opponent.getStatistic().getPoints());
		statistics.setLevel(opponent.getStatistic().getLevel());
		challenge.setOpponentPlayerStats(statistics);

		return challenge;
	}

	public static ChallengeTO challengeMapper(ChallengeEntity challEnt) {
		ChallengeTO challenge = new ChallengeTO();
		challenge.setId(challEnt.getId());
		challenge.setChallengingPlayerId(challEnt.getChallengingPlayerId());
		challenge.setOpponentPlayerId(challEnt.getOpponentPlayerId());
		return challenge;
	}

	public static ChallengeEntity challengeMapper(ChallengeTO chall) {
		ChallengeEntity challenge = new ChallengeEntity(chall.getId(), chall.getChallengingPlayerId(), chall.getOpponentPlayerId());

		return challenge;
	}

}
