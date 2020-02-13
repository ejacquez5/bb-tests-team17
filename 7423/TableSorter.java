/*
 * Author: <<author name redacted >>
 * Last Updated: 02/07/2020 
 */
public class TableSorter {
	
	static int operations = 0;
	
	public static void main(String[] args) throws Exception{
		int [] values = {2,3,5,4};
		Table t = Table.GetTable("TEST2");
		int size = t.getSize();
		System.out.println("Size: " + t.getSize());
		sortable (t);
		
		
		System.out.println(isSorted(t));
		System.out.print("Operations = " + operations);
		
		
		
	}
	
	public static boolean isSorted(Table t) {
		// returns true if every row and every column of the table t is sorted in ascending order
		
		int range = t.getSize();
		operations += 2; //assign + fn call
		int col,row = 0; //column
		operations += 2; //2 assignments
		
		for (row = 0; row < range; row++) { 
			operations ++; //compare
			for (col = 0; col < range; col++) { 
				operations ++; //compare
				if (t.getTableValue(row, col) > t.getTableValue(row, col + 1)){
					operations+= 3; // compare + 2 fn calls
					return false;
				} operations++; // branch when condition is false
				if (t.getTableValue(row, col) > t.getTableValue(row + 1, col)){
					operations+= 3; // compare + 2 fn calls
					return false;
				} operations++; // branch when condition is false
				operations+=3; // for loop increment, branch, compare
            }operations++; // for branch when for loop compare fails
            operations+=3; // for loop increment, branch, compare
        }operations++; // for branch when for loop compare fails
		return true;
	}
	
	public static void sortable (Table t) {
		//sorts a Table so that isSorted() is true.
	    int col = 0; //column
	    operations ++; //assign
	    int row1 = 0; //row
	    operations ++; //assign
	    int row2 = 0;
	    operations ++; //assign
	    int colNum, rowNum = 0;
	    operations += 2; //2 assignments
	    colNum = t.getSize();
	    operations ++; //function call
	    rowNum = t.getSize();
	    operations ++; //function call
	    

	    for ( col = 0; col < colNum; col++) {
	    	operations ++; //compare
	        for ( row1 = 0; row1 < rowNum; row1++) {
	        	operations ++; //compare
	            for ( row2 = row1 + 1 ; row2 < rowNum; row2++) {
	            	operations ++; //compare
	                if(col%2==0){
	                	operations ++; //compare
	                	if (t.getTableValue(row1, col)> t.getTableValue(row2, col)) {
		                	operations+= 3; // compare + 2 fn calls
		                    int temp1= t.getTableValue(row1, col);
		                    operations+= 2; // assign + fn call
		                    t.setTableValue(row1, col, t.getTableValue(row2, col));
		                    operations+=2; //2 fn calls
		                    t.setTableValue(row2, col, temp1);
		                    operations++; // 1 fn call
		                }
	                	operations++; // branch when condition is false
	                	
	                }
	                else{
	                    if (t.getTableValue(row1, col)< t.getTableValue(row2, col)) {
	                    	operations+= 3; // compare + 2 fn calls
	                        int temp1= t.getTableValue(row1, col); 
	                        operations+= 2; // assign + fn call
	                        t.setTableValue(row1, col, t.getTableValue(row2,col));
	                        operations+=2; //2 fn calls
	                        t.setTableValue(row2, col, temp1);
	                        operations++; // 1 fn call
	                    }
	                    operations++; // branch when condition is false
	                }//end else
	                operations+=3; // for loop increment, branch, compare
	            }operations++; // for branch when for loop compare fails
	            operations+=3; // for loop increment, branch, compare
	        }operations++; // for branch when for loop compare fails
	        operations+=3; // for loop increment, branch, compare
	    }operations++; // for branch when for loop compare fails
	   
	    
	}

}
