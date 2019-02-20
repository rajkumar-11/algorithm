package Tree;

public class nodesAtkDistanceFromRoot {
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();

		/*
		 * Constructed binary tree is 1 / \ 2 3 / \ / 4 5 8
		 */
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(8);

		printKDistant(tree.root, 0, 2);

	}

	private static void printKDistant(Node root, int i, int k) {
		if (root == null)
			return;

		if (i > k)
			return;

		if (i == k)
			System.out.println(root.data);

		if (root.left != null) {
			printKDistant(root.left, i + 1, k);

		}

		if (root.right != null) {
			printKDistant(root.right, i + 1, k);

		}

	}
}
