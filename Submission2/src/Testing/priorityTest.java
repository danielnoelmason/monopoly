package Testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Entities.ActionArea;
import Entities.Priority;

class priorityTest {

	/**
	 * testing the constructor of a priority
	 */
	@Test
	void testContructor() {
		String priorityName = "Test Name";
		int priorityValue = 1000;
		int priorityContributionCost =100;
		int priorityStepCost = 10;
		ActionArea aactionArea = new ActionArea("Test Action Area");
		
		Priority priority = new Priority(priorityName, priorityValue, priorityContributionCost, priorityStepCost, aactionArea);
		
		assertEquals(priorityName, priority.getSquareName());
		assertEquals(priorityValue, priority.getPriorityValue());
		assertEquals(priorityContributionCost, priority.getPriorityContributionCost());
		assertEquals(priorityStepCost, priority.getPriorityStepCost());
		assertEquals(aactionArea, priority.getActionArea());
	}
	
	/**
	 * test taking steps
	 */
	@Test
	void testTakingSteps() {
		String priorityName = "Test Steps";
		int priorityValue = 1000;
		int priorityContributionCost =100;
		int priorityStepCost = 10;
		ActionArea aactionArea = new ActionArea("Test Action Area");
		Priority priority = new Priority(priorityName, priorityValue, priorityContributionCost, priorityStepCost, aactionArea);
		
		int initialSteps=priority.getStepsTaken();
		priority.addStepsTaken(1);
		priority.addStepsTaken(1);
		priority.addStepsTaken(1);
		priority.addStepsTaken(1);
		
		assertNotEquals(initialSteps, priority.getStepsTaken());
		assertEquals(4, priority.getStepsTaken());
		assertNotEquals(priorityContributionCost, priority.getPriorityContributionCost());
		
	}
	
	/**
	 * test reset the priority for when players leave
	 */
	@Test
	void testResetPriority() {
		Priority testReset = new Priority("Priority 1", 10, 10, 10, new ActionArea("a1"));
		testReset.setOwner(1);
		testReset.addStepsTaken(4);
		testReset.setAvailableForPurchase(false);
		
		assertNotEquals(10, testReset.getPriorityContributionCost());
		
		testReset.resetSquare();
		
		assertEquals(10, testReset.getPriorityContributionCost());
		assertNotEquals(1, testReset.getOwner());
		assertNotEquals(4, testReset.getStepsTaken());
		assertNotEquals(false, testReset.isAvailableForPurchase());
		
	}
	
	/**
	 * test the string returns are accurate
	 */
	@Test
	void testStringReturns() {
		Priority priority = new Priority("Priority 1", 10, 10, 10, new ActionArea("a1"));
		String expectedOut1 = "0|a1| Priority 1";
		String expectedOut2 = "0|a1| Priority 1\t\tAcquisition Cost: " + 10 + "\t\tDonations Per Visit: " + 10;
		
		assertEquals(expectedOut1, priority.toPrintBoard());
		assertEquals(expectedOut2, priority.toString());
	}
	
	
	
	

}
