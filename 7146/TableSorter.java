/* Author: <<author name redacted >>
   Purpose: To provide two public methods one that
   			sorts a 2-Dimensional matrix, and the
   			other method to check if that sorted
   			2D matrix is indeed sorted.
*/

package cs5387;

public class TableSorter{

	//number of operations performed
	static int count = 0;

	// constructor for the class (default)
	public TableSorter(){}


	// getter for the count variable
	public static int getCount(){
		return count;
	}

	//returns true if every row and every column of the table t
	//is sorted in ascending order
	public boolean isSorted(Table t){

		count+=2; //assignment and function call
		int size = t.getSize();

		//if t[r][c-1] > t[r][c] false
		count+=2; //assignment and comparison
		for (int r = 0; r<size-1; r++){
			count+=2; //assignment and comparison
			for (int c = 0; c < size-1; c++){
				count+=3; //two function calls and comparison
				if (t.getTableValue(r,c) > t.getTableValue(r, c+1)){
					count+=1; //branch
					return false;
				}
				count+=1; //if else branch
			}
			count+=1; //branch
		}
		count+=1; //branch

		//if t[r-1][c] > t[r][c] false
		count+=2; //assignment and comparison
		for (int c = 0; c<size-1; c++){
			count+=2; //assignment and comparison
			for (int r = 0; r < size-1; r++){
				count+=3; //two function calls and comparison
				if (t.getTableValue(r,c) > t.getTableValue(r+1, c)){
					count+=1; //branch
					return false;
				}
				count+=1; //branch
			}
			count+=1; //branch
		}
		count+=2; //two branches
		return true;
	}

	//sorts a Table so that isSorted() is true
	public static void sortable(Table t){


		//size to know the dimensions of the matrix
		count+=2; //function call and assignment
		int size = t.getSize();

		//array to hold the values of the columns/rows to be sorted
		int [] temp;

		System.out.println("Sorting Rows!");

		//Sort rows
		count+=2; //assignment and comparison
		for (int i = 0; i<size; i++){
			count+=1; //assignment
			temp = new int[size];

			count+=2; //assignment and comparison
			for (int j = 0; j<size; j++) {
				count+=2; //function call and assignment
				temp[j] = t.getTableValue(i, j); //storing of the row values to be sorted

			}
			count+=1; //branch

			//sort row i from above
			count+=1; //function call
			bubbleSort(temp, size);


			//set the sorted row values obtained from above
			//back into the original matrix
			count+=2; //assignment and comparison
			for (int j = 0; j<size; j++){
				count+=1; //function call
				t.setTableValue(i,j,temp[j]);

			}
			count+=1; //branch
		}
		count+=1; //branch


		count+=2; //assignment and comparison
		for (int i = 0; i<size; i++){
			count+=1; //assignment
			temp = new int[size];

			count+=2; //assignment and comparison
			for (int j = 0; j<size; j++){
				count+=2; //function call and assignment
				temp[j] = t.getTableValue(j,i); //storing the of columns values to be sorted
			}
			count+=1; //branch

			//sort columns
			count+=1; //function call
			bubbleSort(temp, size);

			//set the sorted column values obtained from above
			//back into the original matrix
			count+=2; //assignment and comparison
			for (int j = 0; j<size; j++) {
				count+=1; //function call
				t.setTableValue(j, i, temp[j]);
			}
			count+=1; //branch
		}

		count+=2; //two branches
		return;
	}

	//Helper method to sort rows and columns
	private static void bubbleSort(int [] temp, int size){
		//sort the provided array of values obtained
		//from the table
		count+=1; //assignment
		boolean needNextPass = true;

		count+=2; //assignment and comparison
		for (int k = 1; k<size && needNextPass; k++) {
			count+=1; //assignment
			needNextPass = false;

			count+=2; //assignment and comparison
			for (int l = 0; l<size - k; l++){
				count+=1;//comparison
				if (temp[l] > temp[l+1]) {

					//Swap temp[l] with temp[l+1]
					count+=1; //assignment
					int swap = temp[l];
					count+=1; //assignment
					temp[l] = temp[l+1];
					count+=1; //assignment
					temp[l+1] = swap;

					count+=1; //assignment
					needNextPass = true;

				}
				count+=1; //branch
			}
			count+=1; //branch
		}
		count+=2; //two branches
		return;
	}
}
