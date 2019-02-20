package Tree;

import java.util.Stack;

public class InorderTreeTraversalWithoutRecursion {
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(20);
		tree.root.left = new Node(8);
		tree.root.right = new Node(22);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(12);
		tree.root.left.right.left = new Node(10);
		tree.root.left.right.right = new Node(14);
		inorder(tree.root);
	}

	private static void inorder(Node root) {
		Stack<Node> stack = new Stack<>();
		stack.add(root);

		while (!stack.isEmpty()) {
//			System.out.println("here");s
			
			while(root.left!=null)
			{
				stack.add(root.left);	
				root=root.left;
				
			}
			
			Node node = stack.pop();
			System.out.print(node.data + " ");
			if (node.right != null) {
				stack.add(node.right);
			}
//			if (node.left != null) {
//				stack.add(node.left);
//			}

		}

	}
}
