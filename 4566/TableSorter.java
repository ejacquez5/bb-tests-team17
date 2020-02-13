package cs5387;
//Name: <<author name redacted >>
//ID: <<author name redacted >>
//HW 1: Due 1/29/2020 before class
//Description: Purpose of the Homework was to pass an array of integers in which it will be sorted into a 2d array(a.k.a a table)
//from which we need to verify if the table is sorted already, or needs to be sorted. If it needs to be sorted we are given leeway
// on how it should be sorted, as long as the outcome is that both the row and columns are sorted in ascending order.

import java.io.*;

public class TableSorter {
	static int count = 0;
	
// The isSorted boolean method takes in a Table object and returns either true  or false, if it is false it calls in the sortable method
	public static boolean isSorted(Table t) {
		for(int row = 0; row < t.getSize(); row++) {
			for(int column = 0; column < t.getSize() - 1; column++) {
				if(t.getTableValue(row, column) > t.getTableValue(row, column + 1)) {
					sortable(t);
					return false;
				}	
			}
		}

		for(int column = 0; column < t.getSize(); column++) {
			for(int row = 0; row < t.getSize() - 1; row++) {
				if(t.getTableValue(row, column) > t.getTableValue(row + 1, column)) {
					sortable(t);
					return false;
				}
			}
		}
		return true;
	}

// sortable takes a table object that is not sorted and sorts it using bubble sort, key notes .getSize, .getTableValue, .setTableValue to help manipulate table
	public static void sortable(Table t) {
		count+= t.getSize();		// whenever t.getSize() is used count goes up
		int tempCounter = 0;		
		
			tempCounter += 3;		// for the 3 initialization of the for loops
		for(int row = 0; row < t.getSize(); row++) {
			tempCounter += 1;							// for the comparison
			tempCounter++;
			
			for(int k =0; k< t.getSize(); k++) { // added this for loop so you sort the row N times
				tempCounter++;						// for the comparison
				tempCounter++;						// for the incrementing of for loop
				tempCounter++;						// for the incrementing of for .getSize()	
				
				for(int column = 0; column < t.getSize() - 1; column++) {
					tempCounter++;					// for the comparison
					tempCounter++;					// for the incrementing of for loop
					tempCounter++;					// for the incrementing of for .getSize()
					
					if(t.getTableValue(row, column) > t.getTableValue(row, column + 1)) {
						count++;					// increased for comparison 
						tempCounter += 2;			// increased count by 2 for the .getTableValue comparison
						tempCounter++;				// for the incrementing of for .getSize()
						
							int temp = t.getTableValue(row, column);
							t.setTableValue(row, column, t.getTableValue(row, column + 1));
							t.setTableValue(row, column + 1, temp);
							
							tempCounter += 5; 							// increase count for the two .setTableValue, and the two .getTableValuse, and the assignment of the temp value
							count+= tempCounter;
							tempCounter = 0;
						}
					}
			}
		}

		tempCounter += 3;		// for the 3 initialization of the for loops
		for(int k =0; k< t.getSize(); k++) { // added this for loop so you sort the row N times
			tempCounter += 1;							// for the comparison
			tempCounter++;								// for the incrementing of for loop
			tempCounter++;								// for the incrementing of for .getSize()
			
			for(int column = 0; column < t.getSize(); column++) {
				tempCounter++;							// for the comparison
				tempCounter++;							// for the incrementing of for loop
				tempCounter++;								// for the incrementing of for .getSize()
				for(int row = 0; row < t.getSize() - 1; row ++) {
					tempCounter++;						// for the comparison
					tempCounter++;						// for the incrementing of for loop
					tempCounter++;								// for the incrementing of for .getSize()
					if(t.getTableValue(row, column) > t.getTableValue(row + 1, column)) {
						count++;					// increased for comparison 
						tempCounter += 2;			// increased count by 2 for the .getTableValue comparison
						
						int temp = t.getTableValue(row, column);
						t.setTableValue(row, column, t.getTableValue(row + 1, column));
						t.setTableValue(row + 1, column, temp);
						
						tempCounter += 5; 		// increase count for the two .setTableValue, and the two .getTableValuse, and the assignment of the temp value
						count+= tempCounter;
					}
				}
			}
		}
	
		System.out.println("The count is " + count);
		count = 0;
	}


	public static void main(String[] args) throws Exception {

		/**
		 * Test 1, all positve both row and column unsorted
		 */
		Table t = Table.GetTable("File.txt");
		System.out.println(t.toString());
		isSorted(t);
		System.out.println(t.toString());
//		System.out.println("test 1 is " + count);
				
		
		/**
		 * Test 2, negative included columns not sorted, rows are
		 */
		Table t2 = Table.GetTable("File2.txt");
		System.out.println(t2.toString());
		isSorted(t2);
		System.out.println(t2.toString());
		
		
		/**
		 * Test 3, rows are in order, columns are not
		 */
		Table t3 = Table.GetTable("File3.txt");
		System.out.println(t3.toString());
		isSorted(t3);
		System.out.println(t3.toString());
		
		/**
		 * Test 4, columns sorted, rows are not
		 */
		Table t4 = Table.GetTable("File4.txt");
		System.out.println(t4.toString());
		isSorted(t4);
		System.out.println(t4.toString());
		
		/**
		 * Test 5,partial sorted
		 */
		Table t5 = Table.GetTable("File5.txt");
		System.out.println(t5.toString());
		isSorted(t5);
		System.out.println(t5.toString());
		
		/**
		 * Test 6, all positive numbers sorted
		 */
		Table t6 = Table.GetTable("File6.txt");
		System.out.println(t6.toString());
		isSorted(t6);
		System.out.println(t6.toString());
		
		/**
		 * Test 7, all negative numbers unsorted
		 */
		Table t7 = Table.GetTable("File7.txt");
		System.out.println(t7.toString());
		isSorted(t7);
		System.out.println(t7.toString());
		
		/**
		 * Test 8, all negative numbers sorted
		 */
		Table t8 = Table.GetTable("File8.txt");
		System.out.println(t8.toString());
		isSorted(t8);
		System.out.println(t8.toString());
		
		/**
		 * Test 9, all same number 0
		 */
		Table t9 = Table.GetTable("File9.txt");
		System.out.println(t9.toString());
		isSorted(t9);
		System.out.println(t9.toString());
	}
}