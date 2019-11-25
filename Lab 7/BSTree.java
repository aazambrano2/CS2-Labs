/*************************************************************************
 * This class is the blueprint of a binary search node that extends the 
 * type binary tree (BTree)
 * There is 1 BONUS activity in this file.
 *************************************************************************/ 

public class BSTree<T extends Comparable<T>> extends BTree<T> {
 
    // A Binary Search Tree has no additional attributes compared to a Binary Tree
    
    // Constructors ****************************************************************
    public BSTree() {
        super();
    }
    
    public BSTree(BTNode<T> N) {
        super(N);
    }
    
    // Other method ***************************************************************
    /* BONUS: 
     * Method insert:
     * Takes data to be added to the binary search tree
     * Insert a node that contains this data at the correct position in the BST
     */
    public void insert(T data) {
        // YOUR CODE GOES HERE...
        //If the tree is empty
        if(super.getRoot() == null){
            BTNode <T> N = new BTNode<T>(data);
            super.setRoot(N);
            return;
        }

        //if data is less than or equal to the root data
        if(data.compareTo(super.getRoot().getData()) <= 0){
            if(super.getRoot().hasLeft()){
                //recursive call
                BSTree<T> L = new BSTree<T>(super.getRoot().getLeft());
                L.insert(data);
            }
            else{
                BTNode <T> N = new BTNode<T>(data);
                super.getRoot().setLeft(N);
            }
        }

        //if data is greater than the root data
        if(data.compareTo(super.getRoot().getData()) > 0){
            if(super.getRoot().hasRight()){
                //recursive call
                BSTree<T> R = new BSTree<T>(super.getRoot().getRight());
                R.insert(data);
            }
            else{
                BTNode <T> N = new BTNode<T>(data);
                super.getRoot().setRight(N);
            }
        }

    }
}