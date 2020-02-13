/*
 * Author: <<author name redacted >>
 * Date:01/23/2020
 * Title: Assignment 2
 * Purpose: Count the number of operations that it takes to execute Sort
 *
 * 02/06/2020
 * Corrections made based on Dr.Roach's comments (FOR LOOPS and  assignments with function calls)
 * */
package cs5387;

public class TableSorter {

    public int countOperation = 0;

    public static void main(String[] args) throws Exception
    {
        // create table object
        Table table = Table.GetTable("test4");
        // print content
        System.out.println(table.toString());
        // create a TableSorter object
        TableSorter tableSorter = new TableSorter();
        // check if the table is already sorted
        System.out.println(tableSorter.isSorted(table));
        System.out.println("========================================== sort ===================================================");

        // VARIABLE DECLARATION
        tableSorter.countOperation += 1;
        // sort the table
        tableSorter.countOperation += 1; // FUNCTION CALL count 1 operation
        tableSorter.sortable(table);
        // print the matrix
        System.out.println(table.toString());
        // print if the new sorted table is sorted
        System.out.println(tableSorter.isSorted(table));
        //steps taken
        System.out.println("Steps taken: " + tableSorter.countOperation);
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
        countOperation++; // FUNCTION call "sortRows"
        sortRows(table);
        countOperation++; // FUNCTION called "sortColumns"
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

        countOperation += 3; // 3 vairable declarations
        // for each row...
        // for loop contains 4 operations, but I'll count 2 in the loop (comparison and increment),
        //  1 assignment operation
        //  1 exit condition

        countOperation += 2; // FOR assignment variable and exit condition
        for(row = 0; row < table.getSize(); row++)
        {
            swap = true;
            // swap assignment
            countOperation++;

            // WHILE CONDITION
            countOperation+=1;
            while(swap)
            {
                // WHILE CONDITION BRANCH
                countOperation +=1;

                swap = false;
                // swap false assignment
                countOperation++;

                countOperation += 2; // FOR assignment and compare
                for (col = 0; col < table.getSize() - 1; col++)
                {

                    // 2 VARIABLE DECLARATION plus 2 assignments
                    countOperation += 4;
                    int firstValue = table.getTableValue(row, col);
                    int nextValue = table.getTableValue(row, col + 1);
                    // if this is conditions is not met, then it won't change de "swap" variable and jump to
                    // the next column

                    // IF COMPARISON
                    countOperation += 1;
                    if (firstValue > nextValue)
                    {
                        // 3 operations and 1 Branch
                        countOperation += 4;
                        swap = true;
                        table.setTableValue(row, col, nextValue);
                        table.setTableValue(row, col + 1, firstValue);
                    }
                    countOperation+=1; //BRANCH Not IF
                    countOperation += 3; // FOR LOOP INCREMENT, BRANCH, COMPARE
                }
                countOperation += 1; //FOR EXIT CONDITION
            }
            countOperation += 1; // WHILE BRANCH WHEN FALSE
            countOperation += 3; // FOR LOOP INCREMENT, BRANCH, COMPARE
        }
        countOperation += 1; // FOR LOOP CONDITION FALSE
    }

    // Table -> void
    // This method will sort the Table's columns in ascending order
    // by using Bubble Sort algorithm. I use the swap condition so
    // as soon as no swaps are done in a column is means that our column is sorted.
    public void sortColumns(Table table)
    {
        int row = 0;
        int col = 0;
        // 2 variable declarations
        countOperation += 2;
        // for each column ...

        countOperation += 2; // FOR assignment and compare
        for(col = 0; col < table.getSize(); col++)
        {
            // FOR increment variable and comparison
            countOperation +=2;

            boolean swap = true;
            // 1 vairable declarations
            countOperation += 1;

            // WHILE CONDITION
            countOperation+=1;
            while (swap)
            {
                // WHILE CONDITION BRANCH
                countOperation +=1;

                swap = false;
                // swap false assignment
                countOperation++;

                // .... iterate it's values
                countOperation += 2; // FOR assignment and compare
                for (row = 0; row < table.getSize() - 1; row++)
                {
                    // 2 VARIABLE DECLARATION plus 2 assignments
                    countOperation += 4;
                    int firstValue = table.getTableValue(row, col);
                    int nextValue = table.getTableValue(row + 1, col);
                    // if this is conditions is not met, then it won't change de "swap" variable and jump to
                    // the next row

                    // IF COMPARISON
                    countOperation += 1;
                    if (firstValue > nextValue)
                    {
                        // 3 operations and 1 Branch
                        countOperation += 4;
                        swap = true;
                        table.setTableValue(row, col, nextValue);
                        table.setTableValue(row+1, col, firstValue);
                    }
                    countOperation+=1; //BRANCH Not IF
                    countOperation += 3; // FOR LOOP INCREMENT, BRANCH, COMPARE
                }
                countOperation += 1; //FOR EXIT CONDITION
            }
            countOperation += 1; // WHILE BRANCH WHEN FALSE
            countOperation += 3; // FOR LOOP INCREMENT, BRANCH, COMPARE
        }
        countOperation += 1; // FOR LOOP CONDITION FALSE
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
