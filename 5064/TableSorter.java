/**********************************************************************************************************
 * Author: <<author name redacted >>
 * Purpose: To create a Java class TableSorter which has a instance method named sortable that
 *          sorts a Table by row and column in ascending order.
 *          It also has a instance method named isSorted which returns true if all rows and columns are sorted.
 * Modifications: Added the functionality to return the number of operations required to sort the table.
 *
 */
package cs5387;

public class TableSorter {
    public static int operationCounter =0;
    public static void main(String[] args) throws Exception {
        Table tableInit = Table.GetTable("tableFile.txt");
        sortable(tableInit);
        System.out.println("Number of operations: " + operationCounter);
        System.out.println(isSorted(tableInit));
    }

    public static void sortable (Table tableInit){
        rowSorter(tableInit);
        colSorter(tableInit);

    }

    public static boolean isSorted(Table tableInit){
        /* Staring at position row = 1, and col = 1 is necessary to avoid out of bounds exception when
            checking if the next item is bigger.
            Instead we check that the item before is smaller.
         */
        for(int row = 1 ; row <tableInit.getSize() ; row++) {
            for (int col = 1; col < tableInit.getSize(); col++) {
                /* Returning false as soon as we identify that the Table is not sorted
                for either row or column saves us having to use another nested loop to check
                them separately.
                 */
                if(tableInit.getTableValue(row-1,col)<tableInit.getTableValue(row-1,col-1)){
                    return false;
                }
                if(tableInit.getTableValue(row,col-1)<tableInit.getTableValue(row-1,col-1)){
                    return false;
                }
            }
        }
        return true;
    }
    /* In order to make it more readable I abstracted the sorting by row into this method
        In this method I used bubble sort, since we were limited to only I/O library
        this was an alternative way to sort the Table in an efficient way.
     */
    public static void rowSorter(Table tableInit){
        operationCounter++;
        for(int row = 0 ; row <tableInit.getSize() ; row++) {
            operationCounter = operationCounter + 3;
            for (int col = 0; col < tableInit.getSize(); col++) {
                operationCounter = operationCounter + 3;
                for(int k = 0; k < tableInit.getSize()-col-1;k++){
                    operationCounter = operationCounter + 3;
                    if(tableInit.getTableValue(row,k) > tableInit.getTableValue(row,k+1)){
                        operationCounter = operationCounter + 3;
                        int temp = tableInit.getTableValue(row,k);
                        operationCounter = operationCounter + 2;
                        tableInit.setTableValue(row,k,tableInit.getTableValue(row,k+1));
                        operationCounter = operationCounter + 2;
                        tableInit.setTableValue(row,k+1,temp);
                        operationCounter++;
                    }

                }

            }
        }
        operationCounter = operationCounter + 3;
    }
    /* In order to make it more readable I abstracted the sorting by column into this method
    In this method I used bubble sort, since we were limited to only I/O library
    this was an alternative way to sort the Table in an efficient way.
 */
    public static void colSorter(Table tableInit){
        for(int col = 0 ; col <tableInit.getSize() ; col++) {
            operationCounter+=3;
            for (int row = 0; row < tableInit.getSize(); row++) {
                operationCounter+=3;
                for(int k = 0; k < tableInit.getSize()-row-1;k++){
                    operationCounter+=3;
                    if(tableInit.getTableValue(k,col) > tableInit.getTableValue(k+1,col)){
                        operationCounter+=3;
                        int temp = tableInit.getTableValue(k,col);
                        operationCounter+=2;
                        tableInit.setTableValue(k,col,tableInit.getTableValue(k+1,col));
                        operationCounter+=3;
                        tableInit.setTableValue(k+1,col,temp);
                        operationCounter++;
                    }
                }

            }
        }
        operationCounter+=3;
    }
    /*For testing purposes only*/
    public static void printTable(Table tableInit){
        for(int row = 0 ; row <tableInit.getSize() ; row++) {
            for (int col = 0; col < tableInit.getSize(); col++) {
                System.out.print(tableInit.getTableValue(row, col));
            }
            System.out.println();
        }
    }
}
