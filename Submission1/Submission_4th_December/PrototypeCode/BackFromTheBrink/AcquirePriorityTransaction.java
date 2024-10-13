/**
 * 
 */
package BackFromTheBrink;

/**
 * @author danielmason
 *buying a property when landing on it
 */
public class AcquirePriorityTransaction {

	public AcquirePriorityTransaction(Square square, Player player) {
		
		if (((Priority) square).isAvailableForPurchase()) {
			((Priority) square).setAvailableForPurchase(false);
			player.getPrioritiesOwned().add((Priority) square);//could be error
			player.setBalance(player.getBalance() - ((Priority) square).getPriorityValue());
			System.out.println("CONFIRMATION, Player " + player.getName() + " ACQUIRED PRIORITY "
					+ player.getPrioritiesOwned().get(player.getPrioritiesOwned().size() - 1).getPriorityName());
		} else {
			System.out.println("The priority is already owned");
		}
		
	}



}
