package list;

import java.util.LinkedList;
import java.util.List;

import javax.naming.InterruptedNamingException;

import Tree.Node;
import Tree.SortedLinkedListToBalancedBST;

public class BinarySearchTree {
	Node root;
	static int index = 0;

	// Constructor
	BinarySearchTree() {
		root = null;
	}

	// Inorder traversal of the tree
	void inorder() {
		inorderUtil(this.root);
	}

	// Utility function for inorder traversal of the tree
	void inorderUtil(Node node) {
		if (node == null)
			return;

		inorderUtil(node.left);
		System.out.print(node.data + " ");
		inorderUtil(node.right);
	}

	public static void main(String[] args) {

		BinarySearchTree tree1 = new BinarySearchTree();
		tree1.root = new Node(100);
		tree1.root.left = new Node(50);
		tree1.root.right = new Node(300);
		tree1.root.left.left = new Node(20);
		tree1.root.left.right = new Node(70);

		BinarySearchTree tree2 = new BinarySearchTree();
		tree2.root = new Node(80);
		tree2.root.left = new Node(40);
		tree2.root.right = new Node(120);

		BinarySearchTree tree = new BinarySearchTree();
		tree.root = tree.mergeTrees(tree1.root, tree2.root);
		System.out.println("The Inorder traversal of the merged BST is: ");
		tree.inorder();
	}

	private Node mergeTrees(Node root1, Node root2) {
		List<Integer> list2 = new LinkedList();
		List<Integer> list1 = new LinkedList();

		inOrderTraversal(root1, list1);
		inOrderTraversal(root2, list2);
		// System.out.println("list1 size "+list1.size());
		// System.out.println("list2 size "+list2.size());

		List<Integer> list = mergeLists(list1, list2);

		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + "  ");
		}

		return sortedListToBST(list, list.size());
	}

	private Node sortedListToBST(List<Integer> list, int n) {
		if (n <= 0)
			return null;
		// System.out.println("n= "+n);

		Node left = sortedListToBST(list, n / 2);

		Node node = new Node(list.get(index));
		index += 1;
		node.left = left;
		Node right = sortedListToBST(list, n - n / 2 - 1);
		node.right = right;
		return node;

	}

	private List<Integer> mergeLists(List<Integer> list1, List<Integer> list2) {
		List<Integer> list = new LinkedList<>();
		int n = list1.size();
		int m = list2.size();
		// System.out.println("n= "+n+" m= "+m);

		int i = 0;
		int j = 0;
		while (i < n && j < m) {
			if (list1.get(i) < list2.get(j)) {
				list.add(list1.get(i));
				i = i + 1;

			} else {
				list.add(list2.get(j));
				j = j + 1;

			}

		}
		if (i < n) {
			while (i < n) {
				list.add(list1.get(i));
				i += 1;
			}

		}
		if (j < m) {
			while (j < m) {
				list.add(list1.get(j));
				j += 1;
			}

		}

		return list;
	}

	private void inOrderTraversal(Node node, List<Integer> list) {
		if (node == null)
			return;
		inOrderTraversal(node.left, list);
		list.add(node.data);
		inOrderTraversal(node.right, list);

	}

}
