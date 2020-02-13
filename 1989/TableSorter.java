/*
 * @Author: <<author name redacted >>
 * @Purpose: This program is to check if a table is sorted, if not a method will try to sort the table
 * @Modifications: Created the isSorted method and sortable method added and counter to the sortable method to count the number of statements executed
 * to sort a given table
 * 
 */
import java.io.FileNotFoundException;
import java.io.IOException;

public class TableSorter {
	static int counter = 0;
	public static void main(String[] args) throws FileNotFoundException, IOException, Exception {
		
		Table t = Table.GetTable("Test");
		if(isSorted(t)) {
			System.out.println("Table is sorted.");
			System.out.println(t);
			return;
		}
		System.out.println("Table not sorted. Old table:");
		System.out.println(t);
		sortable(t);
		System.out.println("Sorted table:");
		System.out.println(t);
	}
	
	/*This method is to ensure that the given table t is sorted*/
	public static boolean isSorted(Table t) {
		/*Checking if rows are sorted*/
		for (int i = 0; i < t.getSize(); i++) {
			for (int j = 0; j < t.getSize()-1; j++) {
				if(t.getTableValue(i,j) > t.getTableValue(i,j+1)) {
					return false;
				}
			}
		}
		/*Checking if columns are sorted*/
		for (int i = 0; i < t.getSize(); i++) {
			for (int j = 0; j < t.getSize()-1; j++) {
				if(t.getTableValue(j,i) > t.getTableValue(j+1,i)) {
					return false;
				}
			}
		}
		return true;
	}
	
	/*This method is to sort the given table t*/
	public static void sortable (Table t) {
		/*Set the size of 1d array to N^2*/
		int[] sort1D = new int[t.getSize()*t.getSize()];
		counter++;
		
		
		/*Copy all elements of 2d array into 1d array*/
		int index = 0; 
		counter+=2 + t.getSize(); // this accounts for the i=0 and j=0 statements
		for (int i = 0; i < t.getSize(); i++) { 
			for (int j = 0; j < t.getSize(); j++) { 
				sort1D[index++] = t.getTableValue(i, j);
				counter+=5; // all statements for inner loop
			}
			counter+=4; // all statements that involve outer loop
		} // number of operations for above loops 4n+3+(n(2n+1)/2)+(n(2n-1)/2)+(n(n-1)) 
		
		//int ifCounter = 0; //to count the number of operations in the if statement
		/*Sort 1d array*/
		counter++; // i=0 statement
		counter+=t.getSize(); // j=0 statement
	    for (int i = 0; i < sort1D.length-1; i++) {
	    	for (int j = 0; j < sort1D.length-i-1; j++) {
	    		if (sort1D[j] > sort1D[j+1]) {
	    			int temp = sort1D[j]; 
	    			sort1D[j] = sort1D[j+1]; 
	    			sort1D[j+1] = temp;
	    	//		ifCounter+=4; // used for the equation version
	    			counter+=4; // all statements in the if statement
	    			}
	    		counter+=3; // all statements that involve the inner loop
	    	} 
	    	counter+=4; // all statements for outer loop
	    } // number of operations for above loops 4n1D+3+(2n1D(n1D+1)/2)+(n1D(n1D-1)/2)+ifCOunter
	    
		/*Copy 1d array back in to 2d array sorted*/
	    counter++; // i=0
	    counter+=t.getSize(); //j=0 statement
	    for(int i = 0; i < t.getSize(); i++) {
	        for(int j = 0; j < t.getSize(); j++) {
	        	t.setTableValue(i, j, sort1D[(t.getSize()*i) + j]);
	        	counter+=5; // all statements of inner loop
	        }
	        counter+=4; // all statements of outer loop
	    } // number of operations for above loops 4n+3+(n(2n+1)/2)+(n(2n-1)/2)+(n(n-1))
	    //int n = t.getSize(); // length of 2d array
		//int n1D = sort1D.length; // length of 1D array
		counter++; // for the if statement
	    if(isSorted(t)) { 
	    	//int numOfOperations = 2*((4*n+2) + ((n)*((2*n)+1)/2) + ((n)*((2*n)-1)/2) + (n*(n-1)) ) + ((4*n1D+3) + ((2*n1D)*(n1D+1)/2) + (n1D*(n1D-1)/2)) + ifCounter +3;
		    //System.out.println("The equation got: " + numOfOperations + " operations.");
		    System.out.println();
		    System.out.println("The counter got: " + counter + " operations.");
		    System.out.println();
	    	return;
	    }
	    else {
	    	System.out.println("Table failed to sort.");
	    }
	}
}
