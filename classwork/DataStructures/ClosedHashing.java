/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cofc.cs.csci230;

/**
 *
 * @author matt
 * @param <AnyType>
 */
public class ClosedHashing<AnyType extends Comparable<? super AnyType>> {

    public final int HASH_SIZE;
    private final Object[] hashTable;
    private int elementsInHash;
    private final String LAZY_DELETE = "!L_!A_!Z_1Y_!D_1E_1L_!E_!T_!E";//A value highly unlikely to be used in the hash
    public final float LOAD_FACTOR;
    
    
    public ClosedHashing(int hashSize) {
        LOAD_FACTOR = .75f;
        HASH_SIZE = Math.round(hashSize/LOAD_FACTOR);
        hashTable = new Object[HASH_SIZE];
        elementsInHash = 0;
    }

    private int basicHashFunction(int k) {
        return Math.abs(k/31) % HASH_SIZE;
    }
    /**
     * 
     * @param k
     * @return 
     */
    public AnyType search(int k) {
        int elementIndex = (this.basicHashFunction(k));
        boolean looped = false;
        for(int indx = elementIndex;!looped || indx != elementIndex;indx = (indx + 1)%this.HASH_SIZE){
            if (hashTable[indx ] == null ) {
                return null;//element not in Hash
            }
            if (hashTable[indx].hashCode() == k) {
                return (AnyType) hashTable[indx];
            }
            looped = true;
        }
        return null;

    }

    public boolean contains(AnyType v) {
        return search(v.hashCode()) != null;

    }

    public boolean contains(int k) {
        return search(k) != null;

    }

    public void insert(AnyType v) throws FullHashTableException {
        int elementIndex = (this.basicHashFunction(v.hashCode()));
        if (elementsInHash >= HASH_SIZE) {
            throw new FullHashTableException();
        }
        int timesLooped = 0;
        
        for (int i = elementIndex;true ; i = (i + 1)%this.HASH_SIZE) {
            String nextElement = (hashTable[(i + 1)%this.HASH_SIZE]!=null? hashTable[(i + 1)%this.HASH_SIZE].toString():null);
            if (hashTable[i] == null || hashTable[i].equals(LAZY_DELETE)) {
                hashTable[i] = v;
                this.elementsInHash++;
                return;
            }
            
        }

    }

    public void delete(int k) throws ElementNotInHashTableException {
        int elementIndex = (this.basicHashFunction(k));
        int timesLooped = 0;
        boolean looped = false;
        for(int indx = elementIndex;!looped || indx != elementIndex;indx = (indx + 1)%this.HASH_SIZE){
            //System.err.println(hashTable[indx] + " " + indx);
            if(hashTable[indx]==null)
                throw new ElementNotInHashTableException();
            if(hashTable[indx].hashCode()==k){
                //System.err.println("DELETE " + hashTable[indx] + " " + indx);
                
                String nextElement = (hashTable[(indx + 1)%this.HASH_SIZE]!=null? hashTable[(indx + 1)%this.HASH_SIZE].toString():null);
                if( nextElement == null ){
                    hashTable[indx] = null;//if next element is null or if the next element doesnt share the same hashFunction result 
                }else{
                    hashTable[indx] = this.LAZY_DELETE;
                }
                return;
            }
            looped = true;
        }
        
           
//            if (hashTable[i] == null) {//TODO fix this throws element not in hash even when contains element
//                throw new ElementNotInHashTableException();//element not in Hash
//            }
//            
//            if (hashTable[i].hashCode() == k) {
//                if (i!=0 && hashTable[(i - 1) % HASH_SIZE] != null) {
//                    hashTable[i] = this.LAZY_DELETE;
//                }else if (i==0 && hashTable[hashTable.length] != null) {
//                    hashTable[i] = this.LAZY_DELETE;
//                }else {
//                    hashTable[i] = null;    
//                }
//                elementsInHash--;
//                return;
//            }
//            if (i == hashTable.length - 1) {
//                i = 0;
//                timesLooped++;
//            }
//        }
//        throw new ElementNotInHashTableException();

    }

    public void delete(AnyType v) throws ElementNotInHashTableException {
        delete(v.hashCode());

    }

    public static void main(String[] args) throws FullHashTableException, ElementNotInHashTableException {
        ClosedHashing hash = new ClosedHashing(20);
        hash.insert("hello");
        hash.insert("my");
        hash.insert("name");
        hash.insert("is");
        hash.insert("inigo");
        hash.insert("montoya");
        hash.insert("you");
        hash.insert("killed");
        hash.insert("my");
        hash.insert("father");
        for(int i = 0;i<hash.HASH_SIZE;i++){
            System.out.print(i + ":" + hash.hashTable[i] + "\t" );
        }
        System.out.println();
         System.out.println(hash.basicHashFunction("24522h4352343efllasdfo".hashCode()));
        hash.delete("my");
        hash.delete("my");
        
        
      
        
        for(int i = 0;i<hash.HASH_SIZE;i++){
             System.out.print(i + ":" + hash.hashTable[i] + "\t" );
        }
        
    }
}
