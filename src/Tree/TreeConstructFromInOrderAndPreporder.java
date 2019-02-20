package Tree;

public class TreeConstructFromInOrderAndPreporder {
	static int preIndex = 0;

	public static void main(String[] args) {
		// BinaryTree tree = new BinaryTree();
		char in[] = new char[] { 'D', 'B', 'E', 'A', 'F', 'C' };
		char pre[] = new char[] { 'A', 'B', 'D', 'E', 'C', 'F' };
		int len = in.length;
		NodeC root = buildTree(in, pre, 0, len - 1);

		System.out.println("Inorder traversal of constructed tree is : ");
		Inorder(root);

	}

	private static void Inorder(NodeC root) {
		if (root == null)
			return;

		Inorder(root.left);
		System.out.print(root.data + "  ");
		Inorder(root.right);

	}

	private static NodeC buildTree(char[] in, char[] pre, int start, int end) {
		if (end < start)
			return null;
		char c = pre[preIndex++];
		System.out.println("char= " + c + " start= " + start + " end= " + end);

		NodeC node = new NodeC(c);

		if (start == end)
			return node;

		int index = start;

		for (int i = start; i <= end; i++) {
			if (in[i] == c) {
				index = i;
				break;
			}

		}
		System.out.println("index= " + index);

		node.left = buildTree(in, pre, start, index - 1);
		node.right = buildTree(in, pre, index + 1, end);

		return node;
	}

}
