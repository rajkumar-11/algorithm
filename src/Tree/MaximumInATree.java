package Tree;

public class MaximumInATree {

	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(2);
		tree.root.left = new Node(7);
		tree.root.right = new Node(5);
		tree.root.left.right = new Node(6);
		tree.root.left.right.left = new Node(1);
		tree.root.left.right.right = new Node(11);
		tree.root.right.right = new Node(9);
		tree.root.right.right.left = new Node(4);

		findMax(tree.root);
		System.out.println("Maximum element is " + max);
	}

	private static void findMax(Node root) {
		if (root == null)
			return;

		if (root.data > max) {
			max = root.data;
		}
		findMax(root.left);
		findMax(root.right);

		return;
	}

}
