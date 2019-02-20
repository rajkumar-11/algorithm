package DynamicProgramming;

public class Tree {
	Tree left, right;
	int data,vc;

	public Tree(int value) {
		this.data = value;
		this.left = null;
		this.right = null;
		this.vc=0;
	}

}
