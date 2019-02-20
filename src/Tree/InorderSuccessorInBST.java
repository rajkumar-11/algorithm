package Tree;

public class InorderSuccessorInBST {

	static int successor = Integer.MAX_VALUE;

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		Node temp = null, suc = null;
		tree.root = insert(tree.root, 20);
		tree.root = insert(tree.root, 8);
		tree.root = insert(tree.root, 22);
		tree.root = insert(tree.root, 24);
		tree.root = insert(tree.root, 4);
		tree.root = insert(tree.root, 12);
		tree.root = insert(tree.root, 10);
		tree.root = insert(tree.root, 14);
		temp = tree.root.left.right;
		suc = inOrderSuccessor(tree.root, temp);
		if (successor != Integer.MAX_VALUE) {
			System.out.println("Inorder successor of " + temp.data + " is " + successor);
		} else {
			System.out.println("Inorder successor does not exist");
		}

	}

	private static Node inOrderSuccessor(Node root, Node temp) {
		if (root == null)
			return null;

		if (root.data == temp.data) {
			if (root.right != null) {
				Node r = min(root.right);
				successor = r.data;
				return r;
			}

		} else if (root.data > temp.data) {
			successor = root.data;
			inOrderSuccessor(root.left, temp);

		} else {

			inOrderSuccessor(root.right, temp);
		}

		return root;
	}

	private static Node min(Node root) {
		while (root.left != null) {
			root = root.left;

		}

		return root;
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
