package Tree;

public class NodeH {
	int data;
	NodeH left, right;
	int height;

	public NodeH(int value) {
		this.data = value;
		this.height = 1;
		this.left = this.right = null;

	}

}
