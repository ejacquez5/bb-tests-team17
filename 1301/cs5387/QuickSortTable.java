package cs5387;

//*******************************************************************
//QuickSortTable
//Author: <<author name redacted >>
//Date: 01/29/2020
//Programming Assignment 1
//
//Sorting algorithm class implemented to sort rows or columns on 
//a given table. The algorithm has a single implementation, but
//depending on the entry method used it will decide if the next position
//on the matrix is right (for rows) or down (for columns).
//
//References: 
//- Implementation of quick sort algorithm provided by https://www.geeksforgeeks.org/quick-sort/
//*******************************************************************

public class QuickSortTable {
	
	boolean isColumn;
	int operationCount;
	
	//Entry point for sorting rows. 
	public void quickSortRow(Table t, int rowIndex) {
		operationCount = 0;
		int range = t.getSize();
		operationCount+=2;
		
		isColumn = false;
		operationCount++;
		Position start = new Position( rowIndex, 0, range);
		operationCount+=5;
		Position end = new Position( rowIndex, range-1, range);
		operationCount+=5;
		
		quickSort( t, start, end);
		operationCount++;
	}
	
	//Entry point for sorting columns. 
	public void quickSortCol(Table t, int colIndex) {
		operationCount = 0;
		int range = t.getSize();
		operationCount+=2;
		
		isColumn = true;
		operationCount++;
		Position start = new Position( 0, colIndex, range);
		operationCount+=5;
		Position end = new Position( range-1, colIndex, range);
		operationCount+=5;
		
		quickSort( t, start, end);
		operationCount++;
	}
	
	private void quickSort(Table t, Position min, Position max) {
		if(min != null && max != null && min.smallerThan(max)) {
			operationCount+=6;
			Position partitionIndex = partition(t,min,max);
			operationCount+=2;
			quickSort(t, min, partitionIndex.getPrev(isColumn));
			operationCount+=5;
			quickSort(t, partitionIndex.getNext(isColumn), max);
			if(partitionIndex.getNext(isColumn) == null) {
				operationCount+=3;
			}
			else {
				operationCount+=6;
			}
		}
	}
	
	private Position partition(Table t, Position min, Position max) {
		
		Position pivot = max;
		Position positionIndex = min.getPrev(isColumn);
		Position iterator = min;
		operationCount+=9;
		while(iterator.smallerThan(pivot)) {
			
			int iteratorVal  = t.getTableValue(iterator.row, iterator.col);
			int pivotVal = t.getTableValue(pivot.row, pivot.col);
			operationCount+=4;
			if (iteratorVal < pivotVal) {
				
				positionIndex = positionIndex.getNext(isColumn);
				if(positionIndex.getNext(isColumn)==null) {
					operationCount+=5;
				}
				else {
					operationCount+=8;
				}
				swap( t, positionIndex, iterator);
				operationCount+=6;
			}
			
			iterator = iterator.getNext(isColumn);
			if(iterator.getNext(isColumn)==null) {
				operationCount+=5;
			}
			else {
				operationCount+=8;
			}
		}
		
		swap(t, positionIndex.getNext(isColumn), pivot);
		operationCount+=6;
		
		if(positionIndex.getNext(isColumn)==null) {
			operationCount+=8;
		}
		else {
			operationCount+=14;
		}
		return positionIndex.getNext(isColumn);
	}
	
	private void swap(Table t, Position a, Position b) {
		
		int tempVal_A = t.getTableValue(a.row, a.col);
		int tempVal_B = t.getTableValue(b.row, b.col);
		
		t.setTableValue(a.row, a.col, tempVal_B);
		t.setTableValue(b.row, b.col, tempVal_A);
	}
	
	public int getOperationCount() {
		return operationCount;
	}

}
