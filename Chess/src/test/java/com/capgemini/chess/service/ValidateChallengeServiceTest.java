package com.capgemini.chess.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.capgemini.chess.dao.ChallengeDao;
import com.capgemini.chess.exception.ChallengeAlreadyExistsException;
import com.capgemini.chess.service.impl.ValidateChallengeServiceImpl;
import com.capgemini.chess.service.to.ChallengeTO;

@RunWith(MockitoJUnitRunner.class)
public class ValidateChallengeServiceTest {

	@Mock
	ChallengeDao challengeDao;

	@Test(expected = ChallengeAlreadyExistsException.class)
	public void shouldFindExistingChallengeAndThrowException() {
		// given
		ValidateChallengeService validateService = new ValidateChallengeServiceImpl(challengeDao);
		ChallengeTO challenge = new ChallengeTO();
		challenge.setId(1L);
		challenge.setChallengingPlayerId(1L);
		challenge.setOpponentPlayerId(2L);
		when(challengeDao.findChallenge(1L, 2L)).thenReturn(challenge);

		// when
		validateService.validateChallenge(1L, 2L);

	}
	
	@Test
	public void shouldNotFindChallengeAndThrowException() {
		// given
		ValidateChallengeService validateService = new ValidateChallengeServiceImpl(challengeDao);
		ChallengeTO challenge = new ChallengeTO();
		challenge.setId(1L);
		challenge.setChallengingPlayerId(1L);
		challenge.setOpponentPlayerId(2L);
		when(challengeDao.findChallenge(1L, 2L)).thenReturn(null);

		// when
		validateService.validateChallenge(1L, 2L);

		// then
		assertEquals(1L, challenge.getId());

	}

}
