package cs5387;


//*******************************************************************
//TableSorter
//Author: <<author name redacted >>
//Date: 01/29/2020
//Programming Assignment 1
//
//TableSorter class with public interface methods required by
//programming assignment 1
//*******************************************************************
public class TableSorter {
	
	static int operationCount = 0;
	//*******************************************************************
	//isSorted
	//Author: Diego A. Rivera
	//Date: 01/29/2020
	//Programming Assignment 1
	//
	//Given a table returns a boolean value "True" if the table 
	//provided has all rows and columns sorted.  
	//*******************************************************************
	public boolean isSorted(Table table) {
		if(table != null) {
				
			int range = table.getSize();
			
			Position index;
			
			//Iterate through rows
			for(int rowIndex = 0; rowIndex < range ; rowIndex++) {
				
				index = new Position( rowIndex, 0, range);
				Position next;
				
				//Check that all values in the row are sorted
				while(index.getNext(false)!=null) {
					next = index.getNext(false);
					int curVal = table.getTableValue(index.row, index.col);
					int nextVal = table.getTableValue(next.row, next.col);
					
					if(curVal>nextVal) {
						return false;
					}
					
					index = next;
				}
			}
			
			//Iterate through all columns
			for(int colIndex = 0; colIndex < range ; colIndex++) {
				
				index = new Position( 0, colIndex, range);
				Position next;
				
				//Check that all values in the column are sorted. 
				while(index.getNext(true)!=null) {
					next = index.getNext(true);
					int curVal = table.getTableValue(index.row, index.col);
					int nextVal = table.getTableValue(next.row, next.col);
					
					if(curVal>nextVal) {
						return false;
					}
					
					index = next;
				}
			}
			
			return true; 
		}
		else {
			throw new NullPointerException();
		}
	}
	
	
	//*******************************************************************
	//sortable
	//Author: Diego A. Rivera
	//Date: 01/29/2020
	//Programming Assignment 1
	//
	//Given a table returns a boolean value "True" if the table 
	//provided has all rows and columns sorted.  
	//*******************************************************************
	public static void sortable(Table table) {
		operationCount = 0;
		operationCount++;
		if(table != null) {
			operationCount+=2; //var assignment and method call
			QuickSortTable sorter = new QuickSortTable();
			operationCount+=2; //var assignment and method call
			int range = table.getSize();
			
			//sort rows
			operationCount++; operationCount++; //for assignment and first comparison
			for(int rowIndex = 0; rowIndex < range ; rowIndex++) {
				sorter.quickSortRow(table, rowIndex);
				operationCount+= sorter.getOperationCount();
				operationCount+=3;//for index increase + comparison
			}
			
			//sort columns 
			operationCount++;operationCount++; //for index increase
			for(int colIndex = 0; colIndex < range ; colIndex++) {
				operationCount++;
				sorter.quickSortCol(table, colIndex);
				operationCount+= sorter.getOperationCount();
				
				operationCount+=3;//for index increase + comparison
			}
		}
		else {
			operationCount+=2; //branch and method call
			throw new NullPointerException();
		}
	}
	
	public int getOperationCount() {
		return operationCount;
	}
	
}
