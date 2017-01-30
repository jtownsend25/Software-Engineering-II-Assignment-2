package com.chasebabbitt.hexgame.strategy;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.chasebabbitt.hexgame.card.Card;
/**
 * A Move object
 * @author Chase
 *
 */
public class Move {
	/**
	 * attacker is the attacking card and defender is the defending card, the defending card may be full to represent
	 * not defending an attack when it would be unwise to do so
	 */
	Card attacker, defender;
	
	public Move(Card attacker, Card defender){
		this.attacker=attacker;
		this.defender=defender;
	}
	
	/**
	 * Draws a graphical representation of the move to right side of the screen
	 * @param batch an object of type SpriteBatch
	 */
	public void draw(SpriteBatch batch){
		attacker.setBounds(0, 0, 214,297);
		attacker.setPosition(900, 420);
		attacker.draw(batch);
		if(defender!=null){
			
			defender.setBounds(0,0,214,297);
			defender.setPosition(900, 10);
			defender.draw(batch);
		}
	}
	/**
	 * Displays the move for the console
	 */
	public void consoleDisplay(){
		if(defender==null){
			System.out.println(attacker.getName()+" attacks and is not blocked");
		}
		else{
			System.out.println(attacker.getName()+" attacks and is blocked by "+defender.getName());
		}
	}
}
