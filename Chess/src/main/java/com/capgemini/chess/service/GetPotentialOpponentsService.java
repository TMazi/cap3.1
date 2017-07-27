package com.capgemini.chess.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.capgemini.chess.service.to.ChallengeTO;
import com.capgemini.chess.service.to.UserTO;

@Service
public interface GetPotentialOpponentsService {
	
	public List<ChallengeTO> getPotentialOpponents(UserTO user);

}
