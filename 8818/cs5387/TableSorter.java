
/**
 * @author  <<author name redacted>>
 * @version 1.1
 * 
 * The purpose of this program is to populate a Table and then sort it out
 * After sorting the table, it will be confirmed if it was sorted
 * 
 * The placement of the operation counter was updated to have a better count
 */

import cs5387.Table;
import java.util.*;

public class TableSorter {

    private int operation = 0; 

    private int getOperations(){
        return this.operation;
    }

    private void sortable(Table t) {

        int temp;

        //one increment will be place outside each for loop because
        //even if it does not go in, it still compares. hence, one point
        //plus 2 for the method calls to getSize() in the comparison
        //and another point because it assigns 0 to sort, 1 arithmetic
        operation += 5;
        for (int sort = 0; sort < t.getSize() * t.getSize(); sort++) {
            operation += 4; //1 point for comparison, 1 point for increment, 2 for methods, 1 arithmetic

            //1 for assignment, 1 for comparison, 1 for method call
            operation += 3;
            for (int row = 0; row < t.getSize(); row++) {
                operation += 3;//1 for increment, 1 for comparison, 1 for method

                //1 for assignment, 1 for comparison, 1 for method call, one for arithmetic
                for (int column = 0; column < t.getSize() - 1; column++) {
                    //1 for comparison, 1 for method call, 1 for arithmetic, 1 for increment
                    operation += 4;

                    //1 for comparison, 2 for two method calls, 1 for arithmetic
                    operation += 4;
                    if (t.getTableValue(column, row) > t.getTableValue(column + 1, row)) {

                        temp = t.getTableValue(column, row); operation += 2;//1 for assign, 1 for method call
                        t.setTableValue(column, row, t.getTableValue(column + 1, row)); operation += 3;//2 for method, 1 for arithmetic
                        t.setTableValue(column + 1, row, temp); operation += 2;//1 for method, 1 for arithmetic
                    }
                }
            }
        }

        //1 for assignment, 1 for comparison, 2 method calls, 1 arithmetic
        operation += 5;
        for (int sort = 0; sort < t.getSize() * t.getSize(); sort++) {
            //1 comparison, 2 method calls, 1 increment, 1 arithmetic
            operation += 5;

            //1 assignment, 1 comparison, 1 method call
            operation += 3;
            for (int column = 0; column < t.getSize(); column++) {
                //1 comparison, 1 method call, 1 increment
                operation += 3;

                //1 assignment, 1 comparison, 1 method call
                operation += 3;
                for (int row = 0; row < t.getSize() - 1; row++) {
                    //1 comparison, 1 method call, 1 arithmetic, 1 increment
                    operation += 4;

                    //1 comparision, 2 method calls, 1 arithmetic
                    operation += 4;
                    if (t.getTableValue(column, row) > t.getTableValue(column, row + 1)) {

                        temp = t.getTableValue(column, row); operation += 2;//1 assign, 1 method call
                        t.setTableValue(column, row, t.getTableValue(column, row + 1)); operation += 3;//2 method calls, 1 arithmetic
                        t.setTableValue(column, row + 1, temp); operation += 2; //1 method call, 1 arithmetic
                    }
                }
            }
        }

    }

    private boolean isSorted(Table t) {

        for (int sort = 0; sort < t.getSize() * t.getSize(); sort++) {
            for (int row = 0; row < t.getSize(); row++) {
                for (int column = 0; column < t.getSize() - 1; column++) {

                    if (t.getTableValue(column, row) > t.getTableValue(column + 1, row)) {
                        return false;
                    }
                }
            }
        }

        for (int sort = 0; sort < t.getSize() * t.getSize(); sort++) {
            for (int column = 0; column < t.getSize(); column++) {
                for (int row = 0; row < t.getSize() - 1; row++) {

                    if (t.getTableValue(column, row) > t.getTableValue(column, row + 1)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {

        try {

            Scanner input = new Scanner(System.in);
            System.out.println("NxN matrix. Value for N?");
            int number = Integer.parseInt(input.nextLine());
            int[] a = populate(number);
            number *= number;

            TableSorter sort = new TableSorter();
            Table table = new Table(number, a);

            // print(table);
            System.out.printf("Table is sorted? %b", sort.isSorted(table));
            System.out.println("\nsorting...");
            sort.sortable(table);
            // print(table);
            System.out.printf("Table is sorted? %b\n", sort.isSorted(table));
            System.out.printf("Operations: %d\n", sort.getOperations());
            input.close();

        } catch (Exception e) {
            System.out.printf("Enter an integer, please!!");
        }

    }

    public static void print(Table t) {

        for (int x = 0; x < t.getSize(); x++) {
            for (int y = 0; y < t.getSize(); y++) {
                System.out.printf("%d\t", t.getTableValue(x, y));
            }
            System.out.printf("\n");
        }
    }

    public static int[] populate(int value) {
        value *= value;
        int[] array = new int[value];
        for (int i = 0; i < value; i++) {
            array[i] = (int) (Math.random() * 101);
        }
        return array;
    }
}