/*
 @author <<author name redacted>>
 Purpose: To sort a table in ascending order and check if sorted, and to count number of operations being done
 Programming Assignment 2
 Course: CS5387 - Software Integration and V&V
 Professor: Dr. Steve Roach
 Last modification date: 1/25/2020
 */

package cs5387;

public class TablesSorter {

    //Count number of operations
    private int nAssignments = 0;
    private int nComparisons = 0;
    private int nBranches = 0;
    private int nFnCalls = 0;

    /** A Places contains, is an inner class because coordinates are commonly used in the algorithms*/
    private class Place{
        int row;
        int col;

        //Removes default constructor to forces row and col to be specified
        private Place(){}
        public Place(int row, int col){
            nAssignments += 1;
            nAssignments += 1;
            this.row = row;
            this.col = col;
        }
    }

    /** Finds if table is sorted in ascending order
     * @return true if every row and every column of the table t is sorted in ascending order*/
    public boolean isSorted(Table t){

        if(t == null){
            return false;
        }
        nAssignments += 1;
        nFnCalls += 1;
        int tableSize = t.getSize();

        /*We can tell that a table is sorted when every 2 by 2 square is sorted.
        (max value on the bottom-right, and the min on the top-left)*/

        nAssignments += 1;
        nComparisons += 1; //Initial Comparison
        nBranches += 1;
        //Iterates through every row except the last
        for(int row = 0; row < tableSize-1; row++){

            nAssignments += 1;
            nComparisons += 1; //Initial Comparison
            nBranches += 1;
            //Iterates through every column except the last
            for(int col = 0; col < tableSize-1; col++){

                nFnCalls += 1;
                nAssignments += 1;
                //Coordinates of the square
                Place[] squareCoordinates = getSquareIdx(row, col);

                nFnCalls += 1;
                nAssignments += 1;
                //Values of the square
                int [] tableSquareValues = getSquareValues(t, squareCoordinates);

                nFnCalls += 1;
                nAssignments += 1;
                //Finds where the max and min value is
                int idxMax = argMax(tableSquareValues);

                nFnCalls += 1;
                nAssignments += 1;
                int idxMin = argMin(tableSquareValues);

                nComparisons += 2;
                nBranches += 1;
                //return false if min isn't in the top-left corner and max isn't at the bottom-right corner
                if(idxMin != 0 || idxMax != 3){
                    return false;
                }
                nComparisons += 1; //col < tableSize-1
                nAssignments += 1; //col++
            }
            nComparisons += 1; //row < tableSize-1
            nAssignments += 1; //row++
        }
        return true;
    }

    /** Does table sorting of the values (row,col), (row+1,col), (row,col+1), (row+1,col+1),
     * so that index (row, col) value is min, and max value is at index (row+1, col+1)
     * precondition: row+1 < table.getSize() && col+1 < table.getSize() or an index out of bounds exception will be thrown*/
    private void sortSquare(Table t, int row, int col){

        nAssignments += 1;
        nFnCalls += 1;
        Place[] tableSquareIdx = getSquareIdx(row, col);

        nAssignments += 1;
        nFnCalls += 1;
        int [] tableSquareValues = getSquareValues(t, tableSquareIdx);

        nAssignments += 1;
        nFnCalls += 1;
        int idxMax = argMax(tableSquareValues);

        nAssignments += 1;
        nFnCalls += 1;
        int idxMin = argMin(tableSquareValues);

        //Swaps to min is at index (row,col)
        nFnCalls += 1;
        swapValues(t, tableSquareIdx[idxMin], tableSquareIdx[0]);

        //Updates position of idxMax and idxMin (idxMax could have been moved if it was at index row,col)
        nComparisons += 1;
        nBranches += 1;
        if(idxMax == 0){
            nAssignments += 2;
            idxMax = idxMin;
            idxMin = 0;
        }

        nFnCalls += 1;
        swapValues(t, tableSquareIdx[idxMax], tableSquareIdx[3]);
    }

    /** @return coordinates for a 2 by 2 square: (row, col), (row+1, col), (row, col+1), (row+1, col+1)
     *  Used for the table sorting algorithm and for the algorithm check if the table is sorted*/
    private Place[] getSquareIdx(int row, int col){
        nFnCalls += 4;
       return new Place[]{
               new Place(row, col),
               new Place(row + 1, col),
               new Place(row, col + 1),
               new Place(row + 1, col + 1)
        };
    }

    /** @return integer array containing the values in the table the parameter places has the coordinates of*/
    private int[] getSquareValues(Table t, Place[] places){

        nAssignments += 1;
        int[] tableSquareValues = new int[4];

        nAssignments += 1;
        nComparisons += 1;
        nBranches += 1;
        for(int i = 0; i < places.length; i++){
            nAssignments += 1;
            Place p = places[i];

            nAssignments += 1;
            nFnCalls += 1;
            tableSquareValues[i] = t.getTableValue(p.row, p.col);

            nComparisons += 1;
            nAssignments += 1;
        }
        return tableSquareValues;
    }

