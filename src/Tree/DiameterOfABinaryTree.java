package Tree;

public class DiameterOfABinaryTree {
	static int diameter = Integer.MIN_VALUE;

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.left.right.right = new Node(6);
		tree.root.left.right.left = new Node(7);
		tree.root.right.right = new Node(8);
		tree.root.right.right.right = new Node(9);
		tree.root.right.right.right.right = new Node(10);
		tree.root.right.right.right.left = new Node(11);
		tree.root.right.right.right.left.right = new Node(12);

		height(tree.root);

		System.out.println("The diameter of given binary tree is : " + diameter);

	}

	private static int height(Node root) {
		if (root == null)
			return 0;

		int lh = height(root.left);
		int rh = height(root.right);

		if (lh + rh - 1 > diameter) {
			diameter = lh + rh + 1;

		}

		return lh > rh ? lh + 1 : rh + 1;

		// return 0;
	}
}
