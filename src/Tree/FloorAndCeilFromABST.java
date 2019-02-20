package Tree;

public class FloorAndCeilFromABST {

	static int c, f;

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(8);
		tree.root.left = new Node(4);
		tree.root.right = new Node(12);
		tree.root.left.left = new Node(2);
		tree.root.left.right = new Node(6);
		tree.root.right.left = new Node(10);
		tree.root.right.right = new Node(14);
		for (int i = 0; i < 16; i++) {
			c = -1;
			f = -1;
			Ceil(tree.root, i);
			System.out.println(i + " " + " f= " + f + " c= " + c);
		}

	}

	private static void Ceil(Node root, int k) {
		if (root == null) {
			return;

		}

		if (root.data == k)
			c = f = root.data;

		if (root.data < k) {
			f = root.data;
			Ceil(root.right, k);

		} else {
			c = root.data;
			Ceil(root.left, k);
		}
		// return c >= k ? c : root.data;
	}

}
