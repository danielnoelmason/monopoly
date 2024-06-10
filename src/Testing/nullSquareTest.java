package Testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Entities.NullSquare;

class nullSquareTest {

	@Test
	void testNullSqaure() {
		String nullSquareName = "Test name";
		NullSquare nullSquare = new NullSquare(nullSquareName);
		assertEquals(nullSquareName, nullSquare.getSquareName());
	}

}
