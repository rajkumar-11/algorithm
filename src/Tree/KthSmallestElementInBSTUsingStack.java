package Tree;

import java.util.Stack;

public class KthSmallestElementInBSTUsingStack {
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(20);
		tree.root.left = new Node(8);
		tree.root.right = new Node(22);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(12);
		tree.root.left.right.left = new Node(10);
		tree.root.left.right.right = new Node(14);

		int x = findKthElement(tree.root, 4);

		System.out.println("4 th value will be =" + x);

	}

	private static int findKthElement(Node root, int k) {
		int count = 0;
		Stack<Node> stack = new Stack<>();
		// stack.add(root);

		Node curr = root;

		while (!stack.isEmpty() || curr != null) {
			// Node n = stack.pop();

			while (curr != null) {
				stack.push(curr);
				curr = curr.left;

			}
			curr = stack.pop();
			count++;
			System.out.println("count= " + count + " value = " + curr.data);
			if (count == k) {
				return curr.data;
			}

			curr = curr.right;

		}

		return 0;
	}
}
