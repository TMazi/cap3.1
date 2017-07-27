package com.capgemini.chess.dao;

import java.util.List;

import com.capgemini.chess.service.to.ChallengeTO;

public interface ChallengeDao {
	
	public List<Long> getIDsOfPlayersInChallenge(Long playerID);
	
	public List<Long> getIDsOfPlayersChallengingThisPlayer(Long playerID);
	
	public ChallengeTO setNewChallenge(ChallengeTO challenge);

}
