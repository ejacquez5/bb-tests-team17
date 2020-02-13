/*
    Author: <<author name redacted >>
    Date of Last Edit: February 5, 2020
    Description: Class will take in a table and sort both rows and columns in ascending order by using Selection Sort. 
 */
import javax.sound.midi.SysexMessage;

public class TableSorter {
    private static int assignmentCount = 0;
    private static int branchCount = 0;
    private static int comparisonCount = 0;
    private static int functionCall = 0;

    public TableSorter(Table t){
        System.out.println("Imported Table:");
        printTable(t);
        sortable(t);//Sorting table
        if(isSorted(t)){
            System.out.println("Table sorted successfully:");
            printTable(t);
        }
        else{
            System.out.println("Error in sorting table exiting");
        }
    }


    public boolean isSorted(Table t){
        int N = t.getSize();
        for(int index = 0;  index< N; index++){
            for(int index2 = 0; index2<N-1; index2++){
                if(t.getTableValue(index,index2) > t.getTableValue(index, index2+1))
                    return false;
                else if (t.getTableValue(index2,index) > t.getTableValue(index2+1, index))
                    return false;
            }
        }
        return true;
    }

    /*
       Method to print 2D array in row-based order
    */
    public static void printTable(Table t){
        int N = t.getSize();
        for(int index = 0;  index< N; index++){
            for(int index2 = 0; index2<N; index2++){
               System.out.print(t.getTableValue(index,index2) + " ");
            }
            System.out.println();
        }
    }


    public static void sortable (Table t){
        functionCall +=2;
        sortRow(t);
        sortCol(t);
        printCounters();
    }

    /*
    Method to sort Columns using Selection Sort
     */
    public static void sortCol(Table t){
        functionCall ++;
        int N = t.getSize();
        assignmentCount ++;
        comparisonCount++;
        branchCount++;
        for (int index = 0; index < N; index++) {
            assignmentCount++;
            comparisonCount++;
            branchCount++;
            for (int index2 = 0; index2 < N - 1; index2++) {
                assignmentCount++;
                int min = index2;
                assignmentCount++;
                comparisonCount++;
                branchCount++;
                for (int minFinder = index2; minFinder < N; minFinder++) {
                    branchCount++;
                    functionCall++;
                    comparisonCount++;
                    if (t.getTableValue(min, index) > t.getTableValue(minFinder, index)) {
                        assignmentCount++;
                        min = minFinder;
                    }
                    comparisonCount++;
                    assignmentCount++;//minFinder++
                    branchCount++;
                }
                assignmentCount+=3;
                functionCall +=4;
                int temp = t.getTableValue(index2,index);
                t.setTableValue(index2,index,t.getTableValue(min,index));
                t.setTableValue(min,index,temp);
                comparisonCount++;
                assignmentCount++; //index2++
                branchCount++;
            }
            comparisonCount++;
            assignmentCount++;//index++
            branchCount++;
        }
    }

    /*
    Method to sort rows using Selection Sort
     */
    private static void sortRow(Table t) {
        functionCall++;
        int N = t.getSize();
        assignmentCount++;
        comparisonCount++;
        branchCount++;
        for (int index = 0; index < N; index++) {
            assignmentCount++;
            comparisonCount++;
            branchCount++;
            for (int index2 = 0; index2 < N - 1; index2++) {
                assignmentCount++;
                int min = index2;
                branchCount++;
                assignmentCount++;
                comparisonCount++;
                for (int minFinder = index2; minFinder < N; minFinder++) {
                    branchCount++;
                    functionCall+=2;
                    comparisonCount++;
                    if (t.getTableValue(index,min) > t.getTableValue(index, minFinder)) {
                        assignmentCount++;
                        min = minFinder;
                    }
                    comparisonCount++;
                    assignmentCount++; //minFinder++
                    branchCount++;
                }
                assignmentCount+=3;
                functionCall+=4;
                int temp = t.getTableValue(index,index2);
                t.setTableValue(index,index2,t.getTableValue(index,min));
                t.setTableValue(index,min,temp);
                comparisonCount++;
                assignmentCount++; //index2++
                branchCount++;
            }
            assignmentCount++;
            comparisonCount++; //index++
            branchCount++;
        }
    }


    public static void printCounters(){
        System.out.println("Assignment Counter: " + assignmentCount);
        System.out.println("Comparison Counter: " + comparisonCount);
        System.out.println("Branch Counter: " + branchCount);
        System.out.println("Function Call Counter: " + functionCall);
        System.out.println("Total Operations: " + (comparisonCount + assignmentCount + branchCount + functionCall));
    }
}
