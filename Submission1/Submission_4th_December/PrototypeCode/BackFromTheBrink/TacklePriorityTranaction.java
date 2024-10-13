package BackFromTheBrink;

import java.util.List;

/**
 * taking steps/major steps housing/hotels
 *
 */
public class TacklePriorityTranaction {

	public void tacklePriority(Player player, List<Square> squareList, List<Player> playerList) {

		ListPrint.printPrioritys(player.getPrioritiesOwned());
		String priority = Read.read("name of priority tackling");
		for (int i = 0; i < player.getPrioritiesOwned().size(); ++i) {

			if (player.getPrioritiesOwned().get(i).getPriorityName().contains(priority)) {

				if (player.getPrioritiesOwned().get(i).getStepsTaken() >= 4) { // IF PRIORITY FULLY DEVELOPED
					i = 1000;
					System.out.println("Priority fully developed");
				} else {

					int steps = Integer.parseInt(
							Read.read("how many steps you want to take towards tackling the property \nOne Step = £"
									+ player.getPrioritiesOwned().get(i).getPriorityStepCost()));

					while ((player.getPrioritiesOwned().get(i).getStepsTaken() + steps) > 4 || steps < 0) { // only
																											// accept
																											// valid
																											// input
						steps = Integer.parseInt(Read.read("valid number of steps (Maximum 4) \nCurrently "
								+ player.getPrioritiesOwned().get(i).getStepsTaken() + " steps taken"));
					}

					player.getPrioritiesOwned().get(i).addStepsTaken(steps);//updating priority
					player.takeAwayBalance(steps*player.getPrioritiesOwned().get(i).getPriorityStepCost());//updating player balance
				}
			}
		}

	}

}