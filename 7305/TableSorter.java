import cs5387.Table;

public class TableSorter{

    /**
    Checks to see if the table is sorted.
    A table is sorted if each row is sorted and each column is sorted.
    */
    public static boolean isSorted(Table t){
        int size = t.getSize();
        // Iterrates through the table
        for(int i=0; i<size; i++){
            // Checks if each row and column is sorted
            if(!checkRowOrColumn(t, 0, i, size-1, i) || !checkRowOrColumn(t, i, 0, size-1, 0))
                return false;
        }
        return true;
    }

    /**
    Checks if an individual row or column in a table is sorted
    As arguments, it takes in the table as well as the starting and ending indexes to check
    */
    private static boolean checkRowOrColumn(Table t, int startX, int startY, int endX, int endY){
        int previous_value = t.getTableValue(startX, startY);
        // Iterrates through either the row or column
        for(int i=startX; i<=endX; i++){
            for(int j=startY; j<=endY; j++){
                // Checks if the current value is larger then the previous value
                int current_value = t.getTableValue(i, j);
                if(current_value < previous_value)
                    return false;
                // Sets a new previous value
                previous_value = current_value;
            }
        }
        return true;
    }

    /**
    Sorts a table to acending order
    */
    public static void sortable (Table t){
        // counter to keep track of operations
        int counter = 0;
        // Checks if table is already sorted
        // Because it is not part of the sorting process, it is not included in the counting
        if(!isSorted(t)){
            // Create 1D array to hold all table values
            counter += 2; // +1 for assignment, +1 for method call
            int size = t.getSize();
            counter++; // +1 for assignment
            int[] list = new int[size * size];
            // Copy all table values into a 1D array
            counter ++; // +1 for assignment
            for(int i=0; i<size; i++){
                counter += 2; // +1 for the comparison, +1 for the incrementing
                counter ++; // +1 for assignment
                for(int j=0; j<size; j++){
                    counter += 2; // +1 for the comparison, +1 for the incrementing
                    counter += 2; // +1 for the assignment, +1 for the method call
                    list[(i * size) + j] = t.getTableValue(i, j);
                }
                counter ++; // +1 for finishing for-loop
            }
            counter ++; // +1 for finishing for-loop

            // Add the counter var from sortArray and add it to the running total
            // Sort the 1D array to acending order
            counter++;
            counter = counter + sortArray(list, 0, list.length - 1);

            // Copy sorted 1D array values back into table
            counter ++; // +1 for assignment
            for(int i=0; i<size; i++){
                counter += 2; // +1 for the comparison, +1 for the incrementing
                counter ++; // +1 for assignment
                for(int j=0; j<size; j++){
                    counter += 2; // +1 for the comparison, +1 for the incrementing
                    counter++; // +1 for method call
                    t.setTableValue(i, j, list[(i * size) + j]);
                }
                counter ++; // +1 for finishing for-loop
            }
            counter ++; // +1 for finishing for-loop
        }
        System.out.println("Total Operations: " + counter);
    }

    /**
    Sorts a 1D array to acending order using quicksort
    */
    private static int sortArray(int list[], int start, int end){
        // counter to keep track of operations
        int counter = 0;
        counter++; // for comparison
        if (start < end) {
            // Gets the returned array from partition method
            counter += 2; // +1 for assignment, +1 for method call
            int[] partition_array = partition(list, start, end);
            // extracts new partition value from array
            counter++; // +1 for assignment
            int par_value = partition_array[0];

            // extracts op counter from array and adds it to running counter
            counter = counter + partition_array[1];

            counter++; // +1 for method call
            sortArray(list, start, par_value - 1);
            counter++; // +1 for method call
            sortArray(list, par_value + 1, end);
        }

        counter++; // +1 for return value
        return counter;
    }

    /**
    Helper method for quicksort
    */
    private static int[] partition(int list[], int start, int end) {
        // counter to keep track of operations
        int counter = 0;
        // Sets a pivot to the last element
        counter++; // +1 for assignment
        int pivot = list[end];
        counter++; // +1 for assignment
        int i = start - 1;
        int temp; // +1 for assignment

        // Iterrates through array and switches values if needed
        counter ++; // +1 for assignment
        for (int j=start; j<end; j++) {
            counter += 2; // +1 for the comparison, +1 for the incrementing
            counter++; // +1 for comparison
            if (list[j] <= pivot) {
                counter++; // +1 for incrementing
                i++;

                counter++; // +1 for assignment
                temp = list[i];
                counter++; // +1 for assignment
                list[i] = list[j];
                counter++; // +1 for assignment
                list[j] = temp;
            }
        }
        counter ++; // +1 for finishing for-loop

        counter++; // +1 for assignment
        temp = list[i+1];
        counter++; // +1 for assignment
        list[i + 1] = list[end];
        counter++; // +1 for assignment
        list[end] = temp;

        // Returns array with the following values
        // 0 - the new partition
        // 1 - the running counter
        counter++; // +1 for return value
        return new int[] {i + 1, counter};
    }
}
