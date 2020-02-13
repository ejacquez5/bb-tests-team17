// <<author name redacted >>
// CS 5387 Software Integration and V&V
// Programming Assignment 2
/* Purpose: Create a class with two instance methods for programming assignment 1. One method "isSorted(Table t)" returns true if every
   row and every column in the table is sorted in ascending order. The second method "sortTable(Table t)" sorts a table so the isSorted
   will be true.
   -Now instrument TableSorter class to count the number of operations req to execute sort.
 */
/* Modifications: changed isSorted() and sortTable() methods to instance methods as required
 *   -Programming Assignment 2 modification--instrument TableSorter class to count the number of operations req to execute sort.
 *   		-assignment statements, comparison statements, branch, function calls
 *   		-report the total number of operations at the end of sort.
 *   	
 * 	 -Added a getter for opCount (# of operations to sort a matrix) instead of printing it at the end of the sorting method (after 
 *    seeing instructor response to another student on Piazza on how to serve the result).
 *    
 *   -added more opCount increments for return statements and some lines that assigned and had method calls together
 *    and an inc for the first loop comparison
 */

package cs5387;

public class TableSorter {
	
	private int opCount = 0; // num of ops used to sort
	
	// instance method to check and return true if the table is sorted
	public boolean isSorted(Table t) {
		// get the range (n) of the table for looping condition terminating
		int n = t.getSize();
		
		// traverse the table checking if rows and columns are ascending
		for(int r = 0; r < n; r++) {
			for(int c = 0; c < n; c++) {
				// check if spot is less than spot next in row, if not then it is not ascending and false
				if (r < n - 1 && t.getTableValue(r, c) > t.getTableValue(r + 1, c)) {
					return false;
				}
				// check if spot is less than spot in next col, if not then it is not ascending and false
				if (c < n - 1 && t.getTableValue(r, c) > t.getTableValue(r, c + 1)) {
					return false; 
				}
			}
		}
		
		return true; // both rows and columns are ascending if it made it past the for loop
		
	}
	
	// instance method that sorts the table to have both rows and columns sorted in ascending order
	// it will sort each row, then sort each col by transposing, sorting row again, then transposing back
	public void sortTable(Table t){
		this.opCount = 0; // reinitialize to 0 for each new sort
		
		// copy the table to 2d array to make easier when transposing
		int n = t.getSize(); // length of row or col for loop conditions
		this.opCount = this.opCount + 2; // assignment and method call directly above
		int[][] copy = new int[n][n];
		this.opCount++; // assignment directly above
		
		this.opCount++; // increase for r initialization in for-loop below
		this.opCount++; // inc for first loop comparison
		for(int r = 0; r < n; r++, this.opCount = opCount + 2) { // opCount is plus 2 for comparison and increment statements
			this.opCount++; // increase for c initialization in for-loops below
			this.opCount++; // inc for first loop comparison
			for(int c = 0; c < n; c++, this.opCount = opCount + 2) { // opCount is plus 2 for comparison and increment statements
				copy[r][c] = t.getTableValue(r, c);
				this.opCount = this.opCount + 2; // assignment and method call directly above
			}
		}
		
		// sort rows
		copy = bubbleSortRows(copy);
		this.opCount = this.opCount + 2; // assignment and method call directly above
		
		// transpose table to make sorting columns the same as sorting rows again
		copy = transpose(copy);
		this.opCount = this.opCount + 2; // assignment and method call directly above
		
		// sort row again which is really sorting columns
		copy = bubbleSortRows(copy);
		this.opCount = this.opCount + 2; // assignment and method call directly above
		
		// transpose the table back again to have table with sorted rows and columns
		copy = transpose(copy);
		this.opCount = this.opCount + 2; // assignment and method call directly above
		
		// place values of copy which is now sorted (by row and col) into original table
		this.opCount++; // increase for r initialization in for-loop below
		this.opCount++; // inc for first loop comparison
		for(int r = 0; r < n; r++, this.opCount = this.opCount + 2){ // opCount is plus 2 for comparison and increment statements
			this.opCount++; // increase for c initialization in for-loop below
			this.opCount++; // inc for first loop comparison
			for(int c = 0; c < n; c ++, this.opCount = this.opCount + 2){ // opCount is plus 2 for comparison and increment statements
				t.setTableValue(r, c, copy[r][c]);
				this.opCount++; // method call directly above
			}
		}
		
		opCount++; // return/branch from main sorting method
		
		// System.out.println("Total number of operations to sort: "+opCount+".");
	}
	
	// method to bubble sort each row in the 2d array copy
	// helps with sortTable method
	public int[][] bubbleSortRows(int[][] copy){
		int n = copy.length; // length of row or col for loop conditions
		this.opCount = this.opCount + 2; // assignment and method call directly above
		
		// bubble sort rows
		this.opCount++; // increase for r initialization in for-loop below
		this.opCount++; // inc for first loop comparison
		for(int r = 0; r < n; r++, this.opCount = this.opCount +2){ // opCount is plus 2 for comparison and increment statements
			// sort row
			this.opCount++; // increase for c initialization in for-loop below
			this.opCount++; // inc for first loop comparison
			for(int c = 0; c < n-1; c ++, this.opCount = this.opCount +2){ // opCount is plus 2 for comparison and increment statements
				this.opCount++; // increase for i initialization in for-loop below
				this.opCount++; // inc for first loop comparison
				for(int i = 0; i < n-c-1; i++, this.opCount = this.opCount +2){ // i is index // opCount is plus 2 for comparison and increment statements
					
					this.opCount++; // for comparison directly below
					if (copy[r][i] > copy[r][i+1]){ // need to swap so ascends
						int temp = copy[r][i];
						this.opCount++; // assignment directly above
						copy[r][i] = copy[r][i+1];
						this.opCount++; // assignment directly above
						copy[r][i+1] = temp;
						this.opCount++; // assignment directly above
					}
				}
			}
		}
		
		this.opCount++; // for return statement directly below
		return copy;
	}
	
	// method to transpose the table since transposing, sorting row, then transporting again is the same as sorting column 
	// helps with sortTable method
	public int[][] transpose(int[][] copy){
		int n = copy.length; // length of row or col for loop conditions
		this.opCount = this.opCount + 2; // assignment and method call directly above
		int[][] transposedCopy = new int[n][n];
		this.opCount++; // assignment directly above
		
		this.opCount++; // increase for r initialization in for-loop below
		this.opCount++; // inc for first loop comparison
		for(int r = 0; r < n; r++, this.opCount = this.opCount + 2){ // opCount is + 2 for comparison and increment statements
			this.opCount++; // increase for c initialization in for-loop below
			this.opCount++; // inc for first loop comparison
			for(int c = 0; c < n; c++, this.opCount = this.opCount + 2){ // opCount is + 2 for comparison and increment statements
				transposedCopy[r][c] = copy[c][r];
				this.opCount++; // assignment directly above
			}
		}
		
		this.opCount++; // for return statement directly below
		return transposedCopy;
	}
	
	// Getter method for opCount (the number of operations it takes to sort a matrix) since it is private
	public int getOpCount() {
		return this.opCount;
	}
}
