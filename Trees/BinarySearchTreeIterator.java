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
        this.root.left=root;
        this.stack=new Stack<>();
        TreeNode x=this.root;
        while(x!=null){
            stack.add(x);
            x=x.left;
        }

    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return stack.size()>1;
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode r= stack.pop();
        if(stack.size()>0){
            TreeNode peek=stack.peek();
            peek.left=r.right;
            TreeNode temp=peek.left;
            while(temp!=null){
                stack.add(temp);
                temp=temp.left;
            }
        }

        return r.val;
    }
}
