package cs5387;

/**
 * @author <<author name redacted >>
 * This Class can verify if an nxn table is sorted in ascending order,
 * or sort it to ensure that the table is sorted in ascending order
 *
 */
class TableSorter {
	static int count = 0;
	
	//checks if table is sorted
	public boolean isSorted(Table T) {
		//previous will keep the last read number and use it to verify that the array is sorted
		for (int i = 0; i < T.getSize(); i++) {
			if (!checkColumn(T,i))
				return false;
			if (!checkRow(T,i))
				return false;
		}
		return true;
	}

	// check row to ensure ascending order
	private boolean checkRow(Table T, int r) {
		for (int i = 0; i < T.getSize()-1; i++) {
			if (T.getTableValue(r, i) > T.getTableValue(r, (i+1)))
				return false;
		}
		return true;
	}
	//check column to ensure ascending order
	private boolean checkColumn(Table T, int c) {
		for (int i = 0; i < T.getSize()-1; i++) {
			if (T.getTableValue(i, c) > T.getTableValue((i+1), c))
				return false;
		}
		return true;
	}
	
	
	//Bubble sort implementation to avoid recursive
	public static void sortable(Table T) {
		count+=2;//assignment and function call
		int range = T.getSize();
		count++;//assignment
		int sortedCounter = 0;
		//while loop ensures the array is sorted by counting successful comparisons
		count++;//comparison
		while (sortedCounter != range*range-1) {
			count++;//assignment
			sortedCounter = 0;
			count+=2;//assignment and function call
			int previous = T.getTableValue(0, 0);
			count+=3;//assignment and comparison and branch
			for (int i = 0; i < range; i++) {
				count+=3;//assignment, comparison, and branch
				for (int j = 0; j < range; j++) {
					//previous starts at [0][0]
					count+=3;//2 comparisons and branch
					if (i == 0 && j == 0) {
						count++;//assignment
						j++;
					}
					count+=2;//assignment and function call
					int current = T.getTableValue(i, j);
					count+=2;//comparison and branch
					if (previous <= current) {
						count++;//assignment
						previous = current;
						count++;//assignment
						sortedCounter++;
					}
					//the array only needs to be modified if the comparison failed
					else {
						count++;//assignment
						sortedCounter--;
						count++;//function call
						T.setTableValue(i, j, previous);
						//check if previous is from prior row or column and modify the array accordingly
						count+=2;//comparison and branch
						if (j == 0) {
							count++;//function call
							T.setTableValue(i-1, range-1, current);
						} else {
							count++;//function call
							T.setTableValue(i, j-1, current);						
						}
					}
				count+=2;//assignment and comparison for loop
				}
			count+=2;//assignment and comparison for loop
			}
		count++;//while loop comparison
		}
		count++;//while loop exit branch
		System.out.println(count);
	}
}