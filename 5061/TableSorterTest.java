import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TableSorterTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void isSortedReturnsTrue() throws Exception {
		Table f = Table.GetTable("sorted_array.txt"); // Getting table
		assertEquals(true, TableSorter.isSorted(f));
	}
	
	@Test
	public void isSortedReturnsFalse() throws Exception{
		Table f = Table.GetTable("unsorted_array.txt"); // Getting table
		assertEquals(false, TableSorter.isSorted(f));
	}
	
	@Test //REVIEW
	public void isSortedNonIntArray() throws Exception{
		Table f = Table.GetTable("nonInt_array.txt"); // Getting table
		fail("message");
		assertEquals(false, TableSorter.isSorted(f));
	}
	
	@Test
	public void isSortedNegativeInt() throws Exception{
		Table f = Table.GetTable("negativeInt_array.txt"); // Getting table
		assertEquals(false, TableSorter.isSorted(f));
	}
	
	@Test
	public void isSortedPositiveInt() throws Exception{
		Table f = Table.GetTable("positiveInt_array.txt"); // Getting table
		assertEquals(false, TableSorter.isSorted(f));
	}
	
	@Test //REVIEW
	public void notSquaredSizeTest () throws Exception{ //if get error of size
		Table f = Table.GetTable("nm_table.txt"); // Getting table
		fail("message");
		assertEquals(true, TableSorter.isSorted(f));
	}
	
	@Test //REVIEW
	public void squaredTest() throws Exception{ //if get error of size
		Table f = Table.GetTable("nn_table.txt"); // Getting table
		assertEquals(false, TableSorter.isSorted(f));
	}
	
	@Test //REVIEW
	public void oneDigitTable() throws Exception{ //if get error of size
		Table f = Table.GetTable("onebyone_table.txt"); // Getting table
		assertEquals(true, TableSorter.isSorted(f));
	}
	
	
	
	

	

}
