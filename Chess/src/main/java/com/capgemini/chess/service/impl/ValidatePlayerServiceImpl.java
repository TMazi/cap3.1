package com.capgemini.chess.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chess.dao.UserDao;
import com.capgemini.chess.exception.NoSuchPlayerException;
import com.capgemini.chess.service.ValidatePlayerService;
import com.capgemini.chess.service.to.UserTO;

@Service
public class ValidatePlayerServiceImpl implements ValidatePlayerService {

	UserDao userDao = null;

	@Autowired
	public ValidatePlayerServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void validatePlayer(List<Long> playersID) {
		List<UserTO> users = userDao.searchForPlayers(playersID);
		if (users.size() != playersID.size())
			throw new NoSuchPlayerException();

	}
	
	@Override
	public void validatePlayer(long playersID) {
		UserTO user = userDao.findPlayerById(playersID);
		if (user == null)
			throw new NoSuchPlayerException();

	}

}
