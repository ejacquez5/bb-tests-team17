/*
 * Author: <<author name redacted >>
 * Version: 1.3
 * Date: 2-7-2020
 * The Table Sorter class supports the public Table interface.
 * Version 1.1 - First it determines if the Table t is sorted in ascending
 * order for every row and column. Second it sorts Table t if it is not sorted 
 * in ascending order.
 * Version 1.2 - Counts the number of total operations required 
 * to execute sort. A counter is used for this portion of the assignment.
 * Version 1.3 - Minor fixes to correctly count the total number of
 * operations. Fix minor issues w/t sorting Table t
 */

package cs5387;

import java.io.FileNotFoundException;
import java.io.IOException;

public class TableSorter { 

	//Count number of operations
	public static int count = 0;

	//Returns true if every row and every column of
	//the Table t is sorted in ascending order
	public static boolean isSorted(Table t){
		if(isSortedRows(t) && isSortedCols(t)) { count += 2; // 1 comparison, 1 branch
			
			return true;
		}       count++; // 1 branch 

		return false;
	}

	//Check if the rows of Table t are sorted
	public static boolean isSortedRows(Table t) {
		//Loop through the rows of Table t
		for (int i = 0; i < t.getSize(); i++) { count +=4; // 2 Assignment statements, 1 comparison, 1 function call
			
			//Loop through the columns of Table t
			for (int j = 0; j < t.getSize() - 1; j++){ count +=4; // 2 Assignment statements, 1 comparison, 1 function call
	
				if (t.getTableValue(i, j) > t.getTableValue(i, j + 1)) count += 4; // 2 Function calls, 1 Comparison, 1 branch
			
					return false;
			}
		}	count++;//1 branch

		return true;
	}

	//Check if the columns of Table t are sorted
	public static boolean isSortedCols(Table t) {
		//Loop through the rows of Table t
		for (int j = 0; j < t.getSize(); j++) { count +=4; // 2 Assignment statements, 1 comparison, 1 function call
	
			//Loop through the columns of Table t
			for (int i = 0; i < t.getSize() - 1; i++){ count +=4; // 2 Assignment statements, 1 comparison, 1 function call
	
				if (t.getTableValue(i, j) > t.getTableValue(i + 1, j)) count += 4; // 2 Function calls, 1 Comparison, 1 branch
		
					return false;
			}
		} count++;// 1 branch

		return true;
	}

	//Sorts a Table so that isSorted() is true
	public static void sortRows(Table t) {
		
		//boolean swap = true; count++; // 1 Assignment statement 
		// Loop through the rows of Table t 
		for (int i = 0; i < t.getSize(); i++) { count +=4; // 2 Assignment statements, 1 comparison, 1 function call
				//Loop through the columns of Table t
				for (int j = 0; j < t.getSize() - 1; j++) { count +=4; // 2 Assignment statements, 1 comparison, 1 function call
					
					//Compare and swap values in every row
					if (t.getTableValue(i , j) > t.getTableValue(i, j + 1)) { count += 4; // 2 Function calls, 1 Comparison, 1 branch
						
						int orig = t.getTableValue(i, j); count += 2;// 1 Assignment statement, 1 function call  
						int dup = t.getTableValue(i, j + 1); count += 2;// 1 Assignment statement, 1 function call  
						//Swap values
						t.setTableValue(i, j, dup); count++;//1 Function call
						t.setTableValue(i, j + 1, orig); count++;//1 Function call
					}
				}
			}
	}

	// Find transpose of the Table t
	public static void transpose(Table t) { 
		
		for (int i = 0; i < t.getSize(); i++){  count +=4; // 2 Assignment statements, 1 comparison, 1 function call
				for (int j = i + 1; j < t.getSize() - 1; j++)  {  count +=4; // 2 Assignment statements, 1 comparison, 1 function call
					// swapping element at index (i, j)  
					// by element at index (j, i) 
					int orig  = t.getTableValue(i, j); count += 2;// 1 Assignment statement, 1 function call  
					int dup = t.getTableValue(j, i); count += 2;// 1 Assignment statement, 1 function call  
				
					//Swap values
					t.setTableValue(i, j, dup); count++;//1 Function call
					t.setTableValue(j, i, orig); count++;//1 Function call

				}
		} 
	} 

	//Sorts Table t if it is not sorted in ascending  
	public static void sortable (Table t){
		sortRows(t); count++; //1 Function call
		transpose(t); count++; //1 Function Call 
		sortRows(t); count++; //1 Function call
		transpose(t); count++; //1 Function call
		
	}

	public static void main (String [] args) throws FileNotFoundException, IOException, Exception{
		
		
		//Table table = Table.GetTable("C:\\Users\\alan9\\workspace\\V&V Assign 1\\matrix.txt");
		
		int [] array = new int[] {3,1,4,2, 5, 7, 8, 6, 9};
		Table t = new Table (9, array);
		System.out.println("Before sort\n" + t);
		System.out.println("Is sorted? " + isSorted(t) + "\n");
		sortable(t);
		System.out.println("After sort\n" + t);
		System.out.print("Number of operations: " + count);
		/*System.out.print("Before sort:" + table);
		isSorted(table);
		sortable(table);
		System.out.print("After sort:" + table);
		System.out.println(isSortedRows(table));
		System.out.print("Number of operations:" + count);*/

	}
}
