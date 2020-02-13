package cs5387;

public class TableMain {

	public static void main(String[] args) throws Exception {
		// Integer arrays for creation of tables
		int[] v1 = new int[] {3, 6, 2, 233, 8, 1, 90, 23, 4}; // 9 integers, no duplicates
		int[] v2 = new int[] {1}; // 1 integer
		int[] v3 = new int[] {33, 55, 22, 11, 33, 55, 33, 7, 11}; // 9 integers, duplicates
		int[] v4 = new int[] {29, -20, 4, -1}; // 4 integers with negatives
		
		// Test tables
		Table test1 = new Table(9, v1); // 3x3 table with no duplicates
		Table test2 = new Table(1, v2); // 1x1 table
		Table test3 = new Table(9, v3); // 3x3 table with duplicates
		Table test4 = new Table(4, v4); // 2x2 table with negatives
		
		// TableSorter object will be tested using test tables
		TableSorter ts = new TableSorter();
		
		// Test 1: Tests a 3x3 Table with no duplicates
		System.out.println("\nTest1\n" + test1.toString()); // Original table 1
		System.out.println("Test1 isSorted: " + ts.isSorted(test1)); // false
		ts.sortable(test1);
		System.out.println("\nTest1 after Sorting \n" + test1.toString()); // Sorted table1
		System.out.println("Test1 issorted after sorting: " + ts.isSorted(test1)); // true
		
		// Test 2: Test a 1x1 Table
		System.out.println("\nTest2\n" + test2.toString()); // Original table 2
		System.out.println("Test2 isSorted: " + ts.isSorted(test2)); // true
		ts.sortable(test2);
		System.out.println("\nTest2 after sorting \n" + test2.toString()); // Sorted table 2
		System.out.println("Test2 isSorted after sorting: " + ts.isSorted(test2)); // true
		
		// Test 3: Test a 3x3 Table with duplicates
		System.out.println("\nTest3\n" + test3.toString()); // Original table 3
		System.out.println("Test3 isSorted: " + ts.isSorted(test3)); // false;
		ts.sortable(test3);
		System.out.println("\nTest3 after sorting\n" + test3.toString()); // Sorted table 3
		System.out.println("\nTest3 isSorted after sorting: " + ts.isSorted(test3)); // true
		
		// Test 4: Test a 2x2 Table with negatives
		System.out.println("\nTest4\n" + test4.toString()); // Original table 4
		System.out.println("Test4 isSorted: " + ts.isSorted(test4)); // false;
		ts.sortable(test4);
		System.out.println("\nTest4 after sorting\n" + test4.toString()); // Sorted table 4
		System.out.println("\nTest4 isSorted after sorting: " + ts.isSorted(test4)); // true
		
	}
}
