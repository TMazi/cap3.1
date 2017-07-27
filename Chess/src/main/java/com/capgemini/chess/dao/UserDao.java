package com.capgemini.chess.dao;

import java.util.List;

import com.capgemini.chess.service.to.OpponentTO;
import com.capgemini.chess.service.to.StatisticTO;
import com.capgemini.chess.service.to.UserTO;

public interface UserDao {

	public List<OpponentTO> findFivePotentialOpponents(int minLevel, int maxLevel,
			List<Long> impossiblePlayers);

	public List<OpponentTO> getOpponentsByIDs(List<Long> ids);
	
	public UserTO findPlayerById(long playerId);
	
	public StatisticTO getUserStatistic(long playerId);
}
