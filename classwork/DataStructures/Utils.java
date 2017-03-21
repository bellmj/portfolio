package edu.cofc.cs.csci230;

import java.util.Collections;

/**
 * Utilities class that will sort (in increasing order)
 * the elements of a list.
 *
 * The sorting algorithms supported in this class are:
 *	1. selection sort
 *	2. bubble sort
 *	3. insertion sort
 *  4. heap sort (includes min and max heapify)
 * 
 * @author CSCI 230: Data Structures and Algorithms Fall 2015
 *
 */
public class Utils {

	/**
	 * 
	 */
	private Utils() {

	} // end private constructor

	/**
	 * 
	 * @param list
	 */
	public static <AnyType extends Comparable<? super AnyType>> void selectionSort( List<AnyType> list ) throws IndexOutOfBoundsException {

		int min = 0;

		for ( int i=0; i<= list.size()-2; i++ ) {

			min = i;

			for ( int j=i+1; j<=list.size()-1; j++ ) {
				

				if ( list.get( j ).compareTo( list.get( min ) ) < 0 ) {
				
					min = j;
					
				}

			}

			list.swap( i, min );

		}

	} // end selectionSort() method

	/**
	 * 
	 * @param list
	 */
	public static <AnyType extends Comparable<? super AnyType>> void bubbleSort( List<AnyType> list ) throws IndexOutOfBoundsException {

		for ( int i=0; i<= list.size()-2; i++ ) {

			for ( int j=0; j<=list.size()-2-i; j++ ) {

				if (  list.get( j+1 ).compareTo( list.get( j ) ) < 0 ) {
					
					list.swap( j, j+1 );
					
				}

			}

		}

	} // end bubbleSort() method

	/**
	 * 
	 * @param list
	 */
	public static <AnyType extends Comparable<? super AnyType>> void insertionSort( List<AnyType> list ) throws IndexOutOfBoundsException {

		AnyType v = null;
		
		int j = 0;

		for ( int i=1; i< list.size(); i++ ) {
			
			v = list.get( i );
			
			if ( v instanceof Node<?> )
				v = (AnyType)((Node<AnyType>)v).clone();
			
			j = i - 1;

			while( j >= 0 && ( list.get( j ).compareTo( v ) > 0 ) ) {
					
				list.set( j+1, list.get( j ) );
				j--;
				
			}
			
			list.set( j+1, v );
			
		}


	} // end insertionSort() method
	
	/**
	 * 
	 * @param list
	 * @throws IndexOutOfBoundsException
	 */
	public static <AnyType extends Comparable<? super AnyType>> void maxHeapify( List<AnyType> list ) throws IndexOutOfBoundsException {
		//for int i equals the parent of the last item in heap
		for(int i = (int)Math.floor((list.size()-2)/2.0);i>=0;i--){
                    int k = i;
                    AnyType v = list.get(k);
                    boolean heap = false;
                    while(!heap && 2*k+2 <= list.size()){
                        int j = 2*k+1;
                        if (j+1 < list.size()) // two children
                            if (list.get(j).compareTo(list.get(j+1))<0)
                                j = j + 1;
                        if(v.compareTo(list.get(j))>=0)
                            heap = true;
                        else{
                            list.swap(k, j);  // swap parent and largest child
                            k=j;
  
                        }
                       
                    }
                }	
	} // end maxHeapify() method
	
	
	/**
	 * 
	 * @param list
         * 
	 * @throws IndexOutOfBoundsException
	 */
	public static <AnyType extends Comparable<? super AnyType>> void minHeapify( List<AnyType> list ) throws IndexOutOfBoundsException {
		for(int i = (int)Math.floor((list.size()-2)/2.0);i>=0;i--){
                    int k = i;
                    AnyType v = list.get(k);
                    boolean heap = false;
                    while(!heap && 2*k+2 <= list.size()){
                        int j = 2*k+1;
                        if (j+1 < list.size()) // two children
                            if (list.get(j).compareTo(list.get(j+1))>=0)
                                j = j + 1;
                        if(v.compareTo(list.get(j))<0)
                            heap = true;
                        else{
                            list.swap(k, j);  // swap parent and largest child
                            k=j;
  
                        }
                       
                    }
                }
		
		
		
		
		
		
	} // end minHeapify() method

	/**
	 * 
	 * @param sorted_list
	 * @param list
	 * @param increasing
	 * @throws IndexOutOfBoundsException
	 */
	public static <AnyType extends Comparable<? super AnyType>> void heapSort( List<AnyType> sorted_list, List<AnyType> list, Boolean increasing ) throws IndexOutOfBoundsException {
		if(!increasing){
                    while(list.size()>0){
                        maxHeapify(list);
                        sorted_list.add(list.remove(0));
                    }
                }
                else{
                    while(list.size()>0){
                        minHeapify(list);
                        sorted_list.add(list.remove(0));
                    }
                }
			
		
		
		
		
				
	} // end heapSort() method

} // end Utils class definition
