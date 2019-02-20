package Greedy;

import java.util.Comparator;
import java.util.PriorityQueue;

public class HuffManCoding {
	public static void main(String[] args) {

		int n = 6;
		char[] charArray = { 'a', 'b', 'c', 'd', 'e', 'f' };
		int[] charfreq = { 5, 9, 12, 13, 16, 45 };

		PriorityQueue<HuffmanNode> queue = new PriorityQueue<HuffmanNode>(n, new MyComparator());

		for (int i = 0; i < n; i++) {
			HuffmanNode node = new HuffmanNode(charfreq[i], charArray[i]);
			queue.add(node);
		}

		HuffmanNode root = null;

		while (queue.size() > 1)
		{
			HuffmanNode n1 = queue.peek();
			queue.poll();
			HuffmanNode n2 = queue.peek();
			queue.poll();

			HuffmanNode temp = new HuffmanNode(n1.f + n2.f, '-');
			temp.left=n1;
			temp.right=n2;
			queue.add(temp);
			root = temp;

		}

		String string = new String("");
//		System.out.println(string + "0");

		printCode(root, string);

	}

	private static void printCode(HuffmanNode root, String string) {
		
		if(root==null)
			return;
		
		if ( root.left == null && root.right == null && Character.isLetter(root.c)) {
			System.out.println(root.c + " " + string);
			return;

		}
//		System.out.println("string length= " + string.length());
		String right = string + "0";
		String left = string + "1";

		printCode(root.left, right);
		printCode(root.right, left);

	}

}

class MyComparator implements Comparator<HuffmanNode> 
{
	
	public int compare(HuffmanNode x, HuffmanNode y) 
	{

		return x.f - y.f;
	}
}

class HuffmanNode {
	char c;
	int f;
	HuffmanNode left, right;

	public HuffmanNode(int x, char c) {
		this.f = x;
		this.c = c;
		this.left = null;
		this.right = null;

	}

	// @Override
	// public int compare(HuffmanNode node0, HuffmanNode node1) {
	//
	// return node0.f - node1.f;
	// }

}