package com.capgemini.chess.service;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ GetPendingChallengesServiceTest.class, GetPotentialOpponentsServiceTest.class,
		ValidatePlayerServiceTest.class, ValidateChallengeServiceTest.class, GetPlayerStatisticServiceTest.class,
		CreateNewChallengeServiceTest.class })
public class ServiceTestSuite {

}
