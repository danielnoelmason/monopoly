package Entities;

import Actions.AcquirePriorityTransaction;
import Actions.ContributionTransaction;
import Other.UI;

/**
 * @author niamhmclarnon
 * Priority class contains all the relevant information on each priority
 *
 */
public class Priority extends Square {

	private int priorityValue;
	private int priorityContributionCost;

	private boolean availableForPurchase;
	private int owner;

	private ActionArea actionArea;

	private int priorityStepCost;
	private int stepsTaken;
	private int initialContributionCost;

	/**
	 * Contains priority details
	 * 
	 * @param priorityName
	 * @param priorityValue
	 * @param priorityContributionCost
	 * @param priorityStepCost
	 * @param aactionArea
	 */
	public Priority(String priorityName, int priorityValue, int priorityContributionCost, int priorityStepCost,
			ActionArea aactionArea) {
		super();
		this.squareName = priorityName;
		this.priorityValue = priorityValue;
		this.priorityContributionCost = priorityContributionCost;
		this.initialContributionCost = priorityContributionCost;
		this.availableForPurchase = true;
		this.priorityStepCost = priorityStepCost;

		this.stepsTaken = 0;
		this.owner=-1;

		this.actionArea = aactionArea;
		actionArea.addPriorityIndex(getPos());

	}

	/**
	 * Runs action to acquire priority
	 */
	public void runActions(GameDataSingleton gameData) {

		if (!availableForPurchase) { // CONTRIBUTION TRANSACTION
			new ContributionTransaction().runAction(gameData);
		} else {
			boolean choice = UI
					.yesNo("\n\t\t\t\t~Choice~\n\t\t\tWould you like to acquire this priority\n" + toString());
			if (choice)
				new AcquirePriorityTransaction().runAction(gameData);

		}
	}

	/**
	 * Get priority value
	 * 
	 * @return priority value
	 */
	public int getPriorityValue() {
		return priorityValue;
	}

	/**
	 * Get priority contribution cost
	 * 
	 * @return priority contribution cost
	 */
	public int getPriorityContributionCost() {
		return priorityContributionCost;
	}

	/**
	 * Get action area
	 * 
	 * @return action area
	 */
	public ActionArea getActionArea() {
		return actionArea;
	}

	/**
	 * Get priority step cost
	 * 
	 * @return priority step cost
	 */
	public int getPriorityStepCost() {
		return priorityStepCost;
	}

	/**
	 * Get steps taken
	 * 
	 * @return steps taken
	 */
	public int getStepsTaken() {
		return stepsTaken;
	}

	/**
	 * Checks if priority is available to purchase
	 * 
	 * @return available for purchase
	 */
	public boolean isAvailableForPurchase() {
		return availableForPurchase;
	}

	/**
	 * Prints string of priority information
	 * 
	 * @return result
	 */
	public String toString() {
		String res = toPrintBoard() + "\t\tAcquisition Cost: " + getPriorityValue() + "\t\tDonations Per Visit: "
				+ getPriorityContributionCost();
		return res;
	}

	/**
	 * Prints to board
	 * 
	 * @return result
	 */
	public String toPrintBoard() {
		String res = pos + "|" + actionArea.getActionAreaName() + "| " + squareName;
		return res;
	}

	/**
	 * Sets available for purchase
	 * 
	 * @param b
	 */
	public void setAvailableForPurchase(boolean b) {
		this.availableForPurchase = b;
	}

	/**
	 * Reset square of priority
	 */
	public void resetSquare() {
		this.availableForPurchase = true;
		this.priorityContributionCost = initialContributionCost;
		this.stepsTaken = 0;
		this.owner=-1;
	}

	/**
	 * Adds steps taken
	 * 
	 * @param i
	 */
	public void addStepsTaken(int i) {
		this.stepsTaken += i;
		if (stepsTaken == 1)
			this.priorityContributionCost = initialContributionCost * 5;
		if (stepsTaken > 1 && stepsTaken < 4)
			this.priorityContributionCost = (initialContributionCost * 5) * ((stepsTaken - 1) * 3);
		if (stepsTaken == 4)
			this.priorityContributionCost = (initialContributionCost * 25) * ((stepsTaken - 2) * 3) * 3;
	}

	/**
	 * Get owner of priority
	 * 
	 * @return owner
	 */
	public int getOwner() {
		return owner;
	}

	/**
	 * Set owner of priority
	 * 
	 * @param owner
	 */
	public void setOwner(int owner) {
		this.owner = owner;
	}

}