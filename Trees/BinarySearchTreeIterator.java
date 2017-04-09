import java.util.Stack;

/**
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 */
public class BinarySearchTreeIterator {
    TreeNode root= new TreeNode(-1);
    Stack<TreeNode> stack;
    public BinarySearchTreeIterator(TreeNode root) {
        this.stack=new Stack<TreeNode>();
        push_left_node(stack,root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.empty();
    }
    
    private void push_left_node(Stack<TreeNode> s, TreeNode root){
        while(root!=null){
           s.push(root);
           root = root.left;
        } 
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode r= stack.peek();
        stack.pop();
        push_left_node(stack,r.right);
        return r.val;
    }
}
