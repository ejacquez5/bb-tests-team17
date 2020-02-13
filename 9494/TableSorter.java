/**
 * CS5387 Programming Assignment 2:
 * After creating the TableSorter class from Assignment 1,
 * count the number of operations required to execute Sort.
 * 
 * @author	<<author name redacted >>
 * @version 1.1
 * @since	02-03-2020
 */

package cs5387;

public class TableSorter {
	public static int counter = 0;

	public static void main(String args[]) throws Exception {
		//create an array that contains the values of table
		/*
		int[] tableVal = {9,1,8,2,7,3,6,4,5,1,9,2,8,3,7,4};
		//int[] tableVal = {1,1,2,2,3,3,4,4,5,5,6,6,7,7,8,9};
		//create an instance of table
		//NxN
		int n = 16;
		Table t = new Table(n, tableVal);
		*/

		/****************************************
		 * TEST CASE 1
		 * Checking functions with an input file
		 ****************************************
		 */

		//Send file name with table
		//This file is separate, will provide with submission
		String f = "C:\\Users\\steph\\OneDrive\\Documents\\testTable.txt";
		Table t2 = Table.GetTable(f);

		//print table from file
		System.out.println("Printing table from file");
		printTable(t2);


		System.out.println();
		boolean sortedTable = isSorted(t2);
		System.out.println("Check if table is sorted...");
		System.out.println("Result: " + sortedTable + "\n");

		//sort table
		System.out.println("Sorting table...");
		sortable(t2);
		
		//Print counter result
		System.out.println("\nPrint operations counter: " + counter + "\n");

		//print table from file after sorting
		System.out.println("Printing sorted table:");
		printTable(t2);

		System.out.println();
		sortedTable = isSorted(t2);
		System.out.println("Check again if table is sorted...");
		System.out.println("Result: " + sortedTable + "\n");
		

		//only using one test case 
		
		/****************************************
		 * TEST CASE 2
		 * Checking functions with a given array
		 ****************************************
		 */

		/*
		//print table created
		System.out.print("Input table\n");
		printTable(t);

		boolean sortedTable2 = isSorted(t);
		System.out.println("\nCheck if table is sorted");
		System.out.println("Result: " + sortedTable2);

		//sort table
		System.out.println("\nSorting table...");
		sortable(t);

		//print sorted table
		System.out.print("Sorted table:\n");
		printTable(t);

		//Check again if sorted
		sortedTable2 = isSorted(t);
		System.out.println("\nCheck again if table is sorted");
		System.out.println("Result: " + sortedTable2);
		*/
	}

	public static boolean isSorted(Table t) {
		//Variable to store result of checks
		boolean result = true;
		counter++;

		//Variable to know when to stop traversing table
		//Check size of table by using Table.java method
		int size = t.getSize();
		counter++;
		
		int r;
		counter++;
		int c;
		counter++;

		//For loops to traverse table's rows and columns
		for(r = 0; r < size-1; r++) {
			counter++; //for loop branch
			counter++; //r++
			counter++; //size-1
			for(c = 0; c < size-1; c++) {
				counter++; //for loop branch
				counter++; //c++
				counter++; //size-1
				//Check rows
				//If at last character make sure you don't go out of bounds
				
				counter++; //if statement
				counter++; //r+1
				counter++; //function call 1
				counter++; //function call 2
				if(t.getTableValue(r, c) > t.getTableValue(r+1, c)) {
					counter++;
					result = false;
					counter++;
				} else {
					result = true;
					counter++;
				}
				//Check columns
				counter++; //if statement
				counter++; //c+1
				counter++; //function call 1
				counter++; //function call 2
				if(t.getTableValue(r, c) > t.getTableValue(r, c+1)) {
					counter++;
					result = false;
					counter++;
				} else {
					result = true;
					counter++;
				}
			}
		}
		return result;
	}

	public static void sortable(Table t) {
		//Sort by rows first
		sortRows(t);
		counter++;

		//After sorting rows get transpose
		//This is to get the column values
		getTranspose(t);
		counter++;

		//Call row sort again
		//With transpose, rows are the columns
		sortRows(t);
		counter++;

		//After sorting, set the table back 
		getTranspose(t);
		counter++;
	}

	public static void getTranspose(Table t) {
		int size = t.getSize();
		counter++;

		//Temporary variable to swap values when transposing
		int temp = 0;
		counter++;
		//Store value to swap
		int toSwap = 0;
		counter++;

		int r;
		counter++;
		int c;
		counter++;
		
		for(r = 0; r < size; r++) {
			counter++; //for loop branch
			counter++; //r++
			for(c = 0; c < size; c++) {
				counter++; //for loop branch 
				counter++; //c++
				temp = t.getTableValue(r, c);
				counter++;
				toSwap = t.getTableValue(c, r);
				counter++;
				t.setTableValue(r, c, toSwap);
				counter++;
				t.setTableValue(r, c, temp);
				counter++;
			}
		}
	}

	//Class to sort Rows
	//This will help to sort columns later as well
	public static void sortRows(Table t) {
		//Variable to know when to stop traversing table
		//Check size of table by using Table.java method
		int size = t.getSize();
		counter++;

		//create a temporary variable to store values that are being swapped
		//One will store the greater value the other will store the lower value
		int greater = 0;
		counter++;
		int less = 0;
		counter++;
		
		int r;
		counter++;
		int c;
		counter++;
		

		for(r = 0; r < size-1; r++) {
			counter++; //for loop branch 
			counter++; //r++
			for(c = 0; c < size; c++) {
				counter++; //for loop branch 
				counter++; //c++
				
				//Sort rows first
				counter++; //if
				counter++; //function call 1
				counter++; //function call 2
				if(t.getTableValue(r, c) > t.getTableValue(r+1, c)) {
					counter++; //after if
					counter++; //r+1
					
					//get value of r since it is greater
					greater = t.getTableValue(r, c);
					counter++;
					//Save the value at r+1 before swapping
					less = t.getTableValue(r+1, c);
					counter++; //function call
					counter++; //r+1
					
					//Swap values r+1 will now have the value of r
					//r will now have the value of r+1
					t.setTableValue(r+1, c, greater);
					counter++; //function call
					counter++; //r+1
					
					t.setTableValue(r, c, less);
					counter++;
				}
			}
		}
	}

	public static void printTable(Table t) {
		for (int r=0; r< t.getSize(); r++) {
			for (int c=0; c< t.getSize(); c++) {
				System.out.print(t.getTableValue (r, c) + " ");
			}
			System.out.println();
		}
	}
}

