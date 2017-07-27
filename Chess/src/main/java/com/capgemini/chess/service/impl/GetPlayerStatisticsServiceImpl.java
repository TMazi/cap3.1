package com.capgemini.chess.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chess.dao.UserDao;
import com.capgemini.chess.service.GetPlayerStatisticsService;
import com.capgemini.chess.service.ValidatePlayerService;
import com.capgemini.chess.service.to.StatisticTO;

@Service
public class GetPlayerStatisticsServiceImpl implements GetPlayerStatisticsService {

	ValidatePlayerService validateService = null;
	UserDao userDao = null;

	@Autowired
	GetPlayerStatisticsServiceImpl(ValidatePlayerService validateService, UserDao userDao) {
		this.validateService = validateService;
		this.userDao = userDao;
	}

	@Override
	public StatisticTO getPlayersStatistics(long playerID) {
		validateService.validatePlayer(playerID);
		return userDao.getUserStatistic(playerID);
	}

}
