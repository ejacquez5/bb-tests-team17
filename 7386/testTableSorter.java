import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class testTableSorter {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        String userInput;
        Table testTable = null;
        Table solution = null;
        while (true){
            System.out.println("Please enter the name of the file you want to test \n To exit type \"exit\"");
            userInput = scnr.nextLine();
            if(userInput.equals("exit")){
                return;
            }
            try{
                testTable = createTable(userInput);
                TableSorter tb = new TableSorter(testTable) ;
            } catch (Exception e){
                System.out.println("An error has occurred please reenter your filename");
            }
            System.out.println("Please enter the name of the solution file");
            userInput = scnr.nextLine();
            try{
                solution = createTable(userInput);
            } catch (Exception e){
                System.out.println("An error has occurred please reenter your filename");
            }
            if(testTableSort(testTable, solution)){
                System.out.println("Test succeeded");
            }else {
                System.out.println("Test failed");
            }

        }
    }

    private static Table createTable(String userInput){
        Table t;
        try {
            t = Table.GetTable(userInput);
        } catch(Exception e3){
            System.out.println("We apologize an error has occurred with in our system using null as Table");
            return null;
        }
        return  t;
    }

    /*

     */
    private static boolean testTableSort(Table testTable, Table solution){
        if(testTable == null && solution == null) //Testing null testcase
            return true;
        else if (testTable == null || solution == null)
            return false;
        int N = testTable.getSize();
        for(int index = 0;  index< N; index++){
            for(int index2 = 0; index2<N; index2++){
                if(testTable.getTableValue(index,index2) != solution.getTableValue(index, index2))
                    return false;
            }
        }
        return true;
    }
}
