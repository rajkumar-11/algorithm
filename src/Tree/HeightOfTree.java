package Tree;

public class HeightOfTree {
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();

		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);

		System.out.println("Height of tree is : " + maxDepth(tree.root));

	}

	private static int maxDepth(Node root) {
		if (root == null)
			return 0;

		int lh = maxDepth(root.left);
		int rh = maxDepth(root.right);

		return lh > rh ? lh + 1 : rh + 1;
	}
}
