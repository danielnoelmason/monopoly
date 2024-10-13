package BackFromTheBrink;

import java.util.ArrayList;
import java.util.List;

public class playerUI {

	// WILL BE REPLACED WITH GameDataSingleton
	static List<Player> playerList = new ArrayList<Player>();
	static List<Square> board = new ArrayList<Square>();
	static GameDataSingleton gameData = GameDataSingleton.getSingletonInstance();

	public static void main(String[] args) {


//		ACTION AREA CODE NOT YET FUNTIONAL
//		ActionArea aa1 = new ActionArea("ActionArea1");
//		aa1.aaPriorityList.add(location1);
//		aa1.aaPriorityList.add(location2);
//		ActionArea aa2 = new ActionArea("ActionArea2");
//		ActionArea aa3 = new ActionArea("ActionArea3");
//		ActionArea aa4 = new ActionArea("ActionArea4");
		
		
		// hard coded squares
		Square start = new StartingSquare();
		Priority location1 = new Priority("Location1", 60, 2, 30);
		Priority location2 = new Priority("Location2", 60, 4, 30);
		Priority location3 = new Priority("Location3", 100, 6, 50);
		Priority location4 = new Priority("Location4", 100, 6, 50);
		Priority location5 = new Priority("Location5", 120, 8, 60);
		Priority location6 = new Priority("Location6", 140, 10, 70);
		Priority location7 = new Priority("Location7", 140, 10, 70);
		Priority location8 = new Priority("Location8", 160, 12, 80);
		Priority location9 = new Priority("Location9", 180, 14, 90);
		Priority location10 = new Priority("Location10", 180, 14, 90);
		Priority location11 = new Priority("Location11", 200, 16, 100);
		Priority location12 = new Priority("Location12", 220, 18, 110);
		board.add(start);
		board.add(location1);
		board.add(location2);
		board.add(location3);
		board.add(location4);
		board.add(location5);
		board.add(location6);
		board.add(location7);
		board.add(location8);
		board.add(location9);
		board.add(location10);
		board.add(location11);
		board.add(location12);

		intro();//start game

		System.out.println("Please register players");
		playerList = RegisterPlayers.regiserPlayers(); // initialise the players
		
		while (playerList.size() > 1) {// while there is more then 1 player

			for (int count = 0; count < playerList.size(); count++) {// loop through player turns -- will run while > 1
																		// player

				new TakeTurnTransaction(playerList.get(count), board, playerList, count);

			}

		}
		outro();//end game
	}

	public static void intro() {
		ASCIIArt.drawString("Back From ");
		System.out.println();
		ASCIIArt.drawString("The Brink");
	}

	public static void outro() {
		ASCIIArt.drawString("Game Over");
		System.out.println();
		ASCIIArt.drawString(playerList.get(0).getName().toUpperCase() + " Won");
	}

}
