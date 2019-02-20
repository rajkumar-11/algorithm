package Tree;

import java.util.LinkedList;
import java.util.List;

public class AllRootToLeafPaths {
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(10);
		tree.root.left = new Node(8);
		tree.root.right = new Node(2);
		tree.root.left.left = new Node(3);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(2);

		/* Let us test the built tree by printing Insorder traversal */
		List<Integer> list = new LinkedList<>();
		printPaths(tree.root, list);

	}

	private static void printPaths(Node root, List<Integer> list) {
		if (root == null) {
			return;
		}
		if (root.left != null) {
			list.add(root.data);
			printPaths(root.left, list);
			list.remove(new Integer(root.data));
		}
		if (root.right != null) {
			list.add(root.data);
			printPaths(root.right, list);
			list.remove(new Integer(root.data));
		}
		if (root.left == null && root.right == null) {
			list.add(root.data);
			for (int i = 0; i < list.size(); i++) {
				System.out.print(list.get(i) + " ");

			}
			list.remove(new Integer(root.data));

			System.out.println();

		}

	}

}
