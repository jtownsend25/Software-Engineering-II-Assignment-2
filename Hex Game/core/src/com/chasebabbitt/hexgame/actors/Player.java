package com.chasebabbitt.hexgame.actors;

public class Player {
	// The player's health
	int health;
	/**
	 * Constructor for player
	 * @param health the integer value that the player's health will be
	 */
	public Player(int health){
		this.health = health;
	}
	/**
	 * Getter method for health
	 * @return returns the value of health
	 */
	public int getPlayerHealth(){
		return health;
	}
	/**
	 * Setter method for health
	 */
	public void setPlayerHealth(int health){
		this.health = health;
		
	}
}
