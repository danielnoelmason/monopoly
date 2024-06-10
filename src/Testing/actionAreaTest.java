package Testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Entities.ActionArea;

/**
 * 
 * Test for action area
 *
 */
class actionAreaTest {

	/**
	 * Test action area constructor
	 */
	@Test
	void testConstructor() {
		String actionAreaName = "Test area name";
		ActionArea aaTest = new ActionArea(actionAreaName);
		
		assertEquals(actionAreaName, aaTest.getActionAreaName());
		
	}
	
	/**
	 * Test add priority index
	 */
	@Test
	void testAddPriorityIndex() {
		ActionArea aaTest = new ActionArea("actionAreaName");
		int indexOfPriority = 8;
		aaTest.addPriorityIndex(indexOfPriority);	
		
	}
	
}
