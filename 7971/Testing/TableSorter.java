/*
 * Author: <<author name redacted>>
 * 01/23/2020
 * Purpose: Create a class "TableSorter" with two instances methods.
 * "isSorted" this method return a boolean if the table's row and columns are in ascending order.
 * "sortable" sorts the table.
 * In addition to the methods required, I developed methods that supports the methods requested.
 * "sortRows": sorts the table's rows
 * "sortColums": sorts the table's columns
 * "isRowSorted": verfies that the table's row are sorted in ascending order
 * isColumnSorted": verifies that the columns of the table are sorted in ascending order
 * */
package CS5387;

public class TableSorter {

    public static void main(String[] args) throws Exception
    {
        // create table object
        Table table = Table.GetTable("table");
        // print content
        System.out.println(table.toString());
        // create a TableSorter object
        TableSorter tableSorter = new TableSorter();
        // check if the table is already sorted
        System.out.println(tableSorter.isSorted(table));
        System.out.println("========================================== sort ===================================================");
        // sort the table
        tableSorter.sortable(table);
        // print the matrix
        System.out.println(table.toString());
        // print if the new sorted table is sorted
        System.out.println(tableSorter.isSorted(table));
    }

    // Table -> boolean
    // This method verifies if the table's rows and columns are in ascending order.
    // it calls two methods: "isRowSorted" and "isColumnSorted", these methods verify
    // if the rows and columns are sorted in ascending order.
    // I compare this two methods using "&&" so it will be True only if both methods return True
    public boolean isSorted(Table table)
    {
        return isRowSorted(table) && isColumnSorted(table);
    }

    // Table -> void
    // sortable will sort the table by sorting the rows and then the columns.
    // To do this I created two different methods:
    // 1) sortRows, will sort the table's rows.
    // 2) sortColumns, will sort the table's columns
    // In call these methods in the order mentioned above
    public void sortable(Table table)
    {
        sortRows(table);
        sortColumns(table);
    }

    // Table -> void
    // This method will sort the Table's rows in ascending order
    // by using Bubble Sort algorithm. I use the swap condition so
    // as soon as no swaps are done in a row is means that our row is sorted.
    public void sortRows(Table table)
    {
        int row;
        int col;
        boolean swap;
        // for each row...
        for(row = 0; row < table.getSize(); row++)
        {
            swap = true;
            while(swap)
            {
                swap = false;
                for (col = 0; col < table.getSize() - 1; col++)
                {
                    int firstValue = table.getTableValue(row, col);
                    int nextValue = table.getTableValue(row, col + 1);
                    // if this is conditions is not met, then it won't change de "swap" variable and jump to
                    // the next column
                    if (firstValue > nextValue)
                    {
                        swap = true;
                        table.setTableValue(row, col, nextValue);
                        table.setTableValue(row, col + 1, firstValue);
                    }
                }
            }
        }
    }

    // Table -> void
    // This method will sort the Table's columns in ascending order
    // by using Bubble Sort algorithm. I use the swap condition so
    // as soon as no swaps are done in a column is means that our column is sorted.
    public void sortColumns(Table table)
    {
        int row = 0;
        int col = 0;
        // for each column ...
        for(col = 0; col < table.getSize(); col++)
        {
            boolean swap = true;
            while (swap)
            {
                swap = false;
                // .... iterate it's values
                for (row = 0; row < table.getSize() - 1; row++)
                {
                    int firstValue = table.getTableValue(row, col);
                    int nextValue = table.getTableValue(row + 1, col);
                    // if this is conditions is not met, then it won't change de "swap" variable and jump to
                    // the next row
                    if (firstValue > nextValue)
                    {
                        swap = true;
                        table.setTableValue(row, col, nextValue);
                        table.setTableValue(row+1, col, firstValue);
                    }
                }
            }
        }
    }

    // Table -> boolean
    // This method will validate if a row is sorted in ascending order
    // it will iterate every value in the row
    public boolean isRowSorted(Table table)
    {
        int row;
        int col;
        // for every row and it's values
        for(row = 0; row < table.getSize();row++)
        {
            for(col = 0;col < table.getSize()-1;col++)
            {
                // firstValue is our starting value
                int firstValue = table.getTableValue(row, col);
                // nextValue is our value next to the starting value
                int nextValue = table.getTableValue(row, col+1);
                // if its not sorted then return false
                if(firstValue > nextValue)
                    return false;
            }
        }
        // if the rows are sorted then return true
        return true;
    }

    // Table -> boolean
    // This method will validate if a column is sorted in ascending order
    // it will iterate every column that the table has comparing it's values.
    public boolean isColumnSorted(Table table)
    {
        int row;
        int col;
        // Iterate every column on our table
        for(col = 0; col < table.getSize(); col++)
        {
            // For each column, iterate it's values
            for(row = 0; row < table.getSize()-1; row++)
            {
                // firstValue is our starting value
                int firstValue = table.getTableValue(row, col);
                // nextValue is our value next to the starting value
                int nextValue = table.getTableValue(row+1, col);
                // if its not sorted then return false
                if(firstValue > nextValue)
                    return false;
            }
        }
        // if the columns are sorted then return true
        return true;
    }

}
