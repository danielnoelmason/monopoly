package Entities;

import Events.Event;

/**
 * @author niamhmclarnon
 * Event Square class provides special events (value added features)
 *
 */
public class EventSquare extends Square {

	private Event event;

	/**
	 * Constructor
	 * 
	 * @param name
	 * @param event
	 */
	public EventSquare(String name, Event event) {
		this.squareName = name;
		this.event = event;
	}

	/**
	 * runs square events
	 */
	public void runActions(GameDataSingleton gameData) {
		event.runEvent(gameData);
	}

	/**
	 * Gets the square name
	 */
	public String getSquareName() {
		return "|EVENT|" + squareName;
	}

	/**
	 * Prints the event and square name to board
	 */
	public String toPrintBoard() {
		String res = pos + "|EVENT| " + squareName;
		return res;
	}

}
