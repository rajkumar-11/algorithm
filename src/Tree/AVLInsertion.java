package Tree;

public class AVLInsertion {
	public static void main(String[] args) {
		AVLTree tree = new AVLTree();

		tree.root = insert(tree.root, 9);
		tree.root = insert(tree.root, 5);
		tree.root = insert(tree.root, 10);
		tree.root = insert(tree.root, 0);
		tree.root = insert(tree.root, 6);
		tree.root = insert(tree.root, 11);
		tree.root = insert(tree.root, -1);
		tree.root = insert(tree.root, 1);
		tree.root = insert(tree.root, 2);

		System.out.println("PreOrder Traversal of the constructed tree is:");

		preorder(tree.root);

		tree.root = deleteNode(tree.root, 10);

		System.out.println("Preorder traversal after " + "deletion of 10 :");
		preorder(tree.root);

	}

	private static NodeH deleteNode(NodeH root, int key) {
		if (root == null)
			return null;

		if (key < root.data) {
			root.left = deleteNode(root.left, key);

		} else if (key > root.data) {
			root.right = deleteNode(root.right, key);

		} else {
			if (root.left == null) {
				return root.right;

			} else if (root.right == null) {
				return root.left;
			} else {
				root.data = maximum(root.left);

				root.left = deleteNode(root.left, root.data);

			}

		}
		root.height = height(root);

		int difference = getDifference(root);

		if (difference > 1 && getDifference(root.left) >= 0) {
			return rotateRight(root);

		}
		if (difference > 1 && getDifference(root.left) < 0) {
			root.left = rotateLeft(root.left);
			return rotateRight(root);

		}
		if (difference < -1 && getDifference(root.right) <= 0) {
			return rotateLeft(root);

		}
		if (difference < -1 && getDifference(root.right) > 0) {
			root.right = rotateLeft(root.right);
			return rotateLeft(root);

		}

		return root;
	}

	private static int maximum(NodeH node) {
		int max = node.data;

		while (node.right != null) {
			max = node.data;
			node = node.right;
		}

		return max;
	}

	private static void preorder(NodeH root) {
		if (root == null)
			return;

		System.out.print(root.data + " ");
		preorder(root.left);
		preorder(root.right);

	}

	private static NodeH insert(NodeH root, int key) {
		if (root == null) {
			root = new NodeH(key);
			return root;

		}
		if (root.data > key) {
			root.left = insert(root.left, key);

		} else if (root.data < key) {
			root.right = insert(root.right, key);

		} else
			return root;

		root.height = height(root);

		int difference = getDifference(root);

		// System.out.println("height= " + root.height + " difference= " +
		// difference);

		if (difference > 1 && key < root.left.data) {
			return rotateRight(root);

		}
		if (difference < -1 && key > root.right.data) {
			return rotateLeft(root);
		}
		if (difference > 1 && key > root.left.data) {
			root.left = rotateLeft(root.left);
			return rotateRight(root);

		}

		if (difference < -1 && key < root.right.data) {
			root.right = rotateRight(root.right);
			return rotateLeft(root);
		}

		return root;
	}

	private static NodeH rotateLeft(NodeH x) {
		NodeH y = x.right;
		NodeH T2 = y.left;

		y.left = x;
		x.right = T2;

		x.height = Math.max(height(x.left), height(x.right)) + 1;
		y.height = Math.max(height(y.left), height(y.right)) + 1;

		return y;
	}

	private static NodeH rotateRight(NodeH y) {
		NodeH x = y.left;
		NodeH T2 = x.right;

		x.right = y;
		y.left = T2;

		x.height = Math.max(height(x.left), height(x.right)) + 1;
		y.height = Math.max(height(y.left), height(y.right)) + 1;

		return x;
	}

	private static int getDifference(NodeH node) {

		return (node.left == null ? 0 : node.left.height) - (node.right == null ? 0 : node.right.height);
	}

	private static int height(NodeH root) {
		if (root == null)
			return 0;

		return Math.max(root.left == null ? 0 : root.left.height, root.right == null ? 0 : root.right.height) + 1;
	}
}
