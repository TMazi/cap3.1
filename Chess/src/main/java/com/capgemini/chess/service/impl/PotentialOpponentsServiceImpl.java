package com.capgemini.chess.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chess.dao.ChallengeDao;
import com.capgemini.chess.dao.UserDao;
import com.capgemini.chess.mapper.ChallengeMapper;
import com.capgemini.chess.service.PotentialOpponentsService;
import com.capgemini.chess.service.to.ChallengeTO;
import com.capgemini.chess.service.to.OpponentTO;
import com.capgemini.chess.service.to.UserTO;

@Service
public class PotentialOpponentsServiceImpl implements PotentialOpponentsService {

	UserDao users = null;
	ChallengeDao challenges = null;

	@Autowired
	public PotentialOpponentsServiceImpl(UserDao users, ChallengeDao challenges) {
		this.users = users;
		this.challenges = challenges;
	}

	@Override
	public List<ChallengeTO> getPotentialOpponents(UserTO user) {

		int playerLevel = user.getLevel();
		int maxLevel = playerLevel + 2;
		int minLevel;

		if (playerLevel < 3) {
			minLevel = 1;
		} else
			minLevel = playerLevel - 2;

		List<Long> playersAlreadyInChallenge = challenges.getIDsOfPlayersInChallenge(user.getId());
		playersAlreadyInChallenge.add(user.getId());
		List<OpponentTO> opponents = users.findFivePotentialOpponents(minLevel, maxLevel, playersAlreadyInChallenge);

		List<ChallengeTO> challenges = opponents.stream()
				.map(opp -> ChallengeMapper.challengeMapper(opp))
				.collect(Collectors.toList());

		challenges.forEach(chall -> chall.setOpponentPlayerId(user.getId()));

		return challenges;

	}

}
