package Actions;

import Entities.GameDataSingleton;
import Entities.Priority;

/**
 * @author danielmason
 * removes a player from game data
 *
 */
public class PlayerQuitTransaction implements Action {

	@Override
	/**
	 * player.prioirtiesOwned are reset and player removed from game data
	 */
	public void runAction(GameDataSingleton gameData) {
		if (gameData.getCurrentPlayer().getPrioritiesOwned() != null) {
			for (int i : gameData.getCurrentPlayer().getPrioritiesOwned()) {
				((Priority) gameData.getBoard().get(i)).resetSquare();
			}
		}
		System.out.println("..." + gameData.getCurrentPlayer().getName().toUpperCase() + " removed from game...");
		gameData.deletePlayer();
	}
}
