package BackFromTheBrink;

import java.util.List;

/**
 * allows formatted printing of various groups
 *
 */
public class ListPrint {

	/**
	 * for player detail print
	 * purely to see value updating
	 */
	public static void printPlayers(List<Player> playerList) {

		for (int i = 0; playerList != null && i < playerList.size(); ++i)
			playerList.get(i).toPrint();
	}
	
	public static void printPrioritys(List<Priority> priorityList) {

		for (int i = 0; priorityList != null && i < priorityList.size(); ++i)
			priorityList.get(i).toPrint();
	}

}