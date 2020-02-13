package cs5387;

import java.util.Scanner;

/*
<<author name redacted >>
Programming Assignment #2

The purpose of this program is to count the number of operations executed
by the HW#1 sort method.

After testing it was determined that as the table increases so does the number of operations.
Unfortunately not at the same rate. The number of operations is exponential and executes
hundreds of operations even at a size of 4x4.
 */

public class TableSorter {
	static int occur = 0;

	/*
	This method checks correct order by comparing the values of next row
	or column value
	 */
	private static boolean isSorted(Table t) {
		int size = t.getSize();
		for (int i = 0; i < size-1; i++){
			for (int j = 0; j<size-1; j++){
				if(t.getTableValue(i,j) > t.getTableValue(i+1,j)){
					return false;
				}
				if(t.getTableValue(i,j) > t.getTableValue(i,j+1)){
					return false;
				}
			}
		}
		return true;
	}

	/*
	The sorting method has been altered to include a counter variable.
	I did this because it will be increased each time the operation is
	executed and thus correctly count the number of assignments, comparisons,
	branches, and function calls.
	 */
	
	private static void sortable(Table t) {
		System.out.println("***Sorted Table***");
		occur++;//assignment
		int size = t.getSize();
		/*
		brute force attempt. I read the 2D array, order the 1D array
		then save it back into the 2D array
		 */
		occur++; //assignment
		int[] tempArr = new int[size*size];

		occur++; //assignment
		int count = 0;

		occur+=4; //two branches two assignments
		for (int i = 0; i < size; i++) {
			occur++; //comparison
			for (int j = 0; j < size; j++) {
				occur++; //comparison
				tempArr[count] = t.getTableValue(i,j);
				count++;
				occur+=3; //assignment j++, count++, tempArr[]
			}
			occur++; //assignment i++
		}

		occur+= 2;// branch and assignment
		for(int i = 0; i< tempArr.length-1;i++){
			occur+=2; //comparison
			if(tempArr[i] > tempArr[i+1]){
					occur+=4; //assignment tempArr[i], temp, tempArr[i+1], i
					int temp = tempArr[i];
					tempArr[i] = tempArr[i+1];
					tempArr[i+1] = temp;
					i=-1;
				}
			occur++; //i++
		}

		occur++;
		int temp = 0;
		occur+=4; //two branches and two assignments
		for (int i = 0; i < size; i++) {
			occur++; //comparison
			for (int j = 0; j < size; j++) {
				occur+=4; //comparison, temp++, assignment, j++
				t.setTableValue(i,j,tempArr[temp]);
				temp++;
			}
			occur++; //i++
		}
	}

	public static void main(String[] args) throws Exception {

		System.out.println("***Initial Table***");
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter the file location of your txt:");
		Table tab =  Table.GetTable(scan.nextLine());
//		Table tab = Table.GetTable("src/cs5387/info.txt");
		System.out.println(tab.toString());
		System.out.println("Sorted: " + isSorted(tab));
		occur++; //function call
		sortable(tab);
		System.out.println(tab.toString());
		System.out.println("Sorted: " + isSorted(tab));
		System.out.println("Number Of Operations Executed: " + occur);
	}
}
