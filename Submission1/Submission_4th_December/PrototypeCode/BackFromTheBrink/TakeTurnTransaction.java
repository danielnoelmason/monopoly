package BackFromTheBrink;

import java.util.List;

public class TakeTurnTransaction {

	public TakeTurnTransaction(Player player, List<Square> squareList, List<Player> playerList, int count) {

		boolean terminator = true;
		while (terminator) {
			System.out.println("\n\t\t\t\tPlayer " + player.getName().toUpperCase()
					+ "'s turn\n\t\t\t1. Roll Dice \t 2. Tackle Priority \n\t\t\t3. Leave Game \t 4. Show Player Details");

			int choice = Integer.parseInt(Read.read("number of choice"));
			switch (choice) {

			case 1:// roll dice to move player
				new MovePositionTransaction(player, squareList);
				// movePlayer(player, squareList);

				if (player.currentPos == 0) { // if starting square
					terminator = false;
					break;
				}

				if (!((Priority) squareList.get(player.currentPos)).isAvailableForPurchase()) { // CONTRIBUTION
																								// TRANSACTION

					ContributionTransaction cont = new ContributionTransaction(player, squareList, playerList);

					System.out.println(player.getName().toUpperCase() + " paid contribution to "
							+ cont.getPlayerRecieving().getName().toUpperCase() + "\nContribution Cost: "
							+ cont.getContributionCost());
					
					System.out.println(player.getNewBalance());

					terminator = false;
					break;
				}

				System.out.println("\n\t\t\t1. Acquire Priority \t 2. Pass");
				((Priority)squareList.get(player.currentPos)).toPrint();

				//
				int action = Integer.parseInt(Read.read("number of choice"));
				switch (action) {
				case 1: // ACQUIRE A PRIORITY
					new AcquirePriorityTransaction((Priority) squareList.get(player.currentPos), player);
					// player.acquirePriority((Priority) squareList.get(player.currentPos));//
					// locating what square a
					// priority is on
					
					System.out.println(player.getNewBalance());
					
					terminator = false;
					break;
				case 2: // PASS TURN
					terminator = false;
					break;
				}
				break;

			case 2:// tackle a priotiy
				if (player.getPrioritiesOwned().isEmpty()) {
					System.out.println(player.getName().toUpperCase() + " has no prioritys");
					break;
				}
				new TacklePriorityTranaction().tacklePriority(player, squareList, playerList);
				System.out.println(player.getNewBalance());
				break;
			case 3:
				new PlayerQuitTransaction(player, squareList, playerList);
				System.out.println("..." + player.getName().toUpperCase() + " Quit");
				player = playerList.get(count % playerList.size());

				// removePlayer(player, squareList, playerList);
				if (!(playerList.size() > 1))
					terminator = false;
				if (count % playerList.size() == 0)// might have errors
					count++;
				break;
			case 4:
				ListPrint.printPlayers(playerList);// check values updating coreectly
				break;

			default:
				System.out.println("Enter Valid Choice");
				break;

			}
		}

	}

	/*
	 * private static void removePlayer(Player player, List<Square> squareList,
	 * List<Player> playerList) { int pos = 0;
	 * 
	 * for (pos = 0; pos < playerList.size(); ++pos) if (playerList.get(pos) ==
	 * player) break;
	 * 
	 * if (pos >= 0 && pos < playerList.size()) {
	 * 
	 * playerList.remove(pos);
	 * 
	 * }
	 * 
	 * }
	 * 
	 * private static void movePlayer(Player player, List<Square> squareList) { int
	 * diceSum = rolldice(); System.out.println("\nRolled a " + diceSum);
	 * player.currentPos += diceSum; if (player.currentPos > squareList.size() - 1)
	 * { player.passGo(); player.currentPos = player.currentPos % (squareList.size()
	 * - 1); } System.out.println("Landed on " +
	 * squareList.get(player.currentPos).getSquareName());
	 * 
	 * }
	 * 
	 * private static int rolldice() { int dice1 = (int) (Math.random() * 6 + 1);
	 * int dice2 = (int) (Math.random() * 6 + 1); return dice1 + dice2;
	 * 
	 * }
	 * 
	 */
}
