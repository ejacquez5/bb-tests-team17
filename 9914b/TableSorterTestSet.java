package cs5387;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

/* CS 5387
TableSorter tests
@author <<author name redacted>>
@version 1.0
@since 02/12/20
Test set for TableSorter.java */

class TableSorterTestSet {

	/*@Test
	void test() {
		fail("Not yet implemented");
	}
	*/
	
	// Method that will read input from a text 
	// All text files have specific values for testing purposes
	// Values may be altered within valid specifications required for testing purposes
	// All integers in files must be separated with a space

	public int[] inputTextFile(String file) throws Exception {
		//get number of  input  integers
		int counter = 0;
		
		try {
			Scanner scannInput = new Scanner(new File(file));
			while(scannInput.hasNextLine()) {
				counter = counter +1;
				scannInput.next();
			}
			scannInput.close();
			
			//create array of inputs
			int[] input = new int[counter];
			Scanner scanner = new Scanner(new File(file));
			for(int i = 0; i < counter; i++) {
				input[i] = Integer.parseInt(scanner.next());
			}
			scanner.close();
			
			System.out.println();
			return input;
		}catch(FileNotFoundException e) {
			System.out.println("The file you requested does not exist!");
		}
		return null;
	}
	
	// TS1 -  TEST VALID SIZE
	//This test will validate minimum number of input integers needed to create a table.
	//Input file: 2 x 2 format (row and column)
	//Expected Output: Fail
	
		@Test
		public void ts1_valid_Size() throws Exception {
			boolean notvalid = true;
			int [] arr1 = inputTextFile("ts1_valid_size.txt");
	        int size = arr1.length;
	        
	        System.out.println("/////////////");
			System.out.println("TS1");
			System.out.println("/////////////");
			
	        try{
	        	Table table = new Table(size, arr1);
	        	TableSorter.isSorted(table);
	        	
	        }catch(Exception exe) {
	        	if(Math.sqrt(size) != size * size){
	        		fail("Invalid input. Input must be a valid size=> n x n");
	        	}else {
	        		fail("Valid size accepted");
	        	}
	        	
	        }
	        if(notvalid == true) assertEquals(true,true);

		}
		
		// TS2 -  TEST INVALID SIZE
		//This test will validate number of input integers that will not create a table. JUnit is needed for testing.
		//Input file: 3 x 2 file
		//Expected Output: Fail
		
		@Test
		public void ts2_invalid_Size() throws Exception {
			boolean notvalid = true;
			int [] arr2 = inputTextFile("ts2_invalid_size.txt");
	        int size = arr2.length;
	        
	        System.out.println("/////////////");
			System.out.println("TS2");
			System.out.println("/////////////");
			
	        try{
	        	Table table = new Table(size, arr2);
	        	TableSorter.isSorted(table);
	        	
	        }catch(Exception exe) {
	        	if(Math.sqrt(size) != size * size){
	        		fail("Invalid input. Input must be a valid size=> n x n");
	        	}else {
	        		fail("Error!");
	        	}
	        	
	        }
	        if(notvalid == true) assertEquals(true,true);

		}
	
		

		// TS3 -  POSITIVE INTEGERS
		//This test will validate creating a table with four positive integers as input.
		//Input file: 2 x 2 file
	
		@Test
		public void ts3_positve() throws Exception {
		int [] arr3 = inputTextFile("ts3_positive.txt");
        int size = arr3.length;
	
        System.out.println("/////////////");
		System.out.println("TS3");
		System.out.println("/////////////");
		
		 try{
				System.out.println("input");
		        for(int i =0; i < arr3.length; i++) {
		        	System.out.print(arr3[i] + " ");
		        }
		        System.out.println();
		        System.out.println();
		        System.out.println("Output");
		        
		        Table table = new Table(size, arr3);
		        TableSorter.sortable(table); 
		        assertEquals(true,true);
		 }catch(Exception exe) {
	        	if(Math.sqrt(size) != size * size){
	        		fail("Invalid input. Input must be a valid size=> n x n");
	        	}else {
	        		fail("Error!");
	        	}
	        	System.out.println("//////////"); 
		 }
	}
	
		
		// TS4 -  NEGATIVE INTEGERS
		//This test will validate creating a table with four negative integers as input. 
			
		@Test
		public void ts4_negatives() throws Exception {
		int [] arr = inputTextFile("ts4_negatives.txt");
        int size = arr.length;
        
        System.out.println("/////////////");
		System.out.println("TS4");
		System.out.println("/////////////");
		
		 try{
				System.out.println("input");
		        for(int i =0; i < arr.length; i++) {
		        	System.out.print(arr[i] + " ");
		        }
		        System.out.println();
		        System.out.println();
		        System.out.println("Output");
		        
		        Table table = new Table(size, arr);
		        TableSorter.sortable(table); 
		        assertEquals(true,true);
		 }catch(Exception exe) {
	        	if(Math.sqrt(size) != size * size){
	        		fail("Invalid input. Input must be a valid size=> n x n");
	        	}else {
	        		fail("Error!");
	        	}
	        	System.out.println("///////////"); 
		 }
	}
	
	// TS5 -  MIXED INTEGERS
	//This test will validate creating a table with four mixed sign integers and a zero as input. 

	@Test
	public void ts5_mixed() throws Exception {
		int [] arr5 = inputTextFile("ts5_mixed.txt");
        int size = arr5.length;
	
        System.out.println("/////////////");
     		System.out.println("TS5");
     		System.out.println("/////////////");
     		
		 try{
				System.out.println("input");
		        for(int i =0; i < arr5.length; i++) {
		        	System.out.print(arr5[i] + " ");
		        }
		        System.out.println();
		        System.out.println();
		        System.out.println("Output");
		        
		        Table table = new Table(size, arr5);
		        TableSorter.sortable(table);
		        assertEquals(true,true);
		 }catch(Exception exe) {
	        	if(Math.sqrt(size) != size * size){
	        		fail("Input must be a square");
	        	}else {
	        		fail("Something went wrong");
	        	}
	        	System.out.println("////////"); 
		 }
	}
	
	// TS6 -  TEST IF SORTED
	//Test if values are in sorted sequence.
	//This test will validate if a set of input values are in order sequence.
	//Expected output is true if sorted

	@Test
	public void ts6_sorted() throws Exception {
        int [] arr6 = inputTextFile("ts6_sorted.txt");
        
        System.out.println("/////////////");
		System.out.println("TS6");
		System.out.println("/////////////");
		
        
        for(int i = 0; i < arr6.length; i++) {
        	  System.out.print(arr6[i]+" ");
        }
        int size = arr6.length;
        Table table = new Table(size, arr6);
        assertEquals(TableSorter.isSorted(table),true);
    }
	
	// TS7 -  TEST IF NOT SORTED
	//Test if values are not in sorted sequence.
	//This test will validate if a set of input values are not in order sequence.
	//Expected output is false, due to set of input numbers not sorted
	@Test
	public void ts7_notSorted() throws Exception {
	    int [] arr7 = inputTextFile("ts7_not_sorted.txt");
        int size = arr7.length;
        
        System.out.println("/////////////");
		System.out.println("TS7");
		System.out.println("/////////////");
		
        
        Table table = new Table(size, arr7);  
        assertEquals(TableSorter.isSorted(table),false);
	}
	
}

		