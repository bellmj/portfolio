/**
 * This class is a solutin to Problem 15 from the project euler set.
 *
 */
public class Problem15{

    public static void main(String[] args){
        final int SIZE_OF_GRID = 2;
        Node root = new Node(null,null);

        for(int i = 0;i<SIZE_OF_GRID+SIZE_OF_GRID;i++){

        }
    }
    public static void populateChildren(Node node){
        //look at previous paths and figure out how many rights and downs we've used already
        int rights = 0;
        int downs = 0;
        if(node.getParent() == null){//then we're at the root
            node.setLeftChild(new Node(node,new Boolean(true)));//in the case our first move is a right
            node.setRightChild(new Node(node,new Boolean(false)));//in the case our first move is down
        } else {//then we're not at the root
            //TODO count the number of rights and downs already used and use this to figure out if were really have a choice between right and down
        }
    }
}

/**
 * @author Matthew Bell
 * @since 4/11/17
 * This class holds node that will be used to create a binary tree of right and down movements
 */
class Node{
    private Node leftChild;
    private Node rightChild;
    private Boolean rightOrDown;//stores if this node is a right or a down null if it's the root.

    /**
     * This constructor creates and Node that can repersent an right or a down movement in a grid.
     * @param parent the parent of this node(null if root)
     * @param rightOrDown the movement of this node(true for right; false for left; null for root)
     */
    public Node(Node parent,Boolean rightOrDown){
        this.rightOrDown = rightOrDown;
        this.parent = parent;
        leftChild = null;
        rightChild = null;
    }
    private Node parent;

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }
    public Boolean getRightOrDown() {
        return rightOrDown;
    }

    public void setRightOrDown(Boolean rightOrDown) {
        this.rightOrDown = rightOrDown;
    }

}
