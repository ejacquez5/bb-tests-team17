/**
 * <<author name redacted >>
 * 1/29/20
 * cs4387
 */

package cs5387;

public class TableSorter {
    private static int counter = 0;

    public static void main(String[] args) throws Exception {
        Table table = new Table(9, new int[] {20,10,41,3,4,1,24,8,10});
        sortable(table);
        TableSorter sorter = new TableSorter();
        System.out.println(sorter.isSorted(table));
    }

    /*
    * Scanned for an unsorted pair from top left to bottom right to avoid having to make comparisons above an index
    * and to the left of an index.
    * */
    public boolean isSorted(Table t){
        for(int r = 0; r<t.getSize(); r++){
            for(int c = 0; c<t.getSize(); c++){
                if(t.getSize() == 1) {
                    return true;
                }
                if(r < t.getSize()-1){
                    if(t.getTableValue(r,c) > t.getTableValue(r+1,c)) {
                        return false;
                    }
                }

                if(c<t.getSize()-1){
                    if(t.getTableValue(r,c) > t.getTableValue(r,c+1)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /*
    * Seperated the sorting of the Table into a horizontal sort and a vertical sort to simplify
    * the logical flow of the method.
    * */
    public static void sortable(Table t){
        int n = t.getSize();
        counter++; // assignment of local vars

        for(int r = 0; r<n; r++){
            counter+=2; //assignment and comparison in for loop

            counter++; //function call
            horizontalBubbleSort(t,r);
        } counter++; //branch in execution

        for(int c = 0; c<n; c++){
            counter+=2; //assignment and comparison in for loop

            counter++; //function call
            verticalBubbleSort(t,c);
        } counter++; //branch in execution
        System.out.println(counter);
    }

    /*
     * Used to help abstract the process of sorting a 2D Table.
     *  */
    private static void horizontalBubbleSort(Table t, int r){
        int n = t.getSize();
        int temp = 0;
        counter+=2; //assignment of local vars

        for(int i=0; i < n; i++){
            counter+=2; //assignment and comparison in for loop

            for(int c=1; c < (n-i); c++){
                counter+=2; //assignment and comparison in for loop

                counter+=3; //function calls and comparison
                if(t.getTableValue(r,c-1 ) > t.getTableValue(r,c)){

                    temp = t.getTableValue(r,c-1);
                    counter+=2; //assignment and function call

                    t.setTableValue(r,c-1, t.getTableValue(r,c));
                    counter+=2; //function calls

                    t.setTableValue(r, c, temp);
                    counter++; //function call

                }counter++;//branch in execution
            }counter++; // branch in execution
        }counter++; //branch in execution
    }

    /*
     * Used to help abstract the process of sorting a 2D Table
     */
    private static void verticalBubbleSort(Table t, int c) {
        int n = t.getSize();
        int temp = 0;
        counter+=2; //assignment of local vars

        for (int i = 0; i < n; i++) {
            counter+=2; //assignment and comparison

            for (int r = 1; r < (n - i); r++) {
                counter+=2; //assignment and comparison

                counter+=3; //function calls and comparison
                if (t.getTableValue(r - 1, c) > t.getTableValue(r, c)) {

                    temp = t.getTableValue(r - 1, c);
                    counter+=2; //assignment and function call

                    t.setTableValue(r - 1, c, t.getTableValue(r, c));
                    counter+=2; //function calls

                    t.setTableValue(r, c, temp);
                    counter++; //function call

                }counter++; //branch in execution
            }counter++; //branch in execution
        }counter++; //branch in execution
    }
}
