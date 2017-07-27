package com.capgemini.chess.service.to;

public class UserTO {

	private long id;
	private String firstName;
	private String lastName;
	private StatisticTO statistic;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public StatisticTO getStatistic() {
		return statistic;
	}

	public void setStatistic(StatisticTO statistic) {
		this.statistic = statistic;
	}

}
