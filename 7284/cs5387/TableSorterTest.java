package cs5387;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TableSorterTest {
    /*
    Table values to be tested
     */

    int[] x = {37, 28, 3, 38, 35, 2, 43, 5, 15, 32, 4, 19, 42, 30, 14, 16};

    int[] w = {66, 47, 135, 181, 127, 74, 12, 9, 123, 140, 85, 8, 81, 187, 194, 129, 128, 71, 4, 84, 42, 39, 98, 68, 122, 91, 179, 44, 17, 56, 119, 101, 37, 59, 72, 130, 30, 108, 107, 133, 164, 174, 113, 54, 167, 16, 111, 131, 88, 197, 143, 86, 199, 11, 45, 60, 185, 48, 157, 15, 152, 114, 178, 189, 109, 13, 80, 103, 18, 158, 10, 36, 82, 172, 163, 136, 22, 126, 62, 49, 186, 96, 43, 146, 183, 102, 117, 75, 121, 125, 2, 160, 55, 33, 1, 193, 93, 198, 25, 46};

    int[] y = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100};

    int[] z = {-2147483648, 0,-2000, 1, 4, 100, -3500, -10,  2147483647,2,4796440, 11632180, 5820329, 54189592, 57357722, 84805860, 90393156, 3448986, 81424166, 45157212, 63275932, 40455282, 65778777, 81664267, 53990038, 37970222, 98296117, 20041941, 93127710, 63754625, 6315223, 71451371, 2744234, 98762828, 42571177, 39816968, 60992391, 7625848, 19022843, 89504055, 69259314, 16846241, 56054059, 75987733, 26583307, 9725093, 71641291, 41814970, 30728236, 28550574, 21813774, 15722844, 49074898, 6860037, 93308727, 90265620, 87710564, 15028954, 17198072, 54003577, 50910564, 16007130, 79274908, 89347279, 43448120, 71394139, 11678649, 25835111, 71771656, 19261383, 42140903, 99893132, 70638572, 62790449, 46507905, 1005644, 41751052, 39347252, 91923868, 31224823, 59920751, 33960044, 54022385, 83903085, 52828391, 26229926, 76406246, 10595727, 5068337, 39730508, 5853641, 84304636, 61919765, 62482852, 86691345, 57255473, 28193504, 28398901, 53028542, 64566500, 80367126};

    int[] a = {3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3};
    @Test
    void isSorted() throws Exception{

            TableSorter sorter = new TableSorter();

            Table table0 = new Table(16,x);
            Table table1 = new Table(81,w);
            Table table2 = new Table(100,y);
            Table table3 = new Table(100,z);
            Table table4 = new Table(25,a);

           /*
           Test with table 0 before & after sorting
            */
            assertEquals(false, sorter.isSorted(table0));
            sorter.sortTable(table0);
            assertEquals(true,sorter.isSorted(table0));

            /*
            Test with table 1 before & after sorting
             */
            assertEquals(false, sorter.isSorted(table1));
            sorter.sortTable(table1);
            assertEquals(true,sorter.isSorted(table1));
            /*
            Test with table 2 before & after sorting
             */
            assertEquals(true,sorter.isSorted(table2));
            sorter.sortTable(table2);
            assertEquals(true,sorter.isSorted(table2));
            /*
            Test with table 3 before & after sorting
             */
            assertEquals(false, sorter.isSorted(table3));
            sorter.sortTable(table3);
            assertEquals(true,sorter.isSorted(table3));
            /*
            Test with table 4 before & after sorting
             */
            assertEquals(true,sorter.isSorted(table4));
            sorter.sortTable(table4);
            assertEquals(true,sorter.isSorted(table4));

    }

    @Test
    void sortTable() {

    }
}