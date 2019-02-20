package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class SameLevelConncetExtraSpaceIterative {
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

		while (root != null) {
			NodeR q = root;

			while (q != null) {
				if (q.left != null) {
					if (q.right != null) {
						q.left.nextRight = q.right;
						q.right.nextRight = getNextRight(q);

					} else {
						q.nextRight = getNextRight(q);

					}

				}
				if (q.right != null) {
					q.right.nextRight = getNextRight(q);
				}
				q = q.nextRight;

			}

			if (root.left != null) {
				root = root.left;
			} else if (root.right != null) {
				root = root.right;

			} else {
				root = getNextRight(root);
			}

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
