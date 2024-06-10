/**
 * 
 */
package Actions;

import Entities.GameDataSingleton;
import Entities.Priority;
import Other.UI;

/**
 * @author danielmason
 * pays contribution to current square owner from current player
 */
public class ContributionTransaction implements Action {

	@Override
	/**
	 * Updates both players resources and and prints new balance
	 */
	public void runAction(GameDataSingleton gameData) {
		if (!((Priority) gameData.getCurrentSquare()).isAvailableForPurchase()) {
			if (gameData.getCurrentPlayer().getPrioritiesOwned().contains(gameData.getCurrentPlayer().getCurrentPos()))
				UI.out("Already owned");
			else
				for (int i = 0; i < gameData.getPlayers().size(); i++) {
					boolean isPlayerWhoOwns = gameData.getPlayers().get(i).getPrioritiesOwned()
							.contains(gameData.getCurrentPlayer().getCurrentPos());
					int contributionCost = ((Priority) gameData.getCurrentSquare()).getPriorityContributionCost();
					if (isPlayerWhoOwns) {
						boolean fundsAvailable =gameData.getCurrentPlayer().getResources() > contributionCost;
						if (!fundsAvailable) { 
							UI.out(gameData.getCurrentPlayer().getName() + ", you've run out of Resources");
							UI.out("\nRemaining Resources Donated to " + gameData.getPlayers().get(i).getName());
							gameData.getPlayers().get(i).addToBalance(contributionCost);
							new PlayerQuitTransaction().runAction(gameData);
							i=gameData.getPlayers().size();
						} else {
							UI.out(gameData.getCurrentPlayer().getName().toUpperCase() + ", you've donated to "
									+ contributionCost + " resources to "
									+ gameData.getPlayers().get(i).getName().toUpperCase());
							UI.out("Contribution Paid. Your old balance was "
									+ gameData.getCurrentPlayer().getResources());

							gameData.getCurrentPlayer().takeAwayBalance(contributionCost);
							gameData.getPlayers().get(i).addToBalance(contributionCost);
							UI.out(gameData.getCurrentPlayer().getNewBalance());

						}
					}
				}
		}

	}

}
