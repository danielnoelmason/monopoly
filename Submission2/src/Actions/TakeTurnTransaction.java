package Actions;

import Entities.GameDataSingleton;
import Other.ListPrint;
import Other.UI;

/**
 * @author danielmason Take Turn Transaction class allows a player to take their
 *         turn and choose an option
 *
 */
public class TakeTurnTransaction implements Action {

	/**
	 * Allows a player to choose from a range of choices to take during their turn
	 */
	public void runAction(GameDataSingleton gameData) {

		boolean terminator = true;
		while (terminator) {
			UI.out("\n\t\t\t\tPlayer " + gameData.getCurrentPlayer().getName().toUpperCase()
					+ "'s turn\n\t\t\t1. Roll Dice \t 2. Tackle Priority \n\t\t\t3. Leave Game \t 4. Show Players Details \n\t\t\t5. Rules \t 6. Board");

			int choice = Integer.parseInt(UI.read("number of choice"));
			switch (choice) {
			case 1:// roll dice to move player
				new MovePositionTransaction().runAction(gameData);
				terminator = false;
				break;

			case 2:// tackle a priotiy
				new TacklePriorityTranaction().runAction(gameData);
				break;

			case 3:
				new PlayerQuitTransaction().runAction(gameData);
				terminator = false;
				break;

			case 4:
				ListPrint.printPlayers(gameData);// check values updating correctly
				break;

			case 5:
				UI.out("\t** Rules Of the Game! ** \n -Roll the dice to travel around the world\n -Acquire and Tackle Priorities\n -Own Entire Environments to start taking Initiatives on them\n -Winner is decided when a player runs out of money\n -Good luck :)\n ");
				break;

			case 6:
				ListPrint.printBoard(gameData);
				break;

			default:
				UI.out("Enter a Valid Choice Between 1-6 (shown below)");
				break;
			}
		}

	}

}
