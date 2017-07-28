package com.capgemini.chess.service;

import org.springframework.stereotype.Service;

import com.capgemini.chess.service.to.StatisticTO;


@Service
public interface GetPlayerStatisticsService {
	
	StatisticTO getPlayersStatistics(long playerID);

}
