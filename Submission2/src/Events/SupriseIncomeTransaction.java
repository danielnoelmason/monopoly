package Events;

import Entities.GameDataSingleton;

/**
 * @author niamhmclarnon
 * Surprise Income Transaction involves creating a surprise event for the player
 *
 */
public class SupriseIncomeTransaction implements Event {

	@Override
	/**
	 * Involves giving a player surprise resources using a random mathematical
	 * equation. Their player resource balance will be updated
	 */
	public void runEvent(GameDataSingleton gameData) {

		int i = (int) (Math.random() * 200);
		System.out.println(gameData.getCurrentPlayer().getName() + ", you have been given" + i + " Resources");
		gameData.getCurrentPlayer().addToBalance(i);
		System.out.println(gameData.getCurrentPlayer().getNewBalance());

	}
}
