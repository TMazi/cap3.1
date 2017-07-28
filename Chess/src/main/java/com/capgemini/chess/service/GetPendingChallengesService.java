package com.capgemini.chess.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.capgemini.chess.service.to.ChallengeTO;



@Service
public interface GetPendingChallengesService {

	List<ChallengeTO> getPendingChallenges(long userId);

}
