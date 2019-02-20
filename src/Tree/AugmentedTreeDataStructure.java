package Tree;

public class AugmentedTreeDataStructure {
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(20);
		tree.root.left = new Node(8);
		tree.root.right = new Node(22);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(12);
		tree.root.left.right.left = new Node(10);
		tree.root.left.right.right = new Node(14);

		int x = findKthElement(tree.root, 10);

		System.out.println("10 th value will be =" + x);

	}

	private static int findKthElement(Node root, int k) {
		if (root == null)
			return -1;

		int x = FindNumberOfElementsInLeftSubTree(root.left);

		if (x + 1 == k)
			return root.data;

		else if (k > x) {
			k = k - (x + 1);
			root = root.right;
			return findKthElement(root, k);

		} else {
			root = root.left;

			return findKthElement(root, k);

		}

		// return 0;
	}

	private static int FindNumberOfElementsInLeftSubTree(Node root) {
		if (root == null)
			return 0;

		if (root.left == null && root.right == null)
			return 1;

		return 1 + FindNumberOfElementsInLeftSubTree(root.left) + FindNumberOfElementsInLeftSubTree(root.right);

	}
}
