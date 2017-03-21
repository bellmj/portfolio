package edu.cofc.cs.csci230;

import java.time.Clock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * Binary search that does not allow two (or more) binary nodes in the search
 * tree to have the same element value.
 *
 * @author CSCI 230: Data Structures and Algorithms Fall 2015
 *
 * @param <AnyType>
 */
public class BinarySearchTree<AnyType extends Comparable<? super AnyType>> {

    // --------------------------------------
    // instance variable
    private BinaryNode<AnyType> root;

    /**
     * Constructor with one parameter that sets the root node of the BST.
     *
     * @param root
     */
    public BinarySearchTree(AnyType rootElement) throws NullBinaryNodeException {

        if (rootElement == null) {
            throw new NullBinaryNodeException();
        }

        this.root = new BinaryNode<AnyType>(rootElement);

    } // end constructor

    /**
     * If the BST does not have a root node, then the BST is empty.
     *
     * @return
     */
    public boolean isEmpty() {

        return (root == null);

    } // end isEmpty() method

    /**
     * Make the BST empty, i.e. a BST that has no nodes (including a root node).
     *
     */
    public void makeEmpty() {

        root = null;

    } // end makeEmpty() method

    /**
     * Method that adds a new node with the specified element value in the BST.
     *
     * This method has one parameter: 1) The element value to be added
     *
     * If the BST has an existing node with the same element value, throw an
     * duplicate element exception.
     *
     * @param element
     * @throws NullBinaryNodeException
     * @throws DuplicateElementException
     */
    public void add(AnyType element) throws DuplicateElementException, NullBinaryNodeException {

        if (element == null) {

            throw new NullBinaryNodeException();

        }
        if (root == null) {

            this.root = new BinaryNode<AnyType>(element);

        } else {

            add(root, element);

        }

    } // end add() method

    /**
     * Private recursive method that adds a new node (with the specified element
     * value) in the BST.
     *
     * This method has two parameters: 1) The node visited while recursively
     * walking the BST 2) The element value to be added
     *
     * If the BST has an existing node with the same element value, throw an
     * duplicate element exception.
     *
     * @param node
     * @param element
     */
    private void add(BinaryNode<AnyType> node, AnyType element) throws DuplicateElementException {

        /**
         * ------------------------------------ TODO: You complete the code.
         *
         * Note: Your solution must use recursion
         *
         */
        int compare = element.compareTo(node.getElement());

        if (compare == 0) {

            throw new DuplicateElementException();

        } else if (compare < 0) {

            if (node.getLeft() == null) {

                node.setLeft(new BinaryNode<AnyType>(element));
                node.getLeft().setParent(node);

            } else {

                add(node.getLeft(), element);

            }

        } else if (compare > 0) {

            if (node.getRight() == null) {

                node.setRight(new BinaryNode<AnyType>(element));
                node.getRight().setParent(node);

            } else {

                add(node.getRight(), element);

            }

        }

    } // end add() overloaded method

    /**
     * Method that determines if a node with the specified element value exists
     * in the BST.
     *
     * This method has one parameter: 1) The element value that is being
     * searched.
     *
     * If the BST is empty, throw an empty binary search tree exception.
     *
     * @param element
     * @return
     * @throws NullBinaryNodeException
     * @throws EmptyBSTException
     *
     */
    public boolean hasElement(AnyType element) throws EmptyBSTException, NullBinaryNodeException {

        if (isEmpty()) {
            throw new EmptyBSTException();
        } else if (element == null) {
            throw new NullBinaryNodeException();
        }

        return hasElement(root, element);

    } // end hasElement() method

    /**
     * Private recursive method that determines if the element is currently
     * stored in the BST.
     *
     * This method has two parameters: 1) The node visited while recursively
     * walking the BST 2) The element value that is being searched.
     *
     * Hint: use the compareTo() method
     *
     * @param element
     * @param node
     * @return
     */
    private boolean hasElement(BinaryNode<AnyType> node, AnyType element) {

        if (node == null) {
            return false;
        }

        int compare = element.compareTo(node.getElement());

        if (compare == 0) {

            return true;

        } else if (compare < 0) {

            return hasElement(node.getLeft(), element);

        } else {

            return hasElement(node.getRight(), element);

        }

    } // end hasElement() overloaded method

    /**
     * Find the node with the minimum element value in the BST.
     *
     * This method has no parameters.
     *
     * If the BST is empty, throw an empty binary search tree exception.
     *
     * @return
     * @throws EmptyBSTException
     */
    public AnyType findMin() throws EmptyBSTException {

        if (isEmpty()) {
            throw new EmptyBSTException();
        }

        return findMin(root).getElement();

    } // end findMin() method

