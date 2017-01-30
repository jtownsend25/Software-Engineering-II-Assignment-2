package com.chasebabbitt.hexgame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Array;
import com.chasebabbitt.hexgame.actors.Player;
import com.chasebabbitt.hexgame.card.Card;
import com.chasebabbitt.hexgame.card.CardGenerator;
import com.chasebabbitt.hexgame.strategy.DefenseStrategy;
import com.chasebabbitt.hexgame.strategy.DumbStrategy;
import com.chasebabbitt.hexgame.strategy.Move;
import com.chasebabbitt.hexgame.strategy.Strategy;
import com.chasebabbitt.hexgame.zones.EnemyField;
import com.chasebabbitt.hexgame.zones.PlayerField;

public class HexGame extends Game {

	SpriteBatch batch;
	Texture img;
	Card card;
	EnemyField enemyfield;
	PlayerField playerfield;
	Move suggestedmove;
	Strategy strategy;
	Player player;
	public static AssetManager manager;
	Label defendersLabel;
	Label attackersLabel;
	Label moveLabel;
	
	@Override
	public void create () {
		manager = new AssetManager();
		manager.load("Cards/Blasphemous Horror.jpg", Texture.class);
		manager.load("Cards/Dire Spider.jpg", Texture.class);
		manager.load("Cards/Duskwing Maiden.jpg", Texture.class);
		manager.load("Cards/Llama.jpg", Texture.class);
		manager.load("Cards/Paladin of Naagaan.jpg", Texture.class);
		manager.load("Cards/Phantom.jpg", Texture.class);
		manager.load("Cards/Rhinoceros.jpg", Texture.class);
		manager.load("Cards/Rigid Buffalo.jpg", Texture.class);
		manager.load("Cards/Risen Lancer.jpg", Texture.class);
		manager.load("Cards/Rotroot Enchanter.jpg", Texture.class);
		manager.load("Cards/Rotting Buffalo.jpg", Texture.class);
		manager.load("Cards/Smashodon.jpg", Texture.class);
		manager.load("Cards/Spearcliff Pegasus.jpg", Texture.class);
		manager.load("Cards/Stalwart Spirit.jpg", Texture.class);
		manager.load("Cards/Startouched Brave.jpg", Texture.class);
		manager.load("Cards/Sterling Skywatcher.jpg", Texture.class);
		manager.load("Cards/Trotting Buffalo.jpg", Texture.class);
		manager.load("Cards/Tyrannosaurus Hex.jpg", Texture.class);
		manager.load("Cards/Vine Trap.jpg", Texture.class);
		manager.load("Cards/Wild Child.jpg", Texture.class);
		manager.load("Cards/Zombie Vulture.jpg", Texture.class);
		manager.load("Cards/Zombie.jpg", Texture.class);
		manager.finishLoading();
		batch = new SpriteBatch();
		
		img = manager.get("Cards/Zombie.jpg", Texture.class);
		
		player = new Player(20);
		
		enemyfield = new EnemyField();
		
		playerfield = new PlayerField();

		TestCase1();
		
		//strategy = new DumbStrategy();
		strategy = new DefenseStrategy();
		
		Label.LabelStyle font = new Label.LabelStyle(new BitmapFont(), Color.WHITE);
		
		defendersLabel = new Label("Defending Cards",font);
		defendersLabel.setFontScale(3);
		defendersLabel.setPosition(0, 240);
		
		attackersLabel = new Label("Attacking Cards",font);
		attackersLabel.setFontScale(3);
		attackersLabel.setPosition(0, 690);
		
		moveLabel = new Label("Suggested Move",font);
		moveLabel.setFontScale(3);
		moveLabel.setPosition(860, 350);
		
		

	}

	@Override
	/**
	 * render method for the game
	 */
	public void render () {
		if(Gdx.input.isKeyJustPressed(Input.Keys.A)){
			System.out.println("A key pressed");
			suggestedmove = strategy.getMove(this);
			if(suggestedmove!=null){
				suggestedmove.consoleDisplay();
			}
		}
		if(Gdx.input.isKeyJustPressed(Input.Keys.Q)){
			TestCase1();
		}
		if(Gdx.input.isKeyJustPressed(Input.Keys.W)){
			TestCase2();
		}
		if(Gdx.input.isKeyJustPressed(Input.Keys.R)){
			RandomCase();
		}
		if(Gdx.input.isKeyJustPressed(Input.Keys.S)){
			strategy= new DefenseStrategy();
		}
		if(Gdx.input.isKeyJustPressed(Input.Keys.D)){
			strategy= new DumbStrategy();
		}
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		enemyfield.draw(batch);
		playerfield.draw(batch);
		defendersLabel.draw(batch,1);
		attackersLabel.draw(batch,1);
		if(suggestedmove!=null){
			moveLabel.draw(batch, 1);
			suggestedmove.draw(batch);
		}
		batch.end();
	}
	
	public Array<Card> getAttackingCards(){
		return enemyfield.getCards();
	}
	
	public void removeAttackingCard(Card card){
		enemyfield.removeCard(card);
	}
	
	public Array<Card> getDefendingCards(){
		return playerfield.getCards();
	}
	
	public void removeDefendingCard(Card card){
		playerfield.removeCard(card);
	}
	
	//Creates a random test case consisting of 4 Enemy Cards and 4 Player Cards and Player's health is 10
	public void RandomCase(){
		suggestedmove = null;
		playerfield.discard();
		enemyfield.discard();
		player.setPlayerHealth(10);
		playerfield.addCard();
		playerfield.addCard();
		playerfield.addCard();
		playerfield.addCard();
		enemyfield.addCard();
		enemyfield.addCard();
		enemyfield.addCard();
		enemyfield.addCard();
		
	}
	
	public void TestCase1(){
		suggestedmove = null;
		playerfield.discard();
		enemyfield.discard();
		player.setPlayerHealth(20);
		playerfield.addCard(3);
		playerfield.addCard(9);
		enemyfield.addCard(2);
		enemyfield.addCard(21);
		
	}
	
	/**
	 * Sets a test case where the player is about to die
	 * 
	 */
	public void TestCase2(){
		suggestedmove = null;
		playerfield.discard();
		enemyfield.discard();
		player.setPlayerHealth(1);
		enemyfield.addCard(16);
		playerfield.addCard(20);
	}
	
	//Method for getting information about player's health
	public int getPlayerHealth(){
		return player.getPlayerHealth();
	}
}