    /** precondition: array can't be null and must have at least 1 element
     * @return the index of where the biggest value is, if precondition isn't met, returns -1 */
    private int argMax(int[] arr) {
        nFnCalls += 1;
        return findArgMaxOrMin(arr, true);
    }

    /** precondition: array can't be null and must have at least 1 element
     * @return the index of where the smallest value is, if precondition isn't met, returns -1 */
    private int argMin(int[] arr){
        nFnCalls += 1;
        return findArgMaxOrMin(arr, false);
    }

    /** Finds the index of where the min value or the max value is.
     * precondition: array can't be null and must have at least 1 element, or else returns -1
     * @param findMax if true finds the argument of max, if false finds the index where the min is
     * @return the index of where the max or min value is*/
    private int findArgMaxOrMin(int[] arr, boolean findMax){
        nComparisons += 2;
        nBranches += 1;
        if(arr == null || arr.length < 1){
            return -1;
        }

        nAssignments += 1;
        int maxOrMin = arr[0];

        nAssignments += 1;
        int maxOrMinIndex = 0;

        nAssignments += 1;
        nComparisons += 1;
        nBranches += 1;
        for(int i = 1; i < arr.length; i++){

            nComparisons += 1;
            nAssignments += 1;
            nBranches += 1;
            boolean isMaxOrMin;
            if(findMax){
                nComparisons += 1;
                nAssignments += 1;
                isMaxOrMin = maxOrMin <= arr[i];
            }
            else{
                nComparisons += 1;
                nAssignments += 1;
                isMaxOrMin = maxOrMin > arr[i];
            }

            nComparisons += 1;
            nBranches += 1;
            if(isMaxOrMin) {
                nAssignments += 1;
                maxOrMin = arr[i];
                nAssignments += 1;
                maxOrMinIndex = i;
            }
            nAssignments += 1;
            nComparisons += 1;
        }
        return maxOrMinIndex;
    }

    /** Swaps the values in coordinates p1 and p2 of table t */
    private void swapValues(Table t, Place p1, Place p2){
        nAssignments += 1;
        nFnCalls += 1;
        int p1Value = t.getTableValue(p1.row, p1.col);

        nAssignments += 1;
        nFnCalls += 1;
        int p2Value = t.getTableValue(p2.row, p2.col);

        nFnCalls += 2;
        t.setTableValue(p1.row, p1.col, p2Value);
        t.setTableValue(p2.row, p2.col, p1Value);
    }

    /** Returns numbers of operations done in the class (excluding the operations to count number of operations done)
     * @return int[] of size 4, arr[0] has num of assignments, arr[1] has num of comparisons, arr[2] has num of branches, and arr[3] has num of function calls
     * */
    private int[] getNumOperations(){
        return new int[]{
                nAssignments,
                nComparisons,
                nBranches,
                nFnCalls
        };
    }

    /** Sorts a Table so that every row and every column of the table t is sorted in ascending order */
    public static void sortable(Table t){
        int nAssignments = 0;
        int nComparisons = 0;
        int nBranches = 0;
        int nFnCalls = 0;
        nFnCalls += 1;
        nAssignments += 1;
        int tableSize = t.getSize();

        nFnCalls +=1;
        nAssignments += 1;
        TablesSorter ts = new TablesSorter();

        nAssignments += 1;
        nComparisons += 2;
        nBranches += 1;
        /*Algorithm: Sorts every 2 by 2 square in the table, if you do this tableSize * 2  - 1 times, then eventually
        * the table will be fully sorted since during every square sort a value will be moved at least one place*/
        for(int i = 0; i < tableSize * 2 - 1 && !ts.isSorted(t); i++){
            nBranches += 1;
            nAssignments += 1;
            nComparisons += 1;
            //TableSize - 1 because, index row,col already checks row+1 and col+1
            for (int row = 0; row < tableSize-1; row++) {
                nBranches += 1;
                nAssignments += 1;
                nComparisons += 1;
                for (int col = 0; col < tableSize-1; col++) {
                    nBranches += 1;
                    nFnCalls += 1;
                    ts.sortSquare(t, row, col);

                    nComparisons += 1;
                    nAssignments += 1;
                }

                nComparisons += 1;
                nAssignments += 1;
            }

            nComparisons += 2;
            nAssignments += 1;
        }
        int[] nOperations = ts.getNumOperations();
        nAssignments += nOperations[0];
        nComparisons += nOperations[1];
        nBranches += nOperations[2];
        nFnCalls += nOperations[3];
        System.out.println("Number of Assignments: " + nAssignments + "\n Number of Comparisons: " + nComparisons);
        System.out.println("Number of Branches: " + nBranches + "\n Number of Function calls: " + nFnCalls);

    }

}
