package cs5387;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class TableSorter {
	static int assigned =0;
	static int compared =0;
	static int branch =0;
	static int functionCall=0;
	
	public static boolean isSorted(Table t){
		int range = t.getSize();
		for (int r=0; r<range; r++) {
			for (int c=0; c<range-1; c++) {
				if(t.getTableValue(r,c)>t.getTableValue(r,c+1)){
					return false;
				}
				if(t.getTableValue(c,r)>t.getTableValue(c+1,r)){
					return false;
				}
			}
		}
		return true;
	}

	public static void sortable(Table t){


		sorting(t, t.getSize());
		System.out.println("Number of Branches: "+ branch);

		sorting(t, t.getSize());
		

		System.out.println("Number of Comparison Operations: "+ compared);
		System.out.println("Number of Assignment Statements: "+ assigned);
		System.out.println("Number of Function Calls: "+ functionCall);
	}

	private static void sorting(Table t, int range) {
		functionCall += 1;
		int value1;
		int value2;
		for (int r = 0; r<range; r++) {
		assigned +=1;
		branch +=1;
			compared +=1;
			for (int c=0; c<range-1; c++) {
			branch +=1;
			assigned +=1;
				compared +=1;
				if(t.getTableValue(r,c)>t.getTableValue(r,c+1)){
					branch +=1;
					compared +=1;
					value1 =t.getTableValue(r,c+1);
					value2=t.getTableValue(r,c);
					assigned +=2;
					t.setTableValue(r,c, t.getTableValue(r,c+1));
					t.setTableValue(r,c+1, value2);
				}
				if(t.getTableValue(c,r)>t.getTableValue(c+1,r)){
					branch +=1;
					compared +=1;
					value1 =t.getTableValue(c+1,r);
					value2=t.getTableValue(c,r);
					assigned +=2;
					t.setTableValue(c,r, value1);
					t.setTableValue(c+1,r, value2);
				}
			}branch +=1;
		}
	}

	public static void printT(Table t){
		int range = t.getSize();
		for (int r=0; r<range; r++) {
			for (int c=0; c<range; c++) {
				System.out.print(t.getTableValue(r, c));
				System.out.print(" ");
			}
			System.out.println( );
		}
	}
}
