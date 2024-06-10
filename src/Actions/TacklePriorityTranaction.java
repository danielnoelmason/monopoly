package Actions;

import Entities.GameDataSingleton;

import Entities.Priority;
import Other.ListPrint;
import Other.UI;

/**
 * @author danielmason
 * 'tackles' priority and increases the number of steps on it/contribution cost 
 *
 */
public class TacklePriorityTranaction implements Action {

	@Override
	/**
	 * Checks player owns the priority and as a result will check if they own the
	 * action area this priority exists in. Check number of steps the player wishes
	 * to take between 1-4 and if the priority has been tackled previously Check
	 * player's resource balance to see if they can afford to tackle priority
	 */
	public void runAction(GameDataSingleton gameData) {

		if (gameData.getCurrentPlayer().getPrioritiesOwned().isEmpty()) {
			UI.out(gameData.getCurrentPlayer().getName().toUpperCase() + ", you have no prioritys");
		} else if (!checkHasActionAreaCustodianship(gameData)) {
			UI.out(gameData.getCurrentPlayer().getName().toUpperCase() + ", you dont fully own any Action Areas");
		} else {
			ListPrint.printPlayersActionAreas(gameData);

			int priorityIndex = Integer.parseInt(UI.read("number of priority tackling"));
			boolean owned = gameData.getCurrentPlayer().getPrioritiesOwned().contains(priorityIndex);
			boolean ownedAArea = ((Priority) gameData.getBoard().get(priorityIndex)).getActionArea()
					.isOwnerMonopoly(gameData);

			while (!(owned || ownedAArea))
				priorityIndex = Integer.parseInt(UI.read("a valid priority"));

			boolean fullyDeveloped = ((Priority) gameData.getBoard().get(priorityIndex)).getStepsTaken() >= 4;
			if (fullyDeveloped) {
				UI.out("Priority fully developed");
			} else {
				UI.out("One Step costs " + ((Priority) gameData.getBoard().get(priorityIndex)).getPriorityStepCost()
						+ " Resources");
				int steps = Integer.parseInt(UI.read("how many steps you want to take towards tackling the property"));
				while ((((Priority) gameData.getBoard().get(priorityIndex)).getStepsTaken() + steps) > 4 || steps < 0) {
					UI.out("Currently " + ((Priority) gameData.getBoard().get(priorityIndex)).getStepsTaken()
							+ " steps taken");
					steps = Integer.parseInt(UI.read("valid number of steps (Maximum 4)"));
				}
				int cost = steps * ((Priority) gameData.getBoard().get(priorityIndex)).getPriorityStepCost();
				if (gameData.getCurrentPlayer().getResources() < cost)
					UI.out("You need more resources for this initiative");
				else {
					((Priority) gameData.getBoard().get(priorityIndex)).addStepsTaken(steps);
					gameData.getCurrentPlayer().takeAwayBalance(cost);
					UI.out(gameData.getCurrentPlayer().getNewBalance());
				}
			}

		}

	}

	/**
	 * Checks if player owns any action areas
	 * 
	 * @param gameData
	 * @return true if current players prioritie's action areas have isOwnerMonopoly
	 * 
	 */
	private boolean checkHasActionAreaCustodianship(GameDataSingleton gameData) {
		for (int i = 0; i < gameData.getCurrentPlayer().getPrioritiesOwned().size(); ++i) {
			int priorityIndex = gameData.getCurrentPlayer().getPrioritiesOwned().get(i);
			if (((Priority) gameData.getSquare(priorityIndex)).getActionArea().isOwnerMonopoly(gameData))
				return true;
		}
		return false;
	}

}