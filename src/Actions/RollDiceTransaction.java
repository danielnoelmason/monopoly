package Actions;

/**
 * @author danielmason
 * manages mathematical function when player wants to move
 *
 */
public class RollDiceTransaction {

	/**
	 * A random mathematical number between 1-6 is calculated for each roll of each
	 * dice. The number of each dice is summed to create a number to allow the
	 * player to move that many places along the board
	 * 
	 * @return sum of the two dice
	 */
	public int rolldice() {
		int dice1 = (int) (Math.random() * 6 + 1);
		int dice2 = (int) (Math.random() * 6 + 1);
		return dice1 + dice2;

	}
}
