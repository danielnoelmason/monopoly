package Actions;

import Entities.GameDataSingleton;

/**
 * 
 * @author danielmason
 * interface class for the the different functions that effect a player
 *
 */
public interface Action {

	public void runAction(GameDataSingleton gameData);

}
