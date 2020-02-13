/***
 *  Programming Assignment 2
 *
 *  This class is used to count the number of
 *  operations required to execute Sort on the TableSorter class. Counts every
 *
 *      - assignment statement
 *      - comparison operation
 *      - branch
 *      - function call
 *
 * @author <<author name redacted >>
 * @since   02/03/2020
 */

public class counter {
    private int assignment = 0;
    private int comparison = 0;
    private int branch = 0;
    private int functionCall = 0;

    public void addComparison() {
        this.comparison++;
    }
    public void addBranch() {
        this.branch++;
    }
    public void addFunctionCall() {
        this.functionCall++;
    }
    public void addAssignment() {
        this.assignment++;
    }
    public void printCounts() {
        System.out.println("*************************************");
        System.out.println("Assignment calls:" + this.assignment);
        System.out.println("Comparison Calls: " + this.comparison);
        System.out.println("Branch Calls: " + this.branch);
        System.out.println("Function Calls: " + this.functionCall);
        System.out.println("*************************************");
    }


}
