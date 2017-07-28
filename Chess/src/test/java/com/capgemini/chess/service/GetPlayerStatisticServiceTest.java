package com.capgemini.chess.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.capgemini.chess.dao.StatisticDao;
import com.capgemini.chess.service.impl.GetPlayerStatisticsServiceImpl;
import com.capgemini.chess.service.to.StatisticTO;
import com.capgemini.chess.service.to.UserTO;

@RunWith(MockitoJUnitRunner.class)
public class GetPlayerStatisticServiceTest {

	@Mock
	ValidatePlayerService validateService;

	@Mock
	StatisticDao statisticDao;

	@Test
	public void shouldReturnPlayersStatistics() {

		// given
		GetPlayerStatisticsService service = new GetPlayerStatisticsServiceImpl(validateService, statisticDao);
		UserTO user = new UserTO();
		user.setId(5L);
		user.setStatistic(new StatisticTO());
		user.getStatistic().setPlayed(5);
		user.getStatistic().setLevel(1);
		

		// when
		doNothing().when(validateService).validatePlayer(user.getId());
		when(statisticDao.getUserStatistic(user.getId())).thenReturn(user.getStatistic());
		StatisticTO statistics = service.getPlayersStatistics(user.getId());

		// then
		assertEquals(1, statistics.getLevel());
		assertEquals(5, statistics.getPlayed());
	}

}
