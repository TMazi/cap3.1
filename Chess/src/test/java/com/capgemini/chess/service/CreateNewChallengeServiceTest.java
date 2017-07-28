package com.capgemini.chess.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.capgemini.chess.dao.ChallengeDao;
import com.capgemini.chess.service.impl.CreateNewChallengeServiceImpl;
import com.capgemini.chess.service.to.ChallengeTO;
import com.capgemini.chess.service.to.UserTO;

@RunWith(MockitoJUnitRunner.class)
public class CreateNewChallengeServiceTest {

	@Mock
	ChallengeDao challengeDao;

	@Mock
	ValidatePlayerService validatePlayer;

	@Mock
	ValidateChallengeService validateChallenge;

	@Test
	public void shouldCreateAndReturnNewChallenge() {

		// given
		CreateNewChallengeService service = new CreateNewChallengeServiceImpl(challengeDao, validatePlayer,
				validateChallenge);
		UserTO challenger = new UserTO();
		challenger.setId(1L);
		UserTO opponent = new UserTO();
		opponent.setId(2L);
		ChallengeTO challenge = new ChallengeTO();
		challenge.setId(1L);
		challenge.setChallengingPlayerId(challenger.getId());
		challenge.setOpponentPlayerId(opponent.getId());

		// when
		doNothing().when(validatePlayer).validatePlayer(Matchers.anyListOf(Long.class));
		doNothing().when(validateChallenge).validateChallenge(challenger.getId(), opponent.getId());
		when(challengeDao.setChallenge(Matchers.any(ChallengeTO.class))).thenReturn(challenge);
		ChallengeTO result = service.sendNewChallenge(1L, 2L);

		// then
		assertEquals(1L, result.getId());
		assertEquals(1L, result.getChallengingPlayerId());
		assertEquals(2L, result.getOpponentPlayerId());
	}

}
