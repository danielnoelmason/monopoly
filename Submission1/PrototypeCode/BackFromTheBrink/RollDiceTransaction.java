package BackFromTheBrink;
/**
 * roll dice to move player along board
 * @author danielmason
 *
 */
public class RollDiceTransaction {

	public int rolldice() {
		int dice1 = (int) (Math.random() * 6 + 1);
		int dice2 = (int) (Math.random() * 6 + 1);
		return dice1 + dice2;

	}
}
