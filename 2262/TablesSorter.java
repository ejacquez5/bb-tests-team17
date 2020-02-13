/*
 @author <<author name redacted >>
 Purpose: To sort a table in ascending order and check if sorted
 Programming Assignment 1
 Course: CS5387 - Software Integration and V&V
 Professor: Dr. Steve Roach
 Last modification date: 1/25/2020
 */

package cs5387;

public class TablesSorter {

    /** A Places contains, is an inner class because coordinates are commonly used in the algorithms*/
    private class Place{
        int row;
        int col;

        //Removes default constructor to forces row and col to be specified
        private Place(){}
        public Place(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    /** Finds if table is sorted in ascending order
     * @return true if every row and every column of the table t is sorted in ascending order*/
    public boolean isSorted(Table t){
        int tableSize = t.getSize();

        /*We can tell that a table is sorted when every 2 by 2 square is sorted.
        (max value on the bottom-right, and the min on the top-left)*/

        //Iterates through every row except the last
        for(int row = 0; row < tableSize-1; row++){

            //Iterates through every column except the last
            for(int col = 0; col < tableSize-1; col++){

                //Coordinates of the square
                Place[] squareCoordinates = getSquareIdx(row, col);
                //Values of the square
                int [] tableSquareValues = getSquareValues(t, squareCoordinates);

                //Finds where the max and min value is
                int idxMax = argMax(tableSquareValues);
                int idxMin = argMin(tableSquareValues);

                //return false if min isn't in the top-left corner and max isn't at the bottom-right corner
                if(idxMin != 0 || idxMax != 3){
                    return false;
                }

            }
        }
        return true;
    }

    /** Does table sorting of the values (row,col), (row+1,col), (row,col+1), (row+1,col+1),
     * so that index (row, col) value is min, and max value is at index (row+1, col+1)
     * precondition: row+1 < table.getSize() && col+1 < table.getSize() or an index out of bounds exception will be thrown*/
    private void sortSquare(Table t, int row, int col){

        Place[] tableSquareIdx = getSquareIdx(row, col);
        int [] tableSquareValues = getSquareValues(t, tableSquareIdx);

        int idxMax = argMax(tableSquareValues);
        int idxMin = argMin(tableSquareValues);

        //Swaps to min is at index (row,col)
        swapValues(t, tableSquareIdx[idxMin], tableSquareIdx[0]);

        //Updates position of idxMax and idxMin (idxMax could have been moved if it was at index row,col)
        if(idxMax == 0){
            idxMax = idxMin;
            idxMin = 0;
        }
        swapValues(t, tableSquareIdx[idxMax], tableSquareIdx[3]);
    }

    /** @return coordinates for a 2 by 2 square: (row, col), (row+1, col), (row, col+1), (row+1, col+1)
     *  Used for the table sorting algorithm and for the algorithm check if the table is sorted*/
    private Place[] getSquareIdx(int row, int col){
       return new Place[]{
               new Place(row, col),
               new Place(row + 1, col),
               new Place(row, col + 1),
               new Place(row + 1, col + 1)
        };
    }

    /** @return integer array containing the values in the table the parameter places has the coordinates of*/
    private int[] getSquareValues(Table t, Place[] places){
        int[] tableSquareValues = new int[4];
        for(int i = 0; i < places.length; i++){
            Place p = places[i];
            tableSquareValues[i] = t.getTableValue(p.row, p.col);
        }
        return tableSquareValues;
    }

    /** precondition: array can't be null and must have at least 1 element
     * @return the index of where the biggest value is, if precondition isn't met, returns -1 */
    private int argMax(int[] arr) {
        return findArgMaxOrMin(arr, true);
    }

    /** precondition: array can't be null and must have at least 1 element
     * @return the index of where the smallest value is, if precondition isn't met, returns -1 */
    private int argMin(int[] arr){
        return findArgMaxOrMin(arr, false);
    }

    /** Finds the index of where the min value or the max value is.
     * precondition: array can't be null and must have at least 1 element, or else returns -1
     * @param findMax if true finds the argument of max, if false finds the index where the min is
     * @return the index of where the max or min value is*/
    private int findArgMaxOrMin(int[] arr, boolean findMax){
        if(arr == null || arr.length < 1){
            return -1;
        }
        int maxOrMin = arr[0];
        int maxOrMinIndex = 0;
        for(int i = 1; i < arr.length; i++){

            boolean isMaxOrMin = maxOrMin < arr[i];
            //If we are not finding max
            if(!findMax){
                isMaxOrMin = !isMaxOrMin;
            }
            if(isMaxOrMin){
                maxOrMin = arr[i];
                maxOrMinIndex = i;
            }
        }
        return maxOrMinIndex;
    }

    /** Swaps the values in coordinates p1 and p2 of table t */
    private void swapValues(Table t, Place p1, Place p2){
        int p1Value = t.getTableValue(p1.row, p1.col);
        int p2Value = t.getTableValue(p2.row, p2.col);

        t.setTableValue(p1.row, p1.col, p2Value);
        t.setTableValue(p2.row, p2.col, p1Value);
    }

    /** Sorts a Table so that every row and every column of the table t is sorted in ascending order */
    public static void sortable(Table t){
        int tableSize = t.getSize();
        TablesSorter ts = new TablesSorter();

        /*Algorithm: Sorts every 2 by 2 square in the table, if you do this tableSize * 2  - 1 times, then eventually
        * the table will be fully sorted since during every square sort a value will be moved at least one place*/
        for(int i = 0; i < tableSize * 2 - 1 && !ts.isSorted(t); i++){

            //TableSize - 1 because, index row,col already checks row+1 and col+1
            for (int row = 0; row < tableSize-1; row++) {

                for (int col = 0; col < tableSize-1; col++) {
                    ts.sortSquare(t, row, col);
                }
            }
        }
    }
}
