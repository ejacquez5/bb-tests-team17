import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TableSorterTest {

    int [] table1 = new int[]{0,1,2,3,4,5,6,7,8};
    int [] table2 = new int[]{5,1,8,3,2,1,5,7,3,6,2,1,-1,-1,5,9,3,5,6,10,-2,-1,0,-76,4,-10,0,2,99,100000,2147483647,-2147483648,-10000,-555, 1234,55};
    int [] table3 = new int[]{0,1,1,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,1,1,0,0,0};

    TableSorter sorter = new TableSorter();


    /*
    Testcase where it tests input in which all numbers are negative and input comes from file.
    */
    @Test
    void allNegatives() throws Exception{
        Table negativeTable = Table.GetTable("table5");
        sorter.sortable(negativeTable);
        assertEquals(true, sorter.isSorted(negativeTable));

    }

    /*
    Testcase where it tests input that is sorted.
    */
    @Test
    void sortedInput() throws Exception{
        Table sortedTable = new Table(table1.length, table1);
        sorter.sortable(sortedTable);
        assertEquals(true, sorter.isSorted(sortedTable));
    }

    /*
    Testcase where it tests input which has all same numbers and input comes from file.
    */
    @Test
    void sameNumbers() throws Exception{
        Table sameNumbersTable = Table.GetTable("table3");
        sorter.sortable(sameNumbersTable);
        assertEquals(true, sorter.isSorted(sameNumbersTable));
    }

    /*
    Testcase where it tests random input both negative and positive numbers
    */
    @Test
    void randomNumbers() throws Exception{
        Table randomNumbersTable = new Table(table2.length, table2);
        sorter.sortable(randomNumbersTable);
        assertEquals(true, sorter.isSorted(randomNumbersTable));
    }

    /*
    Testcase where it tests input with zeros and ones only and its a 5x5
    */
    @Test
    void zerosAndOnes() throws Exception{
        Table zerosAndOnes = new Table(table3.length, table3);
        sorter.sortable(zerosAndOnes);
        assertEquals(true, sorter.isSorted(zerosAndOnes));
    }

    /*
    Testcase where the method isSorted() is being tested against an unsorted table. Expecting for it to return FALSE
    */
    @Test
    void isSorted() throws Exception{
        Table randomNumbersTable = new Table(table2.length, table2);
        assertEquals(false, sorter.isSorted(randomNumbersTable));
    }

    /*
    Testcase where the input is a 10x10 table.
    */
    @Test
    void tenByten() throws Exception{
        Table tenByTenTable = Table.GetTable("table6");
        sorter.sortable(tenByTenTable);
        assertEquals(true, sorter.isSorted(tenByTenTable));

    }
}