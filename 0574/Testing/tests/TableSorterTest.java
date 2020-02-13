import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * TableSorterTest class is for testing purposes of the TableSorter class. This file tests the sortTable() and isSorted()
 * methods of the class. The test files that are to be used with this file are the testFileSorted and the testFileUnsorted
 * files. In order to carry out the given tests the tester will only need to manipulate both test text files before executing
 * the tests.
 */
public class TableSorterTest {

    TableSorter sorter = new TableSorter();
    Table tableUnsorted;
    Table tableSorted;

    //Tests a list of positive integers to see if sortTable() is sorting
    //ID 01
    @Test
    public void sortTable() throws Exception {
        tableUnsorted = tableUnsorted.GetTable("testFileUnsorted");
        tableSorted = tableSorted.GetTable("testFileSorted");
        sorter.sortTable(tableUnsorted);
        for (int i = 0; i < tableSorted.getSize(); i++) {
            for (int j = 0; j < tableSorted.getSize(); j++) {
                assertEquals(tableSorted.getTableValue(i, j), tableUnsorted.getTableValue(i, j));
            }

        }
    }

    //Tests sortTable() with a list of integers that are both positive and negative
    //ID 02
    @Test
    public void sortTableNegativeNumbers() throws Exception {
        tableUnsorted = tableUnsorted.GetTable("testFileUnsortedNegative");
        tableSorted = tableSorted.GetTable("testFileSortedNegative");
        sorter.sortTable(tableUnsorted);
        for (int i = 0; i < tableSorted.getSize(); i++) {
            for (int j = 0; j < tableSorted.getSize(); j++) {
                assertEquals(tableSorted.getTableValue(i, j), tableUnsorted.getTableValue(i, j));
            }

        }
    }

    //Tests a list of integers, including 0, to see if sortTable() is sorting
    //ID 03
    @Test
    public void sortTableZeros() throws Exception {
        tableUnsorted = tableUnsorted.GetTable("testFileUnsortedZero");
        tableSorted = tableSorted.GetTable("testFileSortedZero");
        sorter.sortTable(tableUnsorted);
        for (int i = 0; i < tableSorted.getSize(); i++) {
            for (int j = 0; j < tableSorted.getSize(); j++) {
                assertEquals(tableSorted.getTableValue(i, j), tableUnsorted.getTableValue(i, j));
            }

        }
    }


    //Tests sortTable() with a list of integers that contain repeat numbers
    //ID 04
    @Test
    public void sortTableEqualNumbers() throws Exception {
        tableUnsorted = tableUnsorted.GetTable("testFileUnsortedEqual");
        tableSorted = tableSorted.GetTable("testFileSortedEqual");
        sorter.sortTable(tableUnsorted);
        for (int i = 0; i < tableSorted.getSize(); i++) {
            for (int j = 0; j < tableSorted.getSize(); j++) {
                assertEquals(tableSorted.getTableValue(i, j), tableUnsorted.getTableValue(i, j));
            }

        }
    }


    //tests isSorted() against a custom list of integers with squared dimensions to see if it is sorted
    //ID 05
    @Test
    public void isSorted() throws Exception {
        tableSorted = tableSorted.GetTable("testFileSorted");
        assertEquals(true, sorter.isSorted(tableSorted));
    }


    //tests isSorted() against a custom list of integers with squared dimensions to see if it is sorted
    //ID 06
    @Test
    public void isSortedFalse() throws Exception {
        tableUnsorted = tableUnsorted.GetTable("testFileUnsorted");
        assertEquals(false, sorter.isSorted(tableUnsorted));
    }

}