package Entities;

import java.util.ArrayList;
import java.util.List;

import Other.RegisterBoard;
import Other.RegisterPlayers;

/**
 * @author danielmason
 * Applies singleton rule, creates one list of players and squares and can only
 * be instantiated once
 *
 */
public class GameDataSingleton {

	private static List<Player> players = new ArrayList<Player>();
	private static List<Square> board = new ArrayList<Square>();

	private static int currentPlayer;
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

	/**
	 * register players and board, instantiates self
	 * 
	 * @return singleton instance
	 */
	public static GameDataSingleton getSingletonInstance() {
		if (singletonInstance == null) {
			singletonInstance = new GameDataSingleton();
			players = RegisterPlayers.registerPlayers();
			board = RegisterBoard.registerBoard();
			currentPlayer = 0;
		}
		return singletonInstance;
	}

	/**
	 * Get player list
	 * 
	 * @return players
	 */
	public List<Player> getPlayers() {
		return players;
	}

	/**
	 * Get board list
	 * 
	 * @return board
	 */
	public List<Square> getBoard() {
		return board;
	}

	/**
	 * Get current player
	 * 
	 * @return current player
	 */
	public Player getCurrentPlayer() {
		return players.get(currentPlayer);
	}

	/**
	 * Get current square
	 * 
	 * @return current square
	 */
	public Square getCurrentSquare() {
		return board.get(getCurrentPlayer().getCurrentPos());
	}

	/**
	 * Index current player
	 */
	public void indexCurrentPlayer() {
		currentPlayer = (currentPlayer + 1) % players.size();
	}

	/**
	 * Get current player instance
	 * 
	 * @return current player
	 */
	public int getCurrentPlayerIndex() {
		return currentPlayer;
	}

	/**
	 * Returns a specified player
	 * 
	 * @param index
	 * @return player at index
	 */
	public Player getPlayer(int index) {
		if (index >= 0 && index < players.size()) {
			return players.get(index);
		}
		return null;
	}

	/**
	 * Returns a specified square
	 * 
	 * @param index
	 * @return square at index
	 */
	public Square getSquare(int index) {
		if (index >= 0 && index < board.size()) {
			return board.get(index);
		}
		return null;
	}

	/**
	 * Delete current player
	 */
	public void deletePlayer() {
		players.remove(currentPlayer);
		currentPlayer = currentPlayer % players.size();
	}

}
