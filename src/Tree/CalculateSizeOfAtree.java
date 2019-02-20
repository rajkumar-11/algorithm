package Tree;

public class CalculateSizeOfAtree {

	// static int c=0;

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		// int c = 0;
		int c = count(tree.root);

		System.out.println("No of nodes are= " + c);

	}

	private static int count(Node root) {
		if (root == null)
			return 0;

		return count(root.left) + count(root.right) + 1;

		//
		// c++;
		//
		// return;
	}
}
