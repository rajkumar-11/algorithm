
public class DepthFirstTraversal {
	public static void main(String[] args) {
		Node1 root = new Node1(1);
		root.left = new Node1(2);
		root.right = new Node1(3);
		root.left.left = new Node1(4);
		root.left.right = new Node1(5);
		root.right.left = new Node1(6);
		root.right.right = new Node1(7);
		DFS(root);

	}

	private static void DFS(Node1 root) {
		System.out.println("Following is the pre Order Traversal");
		Preorder(root);
		System.out.println("Following is the in Order traversal");
		Inorder(root);
		System.out.println("following is the post Order Traversal");
		PostOrder(root);

	}

	private static void PostOrder(Node1 root) {
		if (root == null) {
			return;
		}
		PostOrder(root.left);
		PostOrder(root.right);
		System.out.print(root.data + " ");

	}

	private static void Inorder(Node1 root) {
		if (root == null) {
			return;
		}
		Inorder(root.right);
		System.out.print(root.data + " ");
		Inorder(root.left);

	}

	private static void Preorder(Node1 root) {
		if (root == null) {
			return;
		}
		System.out.print(root.data + " ");

		Preorder(root.left);

		Preorder(root.right);

	}

}
