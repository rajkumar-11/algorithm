package Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTreeToBinarySearchTreeConversion {
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(10);
		tree.root.left = new Node(2);
		tree.root.right = new Node(7);
		tree.root.left.left = new Node(8);
		tree.root.left.right = new Node(4);

		List<Integer> list = new ArrayList<>();

		ConvertToBST(tree.root, list);

	}

	private static void ConvertToBST(Node root, List<Integer> list) {

		InOrder(root, list);

		Collections.sort(list);

		InOrderSetting(root, list);

		InOrderTraversal(root);

	}

	private static void InOrderTraversal(Node root) {
		if (root == null)
			return;

		if (root.left != null)
			InOrderTraversal(root.left);
		System.out.print(root.data + " ");
		if (root.right != null)
			InOrderTraversal(root.right);

	}

	private static void InOrderSetting(Node root, List<Integer> list) {
		if (root == null)
			return;

		if (root.left != null)
			InOrderSetting(root.left, list);

		int x = list.get(0);
		// System.out.println("x= "+ x);

		root.data = x;
		list.remove(new Integer(x));

		if (root.right != null)
			InOrderSetting(root.right, list);

	}

	private static void InOrder(Node root, List<Integer> list) {

		if (root == null)
			return;

		if (root.left != null)
			InOrder(root.left, list);

		list.add(root.data);

		if (root.right != null)
			InOrder(root.right, list);

	}
}
