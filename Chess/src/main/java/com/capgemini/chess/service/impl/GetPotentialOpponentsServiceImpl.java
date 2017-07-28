package com.capgemini.chess.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chess.dao.ChallengeDao;
import com.capgemini.chess.dao.UserDao;
import com.capgemini.chess.mapper.ChallengeMapper;
import com.capgemini.chess.service.GetPotentialOpponentsService;
import com.capgemini.chess.service.to.ChallengeTO;
import com.capgemini.chess.service.to.UserTO;

@Service
public class GetPotentialOpponentsServiceImpl implements GetPotentialOpponentsService {

	UserDao users = null;
	ChallengeDao challenges = null;

	@Autowired
	public GetPotentialOpponentsServiceImpl(UserDao users, ChallengeDao challenges) {
		this.users = users;
		this.challenges = challenges;
	}

	@Override
	public List<ChallengeTO> getPotentialOpponents(UserTO user) {

		int playerLevel = user.getStatistic().getLevel();
		int maxLevel = playerLevel + 2;
		int minLevel;

		if (playerLevel < 3) {
			minLevel = 1;
		} else
			minLevel = playerLevel - 2;

		List<Long> playersAlreadyInChallenge = challenges.getIDsOfPlayersInChallenge(user.getId());
		playersAlreadyInChallenge.add(user.getId());
		List<UserTO> opponents = users.findFivePotentialOpponents(minLevel, maxLevel, playersAlreadyInChallenge);

		List<ChallengeTO> challenges = opponents.stream()
				.map(opp -> ChallengeMapper.challengeMapper(opp))
				.collect(Collectors.toList());

		challenges.stream().forEach(chall -> chall.setOpponentPlayerId(user.getId()));

		return challenges;

	}

}
