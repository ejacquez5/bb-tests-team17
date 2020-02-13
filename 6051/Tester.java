package cs5387;
/*
 * Author: Denise Castro
 * Class: Software Integration and Verification & Validation
 * Date: February, 2020
 */
import java.io.File;
import java.io.FileWriter;

public class Tester {
	public static void main(String[] args) throws Exception {
		//TestFile is temporary will be deleted after printing statements
		File testFile = new File("TestingFile.txt");
		testFile.createNewFile();
		FileWriter testWriter = new FileWriter(testFile);
		int[] array;

		//Place test variables where numbers are separated by whitespace
		testWriter.write("0 1 2 3");
		testWriter.close();
		
		Table testTable = Table.GetTable("TestingFile.txt");
		TableSorter myTableSorter = new TableSorter();
		
		System.out.println("isSorted: " + myTableSorter.isSorted(testTable));
		
		//myTableSorter.sortable(testTable);
		
		System.out.println("Array: \n" + testTable);
		
		System.out.println("isSorted: " +myTableSorter.isSorted(testTable));
		
		
		testFile.delete();
	}
}
