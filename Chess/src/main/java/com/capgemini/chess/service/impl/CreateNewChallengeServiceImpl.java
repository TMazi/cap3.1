package com.capgemini.chess.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chess.dao.ChallengeDao;
import com.capgemini.chess.enums.Status;
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
	public CreateNewChallengeServiceImpl(ChallengeDao challengeDao, ValidatePlayerService validatePlayer, ValidateChallengeService validateChallenge) {
		this.validatePlayer = validatePlayer;
		this.challengeDao = challengeDao;
		this.validateChallenge = validateChallenge;
	}

	@Override
	public ChallengeTO sendNewChallenge(Long challenger, Long opponent) {
		validatePlayer.validatePlayer(challenger);
		validatePlayer.validatePlayer(opponent);
		validateChallenge.validateChallenge(challenger, opponent);
		ChallengeTO challenge = new ChallengeTO();
		challenge.setChallengingPlayerId(challenger);
		challenge.setOpponentPlayerId(opponent);
		challenge.setStatus(Status.PENDING);

		return challengeDao.setChallenge(challenge);

	}

}
