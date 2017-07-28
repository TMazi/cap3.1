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
import com.capgemini.chess.service.impl.GetPendingChallengesServiceImpl;
import com.capgemini.chess.service.to.ChallengeTO;
import com.capgemini.chess.service.to.StatisticTO;
import com.capgemini.chess.service.to.UserTO;

@RunWith(MockitoJUnitRunner.class)
public class GetPendingChallengesServiceTest {

	@Mock
	ChallengeDao challengers;

	@Mock
	UserDao potential;

	@Test
	public void shouldGetListOfPendindChallenges() {

		// given
		UserTO user = new UserTO();
		user.setId(1L);
		user.setStatistic(new StatisticTO());
		List<Long> ids = generateIds();
		List<UserTO> pendingOpponents = generatePlayers();
		when(challengers.getIDsOfPlayersChallengingThisPlayer(user.getId())).thenReturn(ids);
		when(potential.getOpponentsByIDs(Matchers.anyListOf(Long.class))).thenReturn(pendingOpponents);
		GetPendingChallengesService service = new GetPendingChallengesServiceImpl(challengers, potential);

		// when
		List<ChallengeTO> challenges = service.getPendingChallenges(user.getId());

		// then
		assertEquals(3, challenges.size());

	}

	@Test
	public void shouldGetEmptyList() {

		// given
		UserTO user = new UserTO();
		user.setId(1L);
		List<Long> ids = new ArrayList<>();
		List<UserTO> pendingOpponents = new ArrayList<>();
		when(challengers.getIDsOfPlayersChallengingThisPlayer(user.getId())).thenReturn(ids);
		when(potential.getOpponentsByIDs(Matchers.anyListOf(Long.class))).thenReturn(pendingOpponents);
		GetPendingChallengesService service = new GetPendingChallengesServiceImpl(challengers, potential);

		// when
		List<ChallengeTO> challenges = service.getPendingChallenges(user.getId());

		// then
		assertEquals(0, challenges.size());
	}

	private List<Long> generateIds() {
		List<Long> ids = new ArrayList<>();
		ids.add(2L);
		ids.add(5L);
		ids.add(6L);
		return ids;
	}

	private List<UserTO> generatePlayers() {
		List<UserTO> opponents = new ArrayList<>();
		UserTO first = new UserTO();
		UserTO second = new UserTO();
		UserTO third = new UserTO();
		first.setStatistic(new StatisticTO());
		second.setStatistic(new StatisticTO());
		third.setStatistic(new StatisticTO());
		first.setId(5L);
		second.setId(2L);
		third.setId(6L);
		opponents.add(first);
		opponents.add(second);
		opponents.add(third);
		return opponents;

	}

}