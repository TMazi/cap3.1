package com.capgemini.chess.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chess.dao.ChallengedPlayersDao;
import com.capgemini.chess.dao.PotentialOpponentDao;
import com.capgemini.chess.service.PotentialOpponentsService;
import com.capgemini.chess.service.to.OpponentTO;
import com.capgemini.chess.service.to.UserTO;

@Service
public class PotentialOpponentsServiceImpl implements PotentialOpponentsService {

	PotentialOpponentDao potentialOpponents = null;
	ChallengedPlayersDao challengedPlayers = null;

	@Autowired
	public PotentialOpponentsServiceImpl(PotentialOpponentDao potentialOpponents,
			ChallengedPlayersDao challengedPlayers) {
		this.potentialOpponents = potentialOpponents;
		this.challengedPlayers = challengedPlayers;
	}

	@Override
	public List<OpponentTO> getPotentialOpponents(UserTO user) {

		int playerLevel = user.getLevel();
		int maxLevel = playerLevel + 2;
		int minLevel;

		if (playerLevel < 3) {
			minLevel = 1;
		} else
			minLevel = playerLevel - 2;

		List<OpponentTO> opponents = potentialOpponents.findPotentialOpponents(minLevel, maxLevel);
		List<Long> alreadyChallengedPlayersIds = challengedPlayers.getIDsOfChallengedPlayers(user.getId());

		return opponents.stream()
				.filter(u -> !alreadyChallengedPlayersIds.contains(u.getId()))
				.limit(5)
				.collect(Collectors.toList());

	}

}
