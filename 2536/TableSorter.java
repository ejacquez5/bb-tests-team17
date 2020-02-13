// package cs5387;

/*
 * HW2 for CS5387
 * <<author name redacted >>
 * Created class TableSorter to sort values from a file as input
 * and then created am object Table to manipulate values
 * and then sort them in increasing order from row and columns
 * and verify that the Table is sorted
 * 
 * 
 * Following with HW1, we are now counting the amount of operations 
 * done on the search.
 * 
*/

public class TableSorter{
    public static int count;
    public static void main(String[] args)  throws Exception{
        count = 0;
        Table t = Table.GetTable("file.txt");
        count+=2;
        System.out.println(t.toString());
        sortable(t);
        count++;
        System.out.println(t);
        System.out.println(isSorted(t));
        System.out.println("The number count is: "+count);
    }

    // to verofy that the table is sorted, the method checks if the value infront of the current is greater than
    // changed the method to be static because of having issues calling a non static method from a static method
    public static boolean isSorted(Table t){
        int range = t.getSize();
        for(int i = 0; i < range-1; i++){
            for(int j = 0; j < range-1; j++){
                if(t.getTableValue(i,j) > t.getTableValue(i,j+1)){
                    return false;
                }
                if(t.getTableValue(i,j) > t.getTableValue(i+1,j)){
                    return false;
                }
            }
        }
        return true;

    }

    //using bubble sort to sort the values in the table, checks first horizontally then vertically

    //added counters on the operations:
    //assignment statements
    //comparison opeartions
    //branch
    //function call
    public static void sortable(Table t){
        int range = t.getSize();
        count++;
        count++;
        count+=range;
        count+=(range*range);
        for(int i = 0; i < range; i++){
            count+=2;
            for(int j = 0; j < range-1; j++){
                count+=2;
                for(int l = 0; l < range-j-1; l++){
                    count+=2;
                    count++;
                if(t.getTableValue(i,l) > t.getTableValue(i,l+1)){
                    count+=3;;
                    int temp = t.getTableValue(i,l);
                    count+=2;
                    t.setTableValue(i,l,t.getTableValue(i,l+1));
                    count+=2;
                    t.setTableValue(i,l+1,temp);
                    count++;
                }
            }
        }
        }

        count++;
        count+=range;
        count+=(range*range);
        for(int i = 0; i < range; i++){
            count+=2;
            for(int j = 0; j < range-1; j++){
                count+=2;
                for(int l = 0; l < range-j-1; l++){
                    count+=2;
                    count++;
                if(t.getTableValue(l,i) > t.getTableValue(l+1,i)){
                    count+=3;
                    int temp = t.getTableValue(l,i);
                    count+=2;
                    t.setTableValue(l,i,t.getTableValue(l+1,i));
                    count+=2;
                    t.setTableValue(l+1,i,temp);
                    count++;
                }
            }
        }
        }
    }
}