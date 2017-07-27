package com.capgemini.chess.dao.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.capgemini.chess.dao.UserDao;
import com.capgemini.chess.dataaccess.entities.PlayerStatisticsEntity;
import com.capgemini.chess.dataaccess.entities.UserEntity;
import com.capgemini.chess.mapper.UserMapper;
import com.capgemini.chess.service.to.OpponentTO;
import com.capgemini.chess.service.to.StatisticTO;
import com.capgemini.chess.service.to.UserTO;

@Repository
public class UserDaoImpl implements UserDao {

	Set<UserEntity> players = new HashSet<UserEntity>();

	public UserDaoImpl() {
		initUsers();
	}

	@Override
	public List<OpponentTO> findFivePotentialOpponents(int minLevel, int maxLevel, List<Long> impossiblePlayers) {

		return players.stream()
				.filter(user -> user.getStatistics().getLevel() > maxLevel
						&& user.getStatistics().getLevel() < minLevel)
				.filter(user -> !impossiblePlayers.contains(user.getId()))
				.map(user -> UserMapper.opponentMapper(user))
				.collect(Collectors.toList());
	}

	@Override
	public List<OpponentTO> getOpponentsByIDs(List<Long> ids) {

		return players.stream()
				.filter(player -> ids.contains(player.getId()))
				.map(c -> UserMapper.opponentMapper(c))
				.collect(Collectors.toList());
	}

	@Override
	public UserTO findPlayerById(long playerId) {
		return players.stream()
				.filter(p -> p.getId() == playerId)
				.findFirst()
				.map(user -> UserMapper.userMapper(user))
				.orElse(null);
	}

	@Override
	public StatisticTO getUserStatistic(long playerId) {
		return players.stream()
				.filter(p -> p.getId() == playerId).findFirst()
				.map(p -> UserMapper.statisticsMapper(p))
				.orElse(null);
	}

	private void initUsers() {
		players.add(new UserEntity(1L, "John", "Wolf", new PlayerStatisticsEntity(1L, 20, 5, 10, 5, 200, 1)));
		players.add(new UserEntity(2L, "Michy", "Kaboul", new PlayerStatisticsEntity(2L, 100, 50, 30, 20, 1000, 3)));
		players.add(new UserEntity(3L, "Adam", "Johnson", new PlayerStatisticsEntity(3L, 500, 450, 16, 34, 3000, 5)));
		players.add(new UserEntity(4L, "Alice", "Cooper", new PlayerStatisticsEntity(4L, 11, 3, 8, 0, 15, 1)));
		players.add(new UserEntity(5L, "Brian", "Ham", new PlayerStatisticsEntity(5L, 73, 28, 41, 4, 125, 1)));
		players.add(new UserEntity(6L, "Lidia", "Kaput", new PlayerStatisticsEntity(6L, 125, 83, 37, 5, 1764, 4)));

	}

}
