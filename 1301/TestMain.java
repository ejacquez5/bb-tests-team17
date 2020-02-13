import java.io.FileNotFoundException;
import java.io.IOException;

import cs5387.Table;
import cs5387.TableSorter;

//*******************************************************************
//Test main
//Author: <<author name redacted >>
//Date: 01/29/2020
//Programming Assignment 1
//
//Program entry point to test and review the results of the new methods implemented. 
//*******************************************************************
public class TestMain {
	
	public static void main(String[] args) {
		try {
			Table t = Table.GetTable("C:\\temp\\matrix_NxN.txt");
			
			TableSorter sorter = new TableSorter();
			
			System.out.println("The following table: ");
			System.out.println(t.toString());
			
			if(sorter.isSorted(t)) {
				System.out.println("Is sorted.");
			}
			else {
				System.out.println("Is not sorted.");
			}
			
			
			System.out.println("----------: Sorting Table");
			TableSorter.sortable(t);
			
			System.out.println("The table: ");
			System.out.println(t.toString());
			
			if(sorter.isSorted(t)) {
				System.out.println("Is now sorted.");
			}
			else {
				System.out.println("Failed to sort.");
			}
			
			System.out.println("Operations Performed: " + sorter.getOperationCount());
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
