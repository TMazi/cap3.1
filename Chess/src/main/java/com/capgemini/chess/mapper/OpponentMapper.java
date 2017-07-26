package com.capgemini.chess.mapper;

import com.capgemini.chess.dataaccess.entities.UserEntity;
import com.capgemini.chess.service.to.OpponentTO;

public class OpponentMapper {

	public static OpponentTO opponentMapper(UserEntity user) {
		OpponentTO opponent = new OpponentTO();
		opponent.setId(user.getId());
		opponent.setFirstName(user.getName());
		opponent.setLastName(user.getSurname());
		opponent.setPlayed(user.getStatistics().getPlayed());
		opponent.setWon(user.getStatistics().getWon());
		opponent.setLost(user.getStatistics().getLost());
		opponent.setDrawn(user.getStatistics().getDrawn());
		opponent.setLevel(user.getStatistics().getLevel());
		opponent.setPoints(user.getStatistics().getPoints());
		return opponent;
		
	}
}
