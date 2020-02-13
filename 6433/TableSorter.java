//<<author name redacted >>
//Dr. Roach CS4387

//1-27-2020 - Began working on project
//1-28-2020 - got tables working, now sorting
//1-29-2020 - sorting complete
//2-3-2020 - Added counters in sorting method to count branches, assignment, functionCalls, and comparisons

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

//created a 3x3 table for testing, kept it here.
public class TableSorter{
	public static void main(String[]args){
		try{
			int[]data = {1, 5, 3, 4, 3, 6, 7, 8, 9};
			int range = 9;
			Table table = new Table(range, data);
			table.GetTable("test.txt");
			System.out.println(isSorted(table));
			sortable(table);
			//prints our table
			for(int i = 0; i < table.getSize(); i++){
				for(int j = 0; j < table.getSize(); j++){
					System.out.print(table.getTableValue(i, j));
					if(j == 2){
						System.out.println();
					}
				}
			}
		}
		catch(Exception e){
			System.out.println("Error");
		}
	}
	
	//first checks sort in rows, then columns
	public static boolean isSorted(Table t){
		//checks for sorting in the rows, iterates through rows comparing values next to each other
		for(int i = 0; i<t.getSize(); i++){
			for(int j = 0; j<t.getSize()-1; j++){
				if(t.getTableValue(i, j) > t.getTableValue(i, j+1)){
					System.out.println("not ascending in rows");
					return false;
				}
			}
		}
		//checks for sorting in the columns, iterates through columns comparing values above and below each other
		for(int i = 0; i<t.getSize(); i++){
			for(int j = 0; j<t.getSize()-1; j++){
				if(t.getTableValue(j, i) > t.getTableValue(j+1, i)){
					System.out.println("not ascending in columns");
					return false;
				}
			}
		}
		return true;
	}
	
	//we use a while loop to iterate until our isSorted method returns true, uses the same for loop structure as our isSorted()
	//method. The new thing added is the integer hold that allows for values to be changed and sorted out.
	public static void sortable(Table t){
		int assignment = 0;//assignment, changing the value of a data type.
		int comparison = 0;//comparing the value of 2 data types.
		int branch = 0;//non-sequential flow
		int functionCall = 0;//# of methods used
		while(!(isSorted(t))){
			for(int i = 0; i<t.getSize(); i++){
				for(int j = 0; j<t.getSize()-1; j++){
					if(t.getTableValue(i, j) > t.getTableValue(i, j+1)){
						branch++;//branch in the if statement
						int hold = t.getTableValue(i, j);
						t.setTableValue(i, j, t.getTableValue(i, j+1));
						t.setTableValue(i, j+1, hold);
						assignment+=3;//assignments happen 3 times inside the if statement
						functionCall+=4;//4 functions called inside the if statement
					}
					functionCall+=2;//getters are called to compare
					comparison++;//compared the getters 
					branch++;//this is a branch outside the if
				}
				comparison++;//every new for loop run uses a comparison
				assignment+=2;//assignment happens twice when a new for loop runs
				branch++;//this is a branch for first for loop
			}
			comparison++;//for the loop
			assignment+=2;//for the loop
			branch++;//branch after the for loop
			for(int i = 0; i<t.getSize(); i++){
				for(int j = 0; j<t.getSize()-1; j++){
					if(t.getTableValue(j, i) > t.getTableValue(j+1, i)){
						branch++;//branch in the if statement
						int hold = t.getTableValue(j, i);
						t.setTableValue(j, i, t.getTableValue(j+1, i));
						t.setTableValue(j+1, i, hold);
						assignment+=3;//assignments happen 3 times inside the if statement
						functionCall+=4;//4 functions called inside the if statement
					}
					branch++;//this is a branch outside the if
					functionCall+=2;//getters are called to compare
					comparison++;//compared the getters 
				}
				comparison++;//every new for loop run uses a comparison
				assignment+=2;//assignment happens twice when a new for loop runs
				branch++;//this is a branch for first for loop
			}
			comparison++;//for the loop
			assignment+=2;//for the loop
			branch++;//branch after the for loop
		}
		System.out.println("assignment = "+assignment);
		System.out.println("comparison = "+comparison);
		System.out.println("branch = "+branch);
		System.out.println("function call = "+functionCall);
	}
	
}