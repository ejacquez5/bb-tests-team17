import java.beans.Transient;
import java.io.IOException;
import org.junit.Test;
import static org.junit.Assert.*;

/** 
 * @author <<author name redacted>>
 * Black box testing for a nxn matrix
 */
 public class MatrixbbTest{


    /// simple test to see if we can pull elements from a list

    @Test
    public void testPositions() {
        Matrix m = new Matrix(3, 2);  // Creates the matrix:
        m.set(0, 0, 1);               
        m.set(0, 1, 2);               //   | 1  2 |
        m.set(1, 0, 3);               //   | 3  4 |
        m.set(1, 1, 4);               //   | 5  6 |
        m.set(2, 0, 5);
        m.set(2, 1, 6);
        assertTrue(m.get(0, 0) == 1);   /// checks to see if position o,o = 1
        assertTrue(m.get(0, 1) == 2);   /// does the same for the rest of the positions 
        assertTrue(m.get(1, 0) == 3);
        assertTrue(m.get(1, 1) == 4);
        assertTrue(m.get(2, 0) == 5);
        assertTrue(m.get(2, 1) == 6);
    }

     // test to see if setting a value in an array is in bounds and getting a value
    @Test
    public void testBounds() {
        Matrix m = new Matrix(2, 3);  //row 0,1, --- col 0,1,2
        
        // setting one in row and setting one in col out of bounds 
        try {
            m.set(2, 1, 6);    // row out of bounds
        }
        catch(MatrixException oof) {
            System.out.println(oof.getMessage());
            assertTrue(oof.getMessage().equals("Row of index is out of bounds"));
        }
        try {
            m.set(0, 4, 0);      // col out of bounds
        }
        catch(MatrixException oof) {
            System.out.println(oof.getMessage());
            assertTrue(oof.getMessage().equals("Column of index is out of bounds"));
        }


        // setting one in row and setting one in col out of bounds 


        try {
            m.get(2, 0);           // row out of bounds   
        }
        catch(MatrixException oof) {
            System.out.println(oof.getMessage());
            assertTrue(oof.getMessage().equals("Row of index is out of bounds"));
        }
        try {
            m.get(0, 4);          
        }
        catch(MatrixException oof) { // col out of bounds
            System.out.println(oof.getMessage());
            assertTrue(oof.getMessage().equals("Column of index is out of bounds"));
        }
    }
  //Test if matrix is sorted
  @Test
  public void testSorted(){
    Matrix expected = new Matrix(3,2);
    expected.set(0, 0, 1);               
    expected.set(0, 1, 2);               //   | 1  2 |
    expected.set(1, 0, 3);               //   | 3  4 |
    expected.set(1, 1, 4);               //   | 5  6 |
    expected.set(2, 0, 5);
    expected.set(2, 1, 6);

    Matrix m = new Matrix(3,2);
    m.set(0, 0, 4);               
    m.set(0, 1, 5);               //   | 4  5 |
    m.set(1, 0, 3);               //   | 3  6 |
    m.set(1, 1, 6);               //   | 1  2 |
    m.set(2, 0, 1);
    m.set(2, 1, 2);

    // now that we have a matrix run the sorting algorithm
    sort(m); // this should sort the m matrix
    assertMatrixEquals(expected, m); // now checks the m matrix come out the same as the expected


  }  

  // test to see the left most element is less than the right element
  @Test
  public void testLeftandRight(){
    Matrix m = new Matrix(3,2);
    m.set(0, 0, 1);               
    m.set(0, 1, 2);               //   | 1  2 |
    m.set(1, 0, 3);               //   | 3  4 |
    m.set(1, 1, 4);               //   | 5  6 |
    m.set(2, 0, 5);
    m.set(2, 1, 6);

    //less than test cases
    assertTrue(m.get(2, 1) <= m.get(3, 0)); //checks of left element if less than the rght element 
                                            // 1 space difference

    assertTrue(m.get(1, 1) <= m.get(2, 1));  // 2 space differnce test                              

    // greater than test cases
    
    assertTrue(m.get(3, 0) >= m.get(2, 1)); //checks of left element if less than the rght element 
    // 1 space difference

    assertTrue(m.get(2, 1) >= m.get(1, 1));  // 2 space differnce test    

  }
 }