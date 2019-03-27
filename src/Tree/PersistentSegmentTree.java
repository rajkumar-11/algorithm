package Tree;

public class PersistentSegmentTree {
	static int max = 100;
	static int[] arr = new int[max];
	static SegmentTreeNode[] version = new SegmentTreeNode[max];

	public static void main(String[] args) {
		int A[] = { 1, 2, 3, 4, 5 };
		int l = A.length;
		for (int i = 0; i < l; i++) {
			arr[i] = A[i];
		}
		SegmentTreeNode root = new SegmentTreeNode(null, null, 0);
		build(root, 0, l - 1);
		version[0] = root;
		version[1] = new SegmentTreeNode(null, null, 0);
		upgrade(version[0], version[1], 0, l - 1, 4, 1);
		version[2] = new SegmentTreeNode(null, null, 0);
		upgrade(version[1], version[2], 0, l - 1, 2, 10);
		System.out.println("In version 1,query(0,4) ");
		System.out.println(query(version[1], 0, l - 1, 0, 4));
		System.out.println("In version 2 , query(3,4)");
		System.out.println(query(version[2], 0, l - 1, 3, 4));
		System.out.println("In version 0 , query(0,3) :");
		System.out.println(query(version[1], 0, l - 1, 0, 3));

	}

	private static int query(SegmentTreeNode node, int low, int high, int ss, int se) {
		if (low > high || se < low || ss > high)
			return 0;

		if (ss <= low && se >= high) {
			return node.val;
		}
		int mid = (low + high) / 2;
		return query(node.left, low, mid, ss, se) + query(node.right, mid + 1, high, ss, se);

		// return 0;
	}

	private static void upgrade(SegmentTreeNode prev, SegmentTreeNode cur, int low, int high, int index, int value) 
	{
		if (low == high) {
			cur.val = value;
			return;
		}
		int mid = (low + high) / 2;
		if (mid < index) {
			cur.left = prev.left;
			cur.right = new SegmentTreeNode(null, null, 0);
			upgrade(prev.right, cur.right, mid + 1, high, index, value);

		} else {
			cur.right = prev.right;
			cur.left = new SegmentTreeNode(null, null, 0);
			upgrade(prev.left, cur.left, low, mid, index, value);

		}
		cur.val = cur.left.val + cur.right.val;

	}

	private static void build(SegmentTreeNode node, int low, int high) {
		if (low == high) {
			node.val = arr[low];
			return;

		}
		int mid = (low + high) / 2;
		node.left = new SegmentTreeNode(null, null, 0);
		node.right = new SegmentTreeNode(null, null, 0);
		build(node.left, low, mid);
		build(node.right, mid + 1, high);
		node.val = node.left.val + node.right.val;

	}

}

class SegmentTreeNode {
	int val;
	SegmentTreeNode left, right;

	public SegmentTreeNode(SegmentTreeNode left, SegmentTreeNode right, int v) {
		this.val = v;
		this.left = left;
		this.right = right;
	}

}