    /**
     * Private recursive method that walks the BST searching for the node with
     * the minimum element value.
     *
     * This method has one parameter: 1) The node visited while recursively
     * walking the BST
     *
     * @param node
     * @return
     */
    private BinaryNode<AnyType> findMin(BinaryNode<AnyType> node) {

        /**
         * ------------------------------------ TODO: You complete the code.
         *
         * Note: Your solution must use recursion
         *
         */
        if (node.getLeft() == null) {

            return node;

        } else {

            return findMin(node.getLeft());
        }

    } // end findMin() method

    /**
     * Find the node with the maximum element value in the BST.
     *
     * This method has no parameters.
     *
     * If the BST is empty, throw an empty binary search tree exception.
     *
     * @return
     * @throws EmptyBSTException
     */
    public AnyType findMax() throws EmptyBSTException {

        if (isEmpty()) {
            throw new EmptyBSTException();
        }

        return findMax(root).getElement();

    } // end findMax() method

    /**
     * Private recursive method that walks the BST searching for the node with
     * the maximum element value.
     *
     * This method has one parameter: 1) The node visited while recursively
     * walking the BST
     *
     * @param node
     * @return
     */
    private BinaryNode<AnyType> findMax(BinaryNode<AnyType> node) {

        /**
         * ------------------------------------ TODO: You complete the code.
         *
         * Note: Your solution must use recursion
         *
         */
        if (node.getRight() == null) {

            return node;

        } else {

            return findMax(node.getRight());
        }

    } // end findMax() method

    /**
     * Delete the node with the specified element value in the BST.
     *
     * This method has one parameter: 1) the element value to be deleted
     *
     * This method performs the following delete operations 1) delete node with
     * no children (case 1) 2) delete node with one child (case 2) 3) delete
     * node with two children (case 3)
     *
     * If the BST is empty, throw an empty binary search tree exception.
     *
     * If the element is null, throw a null binary node exception
     *
     * @param element
     * @throws EmptyBSTException
     * @throws NullBinaryNodeException
     */
    public void delete(AnyType element) throws EmptyBSTException, NullBinaryNodeException {
        if (this.isEmpty()) {
            throw new EmptyBSTException();
        }
        if (element == null) {
            throw new NullBinaryNodeException();
        }
        if (root.getLeft() == null && root.getRight() == null) {
            this.makeEmpty();
        } else {
            delete(root, element);
        }

    } // end delete() method

    /**
     * Private recursive method that walk the BST looking for the specified
     * element value to be removed.
     *
     * This method has two parameters: 1) The node visited while recursively
     * walking the BST 2) The element value that is being removed.
     *
     * @param node
     * @param element
     */
    private void delete(BinaryNode<AnyType> node, AnyType element) {

        //if this is my element
        if (element.compareTo((AnyType) node.getElement()) == 0) {

            if (node.getLeft() == null && node.getRight() == null) {//no children
                BinaryNode<AnyType> parent = node.getParent();
                if (parent.getLeft() != null && parent.getLeft().getElement().compareTo(element) == 0) {
                    parent.setLeft(null);
                } else if (parent.getRight() != null & parent.getRight().getElement().compareTo(element) == 0) {
                    parent.setRight(null);
                } else {
                    assert false;
                }
            } else if ((node.getLeft() != null || node.getRight() != null) && !(node.getLeft() != null && node.getRight() != null)) {//1child
                if (root.getElement().compareTo(element) == 0) {
                    if (node.getLeft() != null) {
                        root = node.getLeft();
                    } else if (node.getRight() != null) {
                        root = node.getRight();
                    } else {
                        assert false;
                    }
                } else {

                    if (node.getLeft() != null) {
                        node.getParent().setLeft(node.getLeft());
                    } else if (node.getRight() != null) {
                        node.getParent().setRight(node.getRight());
                    } else {
                        assert false;
                    }
                }

            } else if (node.getLeft() != null && node.getRight() != null) {//2chidrent
                BinaryNode<AnyType> rightTreeMin = this.findMin(node.getRight());
                node.setElement(rightTreeMin.getElement());

                delete(rightTreeMin, rightTreeMin.getElement());

            } else {
                assert false;
            }

        } else if (element.compareTo((AnyType) node.getElement()) > 0) {
            delete(node.getRight(), element);
        } else if (element.compareTo((AnyType) node.getElement()) < 0) {
            delete(node.getLeft(), element);
        } else {
            System.err.println("element not found");
            assert false;
        }

    } // end delete() method

