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
import com.capgemini.chess.service.impl.PotentialOpponentsServiceImpl;
import com.capgemini.chess.service.to.ChallengeTO;
import com.capgemini.chess.service.to.OpponentTO;
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
		PotentialOpponentsService service = new PotentialOpponentsServiceImpl(opponentsDao, challengedDao);
		List<OpponentTO> opponents = createSomeOpponents();
		List<Long> alreadyChallenged = new ArrayList<>();
		alreadyChallenged.add(2L);
		when(challengedDao.getIDsOfPlayersInChallenge(1L)).thenReturn(alreadyChallenged);
		when(opponentsDao.findFivePotentialOpponents(1, 4, Matchers.anyListOf(Long.class))).thenReturn(opponents);
		UserTO user = new UserTO();
		user.setId(1);
		user.setLevel(2);

		// when
		List<ChallengeTO> result = service.getPotentialOpponents(user);

		// then
		assertEquals(3, result.size());

	}

	private List<OpponentTO> createSomeOpponents() {
		List<OpponentTO> opponents = new ArrayList<>();
		OpponentTO first = new OpponentTO();
		first.setId(2L);
		first.setLevel(3);
		OpponentTO second = new OpponentTO();
		second.setId(3L);
		second.setLevel(2);
		OpponentTO third = new OpponentTO();
		third.setId(4L);
		third.setLevel(1);
		OpponentTO fourth = new OpponentTO();
		fourth.setId(5L);
		fourth.setLevel(4);
		opponents.add(first);
		opponents.add(second);
		opponents.add(third);
		opponents.add(fourth);

		return opponents;
	}

}
