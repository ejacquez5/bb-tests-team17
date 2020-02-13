/**
 * Programming Assignment 1
 *
 * Program sorts tables using bubble sort
 * Strategy used was to convert table to 1D array -->
 * Bubble sort 1d Array --> return table
 *
 * Programming Assignment 2
 *
 * Added counter object to count the number of
 * operations required to execute Sort on the TableSorter class.
 * Counts Assignment Statements, Comparison Operations, branches and function calls.
 *
 * @author <<author name redacted>>
 * @since   02/03/2020
 * **/

import java.util.Random; // used to test if program sorts
public class TableSorter {
    static counter sortCounter = new counter();

    /**
     * Added counter code since this method is used by sortable
     * */
    public static boolean isSorted(Table t) {
        for(int i = 0; i < t.getSize()-1; i++){
            sortCounter.addAssignment();
            sortCounter.addComparison();
            // +3 Branches due to for loop
            sortCounter.addBranch();
            sortCounter.addBranch();
            sortCounter.addBranch();
            for(int j = 0; j < t.getSize()-1; j++){
                sortCounter.addAssignment();
                sortCounter.addComparison();

                sortCounter.addComparison();
                sortCounter.addFunctionCall(); // if statement is calling getTableValue
                if(t.getTableValue(i,j) > t.getTableValue(i,j+1) ) {
                    sortCounter.addBranch();
                    return false;
                }
                sortCounter.addBranch();

                sortCounter.addBranch();
                sortCounter.addBranch();
                sortCounter.addBranch();
            }
        }
        return true;
    }
    /*
    * 1) converts table to 1D array
    * 2) Sorts 1D array using bubble sort
    * 3) Converts sorted 1D array to table
    * Counts Assignment Statements, Comparison Operations, branches and function calls
    * */
    public static void sortable (Table t) throws Exception {
        int[] tableArray = tableToArray( t );
        sortCounter.addAssignment();
        sortCounter.addFunctionCall();

        int n = tableArray.length;
        sortCounter.addAssignment();

        int square = t.getSize() * t.getSize() ;
        sortCounter.addAssignment();
        sortCounter.addFunctionCall();
        sortCounter.addFunctionCall();

        boolean sorted = false;
        sortCounter.addAssignment();

        //bubble sort on 1d array
        for (int i = 0; i < n - 1; i++){
            sortCounter.addAssignment();
            sortCounter.addComparison();

            sortCounter.addBranch();
            sortCounter.addBranch();
            sortCounter.addBranch();
            for (int j = 0; j < n - i - 1; j++) {
                sortCounter.addAssignment();
                sortCounter.addComparison();
                // check if sorted so program doesn't have to iterate the whole way. Improves Performance
                t = new Table(square, tableArray);
                sortCounter.addAssignment();

                sortCounter.addComparison();
                sortCounter.addFunctionCall(); // isSorted() is always called to check when to stop

                sortCounter.addBranch();
                sortCounter.addBranch();
                sortCounter.addBranch();

                sortCounter.addBranch();
                if(isSorted(t)){
                    sorted = true;
                    sortCounter.addAssignment();
                    sortCounter.addBranch();
                    break;
                }
                sortCounter.addComparison();

                sortCounter.addBranch();
                if (tableArray[j] > tableArray[j + 1]) {
                    int temp = tableArray[j];
                    sortCounter.addAssignment();

                    sortCounter.addBranch();

                    tableArray[j] = tableArray[j + 1];
                    tableArray[j + 1] = temp;
                    sortCounter.addAssignment();
                    sortCounter.addAssignment();
                }
                sortCounter.addBranch();
            }
            sortCounter.addBranch();
            if(sorted== true){
                sortCounter.addBranch();
                sortCounter.addComparison();
                sortCounter.addBranch(); // for break
                System.out.print(t.toString()); // print sorted table
                sortCounter.addFunctionCall();
                break;
            }
        }
        sortCounter.printCounts();

    }
    /*Convert table to array so Bubblesort is simple
    * Note: Added counting methods since this method is called by the sort method
    * */
    public static int[] tableToArray(Table table){
        int arraySize = table.getSize() *table.getSize();
        sortCounter.addAssignment();
        sortCounter.addFunctionCall();
        sortCounter.addFunctionCall();

        int count = 0;
        sortCounter.addAssignment();

        int tempHolder = 0;
        sortCounter.addAssignment();

        int [] array = new int[arraySize];
        sortCounter.addAssignment();

        for(int i = 0; i < table.getSize(); i++) {
            sortCounter.addAssignment();
            sortCounter.addComparison();

            sortCounter.addBranch();
            sortCounter.addBranch();
            sortCounter.addBranch();

            for (int j = 0; j < table.getSize(); j++) {
                sortCounter.addAssignment();
                sortCounter.addComparison();
                tempHolder = table.getTableValue( i, j );
                sortCounter.addAssignment();
                sortCounter.addFunctionCall();
                array[count] = tempHolder;
                sortCounter.addAssignment();
                count++;
                sortCounter.addAssignment();
                sortCounter.addBranch();
                sortCounter.addBranch();
                sortCounter.addBranch();
            }
        }
        return array;
    }

    public static void main(String [] args) throws Exception{
        Random rand = new Random();
        int n = 4;
       // int[] arr =new int[16];
        int[] arr = {4,1,2,3};
        System.out.println("Random Array Generated");
        // generates numbers numbers from 1 to 100, used to show that program works
        for(int i = 0; i < arr.length; i++){
         //   arr[i] = rand.nextInt(100);
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.println("Before Sort");
        Table table = new Table(n, arr);
        System.out.println(table.toString());
        System.out.println("After Sort");
        sortable(table);
    }
}
