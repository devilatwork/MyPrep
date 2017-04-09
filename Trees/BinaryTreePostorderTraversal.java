
public class BinaryTreePostorderTraversal {
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
    	ArrayList<Integer> ret = new ArrayList<Integer>();
		if (root == null)
			return ret;
		Stack<TreeNode> st = new Stack<TreeNode>();
		TreeNode p = root.right;
		ret.add(root.val);
		st.add(root);
		while (!st.isEmpty()) {
			while (p != null) {
				ret.add(p.val);
				st.add(p);
				p = p.right;
			}
			TreeNode node = st.pop();
			p = node.left;
			if (p != null) {
				ret.add(p.val);
				st.add(p);
				p = p.right;
			}
		}
		int i = 0;
		int j = ret.size() - 1;
		while(i < j) {
			int tmp = ret.get(i);
			ret.set(i, ret.get(j));
			ret.set(j, tmp);
			i++;
			j--;
		}
		return ret;
    }
}
