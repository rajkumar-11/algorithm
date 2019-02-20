package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class SameLevelConncetExtraSpace {
	public static void main(String[] args) {
		BinaryTreeR tree = new BinaryTreeR();

		tree.root = new NodeR(10);
		tree.root.left = new NodeR(8);
		tree.root.right = new NodeR(2);
		tree.root.left.left = new NodeR(3);
		tree.root.left.right = new NodeR(7);
		tree.root.right.left = new NodeR(6);
		tree.root.right.right = new NodeR(4);
		tree.root.left.right.left = new NodeR(1);
		tree.root.left.right.right = new NodeR(5);

		connect(tree.root);
		Traverse(tree.root);

	}

	private static void connect(NodeR root) {
		if (root == null)
			return;

		if (root.nextRight != null) {
			connect(root.nextRight);
		}

		if (root.left != null) {
			if (root.right != null) {
				root.left.nextRight = root.right;
				root.right.nextRight = getNextRight(root);

			} else {
				root.left.nextRight = getNextRight(root);

			}
			connect(root.left);

		} else if (root.right != null) {
			root.right.nextRight = getNextRight(root);
			connect(root.right);
		} 

	}

	private static NodeR getNextRight(NodeR root) {
		NodeR temp = root.nextRight;

		while (temp != null) {
			if (temp.left != null) {
				return temp.left;
			}
			if (temp.right != null) {
				return temp.right;
			}
			temp = temp.nextRight;

		}

		return null;
	}

	private static void Traverse(NodeR root) {
		Queue<NodeR> queue = new LinkedList<NodeR>();
		queue.add(root);

		while (!queue.isEmpty()) {
			NodeR node = queue.poll();

			System.out.println(node.data + " -> " + (node.nextRight != null ? node.nextRight.data : -1));
			if (node.left != null) {
				queue.add(node.left);
			}
			if (node.right != null) {
				queue.add(node.right);
			}

		}

	}

}
