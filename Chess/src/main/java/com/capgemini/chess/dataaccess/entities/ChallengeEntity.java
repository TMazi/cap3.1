package com.capgemini.chess.dataaccess.entities;

import javax.persistence.Entity;

import com.capgemini.chess.enums.Status;

@Entity
public class ChallengeEntity {

	private long id;
	private long challengingPlayerId;
	private long opponentPlayerId;
	private Status status;

	public ChallengeEntity(long id, long challengingPlayerId, long opponentPlayerId, Status status) {
		this.id = id;
		this.challengingPlayerId = challengingPlayerId;
		this.opponentPlayerId = opponentPlayerId;
		this.status = status;
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

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
