package Tree;

public class MorrisTraversal {
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);

		Traversal(tree.root);

	}

	private static void Traversal(Node root) {
		if (root == null)
			return;

		while (root != null) {
			if (root.left == null) {
				System.out.print(root.data + "  ");
				root = root.right;

			} else {
				// System.out.println("here");

				Node temp = root.left;

				while (temp.right != null && temp.right != root) {
					temp = temp.right;

				}
				if (temp.right == null) {
					temp.right = root;
					root = root.left;
				} else {
					temp.right = null;
					System.out.print(root.data + " ");
					root = root.right;

				}

			}
		}

	}

}
