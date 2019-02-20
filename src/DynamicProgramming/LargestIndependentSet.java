package DynamicProgramming;

public class LargestIndependentSet {
	public static void main(String[] args) {

		Node2 root = new Node2(20);
		root.left = new Node2(8);
		root.left.left = new Node2(4);
		root.left.right = new Node2(12);
		root.left.right.left = new Node2(10);
		root.left.right.right = new Node2(14);
		root.right = new Node2(22);
		root.right.right = new Node2(25);
		System.out.println("Size of the Largest Independent Set is " + liss(root));

	}

	private static int liss(Node2 root) {
		if (root == null)
			return 0;

		if (root.liss != 0)
			return root.liss;

		if (root.left == null && root.right == null) {
			return 1;
		}

		int excluded = liss(root.left) + liss(root.right);

		int included = 1;

		if (root.right != null) {
			included += liss(root.right.left) + liss(root.right.right);

		}

		if (root.left != null) {
			included += liss(root.left.right) + liss(root.left.left);

		}
		root.liss = included > excluded ? included : excluded;

		return included > excluded ? included : excluded;

	}
}
