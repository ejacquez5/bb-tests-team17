package TableSorter_IsSortedTests;
import cs5387.Table;
import cs5387.TableSorter;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Size3x3Mixed2_7Test {

	@Test
	void test() {
		//create TableSorter object to access methods
		TableSorter ts = new TableSorter();
		
		//Test 3 x 3 matrix
		int [] vals = { 3, 8, -4, 		//2 positives and 7 negatives
				-6, -5, -1,
				-9, -2, -10 
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
		System.out.printf("3x3 Mixed2_7 Table sorted: %s", TableSorter.isSorted(t1)); //should return
		       //false
	}

}
