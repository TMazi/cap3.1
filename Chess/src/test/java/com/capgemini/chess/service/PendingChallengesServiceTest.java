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

import com.capgemini.chess.dao.ChallengedPlayersDao;
import com.capgemini.chess.dao.PotentialOpponentDao;
import com.capgemini.chess.service.impl.PendingChallengesServiceImpl;
import com.capgemini.chess.service.to.OpponentTO;
import com.capgemini.chess.service.to.UserTO;

@RunWith(MockitoJUnitRunner.class)
public class PendingChallengesServiceTest {

	@Mock
	ChallengedPlayersDao challengers;

	@Mock
	PotentialOpponentDao potential;

	@Test
	public void shouldGetListOfPendindChallenges() {

		// given
		UserTO user = new UserTO();
		user.setId(1L);
		List<Long> ids = generateIds();
		List<OpponentTO> pendingOpponents = generatePlayers();
		when(challengers.getIDsOfPlayersChallenging(user.getId())).thenReturn(ids);
		when(potential.getOpponentsByIDs(Matchers.anyListOf(Long.class))).thenReturn(pendingOpponents);
		PendingChallengesService service = new PendingChallengesServiceImpl(challengers, potential);

		// when
		List<OpponentTO> opponents = service.getPendingChallenges(user);
		
		//then
		assertEquals(3, opponents.size());

	}

	private List<Long> generateIds() {
		List<Long> ids = new ArrayList<>();
		ids.add(2L);
		ids.add(5L);
		ids.add(6L);
		return ids;
	}

	private List<OpponentTO> generatePlayers() {
		List<OpponentTO> opponents = new ArrayList<>();
		OpponentTO first = new OpponentTO();
		OpponentTO second = new OpponentTO();
		OpponentTO third = new OpponentTO();
		first.setId(5L);
		second.setId(2L);
		third.setId(6L);
		opponents.add(first);
		opponents.add(second);
		opponents.add(third);
		return opponents;

	}
}
