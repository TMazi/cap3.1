package com.capgemini.chess.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.capgemini.chess.dao.UserDao;
import com.capgemini.chess.exception.NoSuchPlayerException;
import com.capgemini.chess.service.impl.ValidatePlayerServiceImpl;
import com.capgemini.chess.service.to.UserTO;

@RunWith(MockitoJUnitRunner.class)
public class ValidatePlayerServiceTest {

	@Mock
	UserDao userDao;

	@Test
	public void shouldValidateExistingPlayer() {
		// given
		ValidatePlayerService validateService = new ValidatePlayerServiceImpl(userDao);
		UserTO user = new UserTO();
		user.setId(1L);
		when(userDao.findPlayerById(user.getId())).thenReturn(user);

		// when
		validateService.validatePlayer(1L);

		// then
		assertEquals(1L, user.getId());

	}

	@Test(expected = NoSuchPlayerException.class)
	public void shouldNotFindPlayerAndThrowException() {
		// given
		ValidatePlayerService validateService = new ValidatePlayerServiceImpl(userDao);
		UserTO user = new UserTO();
		user.setId(1L);
		when(userDao.findPlayerById(user.getId())).thenReturn(null);

		// when
		validateService.validatePlayer(1L);
	}

	@Test
	public void shouldValidateExistingTwoPlayers() {
		// given
		ValidatePlayerService validateService = new ValidatePlayerServiceImpl(userDao);
		UserTO user = new UserTO();
		user.setId(1L);
		UserTO user2 = new UserTO();
		user2.setId(2L);
		List<UserTO> users = new ArrayList<>();
		users.add(user);
		users.add(user2);
		when(userDao.searchForPlayers(Matchers.anyListOf(Long.class))).thenReturn(users);

		// when
		validateService.validatePlayer(Arrays.asList(1L, 2L));

		// then
		assertEquals(1L, user.getId());
	}
}
