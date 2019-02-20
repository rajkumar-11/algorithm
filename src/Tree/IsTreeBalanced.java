package Tree;

public class IsTreeBalanced {
	public static void main(String[] args) {

		AVLTree tree = new AVLTree();
		tree.root = new NodeH(1);
		tree.root.left = new NodeH(2);
		tree.root.right = new NodeH(3);
		tree.root.left.left = new NodeH(4);
		tree.root.left.right = new NodeH(5);
		tree.root.left.left.left = new NodeH(7);
		tree.root.right.right = new NodeH(6);
		tree.root.right.right.right = new NodeH(66);
		tree.root.right.right.right = new NodeH(666);

		if (isBalance(tree.root)) {
			System.out.println("The tree is balanced");
		} else {
			System.out.println("Tree is not balanced");
		}
	}

	private static boolean isBalance(NodeH root) {
		if (root == null) {
			return true;
		}
		boolean l = isBalance(root.left);
		boolean r = isBalance(root.right);

		root.height = Math.max(root.left == null ? 0 : root.left.height, root.right == null ? 0 : root.right.height)
				+ 1;

		int lheight = root.left == null ? 0 : root.left.height;
		int rheight = root.right == null ? 0 : root.right.height;

		if (Math.abs(lheight - rheight) > 1)
			return false;

		return l && r;
	}

}
