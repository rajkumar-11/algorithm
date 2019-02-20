package Tree;

public class InorderSuccessorInBSTMethod2 {
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

		if (suc != null) {
			System.out.println("Inorder successor of " + temp.data + " is " + suc.data);
		} else {
			System.out.println("Inorder successor does not exist");
		}

	}

	private static Node inOrderSuccessor(Node root, Node temp) {
		if (temp.right != null) {
			root = min(temp.right);
			return root;

		}
		Node succ = null;

		while (root != null) {
			if (root.data < temp.data) {
				succ = root;
				root = root.left;

			} else if (root.data > temp.data) {
				root = root.right;

			} else
				break;

		}

		return succ;
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
