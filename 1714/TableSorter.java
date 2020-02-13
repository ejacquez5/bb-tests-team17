/**
* This class sorts an 2D Array of integers and verifies it is sorted. 
* @version 1
* @author <<author name redacted >>
*/
package cs5387;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import cs5387.Table;


public class TableSorter {
	
	private static int assignment_counter = 0;
	private static int comparison_counter = 0;
	private static int branch_counter = 0;
	private static int function_counter = 0;
	public static void main(String[] args) throws FileNotFoundException, IOException, Exception {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter a path of a file with a two dimensional array");
		String file = in.nextLine();
		Table table = Table.GetTable(file);
		
		// Initial Array status
		System.out.println("Initial Array Status");
		System.out.println(table);
		System.out.println("Is it Sorted?: "+ isSorted(table));
		System.out.println();

		sortable(table);
		System.out.println("Array sorted First time");
		System.out.println(table);
		System.out.println("Is it Sorted?: "+ isSorted(table));
		System.out.println();
		
		table.setTableValue(1, 1, 2147483647);
		System.out.println("Array with the highest integer posible in the middle");
		System.out.println(table);
		System.out.println("Is it Sorted?: "+ isSorted(table));
		System.out.println();
		
		sortable(table);
		System.out.println("Array sorted Second time");
		System.out.println(table);
		System.out.println("Is it Sorted?: "+ isSorted(table));
		System.out.println();
		
		System.out.println("Total operations required to sort:");
		System.out.println("Assignment statements: "+assignment_counter);
		System.out.println("Comparison operations: "+comparison_counter);
		System.out.println("Branch counter: "+branch_counter);
		System.out.println("Function calls: "+function_counter);
		System.out.println("Total operations: "+get_total_count());
		System.out.println();
		
		
		
		in.close();
	}

	public static int get_total_count() {
		return assignment_counter + comparison_counter + branch_counter + function_counter;
	}
	/**
	 * Accepts a table object to sort its content. (Two dimensional
	 * array of integers)
	 *
	 * @param  t	Table instance to be sorted.
	 */
	public static void sortable(Table t) {
		int range, rowIndex, colIndex;
		range = t.getSize();
		assignment_counter++;  // Assign variable

		for (int z = 0; z < (range * range); z++) {
			comparison_counter++; // Comparison and assignment counters get  higher for every repetition in a loop 
			assignment_counter++;
			for (rowIndex = 0; rowIndex < range; rowIndex++) {
				comparison_counter++;
				assignment_counter++;
				for (colIndex = 0; colIndex < range - 1; colIndex++) {
					comparison_counter++;
					assignment_counter++;
					function_counter++;
					swapToNextColumn(t, rowIndex, colIndex);
				}
				function_counter++;
				swapToNextRow(t, rowIndex, colIndex);
			}
		}
	}
	
	/**
	 * Accepts a table object to verify its content is sorted. 
	 *
	 * @param  t	Table instance to be verified.
	 * @return      A boolean that represents the sorted status.
	 */
	public static boolean isSorted(Table t) {
		int range, rowIndex, colIndex;
		range = t.getSize();
	
		for (rowIndex = 0; rowIndex < range; rowIndex++) {
			for (colIndex = 0; colIndex < range - 1; colIndex++) {
				if(swapNeeded(t.getTableValue(rowIndex, colIndex), t.getTableValue(rowIndex, colIndex + 1))){
					return false;
				}
			}
			if(rowIndex != t.getSize() - 1 && (swapNeeded(t.getTableValue(rowIndex, colIndex), t.getTableValue(rowIndex + 1, 0))))
				return false;
		}
		return true;
	}
	
	
	/**
	 * Checks if two values need to be swapped. 
	 * This is used when a column is compared to the next 
	 * column in the same row.
	 *
	 * @param  t	Table used for comparison.
	 * @param  row	Integer that represents the actual row.
	 * @param  col	Integer that represents the actual column.
	 */
	private static void swapToNextColumn(Table t, int row, int col) {
		if (swapNeeded(t.getTableValue(row, col), t.getTableValue(row, col + 1))) {
			branch_counter++;
			swap(t, row, col, row, col + 1);
		}
	}

	/**
	 * Checks if two values need to be swapped. 
	 * This is used when the last column in a row is compared
	 * to the first column of the next row.
	 *
	 * @param  t	Table used for comparison.
	 * @param  row	Integer that represents the actual row.
	 * @param  col	Integer that represents the actual column.
	 */
	private static void swapToNextRow(Table t, int row, int col) {
		if (row != t.getSize() - 1) {
			branch_counter++;
			if (swapNeeded(t.getTableValue(row, col), t.getTableValue(row + 1, 0))) {
				branch_counter++;
				swap(t, row, col, row + 1, 0);
			}
		}
	}
	
	/**
	 * Swaps two values. 
	 * This is used when the last column in a row is compared
	 * to the first column of the next row.
	 *
	 * @param  t	Table to be updated.
	 * @param  row1	Integer that represents the row number of first
	 * 				item to be swapped.
	 * @param  col1	Integer that represents the column number of first
	 * 				item to be swapped.
	 * @param  row2	Integer that represents the row number of second
	 * 				item to be swapped.
	 * @param  col2	Integer that represents the column number of second
	 * 				item to be swapped.
	 */
	private static void swap(Table t, int row1, int col1, int row2, int col2) {
		assignment_counter++; // var temp is assigned
		function_counter = function_counter + 4; // 3 more function calls for setTableValue() and one for this one: swap().
		int temp = t.getTableValue(row1, col1);
		t.setTableValue(row1, col1, t.getTableValue(row2, col2));
		t.setTableValue(row2, col2, temp);
	}

	/**
	 * Accepts 2 values to be compared. 
	 *
	 * @param  value1	First value to be compared.
	 * @param  value2	Second value to be compared.
	 * @return      	A boolean that represents the need of a swap.
	 */
	private static boolean swapNeeded(int value1, int value2) {
		comparison_counter++;
		function_counter++;
		// Comparison made and function called
		return value1 > value2;
	}
}