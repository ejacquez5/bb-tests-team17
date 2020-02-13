package cs5387;

import java.util.Iterator;
import java.util.NoSuchElementException;

/** I wanted to add every operation into a list and return the
 * result.
*/
public class ListTypeIterator<E> implements Iterator<E>{

   private GeneralList<E> list;
   private int previous;         // previous element
   boolean canRemove;            // manage removals


   public ListTypeIterator(GeneralList<E> aList){

      // list reference.
      list = aList;
      // positioning
      // the iterator just before the first element.
      previous = -1;
      canRemove = false;
   }
   
   /**
    * @return true if the iterator has more elements.
   */
   public boolean hasNext(){

      if ((previous + 1) < list.size())
         return true;
      else
         return false;
   }
   
   /**
    * @return The next element in the list.
   */
   public E next(){
      // throw an exception.
      if (!hasNext())
         throw new NoSuchElementException();

      previous++;

      canRemove = true;
      
      // Return the list element.
      return list.get(previous);
   }
   
   /** removes from the list the last
    * element that was returned by the next method.
   */
   public void remove(){
      if (!canRemove)
         throw new IllegalStateException();
         
      // Remove the previous element.
      list.remove(previous);

      previous--;

      canRemove = false;
   }
}