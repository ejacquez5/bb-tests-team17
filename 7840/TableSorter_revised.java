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
		counter++;//check if t is null
		if(t != null)
		{
			sortRows(t);
			counter++; //function call
			columnsToRows(t);
			counter++; //function call
			sortRows(t);
			counter++; //function call
		}
	}	
	private static void sortRows(Table t)
	{
		int size = t.getSize();
		counter+=2; //'size' initialization and assignment
		counter++; //t.getSize() function call
		
		int[] row = new int[size];
		counter+=2; //'row' initialization and size declaration

		int value = 0;
		counter+=2; //'value' initialization and assignment

		counter+=2; //'i' initialization and assignment
		for(int i=0; i<size; i++)
		{
			counter++; //compare 'i'
			
			counter+=2;//'j' initialization and assignment
			for(int j=0; j<size; j++)
			{
				counter++; //compare 'j'
				
				value = t.getTableValue(i, j);
				counter++; //'value' assignment
				counter++; //t.getTableValue() function call

				row[j] = value;
				counter++; //'row[j]' assignment
				
				counter++; // increment 'j'

			}
			sort(row, 0, row.length-1);
			counter++; //row.length-1 operation
			counter++; //sort() function call

			counter++; //'n' initialization and assignment
			for (int n=0; n<row.length; n++) 
			{
				counter+=2; //compare 'n' and 'row.length' call
				
				t.setTableValue(i, n, row[n]);
				counter++;// setTableValue() function call
				
				counter++; //increment 'n'
			}
			
			counter++; //increment 'i'
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
		counter+=2; //'i' initialization and assignment
		for (int i=0; i<t.getSize(); i++) {
			counter+=2; //compare 'i' and getSize() function call
			
			counter+=3; //'j' initialization, assignment and 'i+1' operation
			for (int j=i+1; j<t.getSize(); j++)
			{
				counter+=2;//compare 'j' and getSize() function call
				
				int temp = t.getTableValue(i, j);
				counter+=2; //'temp' initialization and assignment
				counter++; //getTableValue() function call
				
				t.setTableValue(i,j, t.getTableValue(j, i));
				counter++; //setTableValue() function call
				counter++; //getTableValue() function call
				
				t.setTableValue(j, i, temp);
				counter++; //setTableValue() function call
				
				counter++;//increment'j'
			}
			
			counter++; //increment 'i'
		}
	}
	/*MergeSort is used because of its O(nlogn) time complexity; 
	*Unlike QuickSort or BubbleSort which have O(n^2)*/
	private static int[] sort(int [] array, int left, int right)
	{
		counter++; //compare 'left' < 'right'
		if(left < right)
		{
			int mid = (left+right)/2;
			counter+=2; //'mid' initialization and assignment
			counter++; //'left+right/2' operation 
			
			sort(array, left, mid);
			counter++; //sort() function call

			sort(array, mid+1, right);
			counter+=2; //sort() function call and 'mid+1' operation
			
			merge(array, left, mid, right);
			counter++; //merge() function call

		}
		counter++;//return statement
		return array; 
	}
	private static int[] merge(int [] array, int left, int mid, int right)
	{
		int subArraySize1 = mid-left+1;
		counter+=2;//'subArraySize1' initialization and assignment
		counter++; //'mid-left+1' operation

		int subArraySize2 = right-mid;
		counter+=2;//'subArraySize2' initialization and assignment
		counter++; //'right-mid' operation
		
		int [] leftTempArray = new int [subArraySize1];
		counter+=2; //'leftTempArray' initialization and size declaration

		int [] rightTempArray = new int [subArraySize2];
		counter+=2; //'rightTempArray' initialization and size declaration
		
		counter++; //'i' initialization and assignment
		for(int i=0; i<subArraySize1; ++i) 
		{
			counter++;// compare 'i' 
			
			leftTempArray[i] = array[left+i];
			counter+=2; //'leftTempArray' assignment and 'left+1' operation
			
			counter++; //increment 'i'
		}
		
		counter+=2; //'i' initialization and assignment
		for(int i=0; i<subArraySize2; ++i) 
		{
			counter++;//compare 'i'
			
			rightTempArray[i] = array[mid+1+i];
			counter+=2;// 'rightTempArray' assignment and 'mid+1+i' operation
		}
		
		int i=0;
		counter+=2;//'i' initialization and assignment

		int j=0;
		counter+=2; //'j' initialization and assignment

		int k=left;
		counter+=2; //'k' initialization and assignment

		counter+=2; //check two conditions to enter while loop
		
		while(i<subArraySize1 && j<subArraySize2)
		{
			counter++;//check condition
			if(leftTempArray[i] <= rightTempArray[j])
			{
				array[k] = leftTempArray[i];
				counter++; //'array[k]' assignment
				
				i++;
				counter++;//increment 'i'
			}
			else
			{
				array[k] = rightTempArray[j];
				counter++;//'array[k]' assignment
				
				j++;
				counter++;// increment 'j'
			}
			k++;
			counter++;// increment 'k'

			counter+=2; //check two conditions to continue/exit while loop
		}
		
		counter++;//check condition to enter while loop
		while(i<subArraySize1)
		{
			array[k] = leftTempArray[i];
			counter++; //'array[k]' assignment 
			
			i++;
			counter++; //increment 'i'
			
			k++;
			counter++;//increment 'k'
			
			counter++;//check condition to continue/exit while loop
		}
		
		counter++;//check condition to enter while loop
		while(j<subArraySize2)
		{
			array[k] = rightTempArray[j];
			counter++; //'array[k]' assignment 
			
			j++;
			counter++; //increment 'j'
			
			k++;
			counter++;//increment 'k'
			
			counter++;//check condition to continue/exit while loop
		}
		
		counter++;//return statement
		return array;
	}
	public void run(Table t)
	{
		//if(isSorted(t))
		System.out.print("\nThe table is sorted in");
	}
	public static void main(String[] args)throws FileNotFoundException, IOException, Exception
	{	
		int [] array = new int [] {66,3,5,2,8,16,3,220,1};
		Table t = new Table(array.length, array);

		sortable(t);
		
		TableSorter ts = new TableSorter();
		ts.run(t);
		
		System.out.println(" "+ counter + " operations.");
		
		System.out.println();
		System.out.print(t);

	}	
}
