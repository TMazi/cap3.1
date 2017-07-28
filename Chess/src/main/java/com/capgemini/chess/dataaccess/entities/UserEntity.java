package com.capgemini.chess.dataaccess.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class UserEntity {


	@Id
	private long id;
	private String login;
	private String password;
	private String name;
	private String surname;
	private String email;
	@OneToOne
	private PlayerStatisticsEntity statistics;

	public UserEntity(long id, String name, String surname, PlayerStatisticsEntity statistics) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.statistics = statistics;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public PlayerStatisticsEntity getStatistics() {
		return statistics;
	}

	public void setStatistics(PlayerStatisticsEntity statistics) {
		this.statistics = statistics;
	}

}
