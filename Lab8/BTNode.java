public class BTNode<T> {

    private T data;
    private BTNode<T> left;
    private BTNode<T> right;
    
    // Constructors ****************************************************************
    public BTNode() {}
    
    public BTNode(T d) {
        data = d;
        left = null;
        right = null;
    }
    
    // Setters *********************************************************************
    public void setData(T d) {
        data = d;   
    }
    
    public void setLeft(BTNode<T> L) {
        left = L;
    }
    
    public void setRight(BTNode<T> R) {
        right = R;
    }
    
    // Getters **********************************************************************
    public T getData() {
        return data;   
    }
    
    public BTNode<T> getLeft() {
        return left;   
    }
    
    public BTNode<T> getRight() {
        return right;   
    }
    
    // Other methods ***************************************************************
    /* printNode prints the content of the current node */
    public void printNode() {
        System.out.println(data.toString());   
    }
    
    public String toString() {
    	return data.toString();
    }

    /* Height computes the height of the current node */
    public int height() {
        if (right == null && left == null) return 0;
        if (left != null && right != null)
        	return 1 + Math.max(left.height(), right.height());
        if (left != null)
        	return 1 + left.height();
        return 1 + right.height();
    }
    
    /* SizeBelow computes the number of nodes that are part of the subtree
     * originating at the current node (this), including this current node 
     */
    public int sizeBelow() {
    	if (this.hasLeft() && this.hasRight())
    		return 1 + left.sizeBelow() + right.sizeBelow();
    	if (this.hasLeft())
    		return 1 + left.sizeBelow();
    	if (this.hasLeft())
    		return 1 + right.sizeBelow();
    	return 1;
    }
    
    /* hasLeft returns true if the current node (this) has a non null left child, 
     * false otherwise 
     */
    public boolean hasLeft() {
        return (left != null);
    }
    
    /* hasRight returns true if the current node (this) has a non null right child, 
     * false otherwise 
     */
    public boolean hasRight() {
        return (right != null);
    }

}
