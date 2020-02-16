package TableSorter_IsSortedTests;
import cs5387.Table;
import cs5387.TableSorter;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import cs5387.Table;
import cs5387.TableSorter;

class Size1x1PrevMaxTableTest {

	@Test
	void test() {
		//create TableSorter object to access methods
		TableSorter ts = new TableSorter();

		//Test 1 x 1 matrix
		int [] vals = { Integer.MAX_VALUE-1 };
		int N = vals.length;
		Table t1 = null;
		try {
			t1 = new Table(N, vals);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(TableSorter.isSorted(t1));
		System.out.printf("1x1 Max-1 Table sorted: %s \n", TableSorter.isSorted(t1)); //should return
		       //true
	}

}
