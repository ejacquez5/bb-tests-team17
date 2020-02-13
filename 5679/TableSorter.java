package cs5387;
public class TableSorter{
	static int numoperations;
	
    public static boolean isSorted(Table t){
        int maxNum = 0;
        int range = t.getSize();
        for (int r=0; r<range; r++) {
			for (int c=0; c<range; c++) {
                int currVal = t.getTableValue(r, c);
				if(currVal < maxNum){
                    return false;
                }else{
                	maxNum=currVal;
                }
			}			
		}
        return true;
    }

    /*
     * Create a 1D version of the table to then sort through
     * and then reinsert sorted values into the table.
     */
    public static void sortable(Table t){
        int range = t.getSize();
        int[] sortArr = new int[range*range];
        int sortIndex = 0;
        int currVal = 0;
        numoperations += 7; //plus 2 for the initialization of r and c
        
        for (int r=0; r<range; r++) {
        	numoperations += 2;
			for (int c=0; c<range; c++) {
                currVal = t.getTableValue(r, c);
                sortArr[sortIndex] = currVal;
                sortIndex++;
                numoperations += 6;
			}			
        }
        
        sortIndex = 0;
        sortArr = bubbleSort(sortArr);
        numoperations += 5;  //plus 2 for the initialization of r and c
        
        for (int r=0; r<range; r++) {
        	numoperations += 2;
			for (int c=0; c<range; c++) {
                t.setTableValue(r, c, sortArr[sortIndex]);
                sortIndex++;
                numoperations += 5; //plus 1 for the assignment in setTableValue
			}			
        }
        System.out.println("The number of operations required are: "+numoperations);
    }

    //Bubble sort is used to avoid the worst case scenario of n^2
    static int[] bubbleSort(int[] arr){
        int length = arr.length;
        numoperations += 3; //plus 2 for the initialization of i and j
        for (int i=0; i<length-1; i++){
        	numoperations += 2;
            for (int j=0; j<length-i-1; j++){
            	numoperations += 3; //plus 1 for the branch of 'if'
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    numoperations += 4;
                }
            }
        }
        return arr;
    }
}