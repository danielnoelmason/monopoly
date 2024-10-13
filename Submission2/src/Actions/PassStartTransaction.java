package Actions;

import Entities.GameDataSingleton;

/**
 * @author danielmason
 * Pass Start Transaction class for when player circles map
 *
 */
public class PassStartTransaction implements Action {

	@Override
	/**
	 * Player resource balance is updated once they pass the starting square
	 * player pos is set accordingly
	 */
	public void runAction(GameDataSingleton gameData) {
		System.out.println("Travelled Around the World, You've Been Donated 200 Resources ");
		gameData.getCurrentPlayer().addToBalance(200);
		gameData.getCurrentPlayer()
				.setCurrentPos(gameData.getCurrentPlayer().getCurrentPos() % (gameData.getBoard().size()));
	}

}
