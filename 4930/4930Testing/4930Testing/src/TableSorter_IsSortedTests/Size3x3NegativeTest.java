package TableSorter_IsSortedTests;
import cs5387.Table;
import cs5387.TableSorter;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Size3x3NegativeTest {

	@Test
	void test() {
		//create TableSorter object to access methods
		TableSorter ts = new TableSorter();
		
		//Test 3 x 3 matrix
		int [] vals = { -5, -6, -3, 		//9 negatives
				-1, -7, -2,
				-4, -8, -9 
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
		System.out.printf("3x3 Positive Table sorted: %s", TableSorter.isSorted(t1)); //should return
		       //false
	}

}