    /**
     * Recursive method that traverses the BST dynamically creating a string
     * with the element values stored in an post-order tree traversal format.
     *
     * The return string MUST be formated as follows:
     * <element>,<element>,<element>,<element>, .... <element>
     * where <element> is the element value For example, 1,3,2 Hint: you may
     * want to use regular expressions
     *
     * Discussed in class, please review your notes
     *
     * This method has no parameters.
     *
     * If the BST is empty, throw an empty binary search tree exception
     *
     * @throws EmptyBSTException
     * @return
     *
     */
    public String postOrder() throws EmptyBSTException {
        if (root == null) {
            throw new EmptyBSTException();
        }
        String returnString = postOrder(root);
        return returnString.substring(0, returnString.length() - 1);

    } // end postOrder() muethod

    /**
     * Private recursive method that traverses the BST dynamically creating a
     * string with the element values stored in an post-order tree traversal
     * format.
     *
     * This method has one parameter: 1) The node visited while recursively
     * walking the BST
     *
     * @param node
     * @return
     *
     */
    private String postOrder(BinaryNode<AnyType> node) {
        if (node != null) {
            return String.format("%s%s%s,", postOrder(node.getLeft()), postOrder(node.getRight()), node.getElement());
        } else {
            return "";
        }

    } // end postOrder() method

    /**
     * Recursive method that traverses the BST dynamically creating a string
     * with the element values stored in an pre-order tree traversal format.
     *
     * The return string MUST be formated as follows:
     * <element>,<element>,<element>,<element>, .... <element>
     * where <element> is the element value For example, 2,1,3 Hint: you may
     * want to use regular expressions
     *
     * Discussed in class, please review your notes
     *
     * If the BST is empty, throw an empty binary search tree exception
     *
     * @throws EmptyBSTException
     * @return
     *
     */
    public String preOrder() throws EmptyBSTException {
        if (root == null) {
            throw new EmptyBSTException();
        }
        String returnString = preOrder(root);
        return returnString.substring(0, returnString.length() - 1);

    } // end preOrder() method

    /**
     * Private recursive method that traverses the BST dynamically creating a
     * string with the element values stored in an pre-order tree traversal
     * format.
     *
     * This method has one parameter: 1) The node visited while recursively
     * walking the BST
     *
     * @param node
     * @return
     *
     */
    private String preOrder(BinaryNode<AnyType> node) {

        if (node != null) {
            return String.format("%s,%s%s", node.getElement(), preOrder(node.getLeft()), preOrder(node.getRight()));
        } else {
            return "";
        }

    } // end preOrder() method

    /**
     * Recursive method that traverses the BST dynamically creating a string
     * with the element values stored in an in-order tree traversal format.
     *
     * The return string MUST be formated as follows:
     * <element>,<element>,<element>,<element>, .... <element>
     * where <element> is the element value For example, 1,2,3 Hint: you may
     * want to use regular expressions
     *
     * Discussed in class, please review your notes
     *
     * If the BST is empty, throw an empty binary search tree exception
     *
     * @throws EmptyBSTException
     * @return
     *
     */
    public String inOrder() throws EmptyBSTException {

        if (root == null) {
            throw new EmptyBSTException();
        }
        String returnString = inOrder(root);
        return returnString.substring(0, returnString.length() - 1);

    } // end inOrder() method

    /**
     * Private recursive method that traverses the BST dynamically creating a
     * string with the element values stored in an in-order tree traversal
     * format.
     *
     * This method has one parameter: 1) The node visited while recursively
     * walking the BST
     *
     * @param node
     * @return
     *
     */
    private String inOrder(BinaryNode<AnyType> node) {
        if (node != null) {
            return String.format("%s%s,%s", inOrder(node.getLeft()), node.getElement(), inOrder(node.getRight()));
        } else {
            return "";
        }
    } // end inOrder() method

