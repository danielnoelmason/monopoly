package BackFromTheBrink;

import java.util.List;

/**
 * when a player leaves the game
 *
 */
public class PlayerQuitTransaction {

	public PlayerQuitTransaction(Player player, List<Square> board, List<Player> playerList) {
		int pos = 0;

		for (pos = 0; pos < playerList.size(); ++pos)
			if (playerList.get(pos) == player)
				break;

		if (pos >= 0 && pos < playerList.size()) {

			

			if (player.getPrioritiesOwned() != null) {
				for (int i = 0; i < player.getPrioritiesOwned().size(); i++) {// scan through prioritys owned and set
																				// them buyable again
					((Priority) board.get(player.getPrioritiesOwned().get(i).getPos()))
							.setAvailableForPurchase(true);
					
				}
			}
			//player=playerList.get((pos+1)%playerList.size());
			playerList.remove(pos);
		}
	}

}
