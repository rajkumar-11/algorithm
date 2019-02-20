package Tree;

public class CorrectTheBST {

	public static Node start = null, end = null, middle = null, prev = null;

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(6);
		tree.root.left = new Node(10);
		tree.root.right = new Node(2);
		tree.root.left.left = new Node(1);
		tree.root.left.right = new Node(3);
		tree.root.right.right = new Node(12);
		tree.root.right.left = new Node(7);

		System.out.println("InOrder Traversal Of the given tree");

		InOrder(tree.root);
		System.out.println();

		correctBST(tree.root);

		System.out.println("InOrder Traversal Of the correct tree");

		InOrder(tree.root);

	}

	private static void correctBST(Node root) {

		correctBSTUtil(root);

		if (start != null && end != null) {
			int temp = start.data;
			start.data = end.data;
			end.data = temp;

		} else if (start != null && middle != null) {
			int temp = start.data;
			start.data = middle.data;
			middle.data = temp;

		}

	}

	private static void correctBSTUtil(Node root) {
		if (root != null) {
			correctBSTUtil(root.left);

			if (prev != null && root.data < prev.data) {
				// System.out.println("here");

				if (start == null) {
					start = prev;
					middle = root;
				} else
					end = root;

			}
			prev = root;

			correctBSTUtil(root.right);

		}

	}

	private static void InOrder(Node root) {
		if (root == null)
			return;

		if (root.left != null)
			InOrder(root.left);

		System.out.print(root.data + " ");

		if (root.right != null)
			InOrder(root.right);

	}
}
