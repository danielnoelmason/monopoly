package Entities;

import java.util.ArrayList;
import java.util.List;

/**
 * @author danielmason
 * Action Area class holds the information about each area in the game
 *
 */
public class ActionArea {

	private String actionAreaName;
	private List<Integer> aaPriorityIndexes = new ArrayList<Integer>();
	private boolean ownerMonopoly;

	/**
	 * The action area's name
	 * 
	 * @param aaName
	 */
	public ActionArea(String aaName) {
		this.actionAreaName = aaName;
		this.ownerMonopoly = false;

	}

	/**
	 * Gets the action area's name
	 * 
	 * @return action area name
	 */
	public String getActionAreaName() {
		return actionAreaName;
	}

	/**
	 * Adds index of the priority on the board
	 * 
	 * @param indexOfPriority
	 */
	public void addPriorityIndex(int indexOfPriority) {
		aaPriorityIndexes.add(indexOfPriority);
	}

	/**
	 * Checks if the priority is owned
	 * 
	 * @param gameData
	 * @return false if current player doesn't own one of the action areas
	 * 	      priorities
	 */
	public boolean isOwnerMonopoly(GameDataSingleton gameData) {
		for (int i : aaPriorityIndexes) {
			if (!(((Priority) gameData.getBoard().get(i)).getOwner() == gameData.getCurrentPlayer().getId())) {

				return false;
			}
		}
		ownerMonopoly = true;
		return ownerMonopoly;
	}
}
