package Tree;

public class InsertionDeletionInBST {
	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		// System.out.println("here");
		tree.root = insert(tree.root, 50);
		tree.root = insert(tree.root, 30);
		tree.root = insert(tree.root, 20);
		tree.root = insert(tree.root, 40);
		tree.root = insert(tree.root, 70);
		tree.root = insert(tree.root, 60);
		tree.root = insert(tree.root, 80);

		System.out.println("InOrder Traversal of the given tree");
		Inorder(tree.root);

		System.out.println("\ndelete 20");
		tree.root = deletekey(tree.root, 20);

		System.out.println("InOrder Traversal of the modified tree");
		Inorder(tree.root);

		System.out.println("\ndelete 30");
		tree.root = deletekey(tree.root, 30);

		System.out.println("InOrder Traversal of the modified tree");
		Inorder(tree.root);

		System.out.println("\ndelete 50");
		tree.root = deletekey(tree.root, 50);

		System.out.println("InOrder Traversal of the modified tree");
		Inorder(tree.root);

	}

	private static Node deletekey(Node root, int key) {
		if (root == null)
			return root;

		if (root.data < key) {
			root.right = deletekey(root.right, key);
		} else if (root.data > key) {
			root.left = deletekey(root.left, key);
		}

		else {
			if (root.left == null)
				return root.right;
			if (root.right == null)
				return root.left;

			// root.data = minimum(root.right);

			root.data = maximum(root.left);

			// root.right = deletekey(root.right, root.data);

			root.left = deletekey(root.left, root.data);

		}

		return root;
	}

	private static int maximum(Node root) {
		int maxv = root.data;

		while (root.right != null) {
			maxv = root.right.data;
			root = root.right;

		}

		return maxv;
	}

	private static int minimum(Node root) {
		int minv = root.data;

		while (root.left != null) {
			minv = root.left.data;

			root = root.left;

		}

		return minv;
	}

	private static void Inorder(Node root) {
		if (root == null)
			return;

		Inorder(root.left);
		System.out.print(root.data + "  ");
		Inorder(root.right);

	}

	private static Node insert(Node root, int n) {

		if (root == null) {
			root = new Node(n);
			return root;

		}

		if (root.data > n) {
			root.left = insert(root.left, n);

		} else if (root.data <= n) {
			root.right = insert(root.right, n);
		}

		return root;

	}

}
