package TableSorter_IsSortedTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import cs5387.Table;
import cs5387.TableSorter;

class EmptyTableTest {

	@Test
	void test() {
		TableSorter ts = new TableSorter();

		//empty table test 0 x 0 matrix
		int [] emptyTableVals = new int[0];
		int N = emptyTableVals.length;
		Table emptyTable = null;
		try {
			emptyTable = new Table(N, emptyTableVals);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(TableSorter.isSorted(emptyTable));
		System.out.printf("Empty Table sorted: %s \n", TableSorter.isSorted(emptyTable)); //should return
		       //true
	}

}
