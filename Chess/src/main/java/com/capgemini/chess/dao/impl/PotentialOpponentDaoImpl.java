package com.capgemini.chess.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.capgemini.chess.dao.PotentialOpponentDao;
import com.capgemini.chess.dataaccess.entities.UserEntity;
import com.capgemini.chess.mapper.OpponentMapper;
import com.capgemini.chess.service.to.OpponentTO;

@Repository
public class PotentialOpponentDaoImpl implements PotentialOpponentDao {

	Map<Long, UserEntity> players = new HashMap<>();

	@Override
	public List<OpponentTO> findPotentialOpponents(int minLevel, int maxLevel) {

		return players.values().stream()
				.filter(user -> user.getStatistics().getLevel() > maxLevel
						&& user.getStatistics().getLevel() < minLevel)
				.map(user -> OpponentMapper.opponentMapper(user))
				.collect(Collectors.toList());
	}

	@Override
	public List<OpponentTO> getOpponentsByIDs(List<Long> ids) {


		return players.values()
				.stream().filter(player -> ids.contains(player.getId()))
				.map(c -> OpponentMapper.opponentMapper(c))
				.collect(Collectors.toList());
	}

}
