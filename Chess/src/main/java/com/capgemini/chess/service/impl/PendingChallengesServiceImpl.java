package com.capgemini.chess.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chess.dao.ChallengeDao;
import com.capgemini.chess.dao.UserDao;
import com.capgemini.chess.enums.Status;
import com.capgemini.chess.mapper.ChallengeMapper;
import com.capgemini.chess.service.PendingChallengesService;
import com.capgemini.chess.service.to.ChallengeTO;
import com.capgemini.chess.service.to.OpponentTO;

@Service
public class PendingChallengesServiceImpl implements PendingChallengesService {

	ChallengeDao challenges = null;
	UserDao users = null;

	@Autowired
	public PendingChallengesServiceImpl(ChallengeDao challengers, UserDao potential) {
		this.challenges = challengers;
		this.users = potential;
	}

	@Override
	public List<ChallengeTO> getPendingChallenges(long userId) {

		List<Long> ids = challenges.getIDsOfPlayersInChallenge(userId);
		List<OpponentTO> opponents = users.getOpponentsByIDs(ids);
		
		List<ChallengeTO> challenges = opponents.stream()
				.map(opp -> ChallengeMapper.challengeMapper(opp))
				.collect(Collectors.toList());
		
		challenges.forEach(chall -> {
			chall.setOpponentPlayerId(userId);
			chall.setStatus(Status.PENDING);
		});
		
		return challenges;
	}
}
