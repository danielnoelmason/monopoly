package Entities;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author danielmason
 * Square class to make up the board
 *
 */
public abstract class Square {

	private static final AtomicInteger squareCount = new AtomicInteger(-1);
	protected int pos;
	protected String squareName;

	/**
	 * Addition of square to the board
	 */
	public Square() {
		this.pos = squareCount.incrementAndGet();
	}

	/**
	 * Get square name
	 * 
	 * @return square name
	 */
	public String getSquareName() {
		return squareName;
	}

	/**
	 * Get position
	 * 
	 * @return position
	 */
	public int getPos() {
		return pos;
	}

	/**
	 * Prints board
	 * 
	 * @return result of board
	 */
	public String toPrintBoard() {
		String res = pos + ". " + squareName;
		return res;

	}

	/**
	 * Run actions of game data
	 * 
	 * @param gameData
	 */
	public void runActions(GameDataSingleton gameData) {

	}

}
