package Tree;

import java.util.LinkedList;
import java.util.List;

public class SortedLinkedListToBalancedBST {
	static int size = 0;
	static int index = 0;

	public static void main(String[] args) {
		List<Integer> list = new LinkedList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		System.out.println("Given linked list is ");

		int n = printLinkedList(list);
		size = n;
		System.out.println();

		Node root = sortedListToBST(list, n);
		System.out.println();
		System.out.println("Pre Order Traversal of the constructed tree is ");
		preOrder(root);

	}

	private static void preOrder(Node root) {
		if (root == null) {
			return;

		}
		System.out.print(root.data+" ");
		preOrder(root.left);
		preOrder(root.right);

	}

	private static Node sortedListToBST(List<Integer> list, int n) {
		if (n <= 0)
			return null;
//		System.out.println("n= "+n);

		Node left = sortedListToBST(list, n / 2);

		Node node = new Node(list.get(index));
		index += 1;
		node.left = left;
		Node right = sortedListToBST(list, n - n / 2 - 1);
		node.right = right;
		return node;
	}

	private static int printLinkedList(List<Integer> list) {
		int n = list.size();
		for (int i = 0; i < n; i++) {
			System.out.print(list.get(i) + " ");
		}

		return n;

	}

}
