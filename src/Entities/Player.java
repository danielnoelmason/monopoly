package Entities;

import java.util.ArrayList;
import java.util.List;

/**
 * @author danielmason
 * hold player attributes and methods assosiated with player
 *
 */
public class Player {
	private String name;
	private int resources;
	private List<Integer> prioritiesOwned;
	private int currentPos;

	private int playerId;
	private static int nextId = 0;

	/**
	 * Constructor for player
	 * 
	 * @param name
	 */
	public Player(String name) {
		this.name = name;
		this.prioritiesOwned = new ArrayList<Integer>();
		this.resources = 1500;
		this.setCurrentPos(0);

		this.playerId = nextId;
		nextId++;
	}

	/**
	 * Get name
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Get list of priorities owned
	 * 
	 * @return
	 */
	public List<Integer> getPrioritiesOwned() {
		return prioritiesOwned;
	}

	/**
	 * Get resources
	 * 
	 * @return
	 */
	public int getResources() {
		return resources;
	}

	/**
	 * Set resources
	 * 
	 * @param resources
	 */
	public void setResources(int resources) {
		this.resources = resources;
	}

	/**
	 * Get balance
	 * 
	 * @return balance
	 */
	public String getNewBalance() {
		return ("Your new balance is " + getResources() + " Resources");
	}

	/**
	 * Add to balance
	 * 
	 * @param i
	 */
	public void addToBalance(int i) {
		this.resources += i;

	}

	/**
	 * Take balance away
	 * 
	 * @param i
	 */
	public void takeAwayBalance(int i) {

		this.resources -= i;

	}

	/**
	 * Get current position
	 * 
	 * @return current position
	 */
	public int getCurrentPos() {
		return currentPos;
	}

	/**
	 * set current position
	 * 
	 * @param currentPos
	 */
	public void setCurrentPos(int currentPos) {
		this.currentPos = currentPos;
	}

	/**
	 * get player ID
	 * 
	 * @return player ID
	 */
	public int getId() {
		return playerId;
	}

	/**
	 * Move position as a result of sum of dice
	 * 
	 * @param diceSum
	 */
	public void move(int diceSum) {
		this.currentPos += diceSum;

	}
}
