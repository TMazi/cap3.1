package com.capgemini.chess.service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface ValidatePlayerService {

	void validatePlayer(List<Long> playerID);
	
	void validatePlayer(long playerId);

}
