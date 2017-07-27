package com.capgemini.chess.dao;

import java.util.List;

import com.capgemini.chess.service.to.ChallengeTO;

public interface ChallengeDao {

	List<Long> getIDsOfPlayersInChallenge(Long playerID);

	List<Long> getIDsOfPlayersChallengingThisPlayer(Long playerID);

	ChallengeTO setChallenge(ChallengeTO challenge);

	ChallengeTO findChallenge(long firstPlayer, long secondPlayer);

}
