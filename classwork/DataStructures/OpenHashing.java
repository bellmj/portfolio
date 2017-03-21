package edu.cofc.cs.csci230;

/**
 * This class represents an open hash table. 
 * All keys used in this class are generated using Object.hashCode() to generate a key for Object o envoke o.hashCode()
 *
 * @author matt
 * @param <AnyType> The type to store in the hashTable
 */
public class OpenHashing<AnyType extends Comparable<? super AnyType>> {

    public final int HASH_SIZE;
    private final SinglyLinkedList[] hashTable;
    private int elementsInHash;

    /**
     * creates a Open Hash table to store data
     *
     * @param n capacity of the hash
     */
    public OpenHashing(int n) {
        
        HASH_SIZE = n;
        this.hashTable = new SinglyLinkedList[HASH_SIZE];
        for (int i = 0; i < HASH_SIZE; i++) {
            hashTable[i] = new SinglyLinkedList();
        }
        elementsInHash=0;
    }

    private int basicHashFunction(int k) {
        return Math.abs(k) % HASH_SIZE;
    }

    /**
     * Searches for the key k in the hashTable and returns the object associated
     * with it. precondition: k must be the hashCode() value for the object
     *
     * @param k the hashCode() value for the object to search for
     * @return the object matching the hashCode() value for that object null if
     * not in hashTable
     */
    public AnyType search(int k) {
        SinglyLinkedList<AnyType> hashList = hashTable[basicHashFunction(k)];
        for (int i = 0; i < hashList.size(); i++) {
            if (hashList.get(i).getData().hashCode() == k) {
                return hashList.get(i).getData();
            }
        }
        return null;
    }
    public boolean contains(AnyType v) {
        return search(v.hashCode()) != null;
        
    }
    public boolean contains(int k){
        return search(k) != null;
    }
    
    public void insert(AnyType v) {
        int elementIndex = this.basicHashFunction(v.hashCode());
        SinglyLinkedList s = hashTable[elementIndex];
        s.add(new Node(v));
        elementsInHash++;
        
    }
    /**
     * removes the first instance of the object mapped to the key k in the hash table
     * @param k 
     */
    public void delete(int k){
        int elementIndex = this.basicHashFunction(k);
        SinglyLinkedList s = hashTable[elementIndex];
        for (int i = 0; i < s.size(); i++) {
            if (s.get(i).getData().hashCode() == k) {
                s.remove(i);
                elementsInHash--;
                return;
            }
        }
    }
    public void delete(AnyType v) throws ElementNotInHashTableException {
        int elementIndex = this.basicHashFunction(v.hashCode());
        SinglyLinkedList s = hashTable[elementIndex];
        if (s.remove(v) == null) {
            throw new ElementNotInHashTableException();
        }else{
            elementsInHash--;
        }
    }
    
    public static void main(String[] args) throws ElementNotInHashTableException {
        OpenHashing h1 = new OpenHashing(100);
        for (int i = 0; i < 100; i++) {
            h1.insert("cat" + i);
        }
        for (int i = 0; i < h1.HASH_SIZE; i++) {
            
            System.out.println("" + i + " " + h1.hashTable[i]);
        }
        System.out.println(h1.contains("cat94"));
        h1.delete("cat52");
        h1.delete("cat20");
        for (int i = 0; i < h1.HASH_SIZE; i++) {
            
            System.out.println("" + i + " " + h1.hashTable[i]);
        }
        System.out.println(h1.search(new String("cat90").hashCode()));
        System.out.println(h1.search(new String("cat44").hashCode()));
        System.out.println(h1.search(new String("cat0").hashCode()));
        System.out.println(h1.contains("cat35"));
        System.out.println(h1.contains("cat99".hashCode()));
//        h1.insert("cat");
//        h1.insert("cat1");
//        h1.insert("cat2");
//        h1.insert("cat3");
//        h1.insert("cat4");
//        h1.insert("cat5");
//        h1.insert("cat6");
//        h1.insert("cat7");
//        h1.insert("cat9");
//        h1.insert("cat10");
//        for(int i = 0;i<h1.HASH_SIZE;i++){
//            if(!h1.hashTable[i].isEmpty())
//                System.out.println(i + " "+h1.hashTable[i].get(0));
//            else
//                System.out.println(i);
//        }
//        System.out.println(h1.contains("cat"));
//        System.out.println(h1.contains("cat1"));
//        System.out.println(h1.contains("cat2"));
//        System.out.println(h1.contains("cat3"));
//        System.out.println(h1.contains("cat4"));
//        System.out.println(h1.contains("cat5"));
//        System.out.println(h1.contains("cat6"));
//        System.out.println(h1.contains("cat7"));
//        System.out.println(h1.contains("cat9"));
//        System.out.println(h1.contains("cat10"));
//        
//        
//        
//        h1.delete("cat10");
//        h1.delete("cat1");
//        h1.delete("cat3");
//        h1.delete("cat9");
//        h1.delete("cat");
//        
//        for(int i = 0;i<h1.HASH_SIZE;i++){
//            if(!h1.hashTable[i].isEmpty())
//                System.out.println(i + " "+h1.hashTable[i].get(0));
//            else
//                System.out.println(i);
//       }
    }
    
}

