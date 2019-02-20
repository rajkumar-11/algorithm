package Tree;

public class LeftViewOfABinaryTree {
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.right = new Node(4);
		tree.root.left.right.right = new Node(5);
		tree.root.left.right.right.right = new Node(6);

		int h = height(tree.root);

		boolean[] visited = new boolean[h + 1];
		// System.out.println("height= "+h);

		leftView(tree.root, visited, 1);

	}

	private static int height(Node root) {
		if (root == null)
			return 0;

		int lh = height(root.left);
		int rh = height(root.right);

		return lh > rh ? lh + 1 : rh + 1;
	}

	private static void leftView(Node root, boolean[] visited, int h) {

		if (root == null)
			return;

		if (visited[h] == false) {
			System.out.print(root.data + " ");
			visited[h] = true;
		}
		h = h + 1;
		leftView(root.left, visited, h);
		leftView(root.right, visited, h);

	}
}
