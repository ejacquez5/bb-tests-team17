/**
 * CS5387 - Software V&V
 * Instructor: Dr Steve Roach
 * Student: <<author name redacted >>
 * 
 * This class is the solution for Homework 1.
 */
package cs5387;

public final class TableSorter {
	public int instrumentCounter = 0;
	/**
	 * The following method will return true for table sizes of 0 and 1. for all others,
	 * it will verify that the adjancent neighbor at the right or bottom are always greater. 
	 * This will ensure that the table is sorted
	 * @param t
	 * @return boolean 
	 */
	public boolean isSorted(Table t) {
		if (t == null) {
			System.out.println("TableSorter.isSorted: Invalid Input, table is null");
			return false;
		}
		int tableSize = t.getSize();
		if (tableSize < 0) {
			System.out.println("TableSorter.isSorted: Invalid Table Size");
			return false;
		} 
		else if (tableSize  <= 1) {
			return true;
		}
		for(int i = 1; i < tableSize; i++) {
			for (int j = 1; j < tableSize; j++) {
				if ( t.getTableValue(i, j - 1) > t.getTableValue(i, j)){
					return false;
				} 
				else if ( t.getTableValue(i -1, j) > t.getTableValue(i, j)) {
					return false;
				}
				else if ( t.getTableValue(i - 1, j - 1) > t.getTableValue(i - 1, j)){
					return false;
				}
				else if ( t.getTableValue(i - 1, j - 1) > t.getTableValue(i, j - 1)){
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * This method will first convert a table object into a int[][] type, since more generic types
	 * are easier to implement and troubleshoot. From, there, it will apply quick sort on all rows,
	 * since it is fast algorithm to use when sorting.Next, the it will create arrays type int[]
	 * from all columns and proceed to quicksort them as well. Once the column arrays are sorted, 
	 * the method will update the int[][] array with sorted columns, at this point we will have a
	 * sorted array. Finally we update the Table values with the sorted values of the matrix.
	 * @param t
	 */
	public static void sortable(Table t) {
		int localInstrumentCounter = 0;
		if (t == null || t.getSize() <= 0) {
			System.out.println("TableSorter.sortable: Invalid input, table cannot be sorted.");
			return;
		}
		localInstrumentCounter += 2;
		int tableSize = t.getSize();
		localInstrumentCounter += 1;
		if (tableSize < 0) {
			System.out.println("TableSorter.isSorted: Invalid Table Size");
			return;
		} 
		else if (tableSize  <= 1) {
			return;
		}
		localInstrumentCounter += 2;
		TableSorter sorter = new TableSorter();
		localInstrumentCounter += 1;
		int[][] matrix = sorter.getMatrixFromTable(t);
		localInstrumentCounter += 2;
		for(int i = 0; i < matrix.length; i++) {
			localInstrumentCounter += 2;
			sorter.quickSort(matrix[i], 0, matrix[i].length - 1);
			++localInstrumentCounter;
		}
		for (int j = 0; j < matrix.length; j++) {
			localInstrumentCounter += 2;
			int[] column = sorter.getColumnFromMatrix(matrix, j);
			++localInstrumentCounter;
			sorter.quickSort(column, 0, column.length - 1);
			++localInstrumentCounter;
			sorter.setSortedValuesIntoColumn(column, matrix, j);
			++localInstrumentCounter;
		}
		sorter.setSortedValues(matrix, t);
		++localInstrumentCounter;
		localInstrumentCounter += sorter.instrumentCounter;
		System.out.println("Table Size: " + t.getSize() 
			+ ", Instrumentation count is " + localInstrumentCounter);
	}
	
	/**
	 * This method will help the sortable method to insert the values of a given 
	 * column array into a matrix type int[][]
	 * @param source
	 * @param destination
	 * @param column
	 */
	private void setSortedValuesIntoColumn(int[] source, int[][] destination, int column) {
		if (source == null || destination == null) {
			System.out.println("Tablesorter.setSorterValuesIntoColumn: Invalid Parameters");
			return;
		} 
		this.instrumentCounter += 2;
		if (column < 0 || column > source.length || column > destination.length) {
			System.out.println("Tablesorter.setSorterValuesIntoColumn: Invalid Parameters");
			return;
		}
		this.instrumentCounter += 3;
		for(int i = 0; i < source.length; i++) {
			this.instrumentCounter += 2;
			destination[i][column] = source[i];
			this.instrumentCounter += 1;
		}
	}
	
	/**
	 * This method will retrieve a column as array to be later sorted using quicksort. It was
	 * decided to do this since it is easier to work with generic data types like int[] than dealing
	 * with the complexity of a table object
	 * @param matrix
	 * @param column
	 * @return int[]
	 */
	private int[] getColumnFromMatrix(int[][] matrix, int column) {
		if (matrix == null || column < 0 || column > matrix.length) {
			System.out.println("TableSorter.getColumnFromMatrix: Invalid Input");
			return null;
		}
		this.instrumentCounter += 3;
		int[] result = new int[matrix.length];
		this.instrumentCounter += 1;
		for (int i = 0; i < matrix.length; i++) {
			this.instrumentCounter += 2;
			result[i] = matrix[i][column];
			this.instrumentCounter += 1;
		}
		return result;
	}
	
	/**
	 * This method will retrieve a multi-dimensional array (matrix) from a Table, 
	 * the reason I chose this is because, it is easier to implement and work with 
	 * generic types like int[][] than with the more complex
	 * Table object
	 * @param table
	 * @return int[][]
	 */
	private int[][] getMatrixFromTable(Table table){
		if (table == null) {
			return null;
		}
		this.instrumentCounter += 1;
		int tableSize = table.getSize();
		this.instrumentCounter += 1;
		int[][] result = new int[tableSize][tableSize];
		this.instrumentCounter += 1;
		for (int i = 0; i < tableSize; i++) {
			this.instrumentCounter += 2;
			for (int j = 0; j < tableSize; j++) {
				this.instrumentCounter += 2;
				result[i][j] = table.getTableValue(i, j);
				this.instrumentCounter += 2;
			}
		}
		return result;
	}
	/**
	 * This method is used by sortable method once the multi-dimensional array (matrix) is sorted to
	 * be inserted into the original table object fed into the sortable method.
	 * @param source
	 * @param destination
	 */
	private void setSortedValues(int[][] source, Table destination) {
		if (source == null || destination == null) {
			System.out.println("TableSorter.setSortedValues: Invalid Parameters");
			return;
		}
		this.instrumentCounter += 2;
		if (source.length != destination.getSize()) {
			System.out.println("TableSorter.setSortedValues: Size of arrays do not match");
			return;
		}
		this.instrumentCounter += 2;
		for (int i = 0; i < source.length; i++) {
			this.instrumentCounter += 2;
			for (int j = 0; j < source[i].length; j++) {
				this.instrumentCounter += 2;
				destination.setTableValue(i, j, source[i][j]);
				this.instrumentCounter += 1;
			}
		}
	}

	/**
	 * Quicksort was the chosen algorithm to sort both rows and column arrays.
	 * @param array
	 * @param start
	 * @param end
	 */
	private void quickSort(int[] array, int start, int end) {
		int pivot = array[start + (end - start) / 2];
		this.instrumentCounter += 1;
		int i = start;
		this.instrumentCounter += 1;
		int j = end;
		this.instrumentCounter += 1;
		while (i  <= j) {
			this.instrumentCounter += 1;
			while (array[i] < pivot) {
				i++;
				this.instrumentCounter += 2;
			}
			while (array[j] > pivot) {
				j--;
				this.instrumentCounter += 2;
			}
			if (i <= j) {
				int tmp = array[i];
				array[i] = array[j];
				array[j] = tmp;
				i++;
                j--;
                this.instrumentCounter += 6;
			}
		}
		if (start < j) {
			quickSort(array, start, j);
			this.instrumentCounter += 2;
		}
		if (i < end) {
			quickSort(array, i, end);
			this.instrumentCounter += 2;
		}
	}
	/*
	 *  
	// The method below is used for debugging purposes
	private void printMatrx(int[][] matrix) {
		if (matrix == null || matrix.length == 0) {
			System.out.println("TableSorter.printMatrix - Invalid Input");
		}
		for(int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				//System.out.print(matrix[i][j] + " ");
				System.out.print("("+ i + "," +j + "): " + matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
	*/
}
