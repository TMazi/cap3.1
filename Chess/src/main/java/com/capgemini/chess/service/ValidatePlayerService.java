package com.capgemini.chess.service;

import org.springframework.stereotype.Service;

@Service
public interface ValidatePlayerService {

	void validatePlayer(Long playerID);

}
