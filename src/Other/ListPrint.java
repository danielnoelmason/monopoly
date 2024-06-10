package Other;

import Entities.GameDataSingleton;
import Entities.Priority;

/**
 * @author danielmason
 * List Print class allows formatted printing of various data
 *
 */
public class ListPrint {

	/**
	 * for player detail print to see value updating
	 */
	public static void printPlayers(GameDataSingleton gameData) {

		for (int i = 0; gameData.getPlayers() != null && i < gameData.getPlayers().size(); ++i) {
			UI.out("\nPlayer: " + gameData.getPlayers().get(i).getName());
			UI.out("Resources: " + gameData.getPlayers().get(i).getResources());
			if (gameData.getPlayers().get(i).getPrioritiesOwned().size() > 0)
				UI.out("\t\t\t~Squares Owned~");
			else
				UI.out("\t\t\t~No Prioritys~");
			for (int j = 0; gameData.getPlayers().get(i).getPrioritiesOwned() != null
					&& j < gameData.getPlayers().get(i).getPrioritiesOwned().size(); ++j)
				UI.out(gameData.getBoard().get(gameData.getPlayers().get(i).getPrioritiesOwned().get(j)).toString());
		}
	}

	/**
	 * To print the board
	 * 
	 * @param gameData
	 */
	public static void printBoard(GameDataSingleton gameData) {

		for (int i = 0; gameData.getBoard() != null && i < gameData.getBoard().size(); ++i) {
			UI.out(gameData.getBoard().get(i).toPrintBoard());

		}
	}

	/**
	 * To print out priority details for players
	 * 
	 * @param priorityList
	 */
	public static void printPlayerPrioritys(GameDataSingleton gameData) {

		for (int i = 0; gameData.getCurrentPlayer().getPrioritiesOwned() != null
				&& i < gameData.getCurrentPlayer().getPrioritiesOwned().size(); ++i)
			UI.out(gameData.getBoard().get(gameData.getCurrentPlayer().getPrioritiesOwned().get(i)).toString());
	}

	/**
	 * Tp print the player's action areas
	 * 
	 * @param gameData
	 */
	public static void printPlayersActionAreas(GameDataSingleton gameData) {

		for (int i = 0; gameData.getCurrentPlayer().getPrioritiesOwned() != null
				&& i < gameData.getCurrentPlayer().getPrioritiesOwned().size(); ++i) {
			int priorityIndex = gameData.getCurrentPlayer().getPrioritiesOwned().get(i);
			if (((Priority) gameData.getSquare(priorityIndex)).getActionArea().isOwnerMonopoly(gameData))
				UI.out(gameData.getBoard().get(gameData.getCurrentPlayer().getPrioritiesOwned().get(i)).toString());
		}
	}
}