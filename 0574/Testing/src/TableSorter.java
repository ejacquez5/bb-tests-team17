/**
*@author <<author name redacted>>
*Created 1/26/2020
*@Version 1.0
*TableSorter is a class that uses Table interface to sort a table of integers from the file "filename" in ascending
*order. Main method in thi class instanciates Table and generates an unsorted table using the "filename" file and runs it
*through sortTable (sorts table), isSorted (verifies if table is sorted), and printTable(prints current state of table) methods.
 */

public class TableSorter {

    static Table table;
    public static int counter=0;

    public static void main(String[] args) throws Exception {

        try {
            table = table.GetTable("filename");
            System.out.println("Unsorted Initial Table");
            printTable(table);
            counter++;
            sortTable(table);
            if (isSorted(table) == true) {
                System.out.println("Sorted Table");
                counter++;  printTable(table);
                System.out.println("Total number of operations: "+counter);
            } else {
                System.out.println("Program unable to sort table");
                counter++;
                printTable(table);
            }

        } catch (NumberFormatException e) {
            System.out.println("filename file contains non-integer characters or is empty, please review");
        } catch (NullPointerException n) {

        } catch (Exception e) {
            System.out.println("filename contains a list of integers that cannot be squared, please review");
        }


    }


    /**
     *
     * @param t variable of type Table
     * @return boolean
     *
     * method iterate through Table sorted or unsorted and returns a boolean if a table is sorted or not. Method iterates
     * through table using 2 for-loops with two if statements that check if a particular element is smaller than the
     * element before it. If an element is bigger than the next element in line, the method returns false. If the table
     * in ascending order, the method returns true.
     */
    public static boolean isSorted(Table t) {

        for (int i = 0; i < t.getSize(); i++)
            for (int j = 0; j < t.getSize(); j++) {
                if (j > 1 && t.getTableValue(i, j) < t.getTableValue(i, j - 1)) { //checks current with previous element
                    return false;
                }
                if (i > 0 && t.getTableValue(i, j) < t.getTableValue(i - 1, t.getSize() - 1)) {
                    return false;
                }
            }
        return true;
    }

    /**
     *
     * @param t variable of type Table
     *
     * sortTable sorts t using a bubble sort approach, where the smallest element swaps with the larger element in order
     * follow  ascending order. Two for-loops where used to iterate through the Table element. Two if statements
     * that compare the values of the current element with its predecessor in either the previous column or the last element
     * of the previous row. If a swap is made, the for-loops are either restarted by zeroing the i(row)  and j(column)
     * indexes or by making a recursive call to the method.
     */
    public static void sortTable(Table t) {
        counter+=3; //assignment, comparison,function call
        for (int i = 0; i < t.getSize(); i++) {
            counter+=3; //assignment, comparison,function call
            for (int j = 0; j < t.getSize(); j++) {
                counter+=4; //2 function calls, 2 compare
                if (j > 0 && t.getTableValue(i, j) < t.getTableValue(i, j - 1)) {
                    counter+=2; //assignment,function call
                    int temp = t.getTableValue(i, j - 1); //Value holder for swapped element
                    counter+=2; //function call 2
                    t.setTableValue(i, j - 1, t.getTableValue(i, j));  //swapping
                    counter++; //function call
                    t.setTableValue(i, j, temp);    //swapping
                    counter++; //assignment
                    i = 0;    //zeroed indexes
                    counter++; //assignment
                    j = 0;
                }
                counter++; //condition is false
                counter+=5; //2 comparison,3 function call
                if (i > 0 && t.getTableValue(i, j) < t.getTableValue(i - 1, t.getSize() - 1)) {
                    counter+=3; //assignment, 2 function call
                    int temp = t.getTableValue(i - 1, t.getSize() - 1); //Value holder for swapped element
                    counter+=3; // 3 function call
                    t.setTableValue(i - 1, t.getSize() - 1, t.getTableValue(i, j));   //swapping
                    counter++; //function call
                    t.setTableValue(i, j, temp);  //swapping
                    counter++; //function call
                    sortTable(t); //recursive call
                }
                counter++; //condition is false
                counter+=3; //for loop, comparison and increment
            }
            counter++; //condition is false in for loop
            counter+=3; //for loop, comparison and increment
        }
        counter++; //condition is false for loop

    }

    /**
     *
     * @param t type Table
     *
     *printTable prints the current version of the table using a double for-loop
     */
    public static void printTable(Table t) {
        for (int i = 0; i < t.getSize(); i++) {
            for (int j = 0; j < t.getSize(); j++) {
                System.out.print("[" + t.getTableValue(i, j) + "]"); //printing table elements
            }
            System.out.println();
        }
        System.out.println();


    }

}
