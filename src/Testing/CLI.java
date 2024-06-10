package Testing;

import Controller.Controller;

/**
 * @author danielmason
 * CLI for the game interface
 */
public class CLI {

	/**
	 * Runs game
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Controller game = new Controller();
		game.runGame();
	}
}
