package Events;

import Entities.GameDataSingleton;

/**
 * @author danielmason
 * interface for suprise events
 *
 */
public interface Event {

	/**
	 * Run event
	 * 
	 * @param gameData
	 */
	public void runEvent(GameDataSingleton gameData);

}
