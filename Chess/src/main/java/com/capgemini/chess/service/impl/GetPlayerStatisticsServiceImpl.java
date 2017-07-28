package com.capgemini.chess.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chess.dao.StatisticDao;
import com.capgemini.chess.service.GetPlayerStatisticsService;
import com.capgemini.chess.service.ValidatePlayerService;
import com.capgemini.chess.service.to.StatisticTO;

@Service
public class GetPlayerStatisticsServiceImpl implements GetPlayerStatisticsService {

	ValidatePlayerService validateService = null;
	StatisticDao statisticDao = null;

	@Autowired
	public GetPlayerStatisticsServiceImpl(ValidatePlayerService validateService, StatisticDao statisticDao) {
		this.validateService = validateService;
		this.statisticDao = statisticDao;
	}

	@Override
	public StatisticTO getPlayersStatistics(long playerID) {
		validateService.validatePlayer(playerID);
		return statisticDao.getUserStatistic(playerID);
	}

}
