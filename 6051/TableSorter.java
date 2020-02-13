package cs5387;
/*
 * Author: <<author name redacted >>
 * Class: Software Integration and Verification & Validation
 * Date: January 29, 2020
 */
public class TableSorter {
	private static int counter;
	
	public TableSorter(){
		counter = 0;
	}
	
	/**
	 * tempValue is a variable that is being compared against and where the loop is currently in the array
	 * Changes tempValue2 to compare against tempValue one row or one column place over
	 * if tempValue is smaller than current tempValue2 one is added to sorted int variables 
	 * if the array is sorted in ascending order all three sorted int variables will be equal to size
	 * SortedByRow is equal to how many of the values in the current row are ascending by row
	 * SorteByColumn is equal to how many of the values in the current row are ascending by column
	 * SortedByTable is equal to how many of the rows in the table are sorted in ascending order
	 * @param t
	 * @return sorted 
	 */
	public static boolean isSorted(Table t) {
		int size = t.getSize();
		counter += 2;
		int sortedByRow = 0, sortedByColumn = 0, sortedTable = 0;
		counter += 3;
		boolean sorted= false;
		counter++;
		
		for(int i=0; i< size;i++) {
			counter += 2;
			int tempValue, tempValue2;
			int row, column;
			for(int j=0; j< size; j++) {
				counter += 2;
				tempValue = t.getTableValue(i, j);
				counter += 2;
				if(!(j== size-1)) {
					counter++;
					row= i+1;
					counter++;
					column = j;
					counter ++;
					
					tempValue2 = t.getTableValue(row, column);
					counter += 2;
					if(tempValue < tempValue2)
						sortedByRow ++;
					counter += 2;
				}else
					sortedByRow ++;
				
				if(!(i== size-1)){
					counter++;
					row = i;
					counter++;
					column = j+1;
					counter ++;
					tempValue2 = t.getTableValue(row, column);
					counter += 2;
					if(tempValue< tempValue2)
						sortedByColumn++;
					counter++;
				}else
					sortedByColumn = size;
				
				counter++;
				
				if(sortedByRow == size && sortedByColumn == size)
					sortedTable++;
				
				counter += 3;
			}
		}
		if(sortedTable == size)
			sorted = true;
		
		counter += 2;
		return sorted;
	}


	/**
	 * Sorts a Table
	 * Goes through the table one value at a time compares it against another value 
	 * Organizes them in ascending order.
	 * @param t
	 */
	public static void sortable(Table t) {
		int size = t.getSize();
		counter += 2;
		
		while(!isSorted(t)) {
			counter +=2;
		for(int i=0; i< size;i++) {
			counter += 2;
			int tempValue, tempValue2;
			int row, column;
			
			for(int j=0; j< size; j++) {
				counter +=2;
				tempValue = t.getTableValue(i, j);
				counter += 2;
				
				if(j== size-1) {
					counter ++;
					row= i+1;
					counter++;
					column = 0;
					counter++;
				}else {
					row = i;
					counter++;
					column = j+1;
					counter++;
				}
				
				tempValue2 = t.getTableValue(row, column);
				counter += 2;
				if(tempValue > tempValue2) {
					counter++;
					t.setTableValue(row, column, tempValue);
					counter++;
					t.setTableValue(i, j, tempValue2);
					counter++;
				}
			}
			}
		}
		
	}

	public static int getCounter() {
		return counter;
	}
	
	
}
