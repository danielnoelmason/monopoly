package Actions;

import Entities.GameDataSingleton;

/**
 * @author danielmason Move Position Transaction class allows a player to move
 *         position on the board and runActions() for the current square
 *
 */
public class MovePositionTransaction implements Action {

	@Override
	/**
	 * Uses RollDiceTransaction, moves the player, potentially passes start, runs
	 * current square actions, and indexes current player
	 */
	public void runAction(GameDataSingleton gameData) {
		int diceSum = new RollDiceTransaction().rolldice();
		gameData.getCurrentPlayer().move(diceSum);

		System.out.println(gameData.getCurrentPlayer().getName() + ", you've rolled a " + diceSum);
		if (gameData.getCurrentPlayer().getCurrentPos() >= gameData.getBoard().size()) {
			new PassStartTransaction().runAction(gameData);
		}
		System.out.println(gameData.getCurrentPlayer().getName() + ", you've landed on "
				+ gameData.getCurrentSquare().getSquareName());

		gameData.getCurrentSquare().runActions(gameData);
		gameData.indexCurrentPlayer();

	}
}
