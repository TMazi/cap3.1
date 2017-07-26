package com.capgemini.chess.service;

import java.util.List;

import com.capgemini.chess.service.to.OpponentTO;
import com.capgemini.chess.service.to.UserTO;

public interface PendingChallengesService {

	List<OpponentTO> getPendingChallenges(UserTO user);

}
