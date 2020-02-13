package cs5387;

//*******************************************************************
//Position
//Author: <<author name redacted >>
//Date: 01/29/2020
//Programming Assignment 1
//
//Position serves as an abstraction class that handles the operations
//for a table class that lacks data structure. Identifies neighboring 
//positions depending on the iteration (by row or by column). It also
//contains some functions to compare one position to another. 
//*******************************************************************
public class Position {
	public int row;
	public int col;
	private int max;
	
	//Constructor calling counts as 4 operations
	public Position(int rowIndex, int colIndex, int range) {
		row = rowIndex;
		col = colIndex;
		max = range;
	}
	
	//Gets the next position depending if we are iterating a row or a column. 
	//It is asymmetric to the Prev method because it returns null after hitting the 
	//upper boundary of the row or column. This is because the sorting algorithm uses it 
	//as a base condition to halt the recursion. I'm aware that this should be fixed, 
	//but didn't have the time to address it. 
	public Position getNext(boolean isColumn) {
		//6 Operations when not null
		if(!isColumn) {
			if((col+1) < max) {
				return new Position(row,col + 1, max);
			}
			else{
				//3 Operations when null
				return null;
			}
		}
		else { 
			if((row + 1) < max) {
		
				return new Position(row + 1, col, max);
			}
			else {
				return null;
			}
		}
	}
	
	//Gets previous position depending if we are iterating a row or a column. 
	//No lower boundary is established in order to comply with the sorting algorithm.
	public Position getPrev(boolean isColumn) {
		//5 Operations total
		if(!isColumn) {
			return new Position( row, col - 1, max);
		}
		else { 
			return new Position( row - 1, col, max);
		}
	}
	
	//Check if 2 positions are the same. NOT USED IN THIS VERSION
	public boolean equals (Position pos) {
		if(this.row == pos.row && this.col == pos.col) {
			return true;
		}
		return false;
	}
	
	//Determines if a given position is greater than a this position if it's to the right
	// or under this position. 
	public boolean smallerThan(Position pos) {
		//Can't count, count 4 operations always (worst case)
		if(this.row<pos.row) {
			return true;
		}
		else if (this.row == pos.row && this.col < pos.col) {
			return true;
		}
		return false;
	}
}
