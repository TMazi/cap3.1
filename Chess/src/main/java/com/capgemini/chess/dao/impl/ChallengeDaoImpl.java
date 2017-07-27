package com.capgemini.chess.dao.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.capgemini.chess.dao.ChallengeDao;
import com.capgemini.chess.dataaccess.entities.ChallengeEntity;
import com.capgemini.chess.enums.Status;
import com.capgemini.chess.mapper.ChallengeMapper;
import com.capgemini.chess.service.to.ChallengeTO;

@Repository
public class ChallengeDaoImpl implements ChallengeDao {

	List<ChallengeEntity> challenges = new ArrayList<>();

	public ChallengeDaoImpl() {
		initChallenges();
	}

	@Override
	public List<Long> getIDsOfPlayersInChallenge(Long playerID) {

		return challenges.stream()
				.filter(c -> playerID.equals(c.getChallengingPlayerId()) || playerID.equals(c.getOpponentPlayerId()))
				.map(c -> c.getChallengingPlayerId() != playerID ? c.getChallengingPlayerId() : c.getOpponentPlayerId())
				.collect(Collectors.toList());
	}

	@Override
	public List<Long> getIDsOfPlayersChallengingThisPlayer(Long playerID) {

		return challenges.stream().filter(c -> playerID.equals(c.getOpponentPlayerId()))
				.map(c -> c.getChallengingPlayerId()).collect(Collectors.toList());
	}

	@Override
	public ChallengeTO setNewChallenge(ChallengeTO challenge) {
		ChallengeEntity newChallenge = ChallengeMapper.challengeMapper(challenge);
		newChallenge.setId(getNextId());
		challenges.add(newChallenge);
		return ChallengeMapper.challengeMapper(newChallenge);

	}

	private void initChallenges() {
		challenges.add(new ChallengeEntity(getNextId(), 1L, 5L, Status.PENDING));
		challenges.add(new ChallengeEntity(getNextId(), 5L, 1L, Status.FINISHED));
		challenges.add(new ChallengeEntity(getNextId(), 2L, 4L, Status.ACCEPTED));
		challenges.add(new ChallengeEntity(getNextId(), 1L, 2L, Status.PENDING));

	}

	private long getNextId() {
		return challenges.stream().map(chall -> chall.getId()).max(Comparator.comparing(l -> l)).orElse(0L) + 1L;
	}

}