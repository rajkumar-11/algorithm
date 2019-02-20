package Tree;

public class InorderPredecessorAndSuccessor {
	static int size = 0;
	static int i = 0;

	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();

		tree.root = insert(tree.root, 50);
		tree.root = insert(tree.root, 30);
		tree.root = insert(tree.root, 20);
		tree.root = insert(tree.root, 40);
		tree.root = insert(tree.root, 70);
		tree.root = insert(tree.root, 60);
		tree.root = insert(tree.root, 80);

		size(tree.root);

		System.out.println("size =" + size);

		int[] arr = new int[size];

		InOrder(tree.root, arr);

		for (int i = 0; i < size; i++) {
			System.out.print(arr[i] + " ");
		}

		int key = 65;

		int prev = arr[0];
		int next = arr[0];

		for (int i = 1; i < size - 1; i++) {
			if (arr[i] == key) {
				prev = arr[i - 1];
				next = arr[i + 1];

			} else if (arr[i] > key) {
				prev = arr[i - 1];
				next = arr[i];

			} else {
				prev = arr[i];
				next = arr[i + 1];

			}

		}
		System.out.println("prev= "+prev+" next= "+next+" key= "+key);
		

	}

	private static void InOrder(Node root, int[] arr) {
		if (root == null)
			return;

		InOrder(root.left, arr);
		arr[i] = root.data;
		i++;
		InOrder(root.right, arr);

	}

	private static void size(Node root) {
		if (root == null)
			return;

		size++;

		size(root.left);
		size(root.right);

		// return 0;
	}

	private static Node insert(Node root, int n) {

		if (root == null) {
			root = new Node(n);
			return root;

		}

		if (root.data > n)
			root.left = insert(root.left, n);

		else if (root.data < n) {
			root.right = insert(root.right, n);
		}

		return root;
	}

}
