package Testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import Entities.Player;

class playerTest {

	/**
	 * test player constructor work
	 */
	@Test
	void testConstructor() {
		String name1 = ("Test Player 1");
		int resources= 1500;
		List<Integer> prioritiesOwned=new ArrayList<Integer>();
		int currentPos=0;
		int id=0;
		Player player = new Player(name1);
		assertEquals(name1, player.getName());
		assertEquals(resources, player.getResources());
		assertEquals(prioritiesOwned, player.getPrioritiesOwned());
		assertEquals(currentPos, player.getCurrentPos());
		assertEquals(id, player.getId());
	}
	
	/**
	 * test resource setting works
	 */
	@Test
	void testSetResources() {
		Player player = new Player("testPlayer");
		int resources = 5000;
		player.setResources(resources);
		assertEquals(resources, player.getResources());
	}
	
	/**
	 * test add resources to player
	 */
	@Test
	void testAddResources() {
		Player player = new Player("testPlayer");
		int intitialResources = player.getResources();
		player.addToBalance(200);
		assertEquals(200 +intitialResources, player.getResources());
	}
	
	/**
	 * test taking away player resources
	 */
	@Test
	void testMinusResources() {
		Player player = new Player("testPlayer");
		int intitialResources = player.getResources();
		player.takeAwayBalance(200);
		assertEquals(intitialResources-200, player.getResources());
	}
	
	/**
	 * test getNewBalance returns as expected
	 */
	@Test
	void testNewBalance() {
		Player player = new Player("testPlayer");
		player.takeAwayBalance(1000);
		String test = "Your new balance is 500 Resources";
		assertEquals(test, player.getNewBalance());
	}
	
	/**
	 * test moving a player position
	 */
	@Test
	void testMove() {
		Player player = new Player("testPlayer");
		int test = player.getCurrentPos();
		int diceRoll = 12;
		player.move(diceRoll);
		assertNotEquals(test, player.getCurrentPos());
		assertEquals(diceRoll, player.getCurrentPos());
	}

}
