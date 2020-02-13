package cs5387;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestCases {
	
	@Test
	void testIsSorted0() {
		/**
		 * Test random numbers
		 */
		//Random numbers
		int[] sample0 = {-19,8,77,-6,
				 		54,4,32,2,
				 		81,0,-124,1,
				 		-12,1000,-99999,99999};
		int[] sample1 = {5,6,7,
				 		9,-10,11,
				 		4,-5,6};
		int[] sample2 = {1,0,
				 		0,-1};
		int[] sample3 = {0,0,0,
						0,0,0,
						0,0,0};
		try {
			/*
			 * Create array of tables to test
			 */
			Table[] t = new Table[4];
			t[0] = new Table(sample0.length, sample0);
			t[1] = new Table(sample1.length, sample1);
			t[2] = new Table(sample2.length, sample2);
			t[3] = new Table(sample3.length, sample3);
			
			assertEquals(false, TableSorter.isSorted(t[0]));
			assertEquals(false, TableSorter.isSorted(t[1]));
			assertEquals(false, TableSorter.isSorted(t[2]));
			assertEquals(true, TableSorter.isSorted(t[3]));
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void testIsSorted1() {
		/**
		 * Test negative numbers only
		 */
		//Random negative numbers
		int[] sample0 = {-19,-8,-77,-6,
						 -54,-4,-32,-2,
						 -81,0,-124,-1,
						 -12,1000,-99999,-99999};
		//Sorted negative numbers
		int[] sample1 = {-15,-12,-10,
						 -12,-10,-5,
						 -10,-5,-1};
		//Negative number including zeroes
		int[] sample2 = {-1,0,
						 0,-1};
		//Repeating number
		int[] sample3 = {-10,-10,-10,
					     -10,-10,-10,
					     -10,-10,-10};
		try {
			/*
			 * Create array of tables to test
			 */
			Table[] t = new Table[4];
			t[0] = new Table(sample0.length, sample0);
			t[1] = new Table(sample1.length, sample1);
			t[2] = new Table(sample2.length, sample2);
			t[3] = new Table(sample3.length, sample3);
			
			assertEquals(false, TableSorter.isSorted(t[0]));
			assertEquals(true, TableSorter.isSorted(t[1]));
			assertEquals(false, TableSorter.isSorted(t[2]));
			assertEquals(true, TableSorter.isSorted(t[3]));
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void testIsSorted2() {
		/**
		 * Test positive numbers only
		 */
		//Random positive integers
		int[] sample0 = {19,8,77,6,
						 54,4,32,2,
						 81,10,124,1,
						 12,1000,99999,99999};
		//Sorted positive numbers
		int[] sample1 = {1,12,15,
						 12,15,16,
						 15,5,22};
		//Positive numbers including zeroes
		int[] sample2 = {1,0,
						 0,1};
		//Repeating positive numbers
		int[] sample3 = {20,20,20,
					     20,20,20,
					     20,20,20};
		try {
			/*
			 * Create array of tables to test
			 */
			Table[] t = new Table[4];
			t[0] = new Table(sample0.length, sample0);
			t[1] = new Table(sample1.length, sample1);
			t[2] = new Table(sample2.length, sample2);
			t[3] = new Table(sample3.length, sample3);
			
			assertEquals(false, TableSorter.isSorted(t[0]));
			assertEquals(false, TableSorter.isSorted(t[1]));
			assertEquals(false, TableSorter.isSorted(t[2]));
			assertEquals(true, TableSorter.isSorted(t[3]));
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void testIsSorted3() {
		/**
		 * Test empty table
		 */
		//empty table
		int[] sample0 = {};

		try {
			/*
			 * Create array of tables to test
			 */
			Table[] t = new Table[1];
			t[0] = new Table(sample0.length, sample0);
			
			assertEquals(true, TableSorter.isSorted(t[0]));
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	@Test
	void testSortable0() {
		/**
		 * Test random numbers
		 */
		//Random numbers
		int[] sample0 = {-19,8,77,-6,
				 		54,4,32,2,
				 		81,0,-124,1,
				 		-12,1000,-99999,99999};
		int[] sample1 = {5,6,7,
				 		9,-10,11,
				 		4,-5,6};
		int[] sample2 = {1,0,
				 		0,-1};
		int[] sample3 = {0,0,0,
						0,0,0,
						0,0,0};
		try {
			/*
			 * Create array of tables to test
			 */
			Table[] t = new Table[4];
			t[0] = new Table(sample0.length, sample0);
			t[1] = new Table(sample1.length, sample1);
			t[2] = new Table(sample2.length, sample2);
			t[3] = new Table(sample3.length, sample3);
			
			TableSorter.sortable(t[0]);
			assertEquals(true, TableSorter.isSorted(t[0]));
			TableSorter.sortable(t[1]);
			assertEquals(true, TableSorter.isSorted(t[1]));
			TableSorter.sortable(t[2]);
			assertEquals(true, TableSorter.isSorted(t[2]));
			TableSorter.sortable(t[3]);
			assertEquals(true, TableSorter.isSorted(t[3]));
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}


	@Test
	void testSortable1() {
		/**
		 * Test negative numbers only
		 */
		//Random negative numbers
		int[] sample0 = {-19,-8,-77,-6,
						-54,-4,-32,-2,
						-81,0,-124,-1,
						-12,1000,-99999,-99999};
		//Sorted negative numbers
		int[] sample1 = {-15,-12,-10,
					 	-12,-10,-5,
					 	-10,-5,-1};
		//Negative number including zeroes
		int[] sample2 = {-1,0,
					 	0,-1};
		//Repeating number
		int[] sample3 = {-10,-10,-10,
						-10,-10,-10,
						-10,-10,-10};
		try {
			/*
			 * Create array of tables to test
			 */
			Table[] t = new Table[4];
			t[0] = new Table(sample0.length, sample0);
			t[1] = new Table(sample1.length, sample1);
			t[2] = new Table(sample2.length, sample2);
			t[3] = new Table(sample3.length, sample3);
			
			TableSorter.sortable(t[0]);
			assertEquals(true, TableSorter.isSorted(t[0]));
			TableSorter.sortable(t[1]);
			assertEquals(true, TableSorter.isSorted(t[1]));
			TableSorter.sortable(t[2]);
			assertEquals(true, TableSorter.isSorted(t[2]));
			TableSorter.sortable(t[3]);
			assertEquals(true, TableSorter.isSorted(t[3]));
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}


	@Test
	void testSortable2() {
		/**
		 * Test positive numbers only
		 */
		//Random positive integers
		int[] sample0 = {19,8,77,6,
						 54,4,32,2,
						 81,10,124,1,
						 12,1000,99999,99999};
		//Sorted positive numbers
		int[] sample1 = {1,12,15,
						 12,15,16,
						 15,5,22};
		//Positive numbers smaller table 3x3
		int[] sample2 = {1,0,
						 0,1};
		//Repeating positive numbers
		int[] sample3 = {20,20,20,
					     20,20,20,
					     20,20,20};
		try {
			/*
			 * Create array of tables to test
			 */
			Table[] t = new Table[4];
			t[0] = new Table(sample0.length, sample0);
			t[1] = new Table(sample1.length, sample1);
			t[2] = new Table(sample2.length, sample2);
			t[3] = new Table(sample3.length, sample3);
			
			TableSorter.sortable(t[0]);
			assertEquals(true, TableSorter.isSorted(t[0]));
			TableSorter.sortable(t[1]);
			assertEquals(true, TableSorter.isSorted(t[1]));
			TableSorter.sortable(t[2]);
			assertEquals(true, TableSorter.isSorted(t[2]));
			TableSorter.sortable(t[3]);
			assertEquals(true, TableSorter.isSorted(t[3]));
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void testSortable3() {
		/**
		 * Test empty table
		 */
		//empty table
		int[] sample0 = {};

		try {
			/*
			 * Create array of tables to test
			 */
			Table[] t = new Table[1];
			t[0] = new Table(sample0.length, sample0);
			
			TableSorter.sortable(t[0]);
			assertEquals(true, TableSorter.isSorted(t[0]));
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}	
