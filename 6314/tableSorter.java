import java.io.*;

public class tableSorter {

	//Initiates counter for total computations
	public static int computations = 0;
	/*
	 * Traverses the arrow left to right, top to bottom.
	 * If the next value is higher than the current, return false
	 * Otherwise, array is sorted and it returns true.
	 */
	public static boolean isSorted(Table t) {
		int range = t.getSize();
	
		for (int row = 0;row<range;row++) {
			for (int col=0;col<range-1;col++) {
				if (t.getTableValue(row, col)>t.getTableValue(row, col+1) || t.getTableValue(col, row)>t.getTableValue(col+1,  row)){
					return false;
				}
			}
		}
		return true;
	}
	
	

	/*
	 * Prints out the array in order of left to right, top to bottom
	 */
	public static void printout(Table t) {
		int range = t.getSize();
		for (int i = 0; i < range; i++) {
			for (int j = 0; j < range; j++) {
				int value = t.getTableValue(i, j);
				System.out.println(value);
			}
		}
	}

	/*
	 * Pulls values in an array
	 * Sorts array
	 * Reinserts sorted values to the table
	 */
	public static void sortable(Table t) {
		int range = t.getSize();
		int c = 0;
		int[] valueArray = new int[range*range];
		
		//range,c,value instantiation
		computations+=3;
		
		//Gets variables from Table and stores them in an array
		for (int i = 0; i < range; i++) { 				//2n+1      =2n+1
			for (int j = 0; j < range; j++) { 			//n(2n+1)   =2n^2+n
				valueArray[c] = t.getTableValue(i, j);  //n(n)	    =n^2
		        c++; 									//n(n)		=n^2
			}
		}
		
		//Bubble Sorts array
		for (int i=0;i<valueArray.length-1;i++) {        
			for (int j=0;j<valueArray.length-i-1;j++) {  
				if (valueArray[j]>valueArray[j+1]) {     
					int temp = valueArray[j];            
					valueArray[j] = valueArray[j+1];     
					valueArray[j+1] = temp;			     
					
					//temp is set, valueArray[j] is set,  valueArray[j+1] is set
					computations+=3;
				}
				
				//if condition checked, loop's j is checked, loop's j is iterated
				computations+=3;
				
				//computation for outer loop here
				//j is instantiated, loop's i is checked,  loop's i is iterated
				computations+=3;
			}
		}
		
		//bubblesort loop's i is instantiated
		computations++;
		
	
		//Reinserts sorted values
		c = 0;
		computations++;
		
		for (int i = 0; i < range; i++) { 				//2n+1
			for (int j = 0; j < range; j++) { 			//n(2n+1)
				t.setTableValue(i, j, valueArray[c]);   //n^2
				c++;									//n^2
	
			}
		} 
		
		//Getting and storing values from the table will always result in worse case (full traversal)
		//Therefore: computations can be computed using the formula below
		//4n^2+3n+1
		computations+=2*((4*range*range)+(3*range)+1);
	}
	
	public static void main(String[] args) throws Exception {

		//Test files for debugging
		//File testFile = new File("unsortedTest.txt");
		//File bigTestFile = new File("bigUT.txt");
		File hard = new File("hardTest.txt");
		Table t = Table.GetTable(hard);

		
		//System.out.println(isSorted(t));
		
		//Call to sortable
		computations++;
		
		sortable(t);
		//printout(t);
		//System.out.println(isSorted(t));
		System.out.println("Total Computations: "+computations);
	}

}