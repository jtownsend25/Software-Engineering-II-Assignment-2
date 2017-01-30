package com.chasebabbitt.hexgame.zones;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.chasebabbitt.hexgame.card.Card;
import com.chasebabbitt.hexgame.card.CardGenerator;

public class EnemyField {
	Array<Card> enemycards;
	public EnemyField(){
		enemycards = new Array<Card>();
		
	}
	public void addCard(){
		Card newcard;
		newcard = CardGenerator.getCard();
		//newcard.setPosition(170*enemycards.size, 480);
		enemycards.add(newcard);
		//System.out.println("Card added. Position: "+newcard.getX()+","+newcard.getY()+".");
	}
	
	//Method for adding a specific card to the enemy field based on an index number
	public void addCard(int cardindex){
		Card newcard;
		newcard = CardGenerator.getCard(cardindex);
		enemycards.add(newcard);
	}
	
	public void draw(SpriteBatch batch){
		for(Card c:enemycards){
			//System.out.println("Position"+c.getX()+","+c.getY());
			c.setPosition(enemycards.indexOf(c,true)*170,450);
			c.draw(batch);
		}
	}
	
	public Array<Card> getCards(){
		return enemycards;
	}
	
	public void removeCard(Card card){
		enemycards.removeValue(card,true);
	}
	
	public void discard(){
		enemycards = new Array<Card>();
	}
}
