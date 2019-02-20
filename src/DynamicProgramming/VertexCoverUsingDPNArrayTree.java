package DynamicProgramming;

import java.util.LinkedList;

public class VertexCoverUsingDPNArrayTree {
	public static void main(String[] args) {
		Node root = new Node(1);
		root.arr.add(new Node(2));
		root.arr.add(new Node(3));
		root.arr.add(new Node(4));
		root.arr.get(1).arr.add(new Node(5));
		root.arr.get(1).arr.add(new Node(6));
		root.arr.get(2).arr.add(new Node(7));
		root.arr.get(2).arr.add(new Node(8));
		root.arr.get(2).arr.add(new Node(9));
		root.arr.get(1).arr.get(0).arr.add(new Node(10));
		root.arr.get(1).arr.get(0).arr.add(new Node(11));

		System.out.println("Size of smallest vertex cover is : " + getMinVertexCover(root) + " ");
	}

	private static int getMinVertexCover(Node root) {
		if (root == null)
			return 0;

		if (root.arr.size() == 0)
			return 0;
		if (root.nc != 0)
			return root.nc;

		int included = 1;

		for (Node node : root.arr) {
			included += getMinVertexCover(node);

		}
		int excluded = root.arr.size();

		for (Node node : root.arr) {
			for (Node node2 : node.arr) {
				excluded += getMinVertexCover(node2);
			}

		}

		root.nc = Math.min(included, excluded);

		return root.nc;
	}

}

