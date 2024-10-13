package BackFromTheBrink;

import java.util.List;

public class MovePositionTransaction {

	public MovePositionTransaction(Player player, List<Square> squareList) {
		int diceSum = new RollDiceTransaction().rolldice();
		System.out.println("\nRolled a " + diceSum);
		player.currentPos += diceSum;
		if (player.currentPos > squareList.size() - 1) {
			player.passGo();
			player.currentPos = player.currentPos % (squareList.size() - 1);
		}
		System.out.println("Landed on " + squareList.get(player.currentPos).getSquareName());

	}
}
