package com.capgemini.chess.mapper;

import com.capgemini.chess.dataaccess.entities.PlayerStatisticsEntity;
import com.capgemini.chess.dataaccess.entities.UserEntity;
import com.capgemini.chess.service.to.OpponentTO;
import com.capgemini.chess.service.to.StatisticTO;
import com.capgemini.chess.service.to.UserTO;

public class UserMapper {

	public static OpponentTO opponentMapper(UserEntity user) {
		OpponentTO opponent = new OpponentTO();
		opponent.setId(user.getId());
		opponent.setFirstName(user.getName());
		opponent.setLastName(user.getSurname());
		opponent.setPlayed(user.getStatistics().getPlayed());
		opponent.setWon(user.getStatistics().getWon());
		opponent.setLost(user.getStatistics().getLost());
		opponent.setDrawn(user.getStatistics().getDrawn());
		opponent.setLevel(user.getStatistics().getLevel());
		opponent.setPoints(user.getStatistics().getPoints());
		return opponent;

	}
	
	public static StatisticTO statisticsMapper(UserEntity user) {
		StatisticTO statistic = new StatisticTO();
		PlayerStatisticsEntity statsEntity = user.getStatistics();
		statistic.setFirstName(user.getName());
		statistic.setLastName(user.getSurname());
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
		
		return userTO;
		
	}
}
