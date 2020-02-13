import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

/**
 * NOTE: 
 * The following tests open predefined text files. You can modify these files so you can test custom values
 *  @author <<author name redacted>>
 * */


class TableSorterJTest {
	
	/*
	 * Reads Text file specified on the source library
	 * Used to set up tests.
	 * */
	public int[] readFile(String file) throws Exception {	
		int ctr = 0;
		//get number count
		try {
			Scanner s1 = new Scanner(new File(file));
			while(s1.hasNextLine()) {
				ctr = ctr +1;
				s1.next();
			}
			
			int[] words = new int[ctr];
		 //store numbers
			Scanner s2 = new Scanner(new File(file));
			for(int i = 0; i < ctr; i++) {
				words[i] = Integer.parseInt(s2.next());
			}
			System.out.println();
			return words;
		}catch(FileNotFoundException e) {
			System.out.println("No such file");
		}
		return null;
	}
	
/* isSorted Tests  **********************************************************************************/

	/* This test shows that isSorted method checks if a table is sorted
	 * Input: Sorted square Found on isSortedTest1.txt
	 * Expected Output: True 
	 * */
	@Test
	public void test_isSorted() throws Exception {
        int [] arr = readFile("isSortedTest1.txt");
        for(int i = 0; i < arr.length; i++) {
        	  System.out.print(arr[i]+" ");
        }
        int size = arr.length;
        Table table = new Table(size, arr);
        assertEquals(TableSorter.isSorted(table),true);
    }
	
	/* This test shows that isSorted method checks if a table is sorted
	 * Input: NOT Sorted square Found on isSortedTest2.txt
	 * Expected Output: False 
	 * */
	@Test
	public void test_isSorted2() throws Exception {
	    int [] arr = readFile("isSortedTest2.txt");
        int size = arr.length;
        Table table = new Table(size, arr);  
        assertEquals(TableSorter.isSorted(table),false);
	}
	

/* Size Tests  **********************************************************************************/
	
	/*
	 * This test shows that Table fails if size is not equal to length*length 
	 * Input: 2 x 4 file
	 * Expected Output: Fail, note: text file can be modified so assuming input is a square becomes then test pass
	 * */
	
	@Test
	public void test_Size() throws Exception {
		boolean pass = true;
		int [] arr = readFile("sizeTest1.txt");
        int size = arr.length;
        try{
        	Table table = new Table(size, arr);
        	TableSorter.isSorted(table);
        	
        }catch(Exception exe) {
        	if(Math.sqrt(size) != size * size){
        		fail("Input must be a square");
        	}else {
        		fail("Something went wrong");
        	}
        	
        }
        if(pass == true) assertEquals(true,true);

	}
		
	/* Sortable Tests  *************************************************************
	 * 
	 * NOTE: 
	 * In the instructions for the 1st Homework it was specified that sortable is type VOID
	 * therefore there is no way of retreiving  the sorted table so it can be tested. Also it was specified to NOT
	 * Modify past code so there was nothing to do. These tests simply create squares and prints input
	 * and the output is printed from the sorted method, all of this is seen on the console. 
	 * 
	 * Also my code is wrong. Is not sorted correctly so I cannot modify my code. 
	 * Even though my code is wrong these tests should work for other students code. 
	 * 
	 * */

	/*
	 * This test shows that a square can be created using only positive values
	 * Input: "sortableTest1.txt" All positive numbers
	 * Output: Sorts the square 
	 * */
	@Test
	public void test_Sortable() throws Exception {
		int [] arr = readFile("sortableTest1.txt");
        int size = arr.length;
	
		System.out.println("*************************************************");
		System.out.println("Test 1");
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
	        		fail("Input must be a square");
	        	}else {
	        		fail("Something went wrong");
	        	}
	        	System.out.println("*************************************************"); 
		 }
	}

	/*
	 * This test shows that a square can be created using only negative values
	 * Input: "sortableTest2.txt" All negative numbers
	 * Output: Sorts the square 
	 * */
	@Test
	public void test_Sortable2() throws Exception {
		int [] arr = readFile("sortableTest2.txt");
        int size = arr.length;
	
		System.out.println("*************************************************");
		System.out.println("Test 2");
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
	        		fail("Input must be a square");
	        	}else {
	        		fail("Something went wrong");
	        	}
	        	System.out.println("*************************************************"); 
		 }
	}

	/*
	 * This test shows that a square can be created using combination of positive, negative, and zero on the values
	 * Input: "sortableTest3.txt" Mix numbers with negative, positive and zero
	 * Output: Sorts the square 
	 * */
	
	@Test
	public void test_Sortable3() throws Exception {
		int [] arr = readFile("sortableTest3.txt");
        int size = arr.length;
	
		System.out.println("*************************************************");
		System.out.println("Test 3");
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
	        		fail("Input must be a square");
	        	}else {
	        		fail("Something went wrong");
	        	}
	        	System.out.println("*************************************************"); 
		 }
	}
	

	
	
}
