package cs5387;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.jupiter.api.Test;

import junit.framework.AssertionFailedError;
import junit.framework.TestCase;

class TableSorterTestSet {

	protected String pathFormat, pathName; 
	protected int n;
	protected int[] invalidTable, validSortedTable, validUnsortedTable;
	 
	
	//Variables for tests 
	protected void setUp() {
		//Invalid inputs 
		//Input file format
		pathFormat = "src\\Test_1.tx";
		//Input file name
		pathName = "src\\Test_5.txt";
		//Input n for size of table 
		n = 5;	
		//Table with invalid input
		invalidTable = new int[]{};
		
		// ----------------------------------------------------
		
		//Valid inputs
		//Sorted table 
		validSortedTable = new int[]{1,2,4,45,55,65,82,94,96};
		//Unsorted Table
		validUnsortedTable = new int[]{5,7,8,13,17,20,1,2,3};
	}
	
	@Test
	//Test sort method by making two indexes in the table have the same value
	void test() throws FileNotFoundException, IOException, Exception {
		
		setUp();
		
		//Test that do not meet requirements 
		//Test n, the size of the table for constructor method Table()
		//Table t1 = new Table(n,{1,2,2,4});
		
		//Test file input format for method GetTable()
		//Table t2 = Table.GetTable(pathFormat);
		
		//Test file name for method GetTable()
		//t2 = Table.GetTable(pathName);
		
		//Test array size for empty array
		//Table t3 = new Table(9, invalidTable);
			
		//---------------------------------------------------
		
		//Tests that meet requirements
		//Test isSorted  
		Table t4 = new Table(9, validSortedTable);
		Table t5 = new Table(9, validUnsortedTable);
		
		//Test isSorted to check validSortedTable returns true
		assertTrue(TableSorter.isSorted(t4));
		
		//Test isSorted method to check that rows and columns are sorted in ascending order
		assertFalse(TableSorter.isSorted(t5));
		
		//Test sortable to check validUnsortedTable is sorted in ascending order
		TableSorter.sortable(t4);
		assertTrue(TableSorter.isSorted(t5));
		
		
	}
	
	

}
