package edu.cofc.cs.csci230;

import java.util.Collections;


/**
 * Singly LinkedList Data Structure
 * 
 * @author CSCI 230: Data Structures and Algorithms Fall 2015
 *
 * @param <AnyType>
 */
public class SinglyLinkedList<AnyType extends Comparable<? super AnyType>> implements List<Node<AnyType>> {
	
	// instance variables
	private Node<AnyType> headNode = null;
	private int size = 0;

	/**
	 * Appends the specified element to the end of this list.
	 * 
	 * @param t
	 */
	public void add(Node<AnyType> t) {
		
		if ( isEmpty() ) headNode = t;
		else get( size-1 ).setNextNode( t );
		
		size++;
		
	} // end add() method

	/**
	 * Inserts the specified element at the specified position in this list.
	 * 
	 * @param index
	 * @param t
	 * @throws IndexOutOfBoundsException
	 */
	public void add(int index, Node<AnyType> t) throws IndexOutOfBoundsException {
	
		if ( index < 0 || index > size ) {
			
			throw new IndexOutOfBoundsException();
			
		}
		
		if ( index == 0 ) {
			
			t.setNextNode( headNode );
			headNode = t;
			size++;
			
		} else if ( index == size ) {
			
			add( t );
			
		} else {
			
			t.setNextNode( get( index ) );
			get( index - 1 ).setNextNode( t );
			size++;
			
		}
		
	} // end add() method

	/**
	 * Replaces the element at the specified position in this list with the specified element.
	 * 
	 * @param index
	 * @param t
	 * @throws IndexOutOfBoundsException
	 */
	public void set(int index, Node<AnyType> t) throws IndexOutOfBoundsException {
		
		if ( index < 0 || index >= size ) {
			
			throw new IndexOutOfBoundsException();
			
		}
		
		get( index ).setData( t.getData() );
		
	} // end set() method

	/**
	 * Removes the element at the specified position in this list.
	 * 
	 * @param index
	 * @return
	 * @throws IndexOutOfBoundsException
	 */
	public Node<AnyType> remove( int index ) throws IndexOutOfBoundsException {
		
		if ( index < 0 || index >= size ) {
			
			throw new IndexOutOfBoundsException();
			
		}
		
		Node<AnyType> node = get( index );
		
		if ( index == 0 ) {
			
			headNode = node.getNextNode();
			
		} else if ( index == ( size-1 ) ) {
			
			get( index - 1).setNextNode( null );
			
		} else {
			
			get( index - 1 ).setNextNode( node.getNextNode() );
			
		}
		
		size--;
		
		return node;
		
	} // end remove() method
        public Node<AnyType> remove(AnyType v){
            return remove(this.find(v));
        }
        /**
         * finds the index of the object stored in the Singly Linked list
         * @param v the object to find
         * @return the index of the element in the list -1 if not contained 
         */
        private int find(AnyType v){
            Node tempNode = headNode;
            int index = 0;
            while(tempNode != null){
                if(tempNode.getData().compareTo(v)==0)
                    return index;
                tempNode = tempNode.getNextNode();
                index++;
            }
            return -1;
        }

	/**
	 * Returns the element at the specified position in this list.
	 * 
	 * @param index
	 * @return
	 * @throws IndexOutOfBoundsException
	 */
	public Node<AnyType> get(int index) throws IndexOutOfBoundsException {
		
		if ( index < 0 || index >= size ) {
			
			throw new IndexOutOfBoundsException();
			
		}
		
		Node<AnyType> node = headNode;
		
		if ( index == 0 ) return node;
		
		for ( int i=1; i<index+1; i++ ) {
			
			node = node.getNextNode();
			
		}
		
		return node;
		
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
		
		return ( size == 0 ) ? true : false;
		
	} // end isEmpty() method
	
	
	/**
	 * Removes all of the elements from this list.
	 * 
	 */
	public void clear() {
		
		headNode = null;
		size=0;
		
	} // end clear method
	
	/**
	 * swaps to elements in a list at index 
	 * position i and j.
	 * 
	 * For example, 
	 * 	if A = 1->2->3->4->5 and swap( 1, 3 ) is executed
	 * 	then A = 1->4->3->2->5
	 *
	 * @param i
	 * @param j
	 * @throws IndexOutOfBoundsException
	 */
	public void swap( int i, int j )  throws IndexOutOfBoundsException {
		
		Node ii = this.get(i).clone();
                Node jj = this.get(j).clone();
                this.set(j, ii);
                this.set(i, jj);
                
		
		
		
	} // end swap() method
        public boolean contains(AnyType v){
            Node tempNode = headNode;
            while(tempNode!=null){
                if(v.equals(tempNode.getData())){
                    return true;
                }
                tempNode = tempNode.getNextNode();
            }
            return false;
        }
        @Override
        public String toString(){
            Node tempNode = headNode;
            String returnString = "head";
            while(tempNode!=null){
                returnString = returnString + " --> " + tempNode.getData();
                tempNode = tempNode.getNextNode();
            }
            return returnString;
        }
	
	
	/**
	 * 
	 * @param args
	 */
	public static void main( String[] args ) {
            

            final int ARRAY_SIZE = 1000;
            final int MAX_ELEMENT_SIZE = 10000;
            final int TEST_CASES = 4;
            SinglyLinkedList<String/*Integer*/> l = new SinglyLinkedList();
            java.util.ArrayList<Integer> l1 = new java.util.ArrayList();
            l.add(new Node("hello"));
            l.add(new Node("goodbye"));
            l.add(new Node("fish"));
            System.out.println(""+ l.contains("hello") + l.contains("goodbye") + l.contains("fish"));
            l.remove("hello");
            l.remove("fish");
            l.add(new Node("cat"));
            System.out.println(""+l.get(0)+l.get(1));
            
//            for(int t = 0;t<=TEST_CASES;t++){
//                for (int i = 0; i < ARRAY_SIZE; i++) {
//                    int rando = (int) (Math.random() * ARRAY_SIZE);
//                    l.add(new Node(rando));
//                    l1.add(rando);
//                }
//                Collections.sort(l1);
//                Utils.selectionSort(l);
//                for (int i = 0; i < l.size(); i++) {
//                    assert l.get(i).getData().equals(l1.get(i));
//                }
//
//                l.clear();
//                l1.clear();
//                for (int i = 0; i < ARRAY_SIZE; i++) {
//                    int rando = (int) (Math.random() * ARRAY_SIZE);
//                    l.add(new Node(rando));
//                    l1.add(rando);
//                }
//                Collections.sort(l1);
//                Utils.insertionSort(l);
//                for (int i = 0; i < l.size(); i++) {
//                    assert l.get(i).getData().equals(l1.get(i));
//                }
//
//                l.clear();
//                l1.clear();
//                for (int i = 0; i < ARRAY_SIZE; i++) {
//                    int rando = (int) (Math.random() * ARRAY_SIZE);
//                    l.add(new Node(rando));
//                    l1.add(rando);
//                }
//                Collections.sort(l1);
//                Utils.bubbleSort(l);
//                for (int i = 0; i < l.size(); i++) {
//                    assert l.get(i).getData().equals(l1.get(i));
//                }
//            }

	} // end main() method
 
} // end SinglyLinkedList class definition
