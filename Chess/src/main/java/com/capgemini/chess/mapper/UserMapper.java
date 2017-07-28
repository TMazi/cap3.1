package com.capgemini.chess.mapper;

import com.capgemini.chess.dataaccess.entities.PlayerStatisticsEntity;
import com.capgemini.chess.dataaccess.entities.UserEntity;
import com.capgemini.chess.service.to.StatisticTO;
import com.capgemini.chess.service.to.UserTO;

public class UserMapper {
	
	public static StatisticTO statisticsMapper(UserEntity user) {
		StatisticTO statistic = new StatisticTO();
		PlayerStatisticsEntity statsEntity = user.getStatistics();
		statistic.setId(user.getId());
		statistic.setDrawn(statsEntity.getDrawn());
		statistic.setPlayed(statsEntity.getPlayed());
		statistic.setWon(statsEntity.getWon());
		statistic.setLost(statsEntity.getLost());
		statistic.setLevel(statsEntity.getLevel());
		statistic.setPoints(statsEntity.getPoints());
		
		return statistic;
	}

	public static UserTO userMapper(UserEntity user) {
		UserTO userTO = new UserTO();
		userTO.setFirstName(user.getName());
		userTO.setLastName(user.getSurname());
		userTO.setId(user.getId());
		userTO.setStatistic(UserMapper.statisticsMapper(user));
		
		return userTO;
		
	}
}
