import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author <<author name redacted >>
 * @purpose The purpose of this code is to check if a table is sorted. If it is,
 *          the user will be told the table is already sorted. If not, then it
 *          sorts it and checks once again if it was successfully sorted.
 * @modifications Created the TableSorter java file and edited array.txt for
 *                testing.
 */

public class TableSorter {
	static int count = 0;
	
	public static void main(String[] args) throws FileNotFoundException, IOException, Exception {

		Table f = Table.GetTable("array.txt"); // Getting table

		System.out.println("Original Table: ");
		System.out.println(f); // printed the original table
		System.out.println("Is Sorted  = " + isSorted(f)); // printed the output of isSorted

		/**
		 * Check if already sorted.
		 **/
		if (isSorted(f) == true) {
			System.out.println("Table is already sorted.");
			return;
		} else {
			System.out.println();
			System.out.println("Sorting...");
			sortable(f);
			System.out.println("Is Sorted  = " + isSorted(f)); // printed the output of isSorted
		}
		System.out.println("Number of operations = " + count);

	}

	/**
	 * This method is checking if the table t is sorted.
	 * 
	 * @throws Exception
	 **/
	public static boolean isSorted(Table t) throws Exception {

		/**
		 * This part is checking if the table t is sorted. If not, it immediately
		 * returns false.
		 **/
		for (int row = 0; row < t.getSize() - 1; row++) {
			for (int col = 0; col < t.getSize() - 1; col++) {
				if (t.getTableValue(row, col) > t.getTableValue(row, col + 1)) {
					return false;
				}
			}
		}
		// System.out.println("Each row is in ascending order! Now checking for
		// columns.");

		/**
		 * In this part I transposed a copy of the original matrix to check if the
		 * columns are sorted.
		 **/
		for (int row = 0; row < t.getSize(); row++) {
			for (int col = row + 1; col < t.getSize(); col++) {
				int temp = t.getTableValue(row, col);
				t.setTableValue(row, col, t.getTableValue(col, row));
				t.setTableValue(col, row, temp);
			}
		}
		// System.out.println("Transposed Table: ");
		// System.out.println(t);// I print my new table to verify it was in fact
		// transposed.

		/**
		 * This part is checking if the transposed matrix is sorted. If not, it
		 * immediately returns false.
		 **/
		for (int row = 0; row < t.getSize() - 1; row++) {
			for (int col = 0; col < t.getSize() - 1; col++) {
				if (t.getTableValue(row, col) > t.getTableValue(row, col + 1)) {
					return false;
				}
			}
		}

		return true; // returns true if every row and every column of the table t is sorted in
						// ascending order
	}// end of isSorted

	/**
	 * This method sorts a table.
	 **/
	public static void sortable(Table t) {
		/**
		 * This part sorts each row in ascending order.
		 **/
		
		System.out.println("Transposed Matrix: ");
		System.out.println(t);

		System.out.println("Step 1: Sort transposed(columns) matrix : ");
		int n = t.getSize();
		count ++; //this count is from row = 0;
		count += n; //this count is for the col = 0
		count += n*n; //this count is for pos = 0;
		count +=3; // Add 3 for the failed check cases of the loops
		for (int row = 0; row < t.getSize(); row++) {//
			
			for (int col = 0; col < t.getSize(); col++) { //count = 3
				
				for (int pos = 0; pos < t.getSize() - 1; pos++) { //count = 3
				
					if (t.getTableValue(row, pos) > t.getTableValue(row, pos + 1)) { // count = 2
						
						int temp = t.getTableValue(row, pos);
						
						t.setTableValue(row, pos, t.getTableValue(row, pos + 1));
						t.setTableValue(row, pos + 1, temp);
						count+=8;
					}
					count = count + 3;

				}
				count = count + 3;
			}
			count += 3;
		}
		System.out.println(t);

		/**
		 * This part transposes the matrix.
		 **/
		System.out.println();
		System.out.println("Step 2: Transposed back to original. ");
		count ++;
		count += n;
		count+=2;
		for (int row = 0; row < t.getSize(); row++) {
			for (int col = row + 1; col < t.getSize(); col++) {
				int temp = t.getTableValue(row, col);
				t.setTableValue(row, col, t.getTableValue(col, row));
				t.setTableValue(col, row, temp);
				count = count + 3;
			}
			count = count + 3;
		}

		System.out.println(t);

		/**
		 * This part sorts the matrix.
		 **/
		System.out.println();
		System.out.println("Step 3: Sort original(rows) matrix");
		count ++;
		count += n;
		count += n*n;
		count+=3;
		for (int row = 0; row < t.getSize(); row++) {
			for (int col = 0; col < t.getSize(); col++) {
				for (int pos = 0; pos < t.getSize() - 1; pos++) {
					if (t.getTableValue(row, pos) > t.getTableValue(row, pos + 1)) {
						int temp = t.getTableValue(row, pos);
						t.setTableValue(row, pos, t.getTableValue(row, pos + 1));
						t.setTableValue(row, pos + 1, temp);
						count+=8;
					}
					count = count + 3; // counting the first for loops  < & . & /row++
				}
				count = count + 3; //counting the second for loops  < & . & col++
			}
			count = count + 3; //counting the first for loops  < & . & /pos++
		}
		System.out.println(t);
	}// end of Sortable

}
