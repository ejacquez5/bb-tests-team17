package cs4387;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author <<author name redacted >>
 * 
 * Purpose of this class is to implement two methods sortable and isSorted
 * They sort a table and ensure a table is sorted
 *
 * Sorting algorithm can be optimized in further revisions
 * 
 */

public class TableSorter {
	
	public static int counter =0;
	
	public static Table sortable(Table t) throws Exception {
		int count =0 ;
		int[][] tempTable = tableConverter(t);
		count += 2; //assignment + function call
		int[] tempArray = oneDimension(tempTable);
		count +=2 ; //assignment + function call

        //Sort the 1D array in ascending order   
		//Found this more convenient to ensure array is sorted both row and column wise, should also be easier to optimize
        for (int i = 0; i < tempArray.length; i++) { 
        	count +=1 ; //loop
            for (int j = i+1; j < tempArray.length; j++) {   
            	count +=1; //loop
               if(tempArray[i] > tempArray[j]) {  
            	   count +=1 ; //branch for if statment
                   int temp = tempArray[i];    
                   tempArray[i] = tempArray[j];    
                   tempArray[j] = temp;    
               }  
               count += 1 ; //branch if doesn't use if statement
            }     
        }
        count+=1; //branch out of the loop
        
        //Place values of 1D array back in the table
        int counter = 0;
        count +=1 ; // aassignment
        for (int i =0 ; i < t.getSize(); i++) {
        	count += 1;//loop
        	for (int j = 0; j < t.getSize(); j++) {
        		t.setTableValue(i, j, tempArray[counter]);
        		counter++;
        		count +=1 ; //loop
        	}
        	
        }
        count += 1; //branch out of loop
        TableSorter.setCounter(count);
        return t;
        
		
	}
	
	//Convert the object Table into a 2D array for sorting
	public static int[][] tableConverter(Table t){
		int[][] tempTable = new int[t.getSize()][t.getSize()]; 
		for(int i = 0 ; i < tempTable.length ; i++) {
			for(int j=0; j < tempTable[i].length ; j++) {
				tempTable[i][j] = t.getTableValue(i, j);
			}
		}
		
		return tempTable;
		
	}
	
	//Convert 2D array to 1D for sorting
	public static int[] oneDimension(int[][] tempTable) {
		int[] tempArray = new int[tempTable.length * tempTable.length];
		int index =0;
			for(int j =0 ; j < tempTable.length; j++) {
				for(int k =0 ; k < tempTable.length; k++) {
					tempArray[index] = tempTable[j][k];
					index++;
					
					
				}
			}
		return tempArray;
	}
	
	//Checks to see if table is sorted. Will do this by checking the sort on the 1D array values of the table
	public static boolean isSorted(Table t) {
		int[][] tempArray = tableConverter(t);
		int[] sortedArray = oneDimension(tempArray);
		boolean check = true;
		for(int i =1; i < sortedArray.length; i++) {
			if(sortedArray[i-1] > sortedArray[i]) {
				check = false;
				break;
			}

		}
		return check;
	}

	
	//helper method to print the table
	public static void printer(Table t) {
		int[][] tempTable = tableConverter(t);

		for(int i = 0; i<tempTable.length; i++)
		{
		    for(int j = 0; j<tempTable[i].length; j++)
		    {
		        System.out.print(tempTable[i][j] + " ");
		    }
		    System.out.println();
		}
	}
	
	//setter for the operations counter
	public static void setCounter(int counter) {
		
		TableSorter.counter = counter;
	}
	
	public int getCounter() {
		
		return TableSorter.counter;
	}
	
	//Count the number of total operations
	public static void main(String[] args) throws FileNotFoundException, IOException, Exception {
		Scanner input = new Scanner(System.in);
		System.out.println("Please input the file location: ");
		String location = input.next();
		Table table = Table.GetTable(location);
		Table newTable = TableSorter.sortable(table);
		System.out.println("Sorted Table Below!");
		TableSorter.printer(newTable);
		boolean check = TableSorter.isSorted(table);
		System.out.print("Table is sorted: ");
		System.out.println(check);
		System.out.print("The total number of operations to sort was: ");
		System.out.println(TableSorter.counter);
		
		
		
	}
	
	

}
