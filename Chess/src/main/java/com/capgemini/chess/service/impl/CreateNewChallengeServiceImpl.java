package com.capgemini.chess.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chess.dao.ChallengeDao;
import com.capgemini.chess.service.CreateNewChallengeService;
import com.capgemini.chess.service.ValidateChallengeService;
import com.capgemini.chess.service.ValidatePlayerService;
import com.capgemini.chess.service.to.ChallengeTO;

@Service
public class CreateNewChallengeServiceImpl implements CreateNewChallengeService {

	ChallengeDao challengeDao = null;
	ValidatePlayerService validatePlayer = null;
	ValidateChallengeService validateChallenge = null;

	@Autowired
	public CreateNewChallengeServiceImpl(ChallengeDao challengeDao, ValidatePlayerService validatePlayer,
			ValidateChallengeService validateChallenge) {
		this.validatePlayer = validatePlayer;
		this.challengeDao = challengeDao;
		this.validateChallenge = validateChallenge;
	}

	@Override
	public ChallengeTO sendNewChallenge(Long challenger, Long opponent) {
		List<Long> players = new ArrayList<>();
		players.add(challenger);
		players.add(opponent);
		validatePlayer.validatePlayer(players);
		validateChallenge.validateChallenge(challenger, opponent);
		ChallengeTO challenge = new ChallengeTO();
		challenge.setChallengingPlayerId(challenger);
		challenge.setOpponentPlayerId(opponent);

		return challengeDao.setChallenge(challenge);

	}

}
