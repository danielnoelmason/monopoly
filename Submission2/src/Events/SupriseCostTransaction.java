package Events;

import Entities.GameDataSingleton;

/**
 * @author danielmason
 * Surprise cost transaction class involves implementing a surprise event
 *
 */
public class SupriseCostTransaction implements Event {

	@Override
	/**
	 * takes away random value from player
	 */
	public void runEvent(GameDataSingleton gameData) {

		int i = (int) (Math.random() * 200);
		System.out.println("They require " + i + " Resources");
		gameData.getCurrentPlayer().takeAwayBalance(i);
		System.out.println(gameData.getCurrentPlayer().getNewBalance());

	}
}
