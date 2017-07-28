package com.capgemini.chess.facade;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.capgemini.chess.ChessApplication;
import com.capgemini.chess.dao.ChallengeDao;
import com.capgemini.chess.dao.StatisticDao;
import com.capgemini.chess.dao.UserDao;
import com.capgemini.chess.exception.ChallengeAlreadyExistsException;
import com.capgemini.chess.facade.impl.MultiplayerServiceFacadeImpl;
import com.capgemini.chess.service.CreateNewChallengeService;
import com.capgemini.chess.service.GetPendingChallengesService;
import com.capgemini.chess.service.GetPlayerStatisticsService;
import com.capgemini.chess.service.GetPotentialOpponentsService;
import com.capgemini.chess.service.ValidateChallengeService;
import com.capgemini.chess.service.ValidatePlayerService;
import com.capgemini.chess.service.to.ChallengeTO;
import com.capgemini.chess.service.to.StatisticTO;
import com.capgemini.chess.service.to.UserTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ChessApplication.class })
public class MultiplayerServiceFacadeTest {

	@Autowired
	CreateNewChallengeService createChallengeService;

	@Autowired
	GetPendingChallengesService pendingChallengesService;

	@Autowired
	GetPlayerStatisticsService statisticsService;

	@Autowired
	GetPotentialOpponentsService opponentsService;

	@Autowired
	ValidateChallengeService validateChallenge;

	@Autowired
	ValidatePlayerService validatePlayer;

	@Autowired
	ChallengeDao challengeDaoMock;
	@Autowired
	StatisticDao statisticDaoMock;
	@Autowired
	UserDao userDaoMock;

	static MultiplayerServiceFacade service;

	@Before
	public void setup() {
		service = new MultiplayerServiceFacadeImpl(opponentsService, pendingChallengesService, createChallengeService,
				statisticsService);

	}

	@Test
	public void shouldReturnExistingPlayersStatistics() {

		// given

		// when
		StatisticTO stats = service.getPlayersStatistics(5L);

		// then
		assertEquals(5L, stats.getId());
		assertEquals(1, stats.getLevel());
		assertEquals(125, stats.getPoints());
	}

	@Test
	public void shouldCreateAndReturnNewChallenge() {

		// given

		// when
		ChallengeTO challenge = service.sendNewChallengeToPlayer(1L, 3L);

		// then
		assertEquals(5L, challenge.getId());
		assertEquals(1L, challenge.getChallengingPlayerId());
		assertEquals(3L, challenge.getOpponentPlayerId());

	}

	@Test
	public void shoudlGetPotentialAndPendingChallenges() {

		// given
		UserTO user = new UserTO();
		user.setId(2L);
		user.setStatistic(new StatisticTO());
		user.getStatistic().setLevel(3);
		
		// when
		List<ChallengeTO> challenge = service.getPotentialAndPendingChallenges(user);

		// then
		assertEquals(5, challenge.size());
	}

	@Test(expected = ChallengeAlreadyExistsException.class)
	public void shouldThrowExceptionChallengeAlreadyExists() {
		// given

		// when
		service.sendNewChallengeToPlayer(1L, 5L);

		// then
	}

}
