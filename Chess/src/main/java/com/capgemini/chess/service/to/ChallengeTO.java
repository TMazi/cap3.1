package com.capgemini.chess.service.to;

import com.capgemini.chess.enums.Status;

public class ChallengeTO {

	private long id;
	private long challengingPlayerId;
	private long opponentPlayerId;
	private StatisticTO challengingPlayerStats;
	private Status status;

	public long getOpponentPlayerId() {
		return opponentPlayerId;
	}

	public void setOpponentPlayerId(long opponentPlayerId) {
		this.opponentPlayerId = opponentPlayerId;
	}

	public StatisticTO getChallengingPlayerStats() {
		return challengingPlayerStats;
	}

	public void setChallengingPlayerStats(StatisticTO challengingPlayerStats) {
		this.challengingPlayerStats = challengingPlayerStats;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getChallengingPlayerId() {
		return challengingPlayerId;
	}

	public void setChallengingPlayerId(long challengingPlayerId) {
		this.challengingPlayerId = challengingPlayerId;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
