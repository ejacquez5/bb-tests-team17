import cs5387.Table;
import cs5387.tableSorter;
/* <<author name redacted >>
   Purpose of this program is to test and interact with the tableSorter and Table classes
   Version 1.0, (Later versions to gather input from the user for elements to place in the array)
*/
public class tableTest{
    public static void main(String[] args){
	tableSorter sorter = new tableSorter();
	int[] k = {4,3,1,9,2,7,8,5,33}; //Change this for new table items to test!
	Table tt = null;
	try{ //Table constructor throws an exception, here we catch the exception and print the stack trace
	    tt = new Table(k.length,k);
	}
	catch(Exception e){
	    e.printStackTrace();
	}
	printTable(tt); //Print pre-sorted table
	System.out.println(sorter.isSorted(tt)); //Print whether the table is sorted
	sorter.sortable(tt); //Sort the table
	printTable(tt); //Print the sorted table
	System.out.println(sorter.isSorted(tt)); //Print whether the table is sorted
	System.out.println("Total operations: "+sorter.getTotalOps());
	return;
    }

    public static void printTable(Table tt){
	int range = tt.getSize();
	for(int i=0; i<range; i++)
	    for(int j=0; j<range; j++)
		System.out.println(tt.getTableValue(i,j));
    }
}
