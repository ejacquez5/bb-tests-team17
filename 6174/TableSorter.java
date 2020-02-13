/**
 * Author: <<author name redacted >>
 * Purpose: This class is used for tables from the Table class to sort rows and columns in
 * ascending order and to check if their rows and columns are sorted in ascending order.
 * Sortable displays a count of all operations
 * */

package cs5387;

public class TableSorter {
	
	// Constructor
	public TableSorter() {}

	// Returns true if every row and every column of table t is sorted in ascending order
	public boolean isSorted(Table t) {
		boolean rows;
		boolean columns;
		// Checks Rows
		for(int r = 0; r < t.getSize(); r++) {
			rows = sortedRow(t, r); // returns false if a row is not sorted
			if (rows == false) {
				return false;
			}
		}
		// Checks Columns
		for (int c = 0; c < t.getSize(); c++) {
			columns = sortedColumn(t,c); // returns false if a column is not sorted
			if (columns == false) {
				return false;
			}
		}
		return true;
	}
	
	// Returns true if row i in Table t is sorted in ascending order
	public boolean sortedRow(Table t, int i) {
		for(int j = 0; j < t.getSize(); j++) {
			if(j+1 < t.getSize()) {
				if(t.getTableValue(i, j) > t.getTableValue(i, j+1)) {
					return false;
				}
			}
		}
		return true;
	}
	// Returns true if column j in Table t is sorted in ascending order
	public boolean sortedColumn(Table t, int j) {
		for(int i = 0; i < t.getSize(); i++) {
			if (i+1 < t.getSize()) {
				if(t.getTableValue(i, j) > t.getTableValue(i+1, j)) {
					return false;
				}
			}
		}
		return true;
	}
	
	// Sorts a Table t so that isSorted is true and displays the number of all operations taken
	public static void sortable(Table t) {
		int count = 0;
		int curr;
		count++;
		int[] indexRow = new int[3];
		count++;
		int[] indexColumn = new int[3];
		count++;
		
		// Sorts rows
		for (int i = 0; i < t.getSize(); i++) {
			count++;
			for (int j = 0; j < t.getSize(); j++) {
				count++;
				indexRow[0] = -1;
				count++;
				indexRow[1] = -1;
				count++;
				curr = t.getTableValue(i, j);
				count++;
				indexRow = compareRow(curr,t, i, j); // if a smaller integer subsequent to the current integer in the row exists, the index of the smaller integer is retrieved
				count++;
				count++;
				if(indexRow[0] != -1) {
					// if it exists, the smaller integer swaps with the current integer
					t.setTableValue(i, j, t.getTableValue(indexRow[0], indexRow[1]));
					count++;
					t.setTableValue(indexRow[0], indexRow[1], curr);
					count++;
				}
			}
		}
		
		// Sorts columns after all rows are sorted
		for (int i = 0; i < t.getSize(); i++) {
			count++;
			for (int j = 0; j < t.getSize(); j++) {
				count++;
				indexColumn[0] = -1;
				count++;
				indexColumn[1] = -1;
				count++;
				curr = t.getTableValue(i, j);
				count++;
				indexColumn = compareColumn(curr,t,i,j); // if a smaller integer subsequent to the current integer in the column exists, the index of the smaller integer is retrieved
				count++;
				count++;
				if(indexColumn[0] != -1) {
					// if it exists, the smaller integer swaps with the current integer
					t.setTableValue(i, j, t.getTableValue(indexColumn[0], indexColumn[1]));
					count++;
					t.setTableValue(indexColumn[0], indexColumn[1], curr);
					count++;
				}
			}
		}
		count += indexRow[2];
		count += indexColumn[2];
		System.out.println("Sortable Count = " + count);
	}
	
	// Returns the index of the smallest subsequent integer in a row starting from the 
	// index, i, j, at the current integer curr, in Table t, or returns -1 if the current integer is smaller than all subsequent integers
	public static int[] compareRow(int curr, Table t, int i, int j) {
		int[] index = new int[] {-1, -1, 0};
		int smallest = 1000000;
		index[2] = index[2] + 1;
		index[2] = index[2] + 1;
		if (j+1 < t.getSize()) {
			for (j=j+1; j < t.getSize(); j++) {
				index[2] = index[2] + 1;
				index[2] = index[2] + 1;
				if (t.getTableValue(i, j) < curr) {
					index[2] = index[2] + 1;
					if (t.getTableValue(i, j) < smallest) {
						smallest = t.getTableValue(i, j); // Only the index of the smallest integer subsequent to the current integer is retrieved, if any.
						index[2] = index[2] + 1;
						index[0] = i;
						index[2] = index[2] + 1;
						index[1] = j;
						index[2] = index[2] + 1;
					}
				}
			}
		}
		return index;
	}
	
	// Returns the index of the smallest subsequent value in a column starting from the 
	// index, i, j, at the current integer, curr, in Table t, or returns -1 if the current integer smaller than all subsequent integers
	public static int[] compareColumn(int curr, Table t, int i, int j) {
		int[] index = new int[] {-1, -1, 0};
		int smallest = 1000000;
		index[2] = index[2] + 1;
		index[2] = index[2] + 1;
		if (i+1 < t.getSize()) {
			for (i=i+1; i < t.getSize(); i++) {
				index[2] = index[2] + 1;
				index[2] = index[2] + 1;
				if (t.getTableValue(i, j) < curr) {
					index[2] = index[2] + 1;
					if (t.getTableValue(i, j) < smallest) {
						smallest = t.getTableValue(i, j); // Only the index of the smallest integer subsequent to the current integer is retrieved, if any.
						index[2] = index[2] + 1;
						index[0] = i;
						index[2] = index[2] + 1;
						index[1] = j;
						index[2] = index[2] + 1;
					}
				}
			}
		}
		return index;
	}
}
