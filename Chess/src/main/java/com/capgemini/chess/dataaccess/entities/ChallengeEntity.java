package com.capgemini.chess.dataaccess.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.capgemini.chess.enums.Status;

@Entity
public class ChallengeEntity {

	@Id
	@GeneratedValue
	private long id;
	@Column(nullable = false)
	private long challengingPlayerId;
	@Column(nullable = false)
	private long opponentPlayerId;
	@Column(nullable = false)
	private Status status;

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
