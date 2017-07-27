package com.capgemini.chess.service;

import org.springframework.stereotype.Service;

import com.capgemini.chess.service.to.ChallengeTO;


@Service
public interface SendNewChallengeService {
	
	ChallengeTO sendNewChallenge(Long challenger, Long opponent);

}
