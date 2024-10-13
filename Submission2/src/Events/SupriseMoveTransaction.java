package Events;

import Entities.GameDataSingleton;

/**
 * @author niamhmclarnon
 * Surprise Move Transaction involves creating a surprise event for the player
 *
 */
public class SupriseMoveTransaction implements Event {

	@Override
	/**
	 * Involves moving a player to a random square on the board. Their current
	 * position will be updated
	 */
	public void runEvent(GameDataSingleton gameData) {

		int randomSquare = (int) (Math.random() * gameData.getBoard().size());

		gameData.getCurrentPlayer().setCurrentPos(randomSquare);

		System.out.println("Travel to " + gameData.getCurrentSquare().getSquareName()
				+ ", do not collect reward for passing start");
		gameData.getCurrentSquare().runActions(gameData);

	}

}
