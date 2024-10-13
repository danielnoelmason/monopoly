package Controller;

import Actions.TakeTurnTransaction;
import Entities.GameDataSingleton;
import Other.ASCIIArt;

/**
 * @author danielmason
 * Controller class runs the game  
 *
 */
public class Controller {

	static GameDataSingleton gameData;
	
	/**
	 * prints intro/outro, instantiates gamedata, runs player turns
	 */
	public void runGame() {
		ASCIIArt.intro();
		System.out.println(
				"Welcome to Back From The Brink\nSave the world by travelling the board, protecting environments and taking initiatives to perserve them\n\nPlease register players");
		gameData = GameDataSingleton.getSingletonInstance();
		while (gameData.getPlayers().size() > 1) {
			for (int count = 0; count < gameData.getPlayers().size(); count++) {
				new TakeTurnTransaction().runAction(gameData);
			}
		}		
		ASCIIArt.outro(gameData);
	}

}
