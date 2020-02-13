/*
 @author <<author name redacted>>
 Purpose: To test sorting of a table and checking if sorted
 Programming Assignment 3 - Black box testing
 Course: CS5387 - Software Integration and V&V
 Professor: Dr. Steve Roach
 Last modification date: 2/12/2020
 */

package cs5387;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class TablesSorterTest {

    private TablesSorter ts;

    @Before
    /*Initializes an instance of the TableSorter class*/
    public void setUp() throws Exception {
        ts = new TablesSorter();
    }

    @After
    /*Tears down all global variables*/
    public void tearDown() throws Exception {
        ts = null;
    }

    @Test
    /*Test if method can handle taking null*/
    public void testIsSorted1() {
        boolean isSorted = ts.isSorted(null);
        assertFalse(isSorted);
    }

    @Test
    /*Test if method can handle empty table*/
    public void testIsSorted2() {
        Table table = createTable(0, new int[]{});
        boolean isSorted = ts.isSorted(table);
        assertTrue(isSorted);
    }

    @Test
    /*Test if method can handle only one element*/
    public void testIsSorted3() {
        Table table = createTable(1, new int[]{20});
        boolean isSorted = ts.isSorted(table);
        assertTrue(isSorted);
    }

    @Test
    /*Testing if a regular 5 by 5 table works at success*/
    public void testIsSorted4() {
        int[] values = new int[]{
                5, 10, 15, 20, 25,
                10, 20, 40, 60, 80,
                20, 30, 50, 70, 100,
                30, 40, 60, 80, 120,
                40, 50, 70, 90, 200
        };

        Table table = createTable(25, values);
        boolean isSorted = ts.isSorted(table);
        assertTrue(isSorted);
    }

    @Test
        /*Testing if a regular 5 by 5 table works at success, testing with 0 and negative values*/
    public void testIsSorted5() {
        int[] values = new int[]{
                -200, -90, -70, -50, -40,
                -120, -80, -60, -40, -30,
                -100, -70, -50, -30, -20,
                -80, -60, -40, 0, 20,
                -25, -20, -15, 10, 30
        };

        Table table = createTable(25, values);
        boolean isSorted = ts.isSorted(table);
        assertTrue(isSorted);
    }

    @Test
    /*Testing if a regular 5 by 5 table, where every row is sorted ascending, and every column is sorted except the first*/
    public void testIsSorted6() {
        int[] values = new int[]{
                5, 10, 15, 20, 25,
                10, 20, 40, 60, 80,
                9, 30, 50, 70, 100,
                30, 40, 60, 80, 120,
                40, 50, 70, 90, 200
    };

        Table table = createTable(25, values);
        boolean isSorted = ts.isSorted(table);
        assertFalse(isSorted);
    }

    @Test
    /*Testing if a regular 5 by 5 table, where every row is sorted ascending, but every column except the last isn't*/
    public void testIsSorted7() {
        int[] values = new int[]{
                5, 10, 15, 20, 25,
                10, 20, 40, 60, 80,
                20, 30, 50, 70, 75,
                30, 40, 60, 80, 120,
                40, 50, 70, 90, 200
        };

        Table table = createTable(25, values);
        boolean isSorted = ts.isSorted(table);
        assertFalse(isSorted);
    }

    @Test
    /*Testing if a regular 5 by 5 table, where every column is sorted ascending, but every row except the first isn't*/
    public void testIsSorted8() {
        int[] values = new int[]{
                5, 10, 8, 20, 25,
                10, 20, 40, 60, 80,
                20, 30, 50, 70, 75,
                30, 40, 60, 80, 120,
                40, 50, 70, 90, 200
        };

        Table table = createTable(25, values);
        boolean isSorted = ts.isSorted(table);
        assertFalse(isSorted);
    }

    @Test
    /*Testing if a regular 5 by 5 table, where every column is sorted ascending, but every row except the last isn't*/
    public void testIsSorted9() {
        int[] values = new int[]{
                5, 10, 15, 20, 25,
                10, 20, 40, 60, 80,
                20, 30, 50, 70, 75,
                30, 40, 60, 80, 120,
                40, 50, 45, 90, 200
        };

        Table table = createTable(25, values);
        boolean isSorted = ts.isSorted(table);
        assertFalse(isSorted);
    }

    @Test
        /*Testing if a regular 5 by 5 table, test whether it can handle a tie column-wise*/
    public void testIsSorted10() {
        int[] values = new int[]{
                5, 10, 15, 20, 25,
                10, 20, 40, 60, 80,
                20, 30, 60, 70, 75,
                30, 40, 60, 80, 120,
                40, 50, 80, 90, 200
        };

        Table table = createTable(25, values);
        boolean isSorted = ts.isSorted(table);
        assertFalse(isSorted);
    }

    @Test
    /*Testing if a regular 5 by 5 table, test whether it can handle a tie row-wise (2nd row)*/
    public void testIsSorted11() {
        int[] values = new int[]{
                5, 10, 15, 20, 25,
                10, 20, 45, 45, 80,
                20, 30, 50, 70, 90,
                30, 40, 60, 80, 120,
                40, 50, 80, 90, 200
        };

        Table table = createTable(25, values);
        boolean isSorted = ts.isSorted(table);
        assertTrue(isSorted);
    }

    @Test
    /*Testing if a 4 by 4 table where every value is unique is sorted*/
    public void testIsSorted12() {
        int[] values = new int[]{
                1, 2, 3,
                4, 5, 6,
                7, 8, 9
        };

        Table table = createTable(9, values);
        boolean isSorted = ts.isSorted(table);
        assertTrue(isSorted);
    }

    @Test
    /*Testing if a regular 3 by 3 table is sorted if every value is the same*/
    public void testIsSorted13() {
        int[] values = new int[]{
                2, 2, 2,
                2, 2, 2,
                2, 2, 2
        };

        Table table = createTable(9, values);
        boolean isSorted = ts.isSorted(table);
        assertTrue(isSorted);
    }

    @Test
    /*Testing if a regular 3 by 3 table is sorted if every value is the same*/
    public void testIsSorted14() {
        int[] values = new int[]{
                1, 2, 3,
                4, 5, 6,
                7, 8, 9
        };

        Table table = createTable(9, values);
        boolean isSorted = ts.isSorted(table);
        assertTrue(isSorted);
    }

    @Test
    /*Testing if a regular 3 by 3 table is sorted with the lowest integer value*/
    public void testIsSorted15() {
        int[] values = new int[]{
                Integer.MIN_VALUE, 2, 3,
                4, 5, 6,
                7, 8, 9
        };

        Table table = createTable(9, values);
        boolean isSorted = ts.isSorted(table);
        assertTrue(isSorted);
    }

    @Test
    /*Testing if a regular 3 by 3 table is sorted with the largest integer value*/
    public void testIsSorted16() {
        int[] values = new int[]{
                1, 2, 3,
                4, 5, 6,
                7, 8, Integer.MAX_VALUE
        };

        Table table = createTable(9, values);
        boolean isSorted = ts.isSorted(table);
        assertTrue(isSorted);
    }

    @Test
    /*Testing if it can take a very large sorted table (300 by 300)*/
    public void testIsSorted17() {
        int N = 300;
        int[] values = new int[N*N];
        for(int i = 0; i < N*N; i++){
            values[i] = i;
        }

        Table table = createTable(N*N, values);
        boolean isSorted = ts.isSorted(table);
        assertTrue(isSorted);
    }

    @Test
    /*Testing if it can take a very large unsorted table (300 by 300)*/
    public void testIsSorted18() {
        int N = 300;
        int[] values = new int[N*N];
        for(int i = 0; i < N*N; i++){
            values[i] = i*-1;
        }

        Table table = createTable(N*N, values);
        boolean isSorted = ts.isSorted(table);
        assertFalse(isSorted);
    }

    private Table createTable(int N, int[] values){
        Table t1 = null;
        try {
            t1 = new Table(N, values);
        } catch (Exception e) {
            e.printStackTrace();
            fail("Failed making table, exception was thrown");
        }
        if (t1 == null) {
            fail("Table creation failed, returned null");
        }
        return t1;
    }

    @Test
    
    public void testSortable1() {
        Table table = createTable(0, new int[]{});
        TablesSorter.sortable(table);
        boolean isSorted = ts.isSorted(table);
        assertTrue(isSorted);
    }

    @Test
    /*Check if it can sort a table with only 1 element*/
    public void testSortable2() {
        Table table = createTable(1, new int[]{5});
        TablesSorter.sortable(table);
        boolean isSorted = ts.isSorted(table);
        assertTrue(isSorted);
    }

    @Test
    /*Check if it can sort an already sorted table*/
    public void testSortable3() {
        int[] values = new int[]{
                5, 10, 15, 20, 25,
                10, 20, 40, 60, 80,
                20, 30, 50, 70, 100,
                30, 40, 60, 80, 120,
                40, 50, 70, 90, 200
        };
        Table table = createTable(25, values);
        TablesSorter.sortable(table);
        boolean isSorted = ts.isSorted(table);
        assertTrue(isSorted);
    }

    @Test
    /*Check if it can sort an already sorted table except where the first column isn't sorted*/
    public void testSortable4() {
        int[] values = new int[]{
                5, 10, 15, 20, 25,
                10, 20, 40, 60, 80,
                8, 30, 50, 70, 100,
                30, 40, 60, 80, 120,
                40, 50, 70, 90, 200
        };
        Table table = createTable(25, values);
        TablesSorter.sortable(table);
        boolean isSorted = ts.isSorted(table);
        assertTrue(isSorted);
    }

    @Test
    /*Check if it can sort an already sorted table except where the last column isn't sorted*/
    public void testSortable5() {
        int[] values = new int[]{
                5, 10, 15, 20, 25,
                10, 20, 40, 60, 80,
                15, 30, 50, 70, 75,
                30, 40, 60, 80, 120,
                40, 50, 70, 90, 200
        };
        Table table = createTable(25, values);
        TablesSorter.sortable(table);
        boolean isSorted = ts.isSorted(table);
        assertTrue(isSorted);
    }

    @Test
    /*Check if it can sort an already sorted table except where the first row isn't sorted*/
    public void testSortable6() {
        int[] values = new int[]{
                5, 10, 8, 20, 25,
                10, 20, 40, 60, 80,
                15, 30, 50, 70, 100,
                30, 40, 60, 80, 120,
                40, 50, 70, 90, 200
        };
        Table table = createTable(25, values);
        TablesSorter.sortable(table);
        boolean isSorted = ts.isSorted(table);
        assertTrue(isSorted);
    }

    @Test
    /*Check if it can sort an already sorted table except where the last row isn't sorted*/
    public void testSortable7() {
        int[] values = new int[]{
                5, 10, 15, 20, 25,
                10, 20, 40, 60, 80,
                15, 30, 50, 70, 100,
                30, 40, 60, 80, 120,
                40, 80, 70, 90, 200
        };
        Table table = createTable(25, values);
        TablesSorter.sortable(table);
        boolean isSorted = ts.isSorted(table);
        assertTrue(isSorted);
    }

    @Test
    /*Check if it can sort an already sorted table in descending order, (nothing is sorted)*/
    public void testSortable8() {
        int[] values = new int[]{
                200, 90, 70, 50, 40,
                120, 80, 60, 40, 30,
                100, 70, 50, 30, 20,
                80, 60, 40, 20, 10,
                25, 20, 15, 10, 5
        };
        Table table = createTable(25, values);
        TablesSorter.sortable(table);
        boolean isSorted = ts.isSorted(table);
        assertTrue(isSorted);
    }

    @Test
    /*Check if it can sort a sorted table in descending order, (nothing is sorted), and there is a tie column-wise*/
    public void testSortable9() {
        int[] values = new int[]{
                200, 90, 70, 50, 40,
                120, 80, 50, 40, 30,
                100, 70, 50, 30, 20,
                80, 60, 50, 20, 10,
                25, 20, 15, 10, 5
        };
        Table table = createTable(25, values);
        TablesSorter.sortable(table);
        boolean isSorted = ts.isSorted(table);
        assertTrue(isSorted);
    }

    @Test
    /*Check if it can sort a mostly sorted table in descending order, and there is a tie row-wise*/
    public void testSortable10() {
        int[] values = new int[]{
                200, 90, 70, 50, 40,
                120, 80, 60, 40, 30,
                100, 60, 60, 60, 20,
                80, 60, 40, 20, 10,
                25, 20, 15, 10, 5
        };
        Table table = createTable(25, values);
        TablesSorter.sortable(table);
        boolean isSorted = ts.isSorted(table);
        assertTrue(isSorted);
    }

    @Test
    /*Check if it can sort a sorted table where every value in the table is the same (a tie)*/
    public void testSortable11() {
        int[] values = new int[]{
                4, 4, 4, 4,
                4, 4, 4, 4,
                4, 4, 4, 4,
                4, 4, 4, 4

        };
        Table table = createTable(16, values);
        TablesSorter.sortable(table);
        boolean isSorted = ts.isSorted(table);
        assertTrue(isSorted);
    }

    @Test
    /*Check if it can sort a table with all unique values*/
    public void testSortable12() {
        int[] values = new int[]{
                4, 7, 2,
                20, 1, 0,
                5, 3, 15
        };
        Table table = createTable(9, values);
        TablesSorter.sortable(table);
        boolean isSorted = ts.isSorted(table);
        assertTrue(isSorted);
    }

    @Test
    /*Check if it can sort a table with negative numbers and 0*/
    public void testSortable13() {
        int[] values = new int[]{
                -4, -7, -2,
                -20, -1, 0,
                -5, -3, -15
        };
        Table table = createTable(9, values);
        TablesSorter.sortable(table);
        boolean isSorted = ts.isSorted(table);
        assertTrue(isSorted);
    }

    @Test
    /*Check if it can sort with the smallest number*/
    public void testSortable14() {
        int[] values = new int[]{
                4, 7, 2,
                20, Integer.MIN_VALUE, 0,
                5, 3, 15
        };
        Table table = createTable(9, values);
        TablesSorter.sortable(table);
        boolean isSorted = ts.isSorted(table);
        assertTrue(isSorted);
    }

    @Test
    /*Check if it can sort with the largest number*/
    public void testSortable15() {
        int[] values = new int[]{
                4, 7, 2,
                20, Integer.MAX_VALUE, 0,
                5, 3, 15
        };
        Table table = createTable(9, values);
        TablesSorter.sortable(table);
        boolean isSorted = ts.isSorted(table);
        assertTrue(isSorted);
    }

    @Test
    /*Check if it can sort with the largest number*/
    public void testSortable16() {
        int[] values = new int[]{
                4, 7, 2,
                20, Integer.MAX_VALUE, 0,
                5, 3, 15
        };
        Table table = createTable(9, values);
        TablesSorter.sortable(table);
        boolean isSorted = ts.isSorted(table);
        assertTrue(isSorted);
    }

    @Test
    /*Check if it can sort with a large (300 by 300) table*/
    public void testSortable17() {
        int N = 300;
        int[] values = new int[N*N];
        for(int i = 0; i < N*N; i++){
            values[i] = i * -1;
        }
        Table table = createTable(N*N, values);
        TablesSorter.sortable(table);
        boolean isSorted = ts.isSorted(table);
        assertTrue(isSorted);
    }


}