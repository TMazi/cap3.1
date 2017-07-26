package com.capgemini.chess.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.capgemini.chess.service.to.OpponentTO;
import com.capgemini.chess.service.to.UserTO;

@Service
public interface PotentialOpponentsService {
	
	public List<OpponentTO> getPotentialOpponents(UserTO user);

}
