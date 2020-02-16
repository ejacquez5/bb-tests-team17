package TableSorter_IsSortedTests;
import cs5387.Table;
import cs5387.TableSorter;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import cs5387.Table;
import cs5387.TableSorter;

class NullTableTest {

	@Test
	void test() {
		//create TableSorter object to access methods
		TableSorter ts = new TableSorter();

		//test a null table
		Table emptyTable = null;
		assertTrue(TableSorter.isSorted(emptyTable));
		System.out.printf("Null Table sorted: %s \n", TableSorter.isSorted(emptyTable)); //should return
		       //true
	}

}
