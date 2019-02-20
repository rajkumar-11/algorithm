package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectNodesAtSameLevelLevelOrderTraversal {
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
		Queue<NodeR> queue = new LinkedList<>();

		queue.add(root);

		while (!queue.isEmpty()) {
			// NodeR node= queue.poll();
			int levelLength = queue.size();
			System.out.println("here size= " + levelLength);
			NodeR prev = null;

			for (int i = 0; i < levelLength; i++) {

				NodeR node = queue.poll();

				System.out.println("data=" + node.data + " queue size= " + queue.size() + " i= " + i);
				// NodeR front = null;

				if (node.left != null) {
					queue.add(node.left);

				}

				if (node.right != null) {
					queue.add(node.right);
				}

				if (i == 0) {
					prev = node;
					System.out.println("cheerio");
					continue;
				} else {
					prev.nextRight = node;
					prev = node;

				}

			}

		}

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