    /**
     *
     * @param args
     */
    public static void main(String[] args) {

        int points = 0;
        boolean passed;

        BinarySearchTree<Integer> bst = null;

        System.out.println("----------------------------------");
        System.out.println("Test Case_1:");
        passed = true;

        try {
            bst = new BinarySearchTree(1);
            bst.makeEmpty();
            bst.delete(1);
            passed = false;
        } catch (EmptyBSTException e) {
        } catch (Exception e) {
            passed = false;
        }

        try {
            bst.add(1);
            bst.delete(null);
            passed = false;
        } catch (NullBinaryNodeException e) {
        } catch (Exception e) {
            passed = false;
        }

        if (passed) {
            points += 10;
            System.out.println("[Passed]");
        } else {
            System.out.println("[Failed]");
        }

        System.out.println("----------------------------------");
        System.out.println("Test Case_2:");
        passed = true;

        try {
            bst.makeEmpty();
            String s = bst.preOrder();
            passed = false;
        } catch (EmptyBSTException e) {

        } catch (Exception e) {
            passed = false;
        }

        try {
            bst.add(10);
            bst.add(7);
            bst.add(15);
            bst.add(8);
            bst.add(14);
            bst.add(3);
            bst.add(22);
            bst.add(4);
            bst.add(2);
            bst.add(20);
            bst.add(11);
            bst.add(9);
            bst.add(1);
            bst.add(12);

            String s = bst.preOrder();

            if (!s.equalsIgnoreCase("10,7,3,2,1,4,8,9,15,14,11,12,22,20")) {
                passed = false;
            }
        } catch (Exception e) {
            passed = false;
        }

        if (passed) {
            points += 10;
            System.out.println("[Passed]");
        } else {
            System.out.println("[Failed]");
        }

        System.out.println("----------------------------------");
        System.out.println("Test Case_3:");
        passed = true;

        try {
            String s = bst.postOrder();

            if (!s.equalsIgnoreCase("1,2,4,3,9,8,7,12,11,14,20,22,15,10")) {
                passed = false;
            }
        } catch (Exception e) {
            passed = false;
        }

        if (passed) {
            points += 10;
            System.out.println("[Passed]");
        } else {
            System.out.println("[Failed]");
        }

        System.out.println("----------------------------------");
        System.out.println("Test Case_4:");
        passed = true;

        try {
            String s = bst.inOrder();

            if (!s.equalsIgnoreCase("1,2,3,4,7,8,9,10,11,12,14,15,20,22")) {
                passed = false;
            }
        } catch (Exception e) {
            passed = false;
        }

        if (passed) {
            points += 10;
            System.out.println("[Passed]");
        } else {
            System.out.println("[Failed]");
        }

        System.out.println("----------------------------------");
        System.out.println("Test Case_5:");
        passed = true;

        try {
            bst.delete(1);

            if (bst.findMin() != 2) {
                passed = false;
            }
        } catch (Exception e) {
            passed = false;
        }

        if (passed) {
            points += 10;
            System.out.println("[Passed]");
        } else {
            System.out.println("[Failed]");
        }

        System.out.println("----------------------------------");
        System.out.println("Test Case_6:");
        passed = true;
        try {
            System.out.println(bst.inOrder());
        } catch (EmptyBSTException ex) {
            Logger.getLogger(BinarySearchTree.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            bst.delete(22);
            if (bst.findMax() != 20) {
                passed = false;
            }

        } catch (Exception e) {
            passed = false;
        }
        try {
            System.out.println(bst.inOrder());
        } catch (EmptyBSTException ex) {
            Logger.getLogger(BinarySearchTree.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (passed) {
            points += 10;
            System.out.println("[Passed]");
        } else {
            System.out.println("[Failed]");
        }

        System.out.println("----------------------------------");
        System.out.println("Test Case_7:");
        passed = true;
        try {
            System.out.println(bst.inOrder());
        } catch (EmptyBSTException ex) {
            Logger.getLogger(BinarySearchTree.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {

            bst.delete(7);
            try {
                System.out.println(bst.inOrder());
            } catch (EmptyBSTException ex) {
                Logger.getLogger(BinarySearchTree.class.getName()).log(Level.SEVERE, null, ex);
            }
            String s = bst.inOrder();

            if (!s.equalsIgnoreCase("2,3,4,8,9,10,11,12,14,15,20")) {
                passed = false;
            }
        } catch (Exception e) {
            passed = false;
        }

        if (passed) {
            points += 10;
            System.out.println("[Passed]");
        } else {
            System.out.println("[Failed]");
        }
        System.out.println("----------------------------------");
        System.out.println("Test Case_8:");
        passed = true;

        try {
            System.out.println(bst.inOrder());
            bst.delete(10);

            System.out.println(bst.inOrder());

            String s = bst.preOrder();

            if (!s.equalsIgnoreCase("11,8,3,2,4,9,15,14,12,20")) {
                passed = false;
            }
        } catch (Exception e) {
            passed = false;
        }

        if (passed) {
            points += 10;
            System.out.println("[Passed]");
        } else {
            System.out.println("[Failed]");
        }

        System.out.println("----------------------------------");
        System.out.println("----------------------------------");
        System.out.println("-------------------------------------------------------");
        System.out.println("                     Points Possible    Points Received");
        System.out.println("BST Compiles               15                 15  ");
        System.out.println("Thorough test cases         5                    ");
        System.out.println("Instructor Test Cases      80                 " + points);
        System.out.println("   (8 @ 10pts each)");
        System.out.println("                                      Total points: " + (points + 15));
        System.out.println("-------------------------------------------------------");


        /*
         BinarySearchTree<Integer> b;
         //assert false;
         try {
         b = new BinarySearchTree(1);
         b.add(4);
         b.add(6);
         b.add(46);
         b.add(23);
         b.add(69);
         b.add(67);
         b.add(0);
         b.add(-128);
         b.add((666));
                
         System.out.println(b.inOrder());
         System.out.println(b.preOrder());
         System.out.println(b.postOrder()+"\n");
         b.delete(666);
         System.out.println(b.inOrder());
         System.out.println(b.preOrder());
         System.out.println(b.postOrder()+"\n");
         b.delete(-128);
         System.out.println(b.inOrder());
         System.out.println(b.preOrder());
         System.out.println(b.postOrder()+"\n");
         b.delete(4);
         System.out.println(b.inOrder());
         System.out.println(b.preOrder());
         System.out.println(b.postOrder()+"\n");
         b.delete(0);
         System.out.println(b.inOrder());
         System.out.println(b.preOrder());
         System.out.println(b.postOrder()+"\n");
         b.delete(1);
         System.out.println(b.inOrder());
         System.out.println(b.preOrder());
         System.out.println(b.postOrder()+"\n");
         b.delete(6);
         System.out.println(b.inOrder());
         System.out.println(b.preOrder());
         System.out.println(b.postOrder()+"\n");
         b.delete(23);
         System.out.println(b.inOrder());
         System.out.println(b.preOrder());
         System.out.println(b.postOrder()+"\n");
         b.delete(67);
         System.out.println(b.inOrder());
         System.out.println(b.preOrder());
         System.out.println(b.postOrder()+"\n");
         b.delete(69);
         System.out.println(b.inOrder());
         System.out.println(b.preOrder());
         System.out.println(b.postOrder()+"\n");
         b.delete(46);
         b.makeEmpty();
         for(int i = 7000;i>=1;i-=1)
         b.add(i);
                 
                 
         System.out.println(b.inOrder());
         System.out.println(b.preOrder());
         System.out.println(b.postOrder()+"\n");
                 
                 
         } catch (NullBinaryNodeException ex) {
         System.err.println(ex);
         } catch (DuplicateElementException ex) {
         System.err.println(ex);
         } catch (EmptyBSTException ex) {
         System.err.println(ex);
         } 
         try {
         BinarySearchTree<Integer> a = new BinarySearchTree(null);
         System.err.println("boo");
         } catch (NullBinaryNodeException ex) {
         System.out.println("YAY");
         }
         BinarySearchTree<Integer> a;
         try {
         a = new BinarySearchTree(1);
         a.makeEmpty();
         a.inOrder();
         System.err.println("boo");
         } catch (NullBinaryNodeException ex) {
         System.out.println("YAY");
         } catch (EmptyBSTException ex) {
         System.out.println("YAY");
         }
         try {
         a = new BinarySearchTree(1);
         a.makeEmpty();
         a.preOrder();
         System.err.println("boo");
         } catch (NullBinaryNodeException ex) {
         System.out.println("YAY");
         } catch (EmptyBSTException ex) {
         System.out.println("YAY");
         }
         try {
         a = new BinarySearchTree(1);
         a.makeEmpty();
         a.postOrder();
         System.err.println("boo");
         } catch (NullBinaryNodeException ex) {
         System.out.println("YAY");
         } catch (EmptyBSTException ex) {
         System.out.println("YAY");
         }
         try {
         a = new BinarySearchTree(1);
         a.makeEmpty();
         a.delete(1);
         System.err.println("boo");
         } catch (NullBinaryNodeException | EmptyBSTException ex) {
         System.out.println("YAY");
         }
         try {
         a = new BinarySearchTree(1);
         a.delete(null);
               
         } catch (NullBinaryNodeException | EmptyBSTException ex) {
         System.out.println("YAY");
         }
         */
    } // end main method

} // end BinarySearchTree class
