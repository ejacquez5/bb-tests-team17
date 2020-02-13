package cs5387;

import java.io.*;

public class TableSort {
	
	public static void main(String[] args) throws Exception {
		File testInput = new File("TestTable"); //looking for specific filename
		Table t = Table.GetTable(testInput);    //creating table type to access table data

		System.out.print(t.getTableValue(0, 0)); //Print out unsorted table
		System.out.print(t.getTableValue(0, 1));
		System.out.print(t.getTableValue(0, 2));
		System.out.println(" ");
		System.out.print(t.getTableValue(1, 0));
		System.out.print(t.getTableValue(1, 1));
		System.out.print(t.getTableValue(1, 2));
		System.out.println(" ");
		System.out.print(t.getTableValue(2, 0));
		System.out.print(t.getTableValue(2, 1));
		System.out.print(t.getTableValue(2, 2));
		System.out.println(" ");

		sortable(t); //Sorting method for table

		System.out.println(" ");
		System.out.print(t.getTableValue(0, 0)); //Print out sorted table
		System.out.print(t.getTableValue(0, 1));
		System.out.print(t.getTableValue(0, 2));
		System.out.println(" ");
		System.out.print(t.getTableValue(1, 0));
		System.out.print(t.getTableValue(1, 1));
		System.out.print(t.getTableValue(1, 2));
		System.out.println(" ");
		System.out.print(t.getTableValue(2, 0));
		System.out.print(t.getTableValue(2, 1));
		System.out.print(t.getTableValue(2, 2));
		System.out.println(" ");
		
		TableSort result = new TableSort();  //Result to see if Table is sorted in ascending order
		boolean isTableSorted = result.isSorted(t);
		System.out.print(isTableSorted);
	}
	
	//Method checks to see if table is sorted in ascending order by row and columns
	public boolean isSorted(Table t) {
		for (int row = 0; row < t.getSize(); row++) { //Check each row to see if sorted
			for (int col = 0; col < t.getSize() - 1; col++) {
				if (t.getTableValue(row, col) > t.getTableValue(row, col + 1)) {
					return false;
				}
			}
		}
		
		for (int col = 0; col < t.getSize(); col++) {
			for (int row = 0; row < t.getSize() - 1; row++) { //Check each column to see if sorted
				if (t.getTableValue(row, col) > t.getTableValue(row + 1, col)) { //check value against next value
					return false;
				}
			}
		}
		return true;
	}
	
	//Method sorts the rows first, then will sort the columns once rows are sorted
	public static void sortable(Table t) {
		int branch = 0, func = 0, assi = 0, comp = 0;
		assi++; //for declaration of variable in for loop
		func++; //for the sortable method call
		for (int row = 0; row < t.getSize(); row++) { //Sorting each row
			branch++; //for loop branch
			comp++;   //for loop comparison
			func++;   //function call to getSize
			int colCheck = 0;    //Allows multiple passes in a single row
			assi++; //for colCheck
			while (colCheck < t.getSize()) {
				branch++; //for the while loop
				comp++; //colCheck comparison
				func++; //function call to getSize
				assi++; //for declaration of col
				for (int col = 0; col < t.getSize() - 1; col++) {
					branch++; //for the for loop
					comp++; //col comparison
					func++; //function call to getSize
					if (t.getTableValue(row, col) > t.getTableValue(row, col + 1)) { //BubbleSort of each row
						branch++; //for the if
						comp++; //comparison of the if
						func++; //function call to getTableValue
						func++; //function call to getTableValue
						int temp = t.getTableValue(row, col);
						assi++; //temp
						func++; //function call to getTableValue
						t.setTableValue(row, col, t.getTableValue(row, col + 1));
						func++; //function call to setTableValue
						func++; //function call to getTableValue
						t.setTableValue(row, col + 1, temp);
						func++; //function call to setTableValue
					}
					branch++; //for if loop not being taken
				}
				assi++; //for col++
				branch++; //for the for loop not being taken
				colCheck++; //increment the check
				assi++; //for colCheck++
			}
			branch++; //if while loop not taken
			assi++; //row++ counted
		}
		branch++; //if for loop not taken
		
		assi++; //for declaration in for loop
		for (int col = 0; col < t.getSize(); col++) { //Sorting each column
			branch++; //for the for loop
			comp++; //for col comparison
			func++; //function call getSize
			int rowCheck = 0;    //Allows multiple passes in a single column
			assi++; //rowCheck counted
			while (rowCheck < t.getSize()) {
				branch++; //for the while loop
				comp++; //comparison of rowCheck
				func++; //function call getSize
				assi++; //declaration of row in for loop
				for (int row = 0; row < t.getSize() - 1; row++) {
					branch++; //for the for loop
					comp++; //row comparison
					func++; //function call getSize
					if (t.getTableValue(row, col) > t.getTableValue(row + 1, col)) { //BubbleSort of each column
						branch++; //for the if
						comp++; //comparison of if
						func++; //function call getTableValue
						func++; //function call getTableValue
						int temp = t.getTableValue(row, col);
						assi++; //for temp
						func++; //function call getTableValue
						t.setTableValue(row, col, t.getTableValue(row + 1, col));
						func++; //function call setTableValue
						func++; //function call getTableValue
						t.setTableValue(row + 1, col, temp);
						func++; //function call setTableValue
					}
					branch++; //for if
				}
				rowCheck++;
				assi++; //for rowCheck
				assi++; //for row
				branch++; //for the for loop
			}
			branch++; //for the while loop
			assi++; //for col
		}
		branch++; //for the for loop
		System.out.println(" ");
		System.out.println("Function count: " + func);
		System.out.println("Assignment count: " + assi);
		System.out.println("Branch count: " + branch);
		System.out.println("Comparison count: " + comp);
		System.out.println("Total: " + (func + assi + branch + comp));
	}
}