package Array;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class SortElementByFrequencySet2 {
	public static void main(String[] args) {
		int arr[] = { 5, 2, 2, 8, 5, 6, 8, 8 };

		int l = arr.length;

		BST bst = new BST();

		for (int i = 0; i < l; i++) {
			bst.root = bst.add(i, arr[i], bst.root);

		}
		List<Node> list = new LinkedList<>();
		bst.inorder(list, bst.root);
		// System.out.println(list.size());

		Collections.sort(list, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				if (o1.count == o2.count) {
					return o1.index - o2.index;

				} else {
					return o2.count - o1.count;
				}

			}
		});
		// for (int i = 0; i < list.size(); i++) {
		// System.out.println((list.get(i).data + " " + list.get(i).count));
		// }
		for (int i = 0; i < list.size(); i++) 
		{
			int v = list.get(i).count;
			int y = list.get(i).data;
			
			
			for (int x = 0; x < v; x++) 
			{
				System.out.print(y + " ");
			}

		}

	}
}

class Node {
	int data, count, index;
	Node left, right;

	public Node(int data, int count, int index) {
		this.data = data;
		this.count = count;
		this.index = index;
		this.left = null;
		this.right = null;
	}

}

class BST {
	Node root;

	public BST() {
		this.root = null;

	}

	public void inorder(List<Node> list, Node root2) {
		// System.out.println("here");
		if (root2 == null)
			return;

		this.inorder(list, root2.left);
		list.add(root2);
		// System.out.println("size=" + list.size());

		this.inorder(list, root2.right);

	}

	public Node add(int i, int data, Node root2) {
		if (root2 == null) {
			root2 = new Node(data, 1, i);
			return root2;
		} else if (root2.data == data) {
			root2.count += 1;
			return root2;
		} else if (root2.data > data) {
			root2.left = this.add(i, data, root2.left);
			return root2;
		} else {
			root2.right = this.add(i, data, root2.right);
			return root2;

		}
	}

}
