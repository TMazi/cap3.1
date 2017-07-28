package com.capgemini.chess.dao.impl;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.capgemini.chess.dao.UserDao;
import com.capgemini.chess.data.Users;
import com.capgemini.chess.mapper.UserMapper;
import com.capgemini.chess.service.to.UserTO;

@Repository
public class UserDaoImpl implements UserDao {

	@Override
	public List<UserTO> findFivePotentialOpponents(int minLevel, int maxLevel, List<Long> impossiblePlayers) {

		return Users.getUsers().stream()
				.filter(user -> user.getStatistics().getLevel() <= maxLevel
						&& user.getStatistics().getLevel() >= minLevel)
				.filter(user -> !impossiblePlayers.contains(user.getId()))
				.limit(5)
				.map(user -> UserMapper.userMapper(user))
				.collect(Collectors.toList());
	}

	@Override
	public List<UserTO> getOpponentsByIDs(List<Long> ids) {

		return Users.getUsers().stream()
				.filter(player -> ids.contains(player.getId()))
				.map(c -> UserMapper.userMapper(c))
				.collect(Collectors.toList());
	}

	@Override
	public UserTO findPlayerById(long playerId) {
		return Users.getUsers().stream()
				.filter(p -> p.getId() == playerId)
				.findFirst()
				.map(user -> UserMapper.userMapper(user))
				.orElse(null);
	}
	

	@Override
	public List<UserTO> searchForPlayers(List<Long> playersId) {
		return Users.getUsers()
				.stream()
				.filter(p -> playersId.contains(p.getId()))
				.map(user -> UserMapper.userMapper(user))
				.collect(Collectors.toList());
	}
	
	private long getNextId() {
		return Users.getUsers().stream().map(player -> player.getId()).max(Comparator.comparing(l -> l)).orElse(0L) + 1L;
	}


}
