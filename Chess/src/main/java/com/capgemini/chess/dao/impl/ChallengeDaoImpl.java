package com.capgemini.chess.dao.impl;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.capgemini.chess.dao.ChallengeDao;
import com.capgemini.chess.data.Challenges;
import com.capgemini.chess.dataaccess.entities.ChallengeEntity;
import com.capgemini.chess.mapper.ChallengeMapper;
import com.capgemini.chess.service.to.ChallengeTO;

@Repository
public class ChallengeDaoImpl implements ChallengeDao {

	@Override
	public List<Long> getIDsOfPlayersInChallenge(Long playerID) {

		return Challenges.getChallenges().stream()
				.filter(c -> playerID.equals(c.getChallengingPlayerId()) || playerID.equals(c.getOpponentPlayerId()))
				.map(c -> c.getChallengingPlayerId() != playerID ? c.getChallengingPlayerId() : c.getOpponentPlayerId())
				.collect(Collectors.toList());
	}

	@Override
	public List<Long> getIDsOfPlayersChallengingThisPlayer(Long playerID) {

		return Challenges.getChallenges().stream()
				.filter(c -> playerID.equals(c.getOpponentPlayerId()))
				.map(c -> c.getChallengingPlayerId()).collect(Collectors.toList());
	}

	@Override
	public ChallengeTO setChallenge(ChallengeTO challenge) {
		ChallengeEntity newChallenge = ChallengeMapper.challengeMapper(challenge);
		newChallenge.setId(getNextId());
		Challenges.getChallenges().add(newChallenge);
		return ChallengeMapper.challengeMapper(newChallenge);
	}

	@Override
	public ChallengeTO findChallenge(long firstPlayer, long secondPlayer) {
		return Challenges.getChallenges().stream()
				.filter(c -> (c.getChallengingPlayerId() == firstPlayer && c.getOpponentPlayerId() == secondPlayer)
						|| (c.getOpponentPlayerId() == firstPlayer && c.getChallengingPlayerId() == secondPlayer))
				.findFirst()
				.map(c -> ChallengeMapper.challengeMapper(c))
				.orElse(null);
	}

	private long getNextId() {
		return Challenges.getChallenges().stream().map(chall -> chall.getId()).max(Comparator.comparing(l -> l)).orElse(0L) + 1L;
	}

}