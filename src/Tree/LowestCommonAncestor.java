package Tree;

public class LowestCommonAncestor {
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(20);
		tree.root.left = new Node(8);
		tree.root.right = new Node(22);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(12);
		tree.root.left.right.left = new Node(10);
		tree.root.left.right.right = new Node(14);

		int n1 = 10, n2 = 14;
		Node t = lca(tree.root, n1, n2);
		System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);

	}

	private static Node lca(Node root, int n1, int n2) {
		if (root == null)
			return null;

		if (root.data > n1 && root.data > n2)
			return lca(root.left, n1, n2);

		if (root.data < n1 && root.data < n2)
			return lca(root.right, n1, n2);

		return root;
	}
}
