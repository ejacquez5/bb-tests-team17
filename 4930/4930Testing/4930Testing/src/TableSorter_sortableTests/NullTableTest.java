package TableSorter_sortableTests;
import cs5387.TableSorter;
import cs5387.Table;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import cs5387.Table;
import cs5387.TableSorter;

class NullTableTest {

	@Test
	void test() {
		Table t0 = null;
		TableSorter ts = new TableSorter(); //create a TableSorter object
		boolean exceptionThrown = false;
		TableSorter.sortable(t0); //call the sortable method, should null exception
		
		assertTrue(exceptionThrown);
	}

}
