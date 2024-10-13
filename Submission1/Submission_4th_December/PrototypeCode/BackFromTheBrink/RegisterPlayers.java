package BackFromTheBrink;

import java.util.ArrayList;
import java.util.List;

public class RegisterPlayers {

	public static List<Player> regiserPlayers() {

		List<Player> playerList = new ArrayList<Player>();

		for (int count = 1; count <= 8; count++) {

			String question = "player " + count + "'s name (enter 'start' if no more players)";
			String answer = Read.read(question);
			if (answer.contains("start")) {
				count = 9;
			} else {
				Player player = new Player(answer);
				playerList.add(player);
			}
		}

		return playerList;
	}

}
