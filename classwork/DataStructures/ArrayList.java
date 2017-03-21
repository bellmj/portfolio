package edu.cofc.cs.csci230;
 
import java.util.Collections;

/**
 * ArrayList Data Structure
 * 
 * @author CSCI 230: Data Structures and Algorithms Fall 2015
 *
 * @param <AnyType>
 */

public class ArrayList<AnyType extends Comparable<? super AnyType>> implements List<AnyType> {
    // instance variables
    private Object[] array;
    private int size = 0;
    private final static int INITIAL_CAPACITY = 10;
    private int capacity = INITIAL_CAPACITY;
     
    /**
     * Constructs an empty list with an initial capacity
     * (for this assignment initial capacity is 10 - see 
     * constant instance variable)
     * 
     */
    public ArrayList() {
         
        array = new Object[ INITIAL_CAPACITY ];
         
    } // end constructor
  
    /**
     * Appends the specified element to the end of this list.
     * 
     * @param t
     */
    public void add( AnyType t) {
          
        if ( size >= capacity )
            grow();
         
        array[size]=t;
        size++;
          
    } // end add() method
  
    /**
     * Inserts the specified element at the specified position in this list.
     * 
     * @param index
     * @param t
     * @throws IndexOutOfBoundsException
     */
    public void add(int index, AnyType t) throws IndexOutOfBoundsException {
          
        if ( index < 0 || index > size )
            throw new IndexOutOfBoundsException();
         
        if ( size >= capacity )
            grow();
         
        for ( int i=size; i>index; i-- ) {
         
            array[i] = array[i-1];
             
        }
         
        array[index] = t;
          
        size++;
         
    } // end add() method
  
    /**
     * Replaces the element at the specified position in this list with the specified element.
     * 
     * @param index
     * @param t
     * @throws IndexOutOfBoundsException
     */
    public void set(int index, AnyType t) throws IndexOutOfBoundsException {
          
        if ( index < 0 || index >= size )
            throw new IndexOutOfBoundsException();
         
        array[index] = t;
          
    } // end set() method
  
    /**
     * Removes the element at the specified position in this list.
     * 
     * @param index
     * @return
     * @throws IndexOutOfBoundsException
     */
    @SuppressWarnings("unchecked")
    public AnyType remove( int index ) throws IndexOutOfBoundsException {
          
        if ( index < 0 || index >= size )
            throw new IndexOutOfBoundsException();
         
        AnyType element = (AnyType)array[index];
         
        for ( int i=index; i<size-1; i++ ) {
         
            array[i] = array[i+1];
        }
         
        size--;
         
        if ( size < ( capacity/2 ) && capacity > INITIAL_CAPACITY )
            shrink();
             
        return element;
          
    } // end remove() method
  
    /**
     * Returns the element at the specified position in this list.
     * 
     * @param index
     * @return
     * @throws IndexOutOfBoundsException
     */
    @SuppressWarnings("unchecked")
    public AnyType get(int index) throws IndexOutOfBoundsException {
          
        if ( index < 0 || index >= size )
            throw new IndexOutOfBoundsException();
         
        return (AnyType)array[ index ];
          
          
    } // end get() method
  
    /**
     * Returns the number of elements in this list. 
     * 
     * @return
     */
    public int size() {
          
        return size;
          
    } // end size() method
  
    /**
     * Returns true if this list contains no elements.
     * 
     * @return
     */
    public Boolean isEmpty() {
          
        return ( size == 0 );
          
    } // end isEmpty() method
      
      
    /**
     * Removes all of the elements from this list.
     * and the initial capacity is set back to 10
     * 
     */
    public void clear() {
         
        array = new Object[ INITIAL_CAPACITY ];
		capacity = INITIAL_CAPACITY;
        size=0;
          
    } // end clear method
     
    /**
     * Double the capacity of the array
     * 
     */
    private void grow() {
         
        Object[] array_dbl_cap = new Object[ capacity*=2 ];
         
        for ( int i=0; i<array.length; i++ ) {
             
            array_dbl_cap[i] = array[i];
             
        }
         
        array = array_dbl_cap;
         
        //System.out.printf( "grow opeartion (%d,%d)\n", size, capacity );
         
    } // end grow() method
     
     
    /**
     * Half the capacity of the array
     * 
     */
    private void shrink() {
         
        Object[] array_half_cap = new Object[ capacity/=2 ];
         
        for ( int i=0; i<array_half_cap.length; i++ ) {
             
            array_half_cap[i] = array[i];
             
        }
         
        array = array_half_cap;
         
       
         
    } // end shrink() method
     
	/**
	 * swaps to elements in a list at index 
	 * position i and j.
	 * 
	 * For example, 
	 * 	if A = 1,2,3,4,5 and swap( 1, 3 ) is executed
	 * 	then A = 1,4,3,2,5
	 *
	 * @param i
	 * @param j
	 * @throws IndexOutOfBoundsException
	 */
    @Override
    public void swap( int i, int j )  throws IndexOutOfBoundsException {
		
	if(i<0 || i>= this.size || j<0 || j>= this.size){
            throw new IndexOutOfBoundsException();
            
        }
        else{
            Object temp = this.array[i];
            this.array[i] = this.array[j];
            this.array[j] = temp;
        }
		
		
	} // end swap() method

      
      
    /**
     * 
     * @param args
     */
    public static void main( String[] args ) {
        final int ARRAY_SIZE = 10000;
        final int MAX_ELEMENT_SIZE = 10000;
        final int TEST_CASES = 100;
        ArrayList<Integer> l = new ArrayList();
        java.util.ArrayList<Integer> l1 = new java.util.ArrayList();
        for(int t = 0;t<TEST_CASES;t++){
            for(int i = 0;i < ARRAY_SIZE; i++){
                int rando =(int)(Math.random()*ARRAY_SIZE);
                l.add(rando);
                l1.add(rando);
            }
            Collections.sort(l1);
            Utils.selectionSort(l);
            for(int i = 0;i<l.size();i++){
                assert l.get(i).equals(l1.get(i));
            }

            l.clear();
            l1.clear();
            for(int i = 0;i < ARRAY_SIZE; i++){
                int rando =(int)(Math.random()*ARRAY_SIZE);
                l.add(rando);
                l1.add(rando);
            }
            Collections.sort(l1);
            Utils.insertionSort(l);
            for(int i = 0;i<l.size();i++){
                assert l.get(i).equals(l1.get(i));
            }

            l.clear();
            l1.clear();
            for(int i = 0;i < ARRAY_SIZE; i++){
                int rando =(int)(Math.random()*ARRAY_SIZE);
                l.add(rando);
                l1.add(rando);
            }
            Collections.sort(l1);
            Utils.bubbleSort(l);
            for(int i = 0;i<l.size();i++){
                assert l.get(i).equals(l1.get(i));
            }
        }
                  
        
        
		
          
    } // end main() method
   
} // end SinglyLinkedList class definition
