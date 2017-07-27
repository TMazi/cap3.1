package com.capgemini.chess.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.capgemini.chess.dao.ChallengeDao;
import com.capgemini.chess.dao.UserDao;
import com.capgemini.chess.service.impl.GetPotentialOpponentsServiceImpl;
import com.capgemini.chess.service.to.ChallengeTO;
import com.capgemini.chess.service.to.StatisticTO;
import com.capgemini.chess.service.to.UserTO;

@RunWith(MockitoJUnitRunner.class)
public class PotentialOpponentsServiceTest {

	@Mock
	UserDao opponentsDao;

	@Mock
	ChallengeDao challengedDao;

	@Test
	public void shouldReturnListOfOpponents() {

		// given
		GetPotentialOpponentsService service = new GetPotentialOpponentsServiceImpl(opponentsDao, challengedDao);
		List<UserTO> opponents = createSomeOpponents();
		List<Long> alreadyChallenged = new ArrayList<>();
		alreadyChallenged.add(2L);
		when(challengedDao.getIDsOfPlayersInChallenge(1L)).thenReturn(alreadyChallenged);
		when(opponentsDao.findFivePotentialOpponents(Matchers.eq(1), Matchers.eq(4), Matchers.anyListOf(Long.class))).thenReturn(opponents);
		UserTO user = new UserTO();
		user.setId(1);
		user.setStatistic(new StatisticTO());
		user.getStatistic().setLevel(2);

		// when
		List<ChallengeTO> result = service.getPotentialOpponents(user);

		// then
		assertEquals(4, result.size());

	}

	private List<UserTO> createSomeOpponents() {
		List<UserTO> opponents = new ArrayList<>();
		UserTO first = new UserTO();
		first.setId(2L);
		first.setStatistic(new StatisticTO());
		first.getStatistic().setLevel(3);
		UserTO second = new UserTO();
		second.setStatistic(new StatisticTO());
		second.setId(3L);
		second.getStatistic().setLevel(2);
		UserTO third = new UserTO();
		third.setId(4L);
		third.setStatistic(new StatisticTO());
		third.getStatistic().setLevel(1);
		UserTO fourth = new UserTO();
		fourth.setId(5L);
		fourth.setStatistic(new StatisticTO());
		fourth.getStatistic().setLevel(4);
		opponents.add(first);
		opponents.add(second);
		opponents.add(third);
		opponents.add(fourth);

		return opponents;
	}

}
