package Tree;

public class SubTreeOrNot {
	public static void main(String[] args) {
		BinaryTree tree1 = new BinaryTree();

		tree1.root = new Node(26);
		tree1.root.right = new Node(3);
		tree1.root.right.right = new Node(3);
		tree1.root.left = new Node(10);
		tree1.root.left.left = new Node(4);
		tree1.root.left.left.right = new Node(30);
		tree1.root.left.right = new Node(6);

		BinaryTree tree2 = new BinaryTree();

		tree2.root = new Node(10);
		tree2.root.right = new Node(6);
		tree2.root.left = new Node(4);
		tree2.root.left.right = new Node(30);

		if (isSubtree(tree1.root, tree2.root))
			System.out.println("Tree 2 is subtree of Tree 1 ");
		else
			System.out.println("Tree 2 is not a subtree of Tree 1");

	}

	private static boolean isSubtree(Node t, Node s) {
		if (s == null)
			return true;
		if (t == null)
			return false;

		if (Isidentical(t, s))
			return true;

		return isSubtree(t.left, s) || isSubtree(t.right, s);

		// return false;
	}

	private static boolean Isidentical(Node root1, Node root2) {
		if (root1 == null && root2 == null)
			return true;

		if (root1 == null || root2 == null)
			return false;

		return (root1.data == root2.data) && isSubtree(root1.left, root2.left) && isSubtree(root1.right, root2.right);

	}
}
