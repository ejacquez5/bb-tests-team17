/**
 * Table Sorter sorts tables.
 *
 * isSorted, sortable were given by the professor.
 * @author <<author name redacted >>
 * @version 1.1
 * @since   2020-03-02
 * @modification global counter variable was added.
 * created for Software Integration and Test.
 */

import java.io.FileNotFoundException;
import java.io.IOException;

public class TableSorter {
    private  static int counter;//counter gets assigned before the sorter is used in main.
    /** Sort Checker
     * This method checks if the given table is sorted. Uses the isSortedHelper method.
     * @param t table to be checked
     * @return true if the table is sorted, false otherwise
     */
    public static boolean isSorted(Table t){
        counter++;
        if(isSortedHelper(t,-1,0)&& isSortedHelper(t,0,-1)){
            return true;
        }
        counter++;//comparison in if statment
        return false;
    }

    /**
     * This helper method is used to check if the given table is sorted.
     * The parameters are used to help check either the rows are sorted or the col.
     * This is checked by iterating through each cell.
     * @param t table to be sorted
     * @param rowMod if this is -1 and colMod is 0 then the rows will be checked.
     * @param colMod if this is -1 and rowMod is 0 then the columns will be checked.
     * @return true if the table is sorted by either rows, or columns depending on the given parameters.
     */
    private static boolean isSortedHelper(Table t, int rowMod, int colMod){
       counter++;//function was called
        for (int rowIt=0;rowIt<t.getSize()+rowMod;rowIt++){
            counter++;//compare rowIt<t.getSize()
            counter++;//assignment of rowIt;
            for(int colIt=0;colIt<t.getSize()+colMod;colIt++){
                counter++;//compare colIt<t.getSize()
                counter++;//assignment of colIt;
                if(t.getTableValue(rowIt,colIt)>t.getTableValue(rowIt+(rowMod*-1),colIt+(colMod*-1))){
                    counter++;//t.getTableValue(rowIt,colIt)>t.getTableValue(rowIt+(rowMod*-1),colIt+(colMod*-1))
                    return false;
                }
            }
            counter++;//for colIt assignment
        }
        counter++;//for rowIt assignment
        return true;
    }

    /**
     * This method sorts the columns and then
     * the rows until the table is sorted.
     * @param t this is the table to be sorted.
     */
    public static void sortable (Table t){
        counter++;//function was called
        while (!isSorted(t)){
            counter++;//comparison
            sort(t,0,-1);//sort the col
            sort(t,-1,0);// sort the rows
        }
    }

    /**Sort Table
     * This method uses bubble sort to sort the given table.
     * @param t table to be sorted.
     * @param rowMod if this is -1 and colMod is 0 then we are sorting by row.
     * @param colMod if this is -1 and rowMod is 0 then we are sorting by column.
     */
    private static void sort(Table t,int rowMod, int colMod){
        counter++;
        for (int rowIt=0;rowIt<t.getSize()+rowMod;rowIt++){
            counter++;//comparison;
            counter++;//increment;
            for(int colIt=0;colIt<t.getSize()+colMod;colIt++){
                counter++;//comparison;
                counter++;//increment
                if(t.getTableValue(rowIt,colIt)>t.getTableValue(rowIt+(rowMod*-1),colIt+(colMod*-1))){
                    counter++;//comparison
                    int tmp=t.getTableValue(rowIt,colIt);
                    counter++;//assignment
                    t.setTableValue(rowIt,colIt,t.getTableValue(rowIt+(rowMod*-1),colIt+(colMod*-1)));
                    counter++;//assignment
                    t.setTableValue(rowIt+(rowMod*-1),colIt+(colMod*-1),tmp);
                    counter++;//assignment
                }

            }
            counter++;//colIt assignment
        }
        counter++;//rowIt assignment
    }

    /**
     * This method prints the table to the console for visualization.
     * @param t the table that is to be printed.
     */
    private static void printArray(Table t){
        for(int i=0;i<t.getSize();i++){
            for(int j=0;j<t.getSize();j++){
                System.out.print(t.getTableValue(i,j)+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        try {
            counter=0;
            Table t = Table.GetTable("C:\\Users\\Andrea Fernanda Torr\\IdeaProjects\\TableSorter\\src\\sort.txt");
            printArray(t);
            sortable(t);
            System.out.println();
            printArray(t);
            System.out.println("The total amount of ... is "+counter);
            counter=0;
        }catch (FileNotFoundException e){
            System.out.println("File not found");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
