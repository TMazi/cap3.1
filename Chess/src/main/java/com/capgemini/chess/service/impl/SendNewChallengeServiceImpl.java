package com.capgemini.chess.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chess.dao.ChallengeDao;
import com.capgemini.chess.service.SendNewChallengeService;
import com.capgemini.chess.service.ValidatePlayerService;
import com.capgemini.chess.service.to.ChallengeTO;

@Service
public class SendNewChallengeServiceImpl implements SendNewChallengeService {
	
	ChallengeDao challengeDao = null;
	ValidatePlayerService validatePlayer = null;
	
	@Autowired
	public SendNewChallengeServiceImpl(ChallengeDao challengeDao, ValidatePlayerService validatePlayer) {
		this.validatePlayer = validatePlayer;
		this.challengeDao = challengeDao;
	}
	
	@Override
	public ChallengeTO sendNewChallenge(Long challenger, Long opponent) {
		validatePlayer.validatePlayer(challenger);
		validatePlayer.validatePlayer(opponent);
		ChallengeTO challenge = new ChallengeTO();
		challenge.setChallengingPlayerId(challenger);
		challenge.setOpponentPlayerId(opponent);
		
		return challengeDao.setNewChallenge(challenge);
		
		
	}

}
