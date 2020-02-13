//package cs5387;
/**
 * Author: <<author name redacted >>
 * Version: 2.0
 * Date: February 3, 2020
 * The Java class TableSorter contains two instance methods: 
 * 1. public boolean isSorted(Table t) returns true if every row and every column of the table t is sorted in ascending order
 * 2. public static void sortable (Table t) sorts a Table so that isSorted() is true.
 * The main method was added to test the code and make sure it is working properly 
 * This code will also count the operations 
**/

public class TableSorter{

	// The following method checks that the Table t is sorted and returns true if it is and false it it is not
	public boolean isSorted(Table t) {
		// total operation count. Each assignment, comparison or function call will add 1.
		int operationCount = 0;
		// getting table size for the range
		int range = t.getSize();
		// Starting at the beginning of the table and checking through it to see if it is sorted
		int previous = t.getTableValue(0, 0);
		operationCount+=4;
		for (int r = 0; r < range; r++){
			operationCount+=2;
			for (int c=0; c<range-1; c++){
				operationCount+=2;
				// if it is sorted we return true
				if(previous < t.getTableValue(r, c)){
					operationCount+=2;
					return true;
				}
			}
		}
		// the 2 is for the r = 0 and c = 0 since we only set it once
		operationCount+=2;
		System.out.println("Total operations for isSorted is: " + operationCount);
		// if it is not true, it will return false
		return false;
	}

	// The following method sorts the table in ascending order using a bubble sort
	public static void sortable(Table t){
		// total operation count. Each assignment, comparison or function call will add 1.
		int operationCount = 0;
		int temp;
		int n=t.getSize();
		operationCount+=3;
		// Sort rows of the table
		for(int i = 0; i < n; i++){
			operationCount+=2;
			for(int j = 0; j < n-1; j++){
				operationCount+=2;
				for(int k = 0; k < n-j-1; k++){
					operationCount+=2;
					if(t.getTableValue(i,k)>t.getTableValue(i,k+1)){
						temp = t.getTableValue(i,k);
						t.setTableValue(i, k, t.getTableValue(i, k+1));
						t.setTableValue(i, k+1, temp);
						operationCount+=8;
					}
				}
			}
		}
		// Sort column of the table
		for(int i = 0; i < n; i++) {
			operationCount+=2;
			for (int j = 0; j < n-1; j++) {
				operationCount+=2;
				for (int k = 0; k < n-j-1; k++) { 
					operationCount+=2;
					if(t.getTableValue(k, i) > t.getTableValue(k+1, i)) {
						temp = t.getTableValue(k, i);
						t.setTableValue(k, i, t.getTableValue(k+1, i));
						t.setTableValue(k+1, i, temp);
						operationCount+=8;
					}
				}
			} 
		}
		operationCount+=6;
		System.out.println("Total operations: sortable is: " + operationCount);
	}
	
	// The following is the main method to run the above code and test it
	public static void main(String args[]){
		//The following is the array used to test
		int[] values = { 9, 2, 3, 1, 5, 2, 7, 8, 1};
		try {
			// using values.length instead of hard coded value for the size of the array
			Table t = new Table(values.length, values);
			// Outputting the boolean value to check if it is sorted before sorting
			System.out.println("Is the table sorted: " + new TableSorter().isSorted(t));
			// Outputting the unsorted table
			System.out.println("Unsorted:");
			for(int i = 0; i < t.getSize(); i++) {
				for(int j = 0; j < t.getSize(); j++) {
					if(j != t.getSize()-1) {
						System.out.print(t.getTableValue(i, j) + " ");
					}
					else {
						System.out.println(t.getTableValue(i, j));
					}
				}
			}
			// outputting the sorted Table
			System.out.println("Sorted:");
			TableSorter.sortable(t);
			for(int i = 0; i < t.getSize(); i++) {
				for(int j = 0; j < t.getSize(); j++) {
					if(j != t.getSize()-1) {
						System.out.print(t.getTableValue(i, j) + " ");
            		}
            		else {
            			System.out.println(t.getTableValue(i, j));
            		}
            	}
			}
			//Outputting boolean value to check if it is sorted after sorting it
			System.out.println("Is the table sorted: " + new TableSorter().isSorted(t));
		}
		 catch (Exception e) {
			e.printStackTrace();
		}   
	}
}