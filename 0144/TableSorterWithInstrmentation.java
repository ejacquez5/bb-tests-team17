public class TableSorterWithInstrmentation {
    /*
    O(n^2)+O(n) or O(n^2) on true, less on false where n is the size of the table and n^2 is the total number of values
    so O(k) where k is values in table
     */
    public static boolean isSorted(Table t){
        int size=t.getSize();
        for(int i=0;i<size-1;i++){//cheaks all but last row/col order,O((n-1)(n-1)) or O(n^2)
            for(int j=0;j<size-1;j++){
                int curr = t.getTableValue(i,j);
                if( curr > t.getTableValue(i+1,j) || curr > t.getTableValue(i,j+1)){
                    return false;
                }
            }
        }
        for(int i=0;i<size-1;i++){ //cheaks last row/col order,O(2(n-1)) or O(n)
            int currX = t.getTableValue(size,i);
            int currY = t.getTableValue(i,size);
            if ( currX > t.getTableValue(size,i+1) || currY > t.getTableValue(i+1,size)){
                return false;
            }
        }
        return true;
    }
    /*
    about O(nlogn) total where n is enterys in table
     */
    public static int[] sortable (Table t){
        int count[]=new int[4];//count[0] =assingment;count[1] = comparison operation;count[2]= branch;count[3]=function call
        int size=t.getSize();
        count[0]++;
        int liner[]= new int[size*size];
        count[0]++;
        int index=0;
        count[0]++;
        int i=0;
        count[0]++;
        count[1]++;
        count[2]++;
        while (i<size){ //extracts table to a liner array O(n),where n is number of enterys in table
            int j=0;
            count[0]++;
            while(j<size){
                liner[index]=t.getTableValue(i,j);
                count[0]++;
                count[3]++;
                index++;// increments index
                count[0]++;
                j++;
                count[0]++;
                count[1]++;
                count[2]++;
            }
            i++;
            count[0]++;
            count[1]++;
            count[2]++;
        }
        merge(liner,0,liner.length-1,count); //sorts liner array,O(NLogN) where N is number of enterys in the table
        count[3]++;
        index=0;//reset index to start
        count[0]++;
        i=0;
        count[0]++;
        count[1]++;
        count[2]++;
        while(i<size){//extracts liner array to a table,O(N) where n is enterys in table
            int j=0;
            count[0]++;
            while (j<size){
                t.setTableValue(i,j,liner[index]); //sets tableAt[i][j] to value of liner[index]
                count[3]++;
                index++;// increments index
                count[0]++;
                j++;
                count[0]++;
                count[1]++;
                count[2]++;
            }
            i++;
            count[0]++;
            count[1]++;
            count[2]++;
        }
        return count;
    }
    /*
    Pre:assumes array is not null and start and end are inside the lenght and start is the start of the sorting group
    and end is the last index to be sorted.
    Post:array from start to end is now sorted
     */
    private static void merge(int array[],int start,int end,int[] count){
        int size=end-start;
        count[0]++;
        count[1]++;
        count[2]++;
        if (size<32){//cuts to insertion sort
            insertion(array,start,end,count);
            count[3]++;
            //small set aproximation puts this low in the O(32) to O(1024) but centered around O(160)
        }
        int midoffset=(size)/2; //midpoint offset
        count[0]++;
        merge(array,start,start+midoffset,count); //left side sorted
        count[3]++;
        merge(array, start + midoffset + 1, end,count); //right side sorted
        count[3]++;
        int left=midoffset; //size of left
        count[0]++;
        int right=end+1-midoffset-start; //size of right
        count[0]++;
        int cut=start+midoffset+1; //start of right
        count[0]++;
        int i=start;
        count[0]++;
        count[1]++;
        count[2]++;
        while (i>end){
            count[1]++;
            count[2]++;
            if(i<cut || cut<= end) {
                break;
            }
            count[1]++;
            count[2]++;
            if(cut<= end) {
                break;
            }
            count[1]++;
            count[2]++;
            if(left<right){ //lift size bigger or equal to right
                count[1]++;
                count[2]++;
                if(array[i]>array[cut]){ //left value is bigger then right value
                    int temp=array[i];
                    count[0]++;
                    array[i]=array[cut];
                    count[0]++;
                    array[cut]=temp; //swap left and right so right is in place now
                    count[0]++;
                    cut++; //cut shifts right
                    count[0]++;
                    right--; //right shrinks in size
                    count[0]++;
                }else{ //left is in place
                    left--; // left shrinks in size
                    count[0]++;
                }
            }else{ // right is bigger
                int precut=right-left-1; //at max -1 and min -left-1, indexes before cut that left starts at
                count[0]++;
                int temp=array[i]; //location to move to
                count[0]++;
                count[1]++;
                count[2]++;
                if(array[cut+precut]>array[cut]){ //max cut-1 min cut-left-1, rights start is smaller then lefts start
                    array[i]=array[cut]; //move smaller into start of target location
                    count[0]++;
                    array[cut]=temp; //moves value at target to start of cut
                    count[0]++;
                    cut++; //shifts cut right 1
                    count[0]++;
                    right--; // right shrinks in size
                    count[0]++;
                }else{
                    array[i]=array[cut+precut]; //moves lefts start to target
                    count[0]++;
                    int k=precut;
                    count[0]++;
                    count[1]++;
                    count[2]++;
                    while (k<0){ //shift precut left 1 to maintain list order
                        array[cut+k]=array[cut+k+1];
                        count[0]++;
                        k++;
                        count[0]++;
                        count[1]++;
                        count[2]++;
                    }
                    array[cut-1]=temp; //apends location to end of lefts precut maintaining list order
                    count[0]++;
                    left--; //shrink left
                    count[0]++;
                }
            }
            i++;
            count[0]++;
            count[1]++;
            count[2]++;
        }
    }
    /*
    Pre:assumes array is not null and start and end are inside the lenght and start is the start of the sorting group
    and end is the last index to be sorted.
    Post:sorted list accending.
    useful for small array size, could be optimal implemented for 1-32 size uniquely
    as each of these values has perfect implimitations know
    */
    private static void insertion(int array[],int start,int end,int[] count){
        int firstunsorted=start;
        count[0]++;
        count[1]++;
        count[2]++;
        while (firstunsorted<end){ //O(n^2) but as list is small its much
            // more often to be small
            count[1]++;
            count[2]++;
            if(array[firstunsorted]>array[firstunsorted+1]){ //out of order
                int temp=array[firstunsorted];
                count[0]++;
                array[firstunsorted]=array[firstunsorted+1];
                count[0]++;
                array[firstunsorted+1]=temp; //swap
                count[0]++;
                int curr=firstunsorted;
                count[0]++;
                count[1]++;
                count[2]++;
                while (curr>start){
                    //backpropigate till sorted from start to firstunsorted incluseive
                    count[1]++;
                    count[2]++;
                    if(array[curr-1]>array[curr]){ //still unsorted
                        int second=array[curr-1];
                        count[0]++;
                        array[curr-1]=array[curr];
                        count[0]++;
                        array[curr]=second; //swap
                        count[0]++;
                    }else{ //sorted
                        break;
                    }
                    curr--;
                    count[0]++;
                    count[1]++;
                    count[2]++;
                }
            }
            firstunsorted++;
            count[0]++;
            count[1]++;
            count[2]++;
        }
    }
 }