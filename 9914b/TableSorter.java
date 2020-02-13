package cs5387;

/* CS 5387
 Programming Assignment 1
 @author <<author name redacted >>
 @version 1.2
 @since 02/07/20
 Class TableSorter takes a table of ints, sorts the elements and prints a sorted table.
 To sort the elements in the table, an array is created and then bubble sort is used.
 (sort in ascending order)
 Added variables to count assignment statements, branches and comparisons for sorting table*/


public class TableSorter {
	  public static void sortable(Table t) throws Exception {
	      //variable to count assignments, branches, compares and function calls
		  int assignmentsCount = 0; //assignment
		  
		  //count all instances of the elements in the table
		  //represents the number of elements in table, it will be used
		  //to create array of size count
	        int count = 0; //assignment
	        assignmentsCount++;
	        
	        for (int r = 0; r < t.getSize(); r++) {
	        	assignmentsCount+=2;//assignment and compare for loop
	            for (int c = 0; c < t.getSize(); c++) { 
	            	assignmentsCount=+3;//assignment, compare and 2 function calls
	                count++;
	                assignmentsCount++; //branch
	                assignmentsCount+=2;//for loop increment branch and compares
	            }
	            assignmentsCount++;//compares 
	        }

	        
	        //based on the count of instances create an array with
	        //table elements
	        int[] array = new int[count]; //assignment 
	        assignmentsCount++;
	        
	        int inCount = 0; //assingnment 
	        assignmentsCount++;
	        
	        for (int r = 0; r < t.getSize(); r++) {//assignment and compare loop
	        	assignmentsCount+=2;
	            for (int c = 0; c < t.getSize(); c++) {//assignment, compare and 2 func calls
	            	assignmentsCount+=3;
	                int indexValue = t.getTableValue(r, c);
	                assignmentsCount+=2;//assignment and func calls
	                array[inCount] = indexValue;//assignment
	                assignmentsCount++;
	                inCount++;
	                assignmentsCount++; //branch
	                assignmentsCount+=2;//for loop increment branch and compares
	            }
	            assignmentsCount++;//compare
	        }

	        //bubble sort used to sort elements in array
	        //code adapted from https://www.geeksforgeeks.org/java-program-for-bubble-sort/
	        for (int i = 0; i < array.length; i++) { //assignment and for loop
	        	assignmentsCount+=2;
	            for (int j = i + 1; j < array.length; j++) { //assignment
	            	assignmentsCount+=3;
	                int tmp = 0;//assignment
	                assignmentsCount++;
	                if (array[i] > array[j]) {
	                	//swap tmp and array
	                	assignmentsCount+=1; //branch returns
	                    tmp = array[i];//assignment
	                    assignmentsCount++;
	                    array[i] = array[j];//assignment
	                    assignmentsCount++;
	                    array[j] = tmp;//assignment
	                    assignmentsCount++;
	                    assignmentsCount++; //branch
		                assignmentsCount+=2;//for loop increment branch and compares
	                }
	                assignmentsCount++; // compares
	            }
	            assignmentsCount++;//compares
	        }

	        //sort the new array in table
	        Table table = new Table(count, array);
	        System.out.print(table.toString());
	        System.out.println("Total number of assignments, branches, function calls and compares: " +  assignmentsCount);
	    }

	public static boolean isSorted(Table t) throws Exception {
        boolean check = false;

        //count all instances of the elements in the table
        //number of elements in count used to create array
        int count = 0;
        for (int r = 0; r < t.getSize(); r++) {
            for (int c = 0; c < t.getSize(); c++) {
                count++;
            }
        }

        
        //based on the count of instances create an array with
        //table elements
        int[] array = new int[count];
        int inCount = 0;
        for (int r = 0; r < t.getSize(); r++) {
            for (int c = 0; c < t.getSize(); c++) {
                int s = t.getTableValue(r, c);
                array[inCount] = s;
                inCount++;
            }
        }

        //check temp with sorted array 
        int[] temp = array;

        //bubble sort
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                int tmp = 0;
                if (array[i] > array[j]) {
                	//swap tmp and array
                    tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }

        //linearly compare elements in temp and array
        for (int i = 0; i < array.length; i++)
            if (temp[i] != array[i])
                check = false;
            else
                check = true;

        return check;
    }


		public static void main(String[] args) throws Exception {
			  //create a table with 16 elements, sort and print
			  int[] values = { 8, 3, 7, 1, 6, 87, 90, 43, 55, 2, 456, 5, 43, 0, 76, 5 };
		        Table table = new Table(16, values);
		        sortable(table);
		        if(isSorted(table)) {
		            System.out.print("Table IS Sorted \n");
		        } else {
		            System.out.print("Table NOT sorted");
		        }
		}
}

