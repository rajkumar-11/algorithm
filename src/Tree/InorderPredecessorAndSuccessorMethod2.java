package Tree;

public class InorderPredecessorAndSuccessorMethod2 {
	static int predecessor = Integer.MIN_VALUE, successor = Integer.MAX_VALUE;

	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();

		tree.root = insert(tree.root, 50);
		tree.root = insert(tree.root, 30);
		tree.root = insert(tree.root, 20);
		tree.root = insert(tree.root, 40);
		tree.root = insert(tree.root, 70);
		tree.root = insert(tree.root, 60);
		tree.root = insert(tree.root, 80);

		int key = 25;

		FindPredecessorAndSuccessor(tree.root, key);

		System.out.println("prev= " + predecessor + " key= " + key + " next =" + successor);

	}

	private static void FindPredecessorAndSuccessor(Node root, int key)
	{
		if (root == null)
			return;

		if (root.data == key)
		{
			if (root.right != null)
			{
				successor = min(root.right);

			}
			if (root.left != null) 
			{
				predecessor = max(root.left);

			}
		} else if (root.data > key) {
			successor = root.data;
			FindPredecessorAndSuccessor(root.left, key);

		} else {
			predecessor = root.data;
			FindPredecessorAndSuccessor(root.right, key);

		}

	}

	private static int max(Node root) {
		while (root.right != null) {
			root = root.right;
		}
		return root.data;
	}

	private static int min(Node root) {
		while (root.left != null)
			root = root.left;

		return root.data;
	}

	private static Node insert(Node root, int n) {

		if (root == null) {
			root = new Node(n);
			return root;

		}

		if (root.data > n)
			root.left = insert(root.left, n);

		else if (root.data < n) {
			root.right = insert(root.right, n);
		}

		return root;
	}
}
