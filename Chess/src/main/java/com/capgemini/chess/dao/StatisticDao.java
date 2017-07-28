package com.capgemini.chess.dao;

import com.capgemini.chess.service.to.StatisticTO;

public interface StatisticDao {

	StatisticTO getUserStatistic(long playerId);

}
