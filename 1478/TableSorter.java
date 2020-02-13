package cs5387;

/*<< author name redacted>>, CS4387
 * This program is created to give the capability of sorting
 * a table of NxN size and checking if an NxN size table it 
 * is sorted.
 */
public class TableSorter {
	//A public global counter is used to facilitate the count of each operation being done.
	public static int count = 0;
	/*This main method is used to call the methods necessary to calculate the total operations
	 * of the sort. The isSorted was also modified in case of future need to calculate the operations
	 * done in the verification of the table being sorted correctly.
	*/
	public static void main(String [] args) {
		try {
			Table table = Table.GetTable("fileTable.txt");
			sortable(table);
			count++;
			System.out.println(count);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	/*Checks if table is Sorted by traversing the 
	 *columns then rows, checking the current value with the previous value
	 *by starting in the 2nd value of each column or row. This was done for 
	 *each NxN table larger than 1, for which the table is
	 *assumed to have each position with a valid value.
	 */
	public static boolean isSorted(Table t) {
		/*If table has the sqrt of 1 then it can only have one 
		 *value and is still an NxN table
		 */
		if(t.getSize() == 1) {
			count++;
			return true;
		}
		count++;
		boolean sorted = true;
		count++;
		//checks if each columns is sorted
		for(int r = 0; r < t.getSize(); r++) {
			count++;
			for(int c = 1; c< t.getSize(); c++) {
				count++;
				if((t.getTableValue(r, c) < t.getTableValue(r, c-1))) {
					count++;
					sorted = false;
					count++;
				}//if
				count++;
			}//for(c)
		}//for(r)
		
		//Checks if each row is sorted
		for(int c = 0; c < t.getSize(); c++) {
			count++;
			for(int r = 1; r< t.getSize(); r++) {
				count++;
				if(t.getTableValue(r, c) > t.getTableValue(r - 1, c)) {
					count++;
					sorted = false;
					count++;
				}//if
				count++;
			}//for(r)
		}//for(c)
		return sorted;
	}
	
	/*Assumes table is of size 2 or more and NxN.
	 * Begins with the second number and checks the 
	 * current value with the previous value of the column or 
	 * row which is being checked. * Bubble Sort.
	 */
	public static void sortable(Table t) {
		//rowOrCOl for sortValue method, to show if sorting Column value or row Value
		boolean rowOrCol;
		count++;
		boolean isSorted = false;
		count++;
		int size = t.getSize();
		count++;
		if(size > 1) {
			count++;
		while(!isSorted) {
			count++;
			isSorted = true;
			count++;
			//Sorts the columns in the table
			for(int c = 0; c<size; c++) {
				for(int r = 1; r<size; r++) {
					if(t.getTableValue(r-1, c) < t.getTableValue(r, c)) {
						count++;
						rowOrCol = true;
						count++;
						sortValue(r, c,rowOrCol, t);
						count++;
						isSorted = false;
						count++;
					}//if
					count++;//if
					count+=3;//for
				}//for(r)
				count++; // for alternate
				count+=3; //for
			}//for(c)
			count++;//for alternate route
			
			
			//Sorts the rows in the table
			for(int r = 0; r < size; r++) {
				
				for(int c = 1; c< size; c++) {
					count++;
					if(t.getTableValue(r, c-1) > t.getTableValue(r, c)) {
						count++;
						rowOrCol = false;
						count++;
						sortValue(r, c,rowOrCol, t);
						count++;
						isSorted = false;
						count++;
					}//if
					count++; //if
				}//for(c)
				count++; //for alternate
				count+=3; //for
			}//for(r)
			count++;//for alternate
			count+=3; //for
		}//While()
		count++; //while alternate
		}
		count++; //if alternate
	}
	
	public static void sortValue(int r, int c, boolean rowOrCol, Table t) {
		/*True if moving value up in column, false if moving value in row
		 * Bubble sort.
		 */
		if(rowOrCol) {
			count++;
			int smallValue = t.getTableValue(r-1, c);
			count++;
			int largeValue = t.getTableValue(r, c);
			count++;
			t.setTableValue(r-1, c, largeValue);
			count++;
			t.setTableValue(r, c, smallValue);
			count++;
			
		}else {
			count++;
			int largeValue = t.getTableValue(r, c-1);
			count++;
			int smallValue = t.getTableValue(r, c);
			count++;
			t.setTableValue(r, c, largeValue);
			count++;
			t.setTableValue(r, c-1, smallValue);
			count++;
		}
		count++;
	}
}
