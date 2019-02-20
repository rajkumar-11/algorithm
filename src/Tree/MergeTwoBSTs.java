package Tree;

import java.util.Stack;

public class MergeTwoBSTs {
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(3);
		tree.root.left = new Node(1);
		tree.root.right = new Node(5);
		tree.root.right.left = new Node(4);
		tree.root.right.right = new Node(7);

		BinaryTree tree1 = new BinaryTree();
		tree1.root = new Node(14);
		tree1.root.left = new Node(12);
		tree1.root.right = new Node(16);
		tree1.root.right.left = new Node(15);
		tree1.root.right.right = new Node(19);

		merge(tree.root, tree1.root);

	}

	private static void merge(Node root, Node root2) {
		Stack<Node> stack1 = new Stack<>();
		Stack<Node> stack2 = new Stack<>();

		Node curr1 = root;
		Node curr2 = root2;

		while (!stack1.isEmpty() || !stack2.isEmpty() || curr1 != null || curr2 != null) {

			if (stack1.isEmpty() && curr1 == null) {
				// System.out.println("tada");
				while (!stack2.isEmpty() || curr2 != null) {
					while (curr2 != null) {
						stack2.push(curr2);
						curr2 = curr2.left;

					}
					curr2 = stack2.pop();

					System.out.print(curr2.data + " ");

					curr2 = curr2.right;

				}

			} else if (stack2.isEmpty() && curr2 == null) {
				// System.out.println("data");

				while (!stack1.isEmpty() || curr1 != null) {
					while (curr1 != null) {
						stack1.push(curr1);
						curr1 = curr1.left;

					}
					curr1 = stack1.pop();

					System.out.print(curr1.data + " ");

					curr1 = curr1.right;

				}
			} else {
				while (curr1 != null) {
					stack1.push(curr1);
					curr1 = curr1.left;

				}

				while (curr2 != null) {
					stack2.push(curr2);
					curr2 = curr2.left;

				}
				// System.out.println("stack1 size =" + stack1.size() + " stack2
				// size= " + stack2.size());

				curr1 = stack1.pop();
				curr2 = stack2.pop();

				// System.out.println("curr1= " + curr1.data + " curr2= " +
				// curr2.data);

				if (curr1.data > curr2.data) {
					System.out.print(curr2.data + " ");
					// System.out.println();
					curr2 = curr2.right;
					// curr1=curr1.right;
					stack1.push(curr1);
					curr1 = null;

				} else {
					System.out.print(curr1.data + " ");
					// System.out.println();
					curr1 = curr1.right;
					// curr2 = curr2.right;
					stack2.push(curr2);
					curr2 = null;
				}

			}

		}

	}
}
