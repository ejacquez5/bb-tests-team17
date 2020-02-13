/* Author: <<author name redacted >>
 * Title: Programming Assignment 2
 * Purpose: From assignment 2, count the amount of operations 
 * it takes to execute sort
 * 
 * Modifications: Adding a count for operations
 */
import java.util.*;
public class TableSorter {

	public static void main(String[] args) throws Exception{
		Scanner console = new Scanner(System.in);
		//Asks user to enter file without ".txt"
		System.out.println("Enter file name (exculde .txt)");
		String filename = console.next();
		
		//Use declaring type to create table object using filename
		Table t = Table.GetTable(filename+".txt");
		
		//Prints the table out
		for(int i = 0; i< t.getSize(); i++) {
			for(int j = 0;j < t.getSize(); j++ ) {
				System.out.print(t.getTableValue(i, j)+" ");
			}
			System.out.println();
		}	
		
		//isSorted(t) checks if the table is sorted
		if(!isSorted(t)) {
			System.out.println("The table is not sorted\n");
			//calling the method sorts the table
			sortable(t);
			//prints the now sorted method
			for(int i = 0; i< t.getSize(); i++) {
				for(int j = 0;j < t.getSize(); j++ ) {
					System.out.print(t.getTableValue(i, j)+" ");
				}
				System.out.println();
			}	
			
			//calls isSorted to confirm the table is now sorted
			System.out.println("The table is now sorted: " +isSorted(t)+ "\n");
		
		}
		else {
			System.out.println("The table is sorted\n");
		}
		
		
	console.close();
	}
	public static boolean isSorted(Table t) {
		//t.getSize()-1 to avoid array out of bounds
		for(int i = 0; i< t.getSize()-1; i++) {
			for(int j = 0;j < t.getSize()-1; j++ ) {
				/*checks if the element is greater than the element to the right of it or 
				 *  below it to determine if the table is ascending */
				if(t.getTableValue(i, j) > t.getTableValue(i, j+1) ||t.getTableValue(i, j) > t.getTableValue(i+1, j) )
					return false;
			}
		}	
		return true;
		
	}
	
	//sorts the table
	public static void sortable(Table t) {
		int count = 3; //function call of sortable initialization of x and the failed condition of the for loop     
		//Sorts the array from ascending order by rows first
		//x is go through the rows
		for(int x = 0; x< t.getSize(); x++) {
			count+=2; //for initialization of i and failed condition
			//i is for the columns
			for(int i = 0; i < t.getSize(); i++) {
				count+=2; //for initialization of j and failed condition
				//j is for the element to the right of i
				for(int j = i+1;j < t.getSize(); j++ ) {
					count+=3; //comparison operation and 2 function calls
					//checks if the element to the right is less, then swap
					if(t.getTableValue(x, i) > t.getTableValue(x, j)  ) {
						//swapping the elements
						count+= 4; //function calls
						int temp = t.getTableValue(x, i);
						t.setTableValue(x, i, t.getTableValue(x, j) );
						t.setTableValue(x, j, temp );
						count++; //assignment statement
					} 
					count++; //branch
				} 
				count++; //branch 
			}	
			count++; //branch
		}
		
		count +=3; //initialization and failed condition of x and branch
		//Sorts the array going through the columns
		//x is the columns
		for(int x = 0; x< t.getSize(); x++) {
			count+=2; //initialization of i and failed condition
			//i is for the current row
			for(int i = 0; i < t.getSize(); i++) {
				count+=2; //initialization of j and failed condition
				//j is for the element under i
				for(int j = i+1; j < t.getSize(); j++) {
					count+=3; //comparison operation and 2 function calls
					//checks if the element in the row is ascending
					if(t.getTableValue(i, x) > t.getTableValue(j, x)  ) {
						count+=4; //function calls
						//swaps if the element under is less than the current
						int temp = t.getTableValue(i, x);
						t.setTableValue(i, x, t.getTableValue(j, x) );
						t.setTableValue(j, x, temp );
						count++; //assignment
					}
					count++;   //branch
				}	
				count++;   //branch
			}	
			count++;       //branch
		}
		count++; //branch
		System.out.println("\n\nNumber of operations to execute sort is: "+count+ "\n\n");
	}
}

