package TableSorter_IsSortedTests;
import cs5387.Table;
import cs5387.TableSorter;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Size2x2PositiveTest {

	@Test
	void test() {
		//create TableSorter object to access methods
		TableSorter ts = new TableSorter();
		
		//Test 2 x 2 matrix
		int [] vals = { 10, 2, 		//4 positives
		4, 1
		};
		int N = vals.length;
		Table t1 = null;
		try {
			t1 = new Table(N, vals);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertFalse(TableSorter.isSorted(t1));
		System.out.printf("2x2 Positive Table sorted: %s", TableSorter.isSorted(t1)); //should return
		       //false
	}

}
