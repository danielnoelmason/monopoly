package Events;

import Entities.GameDataSingleton;

/**
 * @author niamhmclarnon
 * Surprise Donate Transaction involves creating a surprise event for the player
 *
 */
public class SupriseDonateToTransaction implements Event {

	@Override
	/**
	 * Involves making a player donate money to a random player Their resource
	 * balance will be updated
	 */
	public void runEvent(GameDataSingleton gameData) {

		int donation = (int) (Math.random() * 100);
		int randomPlayer = (int) (Math.random() * gameData.getPlayers().size());

		gameData.getCurrentPlayer().takeAwayBalance(donation);
		gameData.getPlayer(randomPlayer).addToBalance(donation);

		System.out.println(
				gameData.getCurrentPlayer().getName() +	", you have donated " + donation + " resources to " + gameData.getPlayer(randomPlayer).getName());
		System.out.println(gameData.getCurrentPlayer().getNewBalance());

	}

}
