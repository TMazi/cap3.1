package com.capgemini.chess.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chess.dao.ChallengedPlayersDao;
import com.capgemini.chess.dao.PotentialOpponentDao;
import com.capgemini.chess.service.PendingChallengesService;
import com.capgemini.chess.service.to.OpponentTO;
import com.capgemini.chess.service.to.UserTO;

@Service
public class PendingChallengesServiceImpl implements PendingChallengesService {

	ChallengedPlayersDao challengers;
	PotentialOpponentDao potential;

	@Autowired
	public PendingChallengesServiceImpl(ChallengedPlayersDao challengers, PotentialOpponentDao potential) {
		this.challengers = challengers;
		this.potential = potential;
	}

	@Override
	public List<OpponentTO> getPendingChallenges(UserTO user) {

		List<Long> ids = challengers.getIDsOfChallengedPlayers(user.getId());
		return potential.getOpponentsByIDs(ids);

	}
}
