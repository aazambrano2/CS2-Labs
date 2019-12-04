public class BTree<T> {

	private BTNode<T> root;
    private int size;
    private int height;
    
    // Constructors ****************************************************************
    public BTree() {}
    
    public BTree(BTNode<T> N) {
        root = N;
        size = N.sizeBelow();
        height = N.height();
    }
    
    // Setters *********************************************************************
    public void setRoot(BTNode<T> N) {
        root = N;
        size = N.sizeBelow();
        height = N.height();
    }
    
    // Getters **********************************************************************
    public BTNode<T> getRoot() {
        return root;   
    }

    public int getSize() {
        return size;   
    }

    public int getHeight() {
        return height;   
    }
    
    // Other methods ***************************************************************
    /* In the event that structural changes were made to the tree without updating 
     * its size, resetSize() allows to update the size to its current value */
    public void resetSize() {
        size = root.sizeBelow();
    }

    /* In the event that structural changes were made to the tree without updating 
     * its height, resetHeight() allows to update the size to its current value */
    public void resetHeight() {
        height = root.height();
    }
    
    /* The print method traverses and prints the content of the binary tree in a 
     * pre-order fashion:
     *      - root first, 
     *      - then pre-order of left subtree, 
     *      - then pre-order of right subtree.
     */
    public void print() {
        // Your code goes here...
    	if (root == null) return;
    	root.printNode();
    	if (root.getLeft() != null) {
    		BTree<T> L = new BTree<T>(root.getLeft());
    		L.print();
    	}
    	if (root.getRight() != null) {
        	BTree<T> R = new BTree<T>(root.getRight());
        	R.print();
    	}
    }
       
    /* Insert a node in a binary tree, given directions to reach the parent node of the 
     * data to insert. We use directions to find where in the tree to "plug" the node  
     * Example: directions may be "LLRL": 
     *      - The first (n-1) characters (assuming directions has n characters) indicate 
     *        how to navigate (Left, Right, Father, Mother) from the root to the node 
     *        after which insertion will occur.
     *      - The last character of directions indicate whether to insert as left node 
     *        or right node (or as father line or mother line).
     */
    public void insertDataAtLocation(String directions, T data) { 
        // if directions = "0", it means that the data to insert will be the root
        if (directions.equals("0")) {
            root = new BTNode<T>(data);
            size++;
            return;
        }
        
        // if the data to insert was not the root, we need to traverse the tree so as to
        // find the location where to insert it.
        // We create an iterator, just like we do for singly linked lists
        BTNode<T> iter = root;
        // And now we follow directions:
        for (int j = 0; j < directions.length() - 1; j++) {
        	if (directions.charAt(j)=='M' || directions.charAt(j)=='R') iter = iter.getRight();
        	else if (directions.charAt(j) == 'F' || directions.charAt(j)=='L') iter = iter.getLeft();
        	else {
        		System.out.println("Error in the directions. Exiting");
        		return;
        	}
        }   
        
        // Let's build the node to be plugged
        BTNode<T> N = new BTNode<T>(data);
        size++;
        resetHeight();
        // Now we "plug" / insert the new node in the proper side (left or right) 
        // depending on the last character of directions    
        if (directions.charAt(directions.length()-1) == 'L' || directions.charAt(directions.length()-1) == 'F') {
            iter.setLeft(N);   
        }
        if (directions.charAt(directions.length()-1) == 'R' || directions.charAt(directions.length()-1) == 'M') {
            iter.setRight(N);   
        }
    }
    
    /* Method inOrderTraversal:
     * This method traverses and prints the content of the binary tree in an in-order fashion:
     * in-order traversal of left subtree, then root, then in-order traversal of right subtree.
     */
    public void inOrderTraversal() {
        // BONUS: Your code goes here...   
    	if (root == null) return;
    	BTree<T> L = new BTree<T>(root.getLeft());
    	L.inOrderTraversal();
    	root.printNode();
    	BTree<T> R = new BTree<T>(root.getRight());
    	R.inOrderTraversal();
    }
    
}
