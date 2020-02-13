/**
 * The TableSorter is a program that checks if an object of
 * the Table class is sorted in ascending order and provides
 * a simple method that sorts the contents of the table.
 *
 * @author  <<author name redacted >>
 * @version 1.1
 * @since   2020-02-05
 */
package com.company;
import java.io.IOException;

public class TableSorter {
    private Table table;
    private boolean isTableSorted;
    int count; //counter for counting programs operations

    public TableSorter(Table T) {
        table = T;
        isTableSorted = isSorted(table);
    }

    public int getCount() {
        return count;
    }

    public boolean isSorted(Table T) {
        // getting the size of the table and putting it into an array for iteration
        int tableSize = T.getSize();
        int[][] tableArr = new int[tableSize][tableSize];

        // putting values from table into our array
        for (int i = 0; i < tableArr.length; i++) {
            for (int j = 0; j < tableArr[i].length; j++) {
                tableArr[i][j] = T.getTableValue(i,j);
            }
        }
        // checks if the next element is greater than the current element
        for (int i = 0; i < tableArr.length; i++) {
            for (int j = 0; j < tableArr.length - 1; j++) {
                if (tableArr[i][j] > tableArr[i][j + 1]) {
                    return false;
                }
            }
        }

        return true;


    }

    public void sortable(Table T) {
        // getting the size of the table and putting it into an array for iteration
        int tableSize = T.getSize();
        count++; // tableSize assignment
        count++; // getSize method
        int[][] tableArr = new int[tableSize][tableSize];
        count++; //tableArr assignment

        // putting values from table into our array
        for (int i = 0; i < tableArr.length; i++) {
            count++; // i assignment
            count++; // tableArr.length comparison
            for (int j = 0; j < tableArr[i].length; j++) {
                count++; // j assignment
                count++; // tablleArr[i].length comparison
                tableArr[i][j] = T.getTableValue(i,j);
                count++; //tableArr[i][j] assignment
                count++; //getTableValue method

                count++; //End of loop branch
            }
            count++; //Exit loop branch

            count++; //End of loop branch
        }
        count++; //Exit loop branch
        // sorts the elements by sorting the rows and transposing it so both rows and columns are sorted
        // sorting columns first instead of rows also works but gives a different order in the table
        rowSort(tableArr,tableSize);
        count++; //rowSort method

        transpose(tableArr, tableSize);
        count++; //transpose method

        rowSort(tableArr,tableSize);
        count++; //rowSort method

        transpose(tableArr, tableSize);
        count++; //transpose method

        // after sorting, returning the new contents to the Table object.
        for (int i = 0; i < tableArr.length; i++) {
            count++; // i assignment
            count++; //  i and tableArr.length comparison
            for (int j = 0; j < tableArr[i].length; j++) {
                count++; // j assignment
                count++; // j and tableVar[i].length comparison
                T.setTableValue(i,j,tableArr[i][j]);
                count++; //setTableValue method

                count++; //End of loop branch
            }
            count++; //Exit loop branch

            count++; //End of loop branch
        }
        count++; //Exit loop branch

    }

    //sorting the rows
    private void rowSort(int[][] arr, int size) {

        for (int i = 0; i < size; i++) {
            count++; //  i assignment
            count++; //  i and size comparison
            int temp;
            count++; //  temp assignment

            for (int j = 0; j < size; j++) {
                count++; //  j assignment
                count++; //  j and size comparison
                for (int k = j + 1; k < size; k++) {
                    count++; //  i assignment
                    count++; //  i and size comparison

                    if (arr[i][j] > arr[i][k]) {
                        count++; //  arr[i][j] and arr[i][k] comparison
                        // using bubble sort to put the elements in ascending order
                        temp = arr[i][j];
                        count++; //  temp assignment
                        arr[i][j] = arr[i][k];
                        count++; //  arr[i][j] assignment
                        arr[i][k] = temp;
                        count++; //  arr[i][k] assignment
                    }

                    count++; //End of loop branch
                }
                count++; //Exit loop branch

                count++; //End of loop branch
            }
            count++; //Exit loop branch

            count++; //End of loop branch
        }
        count++; //Exit loop branch
    }

    //transposes the array so the columns can be sorted
    private void transpose (int[][] arr, int size) {
        for (int i = 0; i < size; i++) {
            count++; //  i assignment
            count++; //  i and size comparison
            for (int j = i + 1; j < size; j++) {
                count++; //  j assignment
                count++; //  j and size comparison

                int temp;
                count++; //  temp assignment

                //shifting the array on its side so columns become rows and vice versa.
                temp = arr[i][j];
                count++; //  temp assignment
                arr[i][j] = arr[j][i];
                count++; //  arr[i][j] assignment
                arr[j][i] = temp;
                count++; //  arr[j][i] assignment

                count++; //End of loop branch
            }
            count++; //Exit loop branch

            count++; //End of loop branch
        }
        count++; //Exit loop branch
    }
}
