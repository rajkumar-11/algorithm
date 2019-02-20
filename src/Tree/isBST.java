package Tree;

public class isBST {
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(3);
		tree.root.left = new Node(2);
		tree.root.right = new Node(5);
		tree.root.left.left = new Node(1);
		tree.root.left.right = new Node(4);

		if (isBST(tree.root, Integer.MIN_VALUE, Integer.MAX_VALUE))
			System.out.println("IS BST");
		else
			System.out.println("Not a BST");

	}

	private static boolean isBST(Node root, int min, int max) {
		if (root == null)
			return true;

		if (root.data < min || root.data > max)
			return false;

		return isBST(root.left, min, root.data) && isBST(root.right, root.data, max);

	}
}
