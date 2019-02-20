package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectNodesAtSameLevel {

	public static void main(String[] args) {
		BinaryTreeR tree = new BinaryTreeR();

		tree.root = new NodeR(10);
		tree.root.left = new NodeR(8);
		tree.root.right = new NodeR(2);
		tree.root.left.left = new NodeR(3);

		connect(tree.root);
		Traverse(tree.root);

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

	private static void connect(NodeR root) {
		if (root == null)
			return;
		if (root.left != null) {
			root.left.nextRight = root.right;
		}
		if (root.right != null) {
			root.right.nextRight = root.nextRight != null ? root.nextRight.left : null;
		}
		connect(root.left);
		connect(root.right);

	}

}
