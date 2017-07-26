package com.capgemini.chess.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.capgemini.chess.dao.ChallengedPlayersDao;
import com.capgemini.chess.dataaccess.entities.ChallengeEntity;

@Repository
public class ChallengedPlayersDaoImpl implements ChallengedPlayersDao {

	List<ChallengeEntity> challenges = new ArrayList<>();

	@Override
	public List<Long> getIDsOfChallengedPlayers(Long playerID) {

		return challenges.stream()
				.filter(c -> playerID.equals(c.getChallengingPlayerId()) 
						|| playerID.equals(c.getOpponentPlayerId()))
				.map(c -> c.getChallengingPlayerId() != playerID ? c.getChallengingPlayerId() 
						: c.getOpponentPlayerId())
				.collect(Collectors.toList());
	}

	@Override
	public List<Long> getIDsOfPlayersChallenging(Long playerID) {
		
		return challenges.stream()
				.filter(c -> playerID.equals(c.getOpponentPlayerId()))
				.map(c -> c.getChallengingPlayerId())
				.collect(Collectors.toList());
	}

}