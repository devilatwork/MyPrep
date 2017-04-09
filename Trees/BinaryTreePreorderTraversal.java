public class BinaryTreePreorderTraversal {
	public ArrayList<Integer> preorderTraversal(TreeNode root) {
		ArrayList<Integer> ret = new ArrayList<Integer>();
		if (root == null)
			return ret;
		Stack<TreeNode> st = new Stack<TreeNode>();
		TreeNode p = root.left;
		ret.add(root.val);
		st.add(root);
		while (!st.isEmpty()) {
			while (p != null) {
				ret.add(p.val);
				st.add(p);
				p = p.left;
			}
			TreeNode node = st.pop();
			p = node.right;
			if (p != null) {
				ret.add(p.val);
				st.add(p);
				p = p.left;
			}
		}
		return ret;
	}
}
