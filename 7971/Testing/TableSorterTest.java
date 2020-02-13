package CS5387;

import jdk.nashorn.internal.runtime.ECMAException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TableSorterTest
{
    // The object that will execute the methods
    TableSorter tableSorter = new TableSorter();

    // This test is the simplest test 2 x 2 with positive numbers
    @Test
    void minimumTable() throws  Exception
    {
        Table minimumTable = Table.GetTable("table");
        tableSorter.sortable(minimumTable);
        assertEquals(true, tableSorter.isSorted(minimumTable));
    }

    // I added more numbers and also negative numbers and 0 - 12 x 12
    @Test
    void table12by12() throws  Exception
    {
        Table test2 = Table.GetTable("test2");
        tableSorter.sortable(test2);
        assertEquals(true, tableSorter.isSorted(test2));
    }

    // Testing negative numbers, 0 and positive numbers - 4 x 4
    @Test
    void table4by4() throws Exception
    {
        Table test3 = Table.GetTable("test3");
        tableSorter.sortable(test3);
        assertEquals(true, tableSorter.isSorted(test3));
    }

    // Testing negative numbers, 0 and positive numbers - 24 x 24
    @Test
    void tableb24by24() throws Exception
    {
        Table test4 = Table.GetTable("test4");
        tableSorter.sortable(test4);
        assertEquals(true, tableSorter.isSorted(test4));
    }

    // Testing equal numbers, the file contains only ones as the number to be tested - 4 x 4
    @Test
    void equalNumbers() throws Exception
    {
        Table equalNumbers = Table.GetTable("equalNumbers");
        tableSorter.sortable(equalNumbers);
        assertEquals(true, tableSorter.isSorted(equalNumbers));
    }

    // Testing with only negative numbers - 5x5
    @Test
    void negativeNumbers() throws  Exception
    {
        Table negativeNumbers = Table.GetTable("negativeNumbers");
        tableSorter.sortable(negativeNumbers);
        assertEquals(true, tableSorter.isSorted(negativeNumbers));
    }

    // Testing without calling the "sortable" method to test that isSorted returns false
    @Test
    void notCallingSortable() throws Exception
    {
        Table notCallingSortable = Table.GetTable("table");
        assertEquals(false, tableSorter.isSorted(notCallingSortable));
    }
}