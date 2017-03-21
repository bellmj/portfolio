package edu.cofc.cs.csci230;

public class HeapTest {

	public static void main(String[] args) {
		
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<Integer> sorted_list = new ArrayList<Integer>();
		
		list.add( 5 );
		list.add( 16 );
		list.add( 8 );
		list.add( 14 );
		list.add( 20 );
		list.add( 1 );
		list.add( 26 );
		
		Utils.heapSort( sorted_list, list, true );
		for(int i = 0; i<sorted_list.size();i++){
                    System.out.print(sorted_list.get(i) + " ");
                }
                 System.out.println();
		
		SinglyLinkedList<Integer> slist = new SinglyLinkedList<Integer>();
		SinglyLinkedList<Integer> sorted_slist = new SinglyLinkedList<Integer>();
		
		slist.add( new Node<Integer>(5) );
		slist.add( new Node<Integer>(16) );
		slist.add( new Node<Integer>(8) );
		slist.add( new Node<Integer>(14) );
		slist.add( new Node<Integer>(20) );
		slist.add( new Node<Integer>(1) );
		slist.add( new Node<Integer>(26) );
		
		Utils.heapSort(sorted_slist, slist, false );
		for(int i = 0; i<sorted_slist.size();i++){
                    System.out.print(sorted_slist.get(i));
                }
                
                list = new ArrayList<Integer>();
		sorted_list = new ArrayList<Integer>();
                list.add(0);
                list.add(0);
                list.add(4);
                list.add(2);
                list.add(6);
                list.add(3);
                list.add(3);
                list.add(2);
                list.add(1);
                Utils.heapSort( sorted_list, list, true );
		for(int i = 0; i<sorted_list.size();i++){
                    System.out.print(sorted_list.get(i) + " ");
                }
                System.out.println();
                
                list = new ArrayList<Integer>();
		sorted_list = new ArrayList<Integer>();
                list.add(0);
                list.add(0);
                list.add(4);
                list.add(2);
                list.add(6);
                list.add(3);
                list.add(3);
                list.add(2);
                list.add(1);
                Utils.heapSort( sorted_list, list, false );
		for(int i = 0; i<sorted_list.size();i++){
                    System.out.print(sorted_list.get(i) + " ");
                }
                System.out.println();
                
                list = new ArrayList<Integer>();
		sorted_list = new ArrayList<Integer>();
                for(int i = 0;i<100;i++){
                    list.add(i);
                }
                Utils.heapSort( sorted_list, list, true );
		for(int i = 0; i<sorted_list.size();i++){
                    System.out.print(sorted_list.get(i) + " ");
                }
                System.out.println();
                
                list = new ArrayList<Integer>();
		sorted_list = new ArrayList<Integer>();
                for(int i = 0;i<100;i++){
                    list.add(i);
                }
                Utils.heapSort( sorted_list, list, false );
		for(int i = 0; i<sorted_list.size();i++){
                    System.out.print(sorted_list.get(i) + " ");
                }
                System.out.println();
                
                list = new ArrayList<Integer>();
		sorted_list = new ArrayList<Integer>();
                for(int i = 0;i<100;i++){
                    list.add((int)(Math.random()*100));
                }
                Utils.heapSort( sorted_list, list, true );
		for(int i = 0; i<sorted_list.size();i++){
                    System.out.print(sorted_list.get(i) + " ");
                }
                System.out.println();
                
                list = new ArrayList<Integer>();
		sorted_list = new ArrayList<Integer>();
                for(int i = 0;i<100;i++){
                    list.add((int)(Math.random()*100));
                }
                Utils.heapSort( sorted_list, list, false );
		for(int i = 0; i<sorted_list.size();i++){
                    System.out.print(sorted_list.get(i) + " ");
                }
                System.out.println();
                
                slist = new SinglyLinkedList<Integer>();
		sorted_slist = new SinglyLinkedList<Integer>();
		for(int i = 0;i<15;i++){
                    slist.add(new Node((int)(Math.random()*100)-50));
                }
		Utils.heapSort(sorted_slist, slist, true );
		for(int i = 0; i<sorted_slist.size();i++){
                    System.out.print(sorted_slist.get(i));
                }
                
                
                
                
                
                

	}

}
