package DynamicProgramming;

import java.util.LinkedList;

public class Node {
	int data, nc;
	LinkedList<Node> arr = null;

	public Node(int value) {
		this.data = value;
		this.nc = 0;
		this.arr = new LinkedList<Node>();

	}

}
