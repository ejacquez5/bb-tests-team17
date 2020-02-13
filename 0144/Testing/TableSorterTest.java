import junit.framework.AssertionFailedError;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TableSorterTest {
    String currDerectory="C:\\Users\\Nicholas Pincus\\atomuica\\src\\";

    @Test
    void isSorted() {
        Table ISNULL = null;
        //tests null case and ketches exceptions on it
        System.out.print("starting test");
        try {
            boolean b=TableSorter.isSorted(ISNULL);
            assertTrue (b,"should be true as a null list is sorted");
        }catch (Exception e){
            e.printStackTrace();
        }
        try {
            //Table  EMPTY = Table.GetTable("C:\\Users\\Nicholas Pincus\\atomuica\\src\\empty.txt");
            Table _5x5_0 = Table.GetTable(currDerectory+"5x5_0");
            Table _5x5_1 = Table.GetTable(currDerectory+"5x5_1");
            Table _5x5_2 = Table.GetTable(currDerectory+"5x5_2");
            Table _5x5_3 = Table.GetTable(currDerectory+"5x5_3");
            Table _7x7_0 = Table.GetTable(currDerectory+"7x7_0");
            Table _7x7_1 = Table.GetTable(currDerectory+"7x7_1");
            Table sorted = Table.GetTable(currDerectory+"sorted.txt");
            Table sortedrevs= Table.GetTable(currDerectory+"sortedrevs.txt");
           // assertFalse(TableSorter.isSorted(EMPTY), "failed empty case\n");
            assertTrue(TableSorter.isSorted(_5x5_0),"failed case 5x5_0\n");
            assertTrue(TableSorter.isSorted(_5x5_1),"failed case 5x5_1\n");
            assertFalse(TableSorter.isSorted(_5x5_2), "failed case 5x5_2\n");
            assertFalse(TableSorter.isSorted(_5x5_3), "failed case 5x5_3\n");
            assertFalse(TableSorter.isSorted(_7x7_0), "failed case 7x7_0\n");
            assertFalse(TableSorter.isSorted(_7x7_1), "failed case 7x7_1\n");
            assertTrue(TableSorter.isSorted(sorted), "failed case sorted\n");
            assertFalse(TableSorter.isSorted(sortedrevs), "failed case sortedrevs\n");
        }catch (Exception e){
            System.out.println("starting stack trace");
            e.printStackTrace();
            System.out.println("Ending stack trace");
        }
    }

    @Test
    void sortable() {
        Table ISNULL = null;
        //tests null case and ketches exceptions on it
        System.out.print("starting test");
        try {
            boolean b=TableSorter.isSorted(ISNULL);
            assertTrue (b,"should be true as a null list is sorted");
        }catch (Exception e){
            e.printStackTrace();
        }
        try {
            //Table  EMPTY = Table.GetTable("C:\\Users\\Nicholas Pincus\\atomuica\\src\\empty.txt");
            Table _5x5_0 = Table.GetTable(currDerectory + "5x5_0");
            Table _5x5_1 = Table.GetTable(currDerectory + "5x5_1");
            Table _5x5_2 = Table.GetTable(currDerectory + "5x5_2");
            Table _5x5_3 = Table.GetTable(currDerectory + "5x5_3");
            Table _7x7_0 = Table.GetTable(currDerectory + "7x7_0");
            Table _7x7_1 = Table.GetTable(currDerectory + "7x7_1");
            Table sorted = Table.GetTable(currDerectory + "sorted.txt");
            Table sortedrevs = Table.GetTable(currDerectory + "sortedrevs.txt");
            // assertFalse(TableSorter.isSorted(EMPTY), "failed empty case\n");
            TableSorter.sortable(_5x5_0);
            assertTrue(TableSorter.isSorted(_5x5_0), "failed case 5x5_0\n");
            assertEquals(1, _5x5_0.getTableValue(4, 4), "failed case 5x5_0 to information loss\n");
            TableSorter.sortable(_5x5_1);
            assertTrue(TableSorter.isSorted(_5x5_1), "failed case 5x5_1\n");
            assertEquals(_5x5_1.getTableValue(0, 0), -1, "failed case 5x5_1 to information loss\n");
            TableSorter.sortable(_5x5_2);
            assertTrue(TableSorter.isSorted(_5x5_2), "failed case 5x5_2\n");
            assertEquals(_5x5_2.getTableValue(0, 0), -1, "failed case 5x5_2 to information loss\n");
            TableSorter.sortable(_5x5_3);
            assertTrue(TableSorter.isSorted(_5x5_3), "failed case 5x5_3\n");
            assertEquals(1, _5x5_3.getTableValue(4, 4),"failed case 5x5_3 to information loss\n");
            TableSorter.sortable(_7x7_0);
            assertTrue(TableSorter.isSorted(_7x7_0), "failed case 7x7_0\n");
            assertFalse(_7x7_0.getTableValue(6,6)!=7 ||(_7x7_0.getTableValue(5,6)!=6 &&_7x7_0.getTableValue(6,5)!=6),
                    "failed case 7x7_0 to information loss\n");
            TableSorter.sortable(_7x7_1);
            assertTrue(TableSorter.isSorted(_7x7_1), "failed case 7x7_1\n");
            assertFalse(_7x7_0.getTableValue(6,6)!=7 ||(_7x7_0.getTableValue(5,6)!=6 &&
                    _7x7_0.getTableValue(6,5)!=6)
                ,"failed case 7x7_0 to information loss\n");
            TableSorter.sortable(sorted);
            TableSorter.sortable(sortedrevs);
            assertTrue(TableSorter.isSorted(sorted), "failed case sorted\n");
            assertTrue(checkAll(sorted,255),"information loss fail sorted");
            assertTrue(TableSorter.isSorted(sortedrevs), "failed case sortedrevs\n");
            assertTrue(checkAll(sortedrevs,255),"information loss fail sortedrevs");
        }catch (Exception e){
            System.out.println("starting stack trace");
            e.printStackTrace();
            System.out.println("Ending stack trace");
        }

    }
    public static Boolean checkAll(Table t, int i){
        int size=t.getSize();
        for (int k=0;k<=i;k++){
            boolean curr=false;
            for (int j=0;j<size;j++){
                for (int l=0;l<size;l++){
                    if (t.getTableValue(j,l)==k){
                        curr=true;
                    }
                }
            }
            if(curr=false){
                return false;
            }
        }
        return true;
    }
}