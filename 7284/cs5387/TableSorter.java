/*
    author: <<author name redacted >>
    course : CS 5387 W 18:00
    Programming Assignment 2
 */
package cs5387;

public class TableSorter {
    /*
    The following method, isSorted, returns true if every row and column in Table t is sorted in ascending order
     */
    public boolean isSorted(Table t){

        // if Table t is 1x1 then the table is sorted
        if(t.getSize() == 1) {
            return true;
        }
        /*
        comparison: Contains the current number in the table the the others are being compared agains
        comparingIndex: Saves the index the current number we are comparing against
         */
        int comparison;
        int comparingIndex;

        /*
        The following loops check the rows of the table are ordered in ascending order
        If any of the values is greater than the number we are comparing against the table (starts at the end of the row, and decreases)
        is not sorted.Else, the comparing index is decreased until is reaches the beginning of the table row, which is index [x][0]
         */
        for(int i = 0; i < t.getSize();i++) {
            comparingIndex = t.getSize()-1;
            comparison = t.getTableValue(i,comparingIndex);

            for (int j = 0; j < t.getSize(); j++) {
                if(t.getTableValue(i,j) > comparison){
                    return false;
                }else if(j == comparingIndex){
                    comparingIndex --;
                    j = -1;
                }else{
                    continue;
                }
            }
        }
        /*
        The following loop checks the columns of the table are ordered in ascending order.
        The following operations follow the same idea as the loops above. The comparing index is decreased until it reaches
        the top value of the column [0][y].
         */

        for(int i = 0; i < t.getSize();i++){
            comparingIndex = t.getSize()-1;
            comparison = t.getTableValue(comparingIndex,i);
            for (int j = 0; j < t.getSize(); j++) {
                if(t.getTableValue(j,i)> comparison){
                    return false;
                }else if(j == comparingIndex){
                    comparingIndex --;
                    j = -1;
                }else {
                    continue;
                }
            }
        }

        return true;
    }
    /*
    The following method, sortable, sorts every column and row in Table T in ascending order
     */
    public static void sortTable(Table t){
        int counter = 0; //variable keeping track of operations
        /*
        pivot: value we are comparing the other values in the table against to sort it ascending order
        holder: holds a value when conducting a swap within a table
        pivotIndex: holds the index of where the pivot value is contained in the table
         */

        int pivot;
        int holder;
        int pivotIndex;
        counter+=3;

        /*
        Sorting the rows in the table in ascending order

        Incrementing counter plus two because of the initialization of i (the iterator of the loop), the initial comparison of i against the size of the table
        and the calling of the table method
         */
        counter+=3;
        for(int i = 0; i < t.getSize();i++) {
            //the pivot is initialized as the value in the biggest index within a row, its index is saved in pivotIndex
            pivotIndex  = t.getSize() -1;
            pivot = t.getTableValue(i,pivotIndex);

            /*
            Adding seven to counter because of the top two assignments,
            the two callings of the table methods
            the assignment of j, the comparison of j against the size of the table
            and the calling of the table function to get the size of the table
             */
            counter+=7;

            for (int j = 0; j < t.getSize(); j++) {

                /*
                if the table is sized 1x1, then the table is sorted and the loop will end
                if the pivotIndex is equal to zero, then we have traversed the whole row and the row is ordered in ascending order
                 */
                if(t.getSize() == 1 || pivotIndex == 0){
                    //Break operation
                    counter++;
                    break;
                }
                /*
                    Adding plus three to counter for the two comparisons of the if statement above,
                    and the calling of the table function to get the size
                */
                counter+=3;

                counter++; //branching when condition in above if statement is false.

                /*
                if the current table value is bigger than the pivot then we swap the values in the table
                Adding two to counter for the comparison of the if statement below and the calling of the get table value function
                 */
                counter+=2;
                if(t.getTableValue(i,j) > pivot){
                    /*
                    swapping values operations
                     */
                    holder = t.getTableValue(i,j);
                    t.setTableValue(i,j,pivot);
                    t.setTableValue(i,pivotIndex,holder);
                    //the pivot value is updated the the value in its index
                    pivot = t.getTableValue(i,pivotIndex);

                    //Add six to counter for the above assignments plus the remaining callings of the table functions
                    counter+=6;
                }
                counter++; //branching when condition in above if statement is false.

                /*
                if the loop iterations are about to reach the pivotIndex, the pivotIndex is decreased by one, the pivot value is updated,
                and the loop is restarted.
                Adding 1 to counter for the comparison of the if statement below
                 */
                counter++;
                if (j == (pivotIndex-1)){
                    pivotIndex--;
                    j = -1;
                    pivot = t.getTableValue(i,pivotIndex);
                    //Adding four to counter for the above assignments, operations and the calling of the table function
                    counter+=4;
                }
                counter++; //branching when condition in above if statement is false.
                /*
                Adding the incrementing of j to counter,the branching of the loop and the loop comparison statement
                 */
                counter+=3;

            }
            counter++; //for when comparison of loop fails
            // Adding to increment to i in the loop,the branching of the loop and the comparison statement
            counter+=3;
        }
        counter++; //for when comparison of loop fails
        /*
        Sorting the columns in the table in ascending order
        Incrementing counter plus two because because of the initialization of i (the iterator of the loop),
        the initial comparison of i against the size of the table, and the calling of the get table size function
         */
        counter+=3;
        for(int i = 0; i < t.getSize();i++) {
            //The pivot is initialized as the value in the biggest index within a column, its index is saved in pivotIndex
            pivotIndex  = t.getSize() -1;
            pivot = t.getTableValue(pivotIndex,i);
             /*
            Adding six to counter because of the top two variable assignments, the calling of the table size method, the get table value method
            plus the assignment of j, the comparison of j against the size of the table and again the calling of the table size function
             */
            counter+=7;
            for (int j = 0; j < t.getSize(); j++) {
                counter++;
                /*
                if the table is sized 1x1, then the table is sorted and the loop will end
                if the pivotIndex is equal to zero, then we have traversed the whole column and the column is ordered in ascending order
                 */
                if(t.getSize() == 1 || pivotIndex == 0){
                    //Adding one for break operation
                    counter++;
                    break;
                }
                counter++; //branching when condition in above if statement is false.
                 /*
                    Adding plus two to counter for the two comparisons of the if statement above and the calling of the get
                    table size function
                */
                counter+=3;
                /*
                    if the current table value is bigger than the pivot then we swap the values in the table
                    Adding 1 to counter for the comparison of the if statement below and the calling of the get table value function
                 */
                counter+=2;
                if(t.getTableValue(j,i) > pivot){
                    /*
                    swapping values
                     */
                    holder = t.getTableValue(j,i);
                    t.setTableValue(j,i,pivot);
                    t.setTableValue(pivotIndex,i,holder);
                    //the pivot value is updated the the value in its index
                    pivot = t.getTableValue(pivotIndex,i);
                    //Add six to counter for the above variable assignments and for each table object function calling
                    counter+=6;
                }
                counter++; //branching when condition in above if statement is false.

                /*
                if the loop iterations are about to reach the pivotIndex, the pivotIndex is decreased by one, the pivot value is updated,
                and the loop is restarted.
                Adding 1 to counter for the comparison of the if statement below
                 */
                counter++;
                if (j == (pivotIndex-1)){
                    pivotIndex--;
                    j = -1;
                    pivot = t.getTableValue(pivotIndex,i);
                    /*
                    Adding 3 to counter for the above assignments and operations, plus the calling of the
                    get table value function
                     */
                    counter+=4;
                }
                counter++; //branching when condition in above if statement is false.

                /*
                Adding the incrementing of j to counter, loop branching and comparison
                 */
                counter+=3;
            }
            counter++; //for when comparison of loop fails
            // Adding to increment to i in the loop, loop branching and comparison
            counter+=3;
        }
        counter++; //for when comparison of loop fails

        System.out.println("Number of operations " + counter);
    }
    public static void printTable(Table t){
        for(int i =0; i<t.getSize();i++){
            for(int j = 0; j < t.getSize();j++){
                System.out.print(t.getTableValue(i,j)+ ",");
            }
            System.out.println();
        }
    }

}
