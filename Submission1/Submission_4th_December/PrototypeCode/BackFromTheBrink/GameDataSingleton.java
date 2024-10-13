package BackFromTheBrink;

import java.util.ArrayList;

/**
 * Applies singleton rule, creates one list of players and
 * squares and can only be instantiated once
 *
 */
public class GameDataSingleton {

	private ArrayList<Player> players;
	private ArrayList<Square> board;
	private static GameDataSingleton singletonInstance;

	/**
	 * Applies the singleton rule by only calling the private constructor if it has
	 * not been done before by initialising the instance variable
	 * 
	 */
	private GameDataSingleton() {
		players = new ArrayList<>();
		board = new ArrayList<>();
	}

	public static GameDataSingleton getSingletonInstance() {
		if (singletonInstance == null) {
			singletonInstance = new GameDataSingleton();
		}
		return singletonInstance;
	}
	
	public ArrayList<Player> getPlayers() {
		return this.players;
	}

	/**
	 * Adds a player to the list
	 * 
	 * @param client
	 */
	public void addPlayer(Player bankClient) {
		if (bankClient != null) {
			if (!players.contains(bankClient)) {
				players.add(bankClient);
			}
		}
	}

	/**
	 * prints all the bank clients details
	 * 
	 * @return
	 */
	public void printPlayers() {

		for (Player bankClient : players) {
			if (bankClient != null) {
				bankClient.toPrint();
			}
		}
	}

	public void printPlayer(int index) {

		getPlayer(index).toPrint();
	}



	/**
	 * 
	 * @return - int size of the players list
	 */
	public int getPlayerListSize() {
		return players.size();
	}
	
	/**
	 * 
	 * @return - int size of the board list
	 */
	public int getBoardListSize() {
		return board.size();
	}

	/**
	 * returns a specified player
	 * 
	 * @param index
	 * @return
	 */
	public Player getPlayer(int index) {
		if (index >= 0 && index < players.size()) {
			return players.get(index);
		}
		return null;
	}
	
	/**
	 * returns a specified player
	 * 
	 * @param index
	 * @return
	 */
	public Square getSquare(int index) {
		if (index >= 0 && index < board.size()) {
			return board.get(index);
		}
		return null;
	}

	/**
	 * Removes a player from the list
	 * 
	 * @param index
	 */
	public void deletePlayer(int index) {
		players.remove(getPlayer(index));
	}
}
