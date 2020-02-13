import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Please enter the name of the file");
        String filename = scnr.nextLine();
        Table t;
        try {
            t = Table.GetTable(filename);
        } catch (FileNotFoundException e) {
            System.out.println(e);
            System.out.println("Our apologies we were unable to find the file in your system \n...exiting");
            return;
        } catch(IOException e2){
            System.out.println(e2);
            System.out.println("There has been a problem with your input please try again later");
            return;
        } catch(Exception e3){
            System.out.println("We apologize an error has occurred with in our system exiting");
            return;
        }
        TableSorter tb = new TableSorter(t) ;
    }
}
