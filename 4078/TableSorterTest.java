package cs5387;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * This is the test set deliverable for CS5387
 * Please note that to run it is required JUnit 5 (Jupiter).
 * Also, please know that since to test higher boundaries on Table ranges
 * example  Integer.MAX_VALUE, it is necessary too many memory resources, thus
 * this test case will limit to test more feasible limits such as a range of  8192 * 8192
 * 
 * @author <<author name redacted>>
 *
 */
class TableSorterTest {
	
	Table table;
	TableSorter sorter = new TableSorter();
	
	@Test
	void testNullTable_Sortable() {
		try {
			this.table = null;
			TableSorter.sortable(this.table);
			assertNull(this.table);
		} 
		catch (Exception e) {
			System.out.println(e.getMessage() + Thread.currentThread().getStackTrace());
		}
	}
	
	@Test 
	void testEmptyTable_Sortable(){
		try {
			int[] items = {0};
			this.table = new Table(0, items);
			TableSorter.sortable(this.table);
			assertNotNull(this.table);
		} 
		catch (Exception e) {
			System.out.println(e.getMessage() + Thread.currentThread().getStackTrace());
		}
	}
	
	@Test 
	void testTableSmallestTable_Sortable() {
		try {
			int[] items = {1};
			this.table = new Table(1, items);
			TableSorter.sortable(this.table);
			assertTrue(this.isSorted(this.table));
		} 
		catch (Exception e) {
			System.out.println(e.getMessage() + Thread.currentThread().getStackTrace());
		}
	}
	
	@Test
	void testSecondSmallestTable_Sortable() {
		try {
			int[] items = {1,2,3,4};
			this.table = new Table(4, items);
			TableSorter.sortable(this.table);
			assertTrue(this.isSorted(this.table));
		} 
		catch (Exception e) {
			System.out.println(e.getMessage() + Thread.currentThread().getStackTrace());
		}
	}
	
	@Test
	void testLargestTable_Sortable() {
		try {
			int largeNumber = 67108864; // 8192 * 8192
			int[] items = new int[largeNumber];
			for(int i = 0; i < items.length; i++) {
				items[i] = i;
			}
			this.table = new Table(largeNumber, items);
			TableSorter.sortable(this.table);
			assertTrue(this.isSorted(this.table));
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	void testSecondToLargestTable_Sortable() {
		try {
			int largeNumber = 67092481; // 8191 * 8191
			int[] items = new int[largeNumber];
			for(int i = 0; i < items.length; i++) {
				items[i] = i;
			}
			this.table = new Table(largeNumber, items);
			TableSorter.sortable(this.table);
			assertTrue(this.isSorted(this.table));
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test 
	void testEmptyTable_IsSorted(){
		try {
			int[] items = {0};
			this.table = new Table(0, items);
			assertTrue(this.sorter.isSorted(this.table));
		} 
		catch (Exception e) {
			System.out.println(e.getMessage() + Thread.currentThread().getStackTrace());
		}
	}
	
	@Test
	void testNullTable_isSorted() {
		try {
			this.table = null;
			assertFalse(this.sorter.isSorted(this.table));
		} 
		catch (Exception e) {
			System.out.println(e.getMessage() + Thread.currentThread().getStackTrace());
		}
	}
	
	@Test
	void testTableSmallestTable_IsSorted() {
		try {
			int[] items = {1};
			this.table = new Table(1, items);
			assertTrue(this.sorter.isSorted(this.table));
		} 
		catch (Exception e) {
			System.out.println(e.getMessage() + Thread.currentThread().getStackTrace());
		}
	}
	
	@Test
	void testSmallestUnsortedTable_IsSorted() {
		try {
			int[] items = {4, 3, 2, 1};
			this.table = new Table(4, items);
			assertFalse(this.sorter.isSorted(this.table));
		} 
		catch (Exception e) {
			System.out.println(e.getMessage() + Thread.currentThread().getStackTrace());
		}
	}
	
	@Test
	void testSmallestSortedTable_IsSorted() {
		try {
			int[] items = {1,2,3,4};
			this.table = new Table(4, items);
			assertTrue(this.sorter.isSorted(this.table));
		} 
		catch (Exception e) {
			System.out.println(e.getMessage() + Thread.currentThread().getStackTrace());
		}
	}
	
	@Test
	void testLargestUnsortedTable_isSorted() {
		try {
			int largeNumber = 67108864;
			int[] items = new int[largeNumber];
			for (int i = 0; i < largeNumber; i++) {
				items[i] = largeNumber - i;
			}
			this.table = new Table(4, items);
			assertFalse(this.sorter.isSorted(this.table));
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	void testLargestSortedTable_isSorted() {
		try {
			int largeNumber = 67108864;
			int[] items = new int[largeNumber];
			for (int i = 0; i < largeNumber; i++) {
				items[i] = i;
			}
			this.table = new Table(4, items);
			assertTrue(this.sorter.isSorted(this.table));
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	void testSecondLargestUnsortedTable_isSorted() {
		try {
			int largeNumber = 67092481;
			int[] items = new int[largeNumber];
			for (int i = 0; i < largeNumber; i++) {
				items[i] = largeNumber - i;
			}
			this.table = new Table(4, items);
			assertFalse(this.sorter.isSorted(this.table));
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	void testSecondLargestSortedTable_isSorted() {
		try {
			int largeNumber = 67092481;
			int[] items = new int[largeNumber];
			for (int i = 0; i < largeNumber; i++) {
				items[i] = i;
			}
			this.table = new Table(4, items);
			assertTrue(this.sorter.isSorted(this.table));
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	private boolean isSorted(Table t) {
		if (t == null) {
			System.out.println("TableSorter.isSorted: Invalid Input, table is null");
			return false;
		}
		int tableSize = t.getSize();
		if (tableSize < 0) {
			System.out.println("TableSorter.isSorted: Invalid Table Size");
			return false;
		} 
		else if (tableSize  <= 1) {
			return true;
		}
		for(int i = 1; i < tableSize; i++) {
			for (int j = 1; j < tableSize; j++) {
				if ( t.getTableValue(i, j - 1) > t.getTableValue(i, j)){
					return false;
				} 
				else if ( t.getTableValue(i -1, j) > t.getTableValue(i, j)) {
					return false;
				}
				else if ( t.getTableValue(i - 1, j - 1) > t.getTableValue(i - 1, j)){
					return false;
				}
				else if ( t.getTableValue(i - 1, j - 1) > t.getTableValue(i, j - 1)){
					return false;
				}
			}
		}
		return true;
	}

}