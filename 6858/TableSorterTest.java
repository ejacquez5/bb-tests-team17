package assignment1;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;


import org.junit.jupiter.api.Test;

class TableSorterTest  {

	private int[] userInput_1 = new int[] { 16, 66, 87, 92, 123, 125, 182, 190, 201 };
	private int[] userInput_2 = new int[] { 16, 16, 17, 92, 92, 125, 182, 201, 201 };
	private int[] WrongUserInput_1 = new int[] { 67, 66, 87, 92, 91, 125, 182, 190, 201 };
	private int[] WrongUserInput_2 = new int[] { 16, 66, 87, 15, 123, 125, 182, 190, 180 };
	private int[] WrongUserInput_3 = new int[] { 16, 66, 87, 12, 123, 125, 12, 190, 201 };




	@Test
	void testIsSortedNotSorted() throws Exception {

		assertTrue(TableSorter.isSorted(new Table(9, userInput_1)));
		assertTrue(TableSorter.isSorted(new Table(9, userInput_2)));
		assertFalse(TableSorter.isSorted(new Table(9, WrongUserInput_1)));
		assertFalse(TableSorter.isSorted(new Table(9, WrongUserInput_2)));
		assertFalse(TableSorter.isSorted(new Table(9, WrongUserInput_3)));
	}

	@Test
	void testIsSorted() throws Exception {
	
		assertTrue(TableSorter.isSorted(new Table(9, userInput_1)));
		assertTrue(TableSorter.isSorted(new Table(9, userInput_2)));
		assertFalse(TableSorter.isSorted(new Table(9, WrongUserInput_1)));
		assertFalse(TableSorter.isSorted(new Table(9, WrongUserInput_2)));
		assertFalse(TableSorter.isSorted(new Table(9, WrongUserInput_3)));

	}




}
