import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.*;
import java.math.*; 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test extends TableSorter{
	int[]array = {};
	Table table1 = new Table(0, array);
	int[]array = {1};
	Table table2 = new Table(1, array);
	int[]array = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
	Table table3 = new Table(3, array);
	int[]array = {3, 3, 3, 3, 3, 3, 3, 3, 3};
	Table table4 = new Table(3, array);
	int[]array = {12, 24, 31, 43, 56, 68, 77, 80, 39, 103, 11, 124, 123, 174, 159, 160, 17, 178, 19, 27, 261, 227, 283, 247, 265, 296};
	Table table5 = new Table(5, array);
	
	@Test
	public void testIsSorted() {
		assertEquals(true, isSorted(table1));
		assertEquals(true, isSorted(table2));
		assertEquals(false, isSorted(table3));
		assertEquals(true, isSorted(table4));
		assertEquals(false, isSorted(table5));
	}
}