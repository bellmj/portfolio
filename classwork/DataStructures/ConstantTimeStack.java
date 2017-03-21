package edu.cofc.cs.csci230;

import java.util.EmptyStackException;

/**
 * A LIFO stack that has constant time complexity O(1) for
 * all three stack interface methods (i.e., push, pop, and 
 * peek).
 * 
 * This data structure was discussed in class along with the 
 * operations, please review your notes.
 * 
 * @author CSCI 230: Data Structures and Algorithms Fall 2015
 *
 * @param <AnyType>
 */
public class ConstantTimeStack<AnyType extends Comparable<? super AnyType>> implements Stack<Node<AnyType>>{
	
	/**
	 * private instance variables
	 */
	private SinglyLinkedList<AnyType> list = new SinglyLinkedList<AnyType>();

	/**
	 * Pushes an item onto the top of this stack in constant 
	 * time O(1)
	 * 
	 * @param t the item to be pushed onto this stack.
	 */
	public void push(Node<AnyType> t) {
            list.add(0,t);
            
		
		/**
         * -------------------------------------------
         * TODO: You fully implement this method
         * 
         * Note: Your push solution must be a constant 
         * time O(1) operation
         * 
         */
		
		
		
	} // end push() method

	/**
	 * Removes the object at the top of this stack and return the 
	 * item in constant time O(1)
	 * .
	 * @return The item at the top of this stack
	 * @throws EmptyStackException - if this stack is empty.
	 */
	public Node<AnyType> pop() throws EmptyStackException {
		if(list.size()==0)
                    throw new EmptyStackException();
                return list.remove(0);
		/**
         * -------------------------------------------
         * TODO: You fully implement this method
         * 
         * Note: Your pop solution must be a constant 
         * time O(1) operation
         * 
         */
		
		
		
	} // end pop() method

	/**
	 * Looks at the item at the top of this stack without removing it 
	 * from the stack in constant time O(1)
	 * 
	 * @return the item at the top of this stack
	 * @throws EmptyStackException  - if this stack is empty.
	 */
	public Node<AnyType> peek() throws EmptyStackException {
		if(list.size()==0)
                    throw new EmptyStackException();
                return list.get(0);
		/**
         * -------------------------------------------
         * TODO: You fully implement this method
         * 
         * Note: Your peek solution must be a constant 
         * time O(1) operation
         * 
         */
		
		
		
	} // end peek() method
	
	/**
	 * 
	 * @param args
	 */
	public static void main( String[] args ) {
		
		ConstantTimeStack<String> s = new ConstantTimeStack<>();
                s.push(new Node("one"));
                s.push(new Node("two"));
                s.push(new Node("three"));
                s.push(new Node("four"));
                System.out.println(s.peek());
                System.out.println(s.pop());
                System.out.println(s.peek());
                System.out.println(s.pop());
                System.out.println(s.peek());
                System.out.println(s.pop());
                System.out.println(s.peek());
                System.out.println(s.pop());
                try{
                    System.out.println(s.peek());
                    System.out.println("fail");
                }
                catch(EmptyStackException e){
                    System.out.println("pass");
                }
                try{
                    System.out.println(s.pop());
                    System.out.println("fail");
                }
                catch(EmptyStackException e){
                    System.out.println("pass");
                }
          
                
               
		
		
		
		
		
	} // end main method

} // end ConstantTimeStack class definition
