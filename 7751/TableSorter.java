package cs5387;

/**
 * <h1>TableSorter</h1>
 * The TableSorter program is an java application that:
 * checks whether a Table (2d array) is sorted and also,
 * sorts a Table.
 * <p>
 * <b>Note:</b>  A table is sorted if every row and
 * column are sorted in ascending order.
 * Also, the program can only handle expected input.
 *
 * @author  <<author name redacted >>
 * @version 1.1
 * @since   2020-01-29
 */

public class TableSorter {

	private static int sortCount = 0;
	/**
	 * Check if a table is sorted. 
	 *
	 * @param  t	the table to be sorted.	
	 * @return whether the table is sorted.
	 */
	public boolean isSorted(Table t){
		for(int i=1; i <t.getSize(); i++) {
			for(int j=1; j <t.getSize(); j++) {
				if(t.getTableValue(i-1, j-1) > t.getTableValue(i-1, j) || t.getTableValue(j-1, i-1) > t.getTableValue(j, i-1)) {
					return false;
				}
			}	
		}
		return true;
	}


	/**
	 * Sort a table object by using bubble-sort. 
	 *
	 * @param  t	the table to be sorted.	
	 */
	public static void sortTable(Table t){

		int sum = 0; //sum of total operations

		int temp; 															// 1 assignment =						1 
		int n = t.getSize(); 												// 1 assignment + 1 function call = 	2
		sum+=3;
		//Horizontal bubble-sort
		for(int i = 0; i < n; i++) { 	sum+=2;								// 2 assignments + 1 comparison = 		3
			for (int j = 0; j < n-1; j++) {		sum+=3;						// 2 assignments + 1 comparison = 		3
				for (int k = 0; k < n-j-1; k++) { 		sum+=3;				// 2 assignments + 1 comparison = 		3
					if(t.getTableValue(i, k) > t.getTableValue(i, k+1)) { 	// 1 comparison + 2 function calls = 	3
						temp = t.getTableValue(i, k);						// 1 assignment + 1 function call =		2
						t.setTableValue(i, k, t.getTableValue(i, k+1)); 	// 2 function calls = 					2
						t.setTableValue(i, k+1, temp);	sum+=8;				// 1 function call =					1
					} 
				}
			}
		}
		
		//Vertical bubble-sort
		for(int i = 0; i < n; i++) {			sum+=2;						// 2 assignments + 1 comparison = 		3
			for (int j = 0; j < n-1; j++) {		sum+=3;						// 2 assignments + 1 comparison = 		3
				for (int k = 0; k < n-j-1; k++) { 	sum+=3;					// 2 assignments + 1 comparison = 		3
					if(t.getTableValue(k, i) > t.getTableValue(k+1, i)) {	// 1 comparison + 2 function calls = 	3
						temp = t.getTableValue(k, i);						// 1 assignment + 1 function call =		2
						t.setTableValue(k, i, t.getTableValue(k+1, i));		// 2 function calls = 					2
						t.setTableValue(k+1, i, temp); 						// 1 function call =					1
						sum+=8;
					} 

				}
			}
		}
		
		System.out.println("\nTotal operations:	" + sum + "\nTable of size:	" + t.getSize() + "\n");													// total =					#N + finite number
	}


}