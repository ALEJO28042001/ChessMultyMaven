package org.example.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Game {
	
	@Id
	protected int id;
	private String blackPlayer;
	private String whitePlayer;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBlackPlayer() {
		return blackPlayer;
	}
	public void setBlackPlayer(String blackPlayer) {
		this.blackPlayer = blackPlayer;
	}
	public String getWhitePlayer() {
		return whitePlayer;
	}
	public void setWhitePlayer(String whitePlayer) {
		this.whitePlayer = whitePlayer;
	}
	
	

}
