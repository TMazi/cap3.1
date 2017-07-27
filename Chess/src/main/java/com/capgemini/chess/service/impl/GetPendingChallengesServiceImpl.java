package com.capgemini.chess.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chess.dao.ChallengeDao;
import com.capgemini.chess.dao.UserDao;
import com.capgemini.chess.mapper.ChallengeMapper;
import com.capgemini.chess.service.GetPendingChallengesService;
import com.capgemini.chess.service.to.ChallengeTO;
import com.capgemini.chess.service.to.UserTO;

@Service
public class GetPendingChallengesServiceImpl implements GetPendingChallengesService {

	ChallengeDao challenges = null;
	UserDao users = null;

	@Autowired
	public GetPendingChallengesServiceImpl(ChallengeDao challengers, UserDao potential) {
		this.challenges = challengers;
		this.users = potential;
	}

	@Override
	public List<ChallengeTO> getPendingChallenges(long userId) {

		List<Long> ids = challenges.getIDsOfPlayersInChallenge(userId);
		List<UserTO> opponents = users.getOpponentsByIDs(ids);
		
		List<ChallengeTO> challenges = opponents.stream()
				.map(opp -> ChallengeMapper.challengeMapper(opp))
				.collect(Collectors.toList());
		
		challenges.forEach(chall -> {
			chall.setOpponentPlayerId(userId);
		});
		
		return challenges;
	}
}
