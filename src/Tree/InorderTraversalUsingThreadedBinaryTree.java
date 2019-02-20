package Tree;

public class InorderTraversalUsingThreadedBinaryTree {
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);

		MorrisTraversal(tree.root);

	}

	private static void MorrisTraversal(Node current) {
		while (current != null) {
			if (current.left == null) {
				System.out.print(current.data + " ");
				current = current.right;
			} else {
				Node pre = current.left;

				while (pre.right != null && pre.right != current) {
					pre = pre.right;

				}

				if (pre.right == null) {
					pre.right = current;
					current = current.left;
				} else {
					pre.right = null;
					System.out.print(current.data + " ");
					current = current.right;
				}

			}

		}

	}

}
