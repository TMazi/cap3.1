package com.capgemini.chess.dao.impl;

import org.springframework.stereotype.Repository;

import com.capgemini.chess.dao.StatisticDao;
import com.capgemini.chess.data.Users;
import com.capgemini.chess.mapper.UserMapper;
import com.capgemini.chess.service.to.StatisticTO;

@Repository
public class StatisticDaoImpl implements StatisticDao {

	@Override
	public StatisticTO getUserStatistic(long playerId) {
		return Users.getUsers().stream()
				.filter(p -> p.getId() == playerId)
				.findFirst()
				.map(p -> UserMapper.statisticsMapper(p))
				.orElse(null);
	}

}
