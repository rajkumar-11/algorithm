package Tree;

import java.util.LinkedList;

public class InPlaceConversionOfSortedDLLToBalancedBST {
	static int index;

	public static void main(String[] args) {

		LinkedList<Node> list = new LinkedList<Node>();

		list.add(new Node(1));
		list.add(new Node(2));
		list.add(new Node(3));
		list.add(new Node(4));
		list.add(new Node(5));
		list.add(new Node(6));
		list.add(new Node(7));

		System.out.println("Given Linked List ");
		printList(list);

		Node root = sortedListToBST(list, list.size());
		System.out.println("");
		System.out.println("Pre-Order Traversal of constructed BST ");
		preOrder(root);

	}

	private static void preOrder(Node root) {
		if (root == null)
			return;
		System.out.print(root.data + " ");
		preOrder(root.left);
		preOrder(root.right);

	}

	private static Node sortedListToBST(LinkedList list, int n) {
		if (n <= 0)
			return null;
		Node left = sortedListToBST(list, n / 2);
		Node root = (Node) list.get(index++);
		root.left = left;
		root.right = sortedListToBST(list, n - n / 2 - 1);

		return root;
	}

	private static void printList(LinkedList<Node> list) {
		int n = list.size();
		for (int i = 0; i < n; i++) {
			System.out.print(list.get(i).data + " ");

		}

	}

}
