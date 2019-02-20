package Tree;

public class isBSTUsingBST {
	static int prev = Integer.MIN_VALUE;

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(3);
		tree.root.left = new Node(2);
		tree.root.right = new Node(5);
		tree.root.left.left = new Node(1);
		tree.root.left.right = new Node(4);

		if (isBST(tree.root))
			System.out.println("IS BST");
		else
			System.out.println("Not a BST");

	}

	private static boolean isBST(Node root) {
		if (root == null)
			return true;

		if (isBST(root.left) == false)
			return false;

		if (prev > root.data)
			return false;
		prev = root.data;

		if (isBST(root.right) == false)
			return false;

		return true;

	}
}
