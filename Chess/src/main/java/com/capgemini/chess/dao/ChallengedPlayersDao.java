package com.capgemini.chess.dao;

import java.util.List;

public interface ChallengedPlayersDao {
	
	public List<Long> getIDsOfChallengedPlayers(Long playerID);
	
	public List<Long> getIDsOfPlayersChallenging(Long playerID);

}
