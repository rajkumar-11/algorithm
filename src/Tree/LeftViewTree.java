package Tree;

import java.util.Scanner;

public class LeftViewTree {
	static int height = 0;
	static int level =1;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int n = s.nextInt();

		TreeView tree = new TreeView();

		for (int i = 0; i < n; i++) {
			int x = s.nextInt();
			tree.root = tree.insert(tree.root, new NodeView(x));

		}
		// printInorder(tree.root);
		height = getHeight(tree.root);
		System.out.println("height = " + height);

		printleftView(tree.root, 1);

	}

	private static void printleftView(NodeView root, int h) {
		if (root == null) {
			return;
		}
		if (level == height + 1) {
			return;
		}
		if (level == h) {
			System.out.print(root.data + " ");
			level += 1;
		}
		printleftView(root.left, h + 1);
		printleftView(root.right, h + 1);

	}

	private static int getHeight(NodeView root) {
		if (root == null)
			return 0;

		return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
	}

	private static void printInorder(NodeView root) {
		if (root == null)
			return;
		printInorder(root.left);
		System.out.println(root.data);
		printInorder(root.right);

	}

}

class TreeView {
	NodeView root = null;

	public NodeView insert(NodeView node, NodeView nodeNew) {

		if (node == null) {
			return nodeNew;
		} else if (node.data > nodeNew.data) {
			node.left = insert(node.left, nodeNew);
		} else {
			node.right = insert(node.right, nodeNew);
		}
		return node;

	}

}

class NodeView {
	int data;
	NodeView left, right;

	public NodeView(int data) {
		this.data = data;
	}

}
