package com.capgemini.chess.dao;

import java.util.List;

import com.capgemini.chess.service.to.UserTO;

public interface UserDao {

	List<UserTO> findFivePotentialOpponents(int minLevel, int maxLevel,
			List<Long> impossiblePlayers);

	List<UserTO> getOpponentsByIDs(List<Long> ids);
	
	UserTO findPlayerById(long playerId);
	
	List<UserTO> searchForPlayers(List<Long> playersId);
	
}
