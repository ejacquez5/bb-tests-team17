/**
 * The TableSorter class verifies if a table is sorted.
 * If table is not sorted, then it sorts it in ascending order.
 *
 * @author  <<author name redacted >>
 * @version 1.0
 * @since   2020-01-29
 */

package cs5387;

import java.util.Arrays;

public class TableSorter{

    //This function returns true if every row and every column of
    //the table t is sorted in ascending order
    public static boolean isSorted(int a[][]){

        int comp = 2; //Variable to compare rows and columns.

        // This function Checks
        // if table is in ascending order
        for (int row = 0; row < comp; row++){
            for (int col = 0; col < comp; col++){

                // This is an out of bounds
                // condition for column
                if (row - 1 >= 0){
                    if (a[row][col] <= a[row - 1][col])
                        return false;
                }

                // This is an out of bounds
                // condition for row
                if (col - 1 >= 0){
                    if (a[row][col] <= a[row][col - 1])
                        return false;
                }
            }
        }

        return true;
    }

    public static void sortable(int a[][], int n){

        // Temporal matrix to copy elements
        int temp[] = new int[n * n];
        int k = 0;

        // copy the elements of matrix
        // one by one into temp[]
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++){
                temp[k++] = a[i][j];
            }
        }

        // sort temp[]
        Arrays.sort(temp);

        // copy the elements of temp[]
        // one by one in mat[][]
        k = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++) {
                a[i][j] = temp[k++];
            }
        }
    }

    //This method gets all elements of the array and
    //displays them to the screen.
    public static void print(int[][]a){
        for(int row = 0; row < a.length; row++){
            for(int col = 0; col < a[row].length; col++){
                System.out.print(a[row][col]+"\t");
            }
            System.out.println();
        }
    }

    //This method populates array with random numbers.
    public static int[][] populateArray(int r, int c){
        int[][] a = new int[r][c];
        for(int row = 0; row < a.length; row++){
            for(int col = 0; col < a[row].length; col++){
                a[row][col] = (int)(Math.random()*41);
            }
        }
        return a;
    }

    public static void main(String[] args){
        int[][] a = populateArray(4,4);
        int n = a.length;

        int b[][] = { { 2, 10,11,13},
                { 20, 23,80,80},
                {80,90,92,95},
                {96,98,100,80}};

        //Prints the content of the array
        System.out.println("Matrix A");
        print(a);
        System.out.println("\nMatrix B");
        //print(b);

        sortable(a, n);
        print(a);

        //Returns True if array is sorted
        //False otherwise
        if(isSorted(a))
            System.out.print("\nTrue");

        else
            System.out.print("\nFalse");

    }
}