package Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

public class BinaryTree {
	Node root;

	public BinaryTree() {
		this.root = null;

	}

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(3);
		tree.root.right = new Node(2);
		tree.root.left.left = new Node(5);
		tree.root.left.right = new Node(4);

		System.out.println("Level Order traversal of binary tree is ");
		printLevelOrder(tree);

	}

	private static void printLevelOrder(BinaryTree tree) {

		Queue<Node> queue = new LinkedList<>();
		queue.add(tree.root);

		while (!queue.isEmpty()) {
			Node node = queue.poll();

			if (node.left != null) {
				queue.add(node.left);
			}
			if (node.right != null) {
				queue.add(node.right);
			}
			System.out.print(node.data + "  ");

		}

	}

}
