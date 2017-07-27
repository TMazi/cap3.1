package com.capgemini.chess.dataaccess.entities;

import javax.persistence.Entity;

@Entity
public class ChallengeEntity {

	private long id;
	private long challengingPlayerId;
	private long opponentPlayerId;

	public ChallengeEntity(long id, long challengingPlayerId, long opponentPlayerId) {
		this.id = id;
		this.challengingPlayerId = challengingPlayerId;
		this.opponentPlayerId = opponentPlayerId;
	}

	public long getOpponentPlayerId() {
		return opponentPlayerId;
	}

	public void setOpponentPlayerId(long opponentPlayerId) {
		this.opponentPlayerId = opponentPlayerId;
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

}
