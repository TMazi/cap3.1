package com.capgemini.chess.data;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.capgemini.chess.dataaccess.entities.ChallengeEntity;

public class Challenges {

	private static Set<ChallengeEntity> challenges = new HashSet<ChallengeEntity>(
			Arrays.asList(new ChallengeEntity(1L, 1L, 5L), new ChallengeEntity(2L, 5L, 1L),
					new ChallengeEntity(3L, 2L, 4L), new ChallengeEntity(4L, 1L, 2L)));

	public static Set<ChallengeEntity> getChallenges() {
		return challenges;
	}

	public static void setChallenges(Set<ChallengeEntity> challenges) {
		Challenges.challenges = challenges;
	}

}
