package com.chasebabbitt.hexgame.card;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
/*
 * Extends the libGDX Sprite class to make the Card class, allowing the card to be
 *  displayed on the screen as a sprite
 */
public class Card extends Sprite{
	
	// Bit masks for card keywords
	public static final short FLY = 1;
	public static final short SKYGUARD = 2;
	public static final short CRUSH = 4;
	public static final short STEADFAST = 8;
	
	
	String name;
	int attackpoints;
	int defensepoints;
	int cost;
	short keywords;
	Texture image;
	Vector2 position;
	// Constructor for Card class for cards with no keywords
	public Card(Texture image, String name, int cost, int attackpoints, int defensepoints){
		this(image,name,cost,attackpoints,defensepoints,(short)0);
	}
	
	// Overloaded constructor for Card class that accepts a a short bitfield that represents keywords the card may have
	public Card(Texture image, String name, int cost, int attackpoints, int defensepoints, short keywords){
		System.out.println("Creating card "+name+" with keywords "+keywords);
		this.name = name;
		this.defensepoints = defensepoints;
		this.attackpoints = attackpoints;
		this.cost = cost;
		this.image = image;
		this.keywords = keywords;
		setRegion(image);
		setBounds(0,0,160,222);
		setPosition(0,0);
		
	}
	//Getter method for attackpoints
	public int getAttackPoints(){
		return attackpoints;
	}
	
	//Getter method for defensepoints
	public int getDefensePoints(){
		return defensepoints;
	}
	
	//Getter method for cost;
	public int getCost(){
		return cost;
	}
	//Getter method for the name of the card
	public String getName(){
		return name;
	}
	//Getter method for the keywords bitfield
	public short getKeywords(){
		return keywords;
	}
}
