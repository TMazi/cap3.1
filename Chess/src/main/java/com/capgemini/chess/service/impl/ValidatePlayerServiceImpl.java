package com.capgemini.chess.service.impl;

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
	ValidatePlayerServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void validatePlayer(Long playerID) {
		UserTO user = userDao.findPlayerById(playerID);
		if (user.equals(null))
			throw new NoSuchPlayerException();

	}

}
