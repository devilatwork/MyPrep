import java.util.ArrayList;
import java.util.Stack;

/**
 * For example: Given binary tree {1,#,2,3},
 * 1
 *  \
 *   2
 *  /
 * 3
 * return [1,3,2].
 *
 * Note: Recursive solution is trivial, could you do it iteratively?
 */

public class BinaryTreeInorderTraversal {
	public ArrayList<Integer> inorderTraversal(TreeNode root) {
		ArrayList<Integer> inOrder = new ArrayList<Integer>();
		if (root == null)
			return inOrder;
		Stack<TreeNode> s = new Stack<TreeNode>();
		while (root!=null || !s.empty()) {
			while (root != null) {
				s.add(root);
				root = root.left;
			}
			TreeNode n = s.pop();
			inOrder.add(n.val);
			root = n.right;
		}
		return inOrder;
	}
}
