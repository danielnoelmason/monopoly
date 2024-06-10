package Testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import Entities.EventSquare;
import Events.SupriseIncomeTransaction;

/**
 * 
 * Test for event square
 *
 */
class eventSquareTest {

	/**
	 * Test for event square constructor
	 */
	@Test
	void testConstructor() {
		String eventName = "Test Name";
		EventSquare eventSquare = new EventSquare(eventName, new SupriseIncomeTransaction());

		assertEquals("|EVENT|" + eventName, eventSquare.getSquareName());

	}

}
