package cs5387;

/**
 *  @author <<author name redacted >>
 *  CS5387 Software Integration and V&V
 *  This class is used to check if a table has been sorted
 *  for the rows and columns. It also sorts the table to ensure
 *  the previous condition stated is met.
 */
public class TableSorter {
	//Counter
	static int c;

	public static void main(String[] args) {
		/**
		 * Test cases generated for the TableSorter class.
		 * Test cases included varying size tables, negative/positive numbers,
		 * repeating integers, ordered tables, and empty tables.
		 */
		int[] sample0 = {-19,8,77,-6,
						 54,4,32,2,
						 81,0,-124,1,
						 -12,1000,-99999,99999};
		int[] sample1 = {5,6,7,
						 9,-10,11,
						 4,-5,6};
		int[] sample2 = {1,0,
						 0,-1};
		int[] sample3 = {0,0,0,
					     0,0,0,
					     0,0,0};
		int[] sample4 = {};
		try {
			/*
			 * Create array of tables to test
			 */
			Table[] t = new Table[5];
			t[0] = new Table(sample0.length, sample0);
			t[1] = new Table(sample1.length, sample1);
			t[2] = new Table(sample2.length, sample2);
			t[3] = new Table(sample3.length, sample3);
			t[4] = new Table(sample4.length, sample4);
			
			for(int i = 0; i < t.length; i++) {
				/* 
				 * If table is empty, print a message in the console.
				 * All sorting methods will be skipped for empty cells.
				 */
				if(t[i].getSize()==0) {
					System.out.println("Table is empty!!!!");
					continue;
				}
				
				System.out.println("Is table " +i+ " sorted?: " + isSorted(t[i]));
				System.out.println(t[i].toString());
				sortable(t[i]);
				System.out.println("Table " +i+ " has now been sorted: " + isSorted(t[i]));
				System.out.println(t[i].toString());
				System.out.println("Counter: " + c);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}	

	}
	
	/** 
	 * This method checks whether a table of NXN dimensions
	 * is already sorted in ascending order for all rows and columns.
	 * @param t: Table object of range dimensions N x N.
	 * @return boolean returns true if table is already sorted, false if not
	 */
	public static boolean isSorted(Table t) {
		int n = t.getSize();
		c+=2; // variable assignment and function call
		
		//Check if rows are in ascending order
		//Counter on both "for" loop initial conditions, comparisons, operations
		//Number of iterations are counted within each loop
		c+=5;
        for (int i = 0; i < n; i++, c++) { 
            for (int j = 0; j < n-1; j++, c++) {
            	c+=3; //if statement comparison and two function calls
            	if (t.getTableValue(i, j) > t.getTableValue(i, j+1)) 
                {
            		c++; //If statement branch entry
                	return false;
                }
            }
        }
        
        //Check if columns are in ascending order
		//Counter on both "for" loop initial conditions, comparisons, operations
		//Number of iterations are counted within each loop
		c+=5;
        for (int j = 0; j < n; j++) { 
            for (int i = 0; i < n-1; i++) {
            	c+=3; //If statement comparison and two funtion calls
                if (t.getTableValue(i, j) > t.getTableValue(i+1, j)) 
                {
                	c++; //If statement branch entry
                    return false;
                }
            }
        }
        
        //If all rows and columns are in ascending order, return true
		return true;
	}
	/**
	 * This method sorts a table of NXN dimensions.
	 * If the table is already sorted, the method makes
	 * no further changes to the existing table.
	 * @param t: Table object of range dimensions N x N.
	 */
	public static void sortable(Table t) {
		c=0;// restart counter value
		/* 
		 * Check if the table is already sorted.
		 * If so, do nothing and exit method.
		 */
		c++; //Counter for "if" statement comparison
		if(isSorted(t)) {
			c++; //Counter for "if" execution
			return;
		}
		
		int n = t.getSize();
		c+=2; //getSize operation
		int loc = 0;
		c++; //loc variable assignment
		int[] temp = new int[(n*n)];
		c+=2; //temp array creation and size operation
		
		//Export table values to an array of size NXN
		//Counter on both "for" loop initial conditions, comparisons
		//Number of iterations are counted within each loop
		c+=4;
		for(int i = 0; i < n; i++, c++) {
			for(int j = 0; j < n; j++, c++) {
				temp[loc] = t.getTableValue(i, j);
				c+=2; // function call and array value assignment
				loc++;
				c++; // loc increment
			}
		}
		loc =0;
		c++; //loc value reassignment
		
		//Sort array
		bubbleSort(temp);
		
		//Enter sorted array back into a Table
		loc = 0;
		c++; //loc value reassignment
		
		//Counter on both "for" loop initial conditions, comparisons, and funtion call
		//Number of iterations are counted within each loop
		c+=5;
		for(int i = 0; i < n; i++, c++) {
			for(int j = 0; j < t.getSize(); j++) {
				t.setTableValue(i, j, temp[loc]);
				c+=2; //funtion call and array value assignment
				loc++;
				c++; //loc increment
			}
		}
	}
	
	/**
	 * This method uses the bubbleSort technique to sort an array.
	 * This is only a sub-method.
	 */
    static void bubbleSort(int arr[]) 
    { 
        int n = arr.length; c++;
        //Counter on both "for" loop initial conditions, comparisons, and operations
        //Number of iterations are counted within each loop
        c+=6;
        for (int i = 0; i < n-1; i++, c++) {
            for (int j = 0; j < n-i-1; j++, c++) {
            	c++; //Counter for "if" statement comparison
                if (arr[j] > arr[j+1]) 
                {  	
                    // swap arr[j+1] and arr[i] 
                    int temp = arr[j];
                    c++; //variable assignment
                    arr[j] = arr[j+1]; 
                    c++; //variable assignment
                    arr[j+1] = temp;
                    c++; //variable assignment
                }
            }
        }
    }

}
