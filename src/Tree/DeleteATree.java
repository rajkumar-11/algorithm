package Tree;

public class DeleteATree {
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);

		// System.out.println("Post Order traversal of binary tree is ");
		DeleteTree(tree.root);
//		System.out.println("deleting "+tree.root.data);
		tree.root=null;

		System.out.println("Pre  Order traversal of binary tree is ");
		Preorder(tree.root);

	}

	private static void DeleteTree(Node root) {
		if (root == null)
			return;
		DeleteTree(root.left);
		DeleteTree(root.right);
		System.out.println("deleting "+root.data);
		root.left = null;
		root.right = null;

	}

	private static void Preorder(Node root) {
		if (root == null)
			return;

		System.out.print(root.data + "  ");
		Preorder(root.left);
		Preorder(root.right);

	}
}
