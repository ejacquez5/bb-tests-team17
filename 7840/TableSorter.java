package cs5387;
import java.io.*;

/**********************************************
*TableSorter sorts the integer values of an NxN 
*matrix in ascending order by using MergeSort. 
*First, it sorts the values in the rows, then 
*it transposes the matrix to sort the values 
*in the columns.
*
*@<<author name redacted >>
***********************************************/
public class TableSorter
{
	public static int counter = 0;
	
	public boolean isSorted(Table t)
	{
		if(t==null)
			return false;
		if(!check(t))
			return false;
		else
		{
			columnsToRows(t);
			if(!check(t))
				return false;
		}
		return true;
	}
	private boolean check(Table t)
	{
		for(int i=0; i<t.getSize(); i++)
			for(int j=i+1; j<t.getSize(); j++)
				if(t.getTableValue(i, j-1) > t.getTableValue(i, j))
					return false;
		return true;
	}
	public static void sortable(Table t)
	{
		counter++;
		if(t != null)
		{
			sortRows(t);
			counter++;
			columnsToRows(t);
			counter++;
			sortRows(t);
			counter++;
		}
	}	
	private static void sortRows(Table t)
	{
		int size = t.getSize();
		counter++;
		counter++;
		
		int[] row = new int[size];
		counter++;

		int value = 0;
		counter++;

		counter++;
		for(int i=0; i<size; i++)
		{
			counter++;
			
			counter++;
			for(int j=0; j<size; j++)
			{
				counter++;
				
				value = t.getTableValue(i, j);
				counter++;
				counter++;

				row[j] = value;
				counter++;

			}
			sort(row, 0, row.length-1);
			counter++;

			counter++;
			for (int n=0; n<row.length; n++) {
				counter++;
				
				t.setTableValue(i, n, row[n]);
				counter++;
			}
		}
		System.out.println();
	}
	/*Since the Table must be sorted individually by row and individually by column, 
	 * the assumption is made that the order per row and/or the order per column of the original table 
	 * does not have to be maintained. Therefore, transposing the table seems like an efficient 
	 * way to sort the values and/or to check if they are sorted.
	 */
	private static void columnsToRows(Table t)
	{
		counter++;
		for (int i=0; i<t.getSize(); i++) {
			counter++;
			
			counter++;
			for (int j=i+1; j<t.getSize(); j++)
			{
				counter++;
				
				int temp = t.getTableValue(i, j);
				counter++;
				counter++;
				
				t.setTableValue(i,j, t.getTableValue(j, i));
				counter++;
				counter++;
				
				t.setTableValue(j, i, temp);
				counter++;
			}
		}
	}
	/*MergeSort is used because of its O(nlogn) time complexity; 
	*Unlike QuickSort or BubbleSort which have O(n^2)*/
	private static int[] sort(int [] array, int left, int right)
	{
		counter++;
		if(left < right)
		{
			int mid = (left+right)/2;
			counter++;
			
			sort(array, left, mid);
			counter++;

			sort(array, mid+1, right);
			counter++;
			
			merge(array, left, mid, right);
			counter++;

		}
		return array;
	}
	private static int[] merge(int [] array, int left, int mid, int right)
	{
		int subArraySize1 = mid-left+1;
		counter++;

		int subArraySize2 = right-mid;
		counter++;
		
		int [] leftTempArray = new int [subArraySize1];
		counter++;

		int [] rightTempArray = new int [subArraySize2];
		counter++;
		
		counter++;
		for(int i=0; i<subArraySize1; ++i) {
			counter++;
			leftTempArray[i] = array[left+i];
			counter++;
		}
		
		counter++;
		for(int i=0; i<subArraySize2; ++i) {
			counter++;
			rightTempArray[i] = array[mid+1+i];
			counter++;
		}
		
		int i=0;
		counter++;

		int j=0;
		counter++;

		int k=left;
		counter++;

		while(i<subArraySize1 && j < subArraySize2)
		{
			counter++;
			if(leftTempArray[i] <= rightTempArray[j])
			{
				counter++;
				array[k] = leftTempArray[i];
				i++;
				counter++;
				counter++;
			}
			else
			{
				array[k] = rightTempArray[j];
				j++;
				counter++;
				counter++;
			}
			k++;
			counter++;

		}
		while(i<subArraySize1)
		{
			counter++;

			array[k] = leftTempArray[i];
			i++;
			k++;
			counter++;
			counter++;
			counter++;

		}
		while(j<subArraySize2)
		{
			counter++;

			array[k] = rightTempArray[j];
			j++;
			k++;
			counter++;
			counter++;
			counter++;

		}
		return array;
	}
	public void run(Table t)
	{
		//if(isSorted(t))
		System.out.print("\nThe table is sorted in");
	}
	public static void main(String[] args)throws FileNotFoundException, IOException, Exception
	{	
		int [] array = new int [] {3,5,7,1,8,6,6,0,7};
		Table t = new Table(array.length, array);

		sortable(t);
		
		TableSorter ts = new TableSorter();
		ts.run(t);
		
		System.out.print(" "+ counter + " operations.");

	}	
}
