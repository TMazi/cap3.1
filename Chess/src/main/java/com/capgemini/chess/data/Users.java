package com.capgemini.chess.data;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.capgemini.chess.dataaccess.entities.PlayerStatisticsEntity;
import com.capgemini.chess.dataaccess.entities.UserEntity;

public class Users {

	private static Set<UserEntity> users = new HashSet<UserEntity>(
			Arrays.asList(new UserEntity(1L, "John", "Wolf", new PlayerStatisticsEntity(1L, 20, 5, 10, 5, 200, 1)),
					new UserEntity(2L, "Michy", "Kaboul", new PlayerStatisticsEntity(2L, 100, 50, 30, 20, 1000, 3)),
					new UserEntity(3L, "Adam", "Johnson", new PlayerStatisticsEntity(3L, 500, 450, 16, 34, 3000, 5)),
					new UserEntity(4L, "Alice", "Cooper", new PlayerStatisticsEntity(4L, 11, 3, 8, 0, 15, 1)),
					new UserEntity(5L, "Brian", "Ham", new PlayerStatisticsEntity(5L, 73, 28, 41, 4, 125, 1)),
					new UserEntity(6L, "Lidia", "Kaput", new PlayerStatisticsEntity(6L, 125, 83, 37, 5, 1764, 4))
					));

	public static Set<UserEntity> getUsers() {
		return users;
	}

	public static void setUsers(Set<UserEntity> users) {
		Users.users = users;
	}

}
