import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

/**
	@author <<author name redacted >>
	Purpose: Homework assignment 1, sorting a table object to test its functionalities
	
*/

public class TableSorter{
	
	static int counter = 0;
	public static void main (String[]args)throws IOException, Exception{
	
		Table tableInit = Table.GetTable("matrix.txt");
		sortable(tableInit);
		Print(tableInit);
		System.out.println();
		System.out.println(isSorted(tableInit));
		System.out.println(counter);
	}
	
	
	public static void sortable(Table t){
		int row = 0;
		//Bubble sort is implemented to sort numbers at the row level first 
		while (row<t.getSize()){
			counter++;
			int n = t.getSize();
			for(int i=0; i< n-1 ; i++){
				counter+=2;
				for(int j=0; j<n-i-1; j++){
					counter+=2;
					if(t.getTableValue(row,j) > t.getTableValue(row,j+1)){
						counter++;
						int temp = t.getTableValue(row,j);
						counter++;
						t.setTableValue(row,j,t.getTableValue(row,j+1));
						counter++;
						t.setTableValue(row,j+1,temp);
						counter++;
					}
				}
			}
			row++;
			counter++;
		}
		
		int col = 0;
		row = 0;
		counter+=2;
		
		//Bubble sort is then implemented again at the column level once rows are sorted
		while (col<t.getSize()){
			counter++;
			int n = t.getSize();
			counter++;
			for(int i=0; i< n-1 ; i++){
				counter+=2;
				for(int j=0; j<n-i-1; j++){
					counter+=2;
					if(t.getTableValue(j,col) > t.getTableValue(j+1,col)){
						counter++;
						int temp = t.getTableValue(j,col);
						counter++;
						t.setTableValue(j,col,t.getTableValue(j+1,col));
						counter++;
						t.setTableValue(j+1,col,temp);
						counter++;
					}
				}
			}
			col++;
			counter++;
		}
	}
	
	public static boolean isSorted(Table t){
		for(int i=0; i<t.getSize(); i++){
			for(int j=0; j<t.getSize() -1; j++){
				if (t.getTableValue(i,j)>t.getTableValue(i,j+1)){
					return false;
				}
			}
		}
		
		for(int i=0; i<t.getSize(); i++){
			for(int j=0; j<t.getSize()-1; j++){
				if (t.getTableValue(j,i)>t.getTableValue(j+1,i)){
					return false;
				}
			}
		}
		
		return true;
	}
	
	public static void Print(Table t){
		for(int i=0; i<t.getSize(); i++){
			for(int j=0; j<t.getSize(); j++){
				System.out.print(t.getTableValue(i,j)+" ");
			}
			System.out.println();
		}
	}

}