package cs5387;
/* <<author name redacted >>
   purpose of this program is to provide sort functions for Tables
   Version 1.0
*/


public class tableSorter{

    public boolean isSorted(Table t){
	int range = t.getSize();
	int prevVal=t.getTableValue(0,0); //prevVal is to compare to the previous element as follows
	for(int i=0; i<range; i++) //For each row
	    for(int j=1;j<range;j++) //for each column
		if(prevVal > t.getTableValue(i,j)) //if previous value is greater than current, Not sorted
		    return false;
		else
		    prevVal=t.getTableValue(i,j); //else, lets update prevVal!
	return true; //Made it this far, table is sorted!
		
    }

    public static int totalOps;
    public int getTotalOps(){
	return totalOps;
    }
    public static void sortable(Table t){
	int range = t.getSize();
	int[] tempArr = new int[range*range]; //Make an array with elements of the table for better sorting
	int k=0;
	totalOps=7; //7 assignments including this one and setting i=0 next line!
	for(int i=0; i<range; i++){
	    totalOps+=3; //3 operations to compare and increment and j=0 below line
	    for(int j=0;j<range;j++){
		totalOps+=2; //2 operations to compare and increment
		tempArr[k++]=t.getTableValue(i,j); //Populate our temporary array
		totalOps+=3; //3 operations to increment k, index into tempArr, and to index into table(i,j)
	    }
	}
	tempArr=bubbleSort(tempArr); //Bubble sort our temporary array!
	k=0;
	totalOps+=3; //3 lines above the call and assignment, and i=0 below
	for(int i=0; i<range; i++){
	    totalOps+=3; //Compare and increment i, and j=0 below
	    for(int j=0;j<range;j++){
		totalOps+=2; //Compare and increment
		t.setTableValue(i,j,tempArr[k++]); //Update the table with sorted values
		totalOps+=3; //increment k, index into tempArr, index into table (i,j) to set the value
	    }
	}
	return;
    }
    private static int[] bubbleSort(int[] inArr){ //Bubble sort algorithm
	int n = inArr.length;
	totalOps+=2; //Assign n above, and assign i to 0 below
	for (int i = 0; i < n-1; i++){
	    totalOps+=3; //compare i, increment i above, j=0 below
	    for (int j = 0; j < n-i-1; j++){
		totalOps+=2; //compare j, increment j above
		if (inArr[j] > inArr[j+1]){
		    totalOps+=1; //Compare above
		    int temp = inArr[j];
		    inArr[j] = inArr[j+1];
		    inArr[j+1] = temp;
		    totalOps+=3; //3 assignments above
		}
	    }
	}
	return inArr;
    }
}
