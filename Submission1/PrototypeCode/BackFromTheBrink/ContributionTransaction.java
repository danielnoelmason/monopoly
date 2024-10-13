/**
 * 
 */
package BackFromTheBrink;

import java.util.List;

/**
 * @author danielmason paying someone rent for landing on their priority
 */
public class ContributionTransaction {

	private int contributionCost;
	private Player playerPaying;
	private Player playerRecieving;

	public ContributionTransaction(Player player, List<Square> squareList, List<Player> playerList) {

		if (!((Priority) squareList.get(player.currentPos)).isAvailableForPurchase()) {
			for (int i = 0; i < playerList.size(); i++)
				if (playerList.get(i).getPrioritiesOwned().contains(((Priority) squareList.get(player.currentPos)))) {

					this.contributionCost = ((Priority) squareList.get(player.currentPos)).getPriorityContributionCost();
					this.playerPaying =player;
					this.playerRecieving = playerList.get(i);

					player.setBalance(player.getBalance() - contributionCost);

					playerList.get(i).setBalance(playerList.get(i).getBalance() + contributionCost);
				}

		}
	}

	public Player getPlayerRecieving() {
		return playerRecieving;
	}

	public Player getPlayerPaying() {
		return playerPaying;
	}

	public int getContributionCost() {
		// TODO Auto-generated method stub
		return contributionCost;
	}
}
