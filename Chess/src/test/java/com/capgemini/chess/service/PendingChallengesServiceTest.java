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
import com.capgemini.chess.service.to.OpponentTO;
import com.capgemini.chess.service.to.UserTO;

@RunWith(MockitoJUnitRunner.class)
public class PendingChallengesServiceTest {

	@Mock
	ChallengeDao challengers;

	@Mock
	UserDao potential;

	@Test
	public void shouldGetListOfPendindChallenges() {

		// given
		UserTO user = new UserTO();
		user.setId(1L);
		List<Long> ids = generateIds();
		List<OpponentTO> pendingOpponents = generatePlayers();
		when(challengers.getIDsOfPlayersChallengingThisPlayer(user.getId())).thenReturn(ids);
		when(potential.getOpponentsByIDs(Matchers.anyListOf(Long.class))).thenReturn(pendingOpponents);
		GetPendingChallengesService service = new GetPendingChallengesServiceImpl(challengers, potential);

		// when
		List<ChallengeTO> challenges = service.getPendingChallenges(user.getId());
		
		//then
		assertEquals(3, challenges.size());

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
