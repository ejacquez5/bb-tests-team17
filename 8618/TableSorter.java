/*
 * Author: <<author name redacted >>
 * Version: 1.1 - Added counter - numOperations - to count the number of operations
 * executed during Sort. Made minor syntactic adjustments to methods.
 * Purpose: This class contains two instance methods, isSorted and sortable. 
 * The isSorted method takes in a Table object as its only parameter and determines whether
 * or not the given Table is sorted in ascending order.
 * The sortable method also takes in a Table object as its only parameter and sorts the given
 * table in ascending order using a bubblesort algorithm.
 * 
 */

package cs5387;

public class TableSorter {
	
	public boolean isSorted(Table t){
		int i, j = 0;
		int tSize = t.getSize();
		
		// the following variable holds onto the value of the previous cell during iteration
		int prevVal = t.getTableValue(0, 0); // this must be less than value of table at (i, j) if sorted
		
		// using a nested for-loop to iterate through every cell in given table
		for(i = 0; i < tSize; i++) { 
			for(j = 0; j < tSize; j++) { 
				// comparing value of current cell with value of previous
				if(t.getTableValue(i, j) < prevVal) {
					return false; // value at (i, j) is less than previous value, table is not sorted
				}
				// update variable to hold on to value for next iteration
				prevVal = t.getTableValue(i, j);
			}
		}	
		return true; // table is sorted
	}
	
	public static void sortable(Table t) {
		int numOperations = 0;
		int i, j = 0;
		int tSize = t.getSize(); 
		
		/* for the sake of readability, the following variables hold: 
		 * value of current table cell - for comparison
		 * value of next table cell - for comparison
		 * index of next row - for use in getTableValue method
		 * index of next column (respectively) */
		int currVal, nextVal, nextR, nextC = 0; 
		
		// the following variable is used to exit while loop below
		boolean valSwapped = true; 
		
		while(valSwapped) {
			// initialized as false at the start of every loop; if no swap is made, loop will exit
			valSwapped = false; numOperations++; //variable assignment
			
			// using a nested for-loop to iterate through every cell of given table
			for(i = 0; i < tSize; i++) { 
				for(j= 0; j < tSize; j++) { 
					currVal = t.getTableValue(i, j); numOperations += 2; // variable assignment + function call
					
					/* the following if-else statement is used to gather variables for comparison
					 * and for getting table values
					 */
					numOperations += 3; // 3 comparisons in if-statement below
					if(j == tSize - 1 && i < tSize - 1) { // end of row reached, jump to next row
						nextR = i + 1; 
						nextC = 0; 
						nextVal = t.getTableValue(nextR, nextC); 
						numOperations += 4; // 3 variable assignments + 1 function call
					}
					else if(i == j && i == tSize - 1) { 
						numOperations += 3; //3 comparisons in else-if 
						break; // end of table reached, break loop
					} 
					else { // no special condition, grab variables from adjacent cell
						nextR = i; 
						nextC = j + 1; 
						nextVal = t.getTableValue(i, j + 1);
						numOperations += 4; // 3 variable assignments + 1 function call
					}

					// if current cell's value is greater than next cell's value, swap them
					numOperations++;
					if(currVal > nextVal) {
						t.setTableValue(i, j, nextVal); 
						t.setTableValue(nextR, nextC, currVal); 
						valSwapped = true; // true boolean will trigger another cycle of while-loop until no swap is made
						numOperations += 3; // 1 variable assignment + 2 function calls
					}
					numOperations++; // branch (inner for)
				}
				numOperations++; // branch (outer for)
			}
			numOperations = numOperations + i + j + 2; // summing initial assignments to i and j + reassignments made at every loop
			numOperations++; // branch (while)
		}	
		System.out.println("Number of operations in Sort: " + numOperations);
	}
}
