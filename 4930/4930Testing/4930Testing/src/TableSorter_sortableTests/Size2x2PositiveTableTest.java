package TableSorter_sortableTests;
import cs5387.TableSorter;
import cs5387.Table;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import cs5387.Table;
import cs5387.TableSorter;

class Size2x2PositiveTableTest {

	@Test
	void test() {

		int [] vals = new int[] { 
				2, 3, 		//create random set of values
				1, 5
				}; 

		int N = vals.length; //get the amount of values, must be a square number
				
		Table t0 = null;
		try {
			t0 = new Table (N,vals);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // create a dummy table
		
		TableSorter.sortable(t0); //call the sortable method
		assertTrue(TableSorter.isSorted(t0));
	}

}
