package Actions;

import Entities.GameDataSingleton;
import Entities.Priority;
import Other.UI;

/**
 * 
 * @author danielmason
 * The Acquire Priority Transaction class allows for the current player to
 * acquire the priority they have landed on
 *
 */
public class AcquirePriorityTransaction implements Action {

	/**
	 *
	 * Checks the players resources to check if they can afford to acquire this
	 * priority. Checks the player doesn't already own the priority This adds the
	 * priority to player.prioritiesOwned, takes away the cost and changes the
	 * priority availability
	 * 
	 */
	@Override
	public void runAction(GameDataSingleton gameData) {

		int priority = gameData.getCurrentPlayer().getCurrentPos();
		int priorityValue = ((Priority) gameData.getCurrentSquare()).getPriorityValue();

		boolean hasEnoughResources = priorityValue < gameData.getCurrentPlayer().getResources();
		boolean availableForPurchase = ((Priority) gameData.getCurrentSquare()).isAvailableForPurchase();

		if (!hasEnoughResources)
			UI.out(gameData.getCurrentPlayer().getName() + ", you do not have the resources to acquire this");
		else if (availableForPurchase) {
			UI.out("Acquisition made. Your old balance was " + gameData.getCurrentPlayer().getResources());
			((Priority) gameData.getCurrentSquare()).setAvailableForPurchase(false);
			((Priority) gameData.getCurrentSquare()).setOwner(gameData.getCurrentPlayer().getId());
			gameData.getCurrentPlayer().getPrioritiesOwned().add(priority);
			gameData.getCurrentPlayer().takeAwayBalance(priorityValue);
			UI.out(gameData.getCurrentPlayer().getNewBalance());
		} else {
			UI.out(gameData.getCurrentPlayer().getName() + ", you already own this");
		}
	}

}
