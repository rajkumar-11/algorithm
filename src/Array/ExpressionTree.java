package Array;

import java.util.Stack;

public class ExpressionTree {
	public static void main(String[] args) {

		ExpressionTree et = new ExpressionTree();
		String postfix = "ab+ef*g*-";
		char[] charArray = postfix.toCharArray();
		TreeNode root = et.constructTree(charArray);
		System.out.println("infix expression is");
		et.inorder(root);

	}

	private void inorder(TreeNode root) {
		if (root == null) {
			return;
		}
		inorder(root.left);
		System.out.print(root.ch + " ");
		inorder(root.right);

	}

	private TreeNode constructTree(char[] charArray) {
		int length = charArray.length;
		Stack<TreeNode> stack = new Stack<>();

		for (int i = 0; i < length; i++) {
			if (isChar(charArray[i])) {
				TreeNode node = new TreeNode(charArray[i]);
				TreeNode node1 = stack.pop();
				TreeNode node2 = stack.pop();
				node.left = node1;
				node.right = node2;
				stack.push(node);

			} else {
				TreeNode node = new TreeNode(charArray[i]);
				stack.push(node);
			}

		}

		return stack.pop();
	}

	private boolean isChar(char c) {
		if (c == '+' || c == '-' || c == '*' || c == '/')
			return true;
		return false;
	}
}

class TreeNode {
	char ch;
	TreeNode left, right;

	public TreeNode(char ch) {
		this.left = null;
		this.right = null;
		this.ch = ch;

	}

}