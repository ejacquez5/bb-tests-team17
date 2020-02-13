/*
Author: <<author name redacted >>
Title: ProgrammingAssignment 2
Purpose: The purpose of this assignment is to create a counter in which counts all operations, declarations and branches
in order for Sortable() to sort the given Table.
 */


public class TableSorter {

    public static int operationCount = 0; //variable to count number of operations needed to sort.

    /*/
    Input: Table
    Output: boolean
    Functionality: Returns true if who table is sorted, else, it returns false.
     */
    public boolean isSorted(Table t){

        return isColSorted(t) && isRowSorted(t);
    }

    /*
    Input: Table
    Output: boolean
    Functionality: Checks if all the columns are sorted.
     */
    private boolean isColSorted(Table t) {
        int range = t.getSize();

        for(int c=0; c<range; c++){
            for(int r=0; r<range-1; r++){
                int currentValue = t.getTableValue(r,c);
                int nextValue = t.getTableValue(r+1, c);
                if(currentValue > nextValue){
                    return false;
                }
            }
        }
        return true;
    }



    /*
    Input: Table
    Output: Boolean
    Functionality: Checks if all the rows are sorted.
     */
    public boolean isRowSorted(Table t){
        int range = t.getSize();

        for(int r=0; r<range; r++){
            for(int c=0; c<range-1; c++){
                int currentValue = t.getTableValue(r,c);
                int nextValue = t.getTableValue(r, c+1);
                if(currentValue > nextValue){
                    return false;
                }
            }
        }
        return true;
    }

    /*
    Input: Table
    Output: None
    Functionality: Takes care of sorting the table row-wise and column-wise
     */
    public static void sortable(Table t){

        operationCount++; //function called +1
        sortRow(t);
        operationCount++; //function call to 'sortRow'

        //after having each row sorted, sort each column.
        sortCol(t);
        operationCount++; //function call to 'sortCol'

    }


    /*
    Input: Table
    Output: None
    Functionality: Sorts all the columns in the Table
     */
    public static void sortCol(Table t){
        int range = t.getSize();
        operationCount+= 2; //variable declaration and function call



        operationCount+=2; //declaration for variable 'c' in for loop and compare
        for(int c=0; c<range; c++){ //loop needed to traverse column
            operationCount+=2; //declaration for variable 'r' for upcoming for loop and compare, loop
            for(int r=0; r<range; r++){ //loop needed to traverse row
                operationCount+=2; //declaration for variable 'i' and compare in loop
                for(int i=0; i<range-r-1; i++){ //loop needed to check elements which were swapped previously.
                    int currentVal = t.getTableValue(i, c);
                    int nextVal = t.getTableValue(i+1,c);
                    operationCount+=4; //declaration of variables 'currentVal' and 'nextVal' and 2 function calls, one for each variable
                    operationCount++; //comparison for currentVal and nextVal
                    if (currentVal > nextVal){
                        //perform swap
                        t.setTableValue(i, c,nextVal);
                        t.setTableValue(i+1, c, currentVal);
                        operationCount+=2; //setting values for table calling functions
                    }
                    operationCount++; //branch when condition above is false
                    operationCount+=3; //for loop increment, a branch and a compare in the loop
                } operationCount++; //for branch when loop compare fails
                operationCount+=3; //for loop increment, a branch and a compare in the loop
            } operationCount++; //for branch when loop compare fails
            operationCount+=3; //for loop increment, a branch and a compare in the loop
        } operationCount++; //for branch when loop compare fails
    }

    /*
    Input: Table
    Output: None
    Functionality: Sorts all the rows in the Table. 
     */
    public static void sortRow(Table t){
        int range = t.getSize();
        operationCount+= 2; //variable declaration and function call


        operationCount+=2; //declaration for variable 'r' in for loop and compare
        for(int r=0; r<range; r++){ //loop needed to traverse row
            operationCount+=2; //declaration for variable 'c' for upcoming for loop and compare
            for(int c=0; c<range; c++){ //loop needed to traverse column
                operationCount+=2; //declaration for variable 'i' for upcoming for loop and compare
                for(int i=0; i<range-c-1; i++){ //loop needed to check elements that were swapped previously.
                    int currentVal = t.getTableValue(r, i);
                    int nextVal = t.getTableValue(r,i+1);
                    operationCount+=4; //declaration of variables 'currentVal' and 'nextVal' and two function calls
                    operationCount++; //comparison for currentVal and nextVal
                    if (currentVal > nextVal){
                        //perform swap
                        t.setTableValue(r, i,nextVal);
                        t.setTableValue(r, i+1, currentVal);
                        operationCount+=2; //setting values for table
                    }
                    operationCount++; //branch when condition above is false
                    operationCount+=3; //for loop increment, a branch and a compare in the loop
                } operationCount++; //for branch when loop compare fails
                operationCount+=3; //for loop increment, a branch and a compare in the loop
            }operationCount++; //for branch when loop compare fails
            operationCount+=3; //for loop increment, a branch and a compare in the loop
        } operationCount++; //for branch when loop compare fails
    }



    //main method with 1 FILE TEST CASE and 6 INITIALIZED TEST CASES
    public static void main(String[] args) throws Exception {
        int [] values0 = new int[]{4,-1,2,0};
        int [] values1 = new int[]{5,1,8,3,2,1,5,7,3,6,2,1,-1,-1,5,9};
        int [] values2 = new int[]{-5,-1,-8,-3,-2,-1,-5,-7,-3,-6,-2,-1,-1,-1,-5,-9,-3,-5,-6,-10,-2,-1,0,-76,-4};
        int [] values3 = new int[]{5,1,8,3,2,1,5,7,3,6,2,1,-1,-1,5,9,3,5,6,10,-2,-1,0,-76,4,-10,0,2,99,100000,2147483647,-2147483648,-10000,-555, 1234,55};
        int [] values4 = new int[]{0,0,0,-1,-1,-1,-2,0,-1};
        int [] values5 = new int[]{0,1,2,3,4,5,6,7,8};
        int [] TESTCASES [] = {values0, values1, values2, values3, values4, values5};


        //test case for file
        Table t1 = Table.GetTable("input");
        String stringTable = t1.toString();
        System.out.println("---------------File Test Case----------------");
        System.out.println(stringTable);
        System.out.println("THIS TABLE IS SORTED: " + new TableSorter().isSorted(t1));
        sortable(t1);
        String stringT = t1.toString();
        System.out.println(stringT);
        System.out.println("THIS TABLE IS SORTED: " + new TableSorter().isSorted(t1));
        System.out.println("NUMBER OF OPERATIONS TO SORT TABLE: " + operationCount);


        //Loop used to test cases for initialized array of values.
        for(int i=0; i<TESTCASES.length; i++){
            Table t = new Table(TESTCASES[i].length, TESTCASES[i]);
            System.out.println("---------------TEST CASE #" + i + " ------------------");
            String stringT1 = t.toString();
            System.out.print(stringT1);

            System.out.println("THE TABLE ABOVE IS SORTED: " + new TableSorter().isSorted(t));
            sortable(t);

            System.out.println("----------------SORTED TEST CASE #" + i + " -------------------");
            String stringTable1 = t.toString();
            System.out.print(stringTable1);
            System.out.println("THE TABLE ABOVE IS SORTED: " + new TableSorter().isSorted(t));
            System.out.println("NUMBER OF OPERATIONS TO SORT TABLE: " + operationCount);
        }



    }


}
