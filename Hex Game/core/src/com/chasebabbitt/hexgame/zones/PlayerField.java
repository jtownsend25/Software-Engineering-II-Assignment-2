package com.chasebabbitt.hexgame.zones;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.chasebabbitt.hexgame.card.Card;
import com.chasebabbitt.hexgame.card.CardGenerator;

public class PlayerField {
	Array<Card> playercards;
	public PlayerField(){
		playercards = new Array<Card>();
		
	}
	public void addCard(){
		Card newcard;
		newcard = CardGenerator.getCard();
		playercards.add(newcard);
	}
	public void addCard(int cardindex){
		Card newcard;
		newcard = CardGenerator.getCard(cardindex);
		playercards.add(newcard);
	}
	
	public void draw(SpriteBatch batch){
		for(Card c:playercards){
			c.setPosition(playercards.indexOf(c,true)*170,0);
			c.draw(batch);
		}
	}
	
	public Array<Card> getCards(){
		return playercards;
	}
	
	public void removeCard(Card card){
		playercards.removeValue(card,true);
	}
	
	public void discard(){
		playercards = new Array<Card>();
	}
}


