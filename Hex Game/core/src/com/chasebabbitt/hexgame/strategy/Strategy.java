package com.chasebabbitt.hexgame.strategy;

import com.chasebabbitt.hexgame.HexGame;

public interface Strategy {

	public Move getMove(HexGame game);
}
