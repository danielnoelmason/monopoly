package Other;

import java.util.ArrayList;
import java.util.List;

import Entities.Player;

/**
 * @author danielmason
 * registers players of the game
 *
 */
public class RegisterPlayers {

	private final static int MAX_PLAYERS = 8; //max players in a game

	/**
	 * asks for names and instantiates players and adds them to a list
	 * 
	 * @return player list
	 */
	public static List<Player> registerPlayers() {

		List<Player> playerList = new ArrayList<Player>();

		for (int count = 0; count < MAX_PLAYERS; count++) {

			String question = "player " + (count + 1) + "'s name (Enter 'START' if no more players)";
			String name = UI.read(question);

			while (!checkValidName(name, playerList)) {
				name = UI.read("Duplicated name, please enter another name");
			}
			if ((name.contains("START")) || (name.contains("Start")) || (name.contains("start"))) {
				if (count == 0)
					count--;
				else
					count = MAX_PLAYERS;
			} else {
				Player player = new Player(name);
				playerList.add(player);
			}
		}

		return playerList;
	}

	/**
	 * Checks the name the player entered is valid (not already registered as a name
	 * in the game already)
	 * 
	 * @param name
	 * @param playerList
	 * @return
	 */
	public static boolean checkValidName(String name, List<Player> playerList) {
		for (Player i : playerList)
			if (i.getName().contains(name)) {
				return false;
			}
		return true;

	}

}
