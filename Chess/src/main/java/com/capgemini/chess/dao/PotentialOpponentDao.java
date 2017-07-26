package com.capgemini.chess.dao;

import java.util.List;

import com.capgemini.chess.service.to.OpponentTO;

public interface PotentialOpponentDao {

	public List<OpponentTO> findPotentialOpponents(int minLevel, int maxLevel);

	public List<OpponentTO> getOpponentsByIDs(List<Long> ids);
}
