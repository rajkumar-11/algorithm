package Graph;
import java.util.Comparator;
import java.util.PriorityQueue;

public class HuffmanCoding {
	public static void main(String[] args) {

		// number of characters.
		int n = 6;
		char[] charArray = { 'a', 'b', 'c', 'd', 'e', 'f' };
		int[] charfreq = { 5, 9, 12, 13, 16, 45 };

		PriorityQueue<HuffmanNode> queue = new PriorityQueue<>(n, new compareNode());

		for (int i = 0; i < n; i++) {
			HuffmanNode node = new HuffmanNode(charfreq[i], charArray[i]);
			queue.add(node);

		}
		HuffmanNode root=null;
		while (queue.size() > 1) 
		{
//		  System.out.println("1");
			HuffmanNode node1 = queue.poll();
			HuffmanNode node2 = queue.poll();

			HuffmanNode temp = new HuffmanNode(node1.data + node2.data, '-');
			temp.left=node1;
			temp.right=node2;

			root=temp;
			queue.add(temp);

		}

		printHuffmanCoding(root,"");

	}

	private static void printHuffmanCoding(HuffmanNode node,String s) 
	{
		if(node==null)
		{
			return ;
		}
//		System.out.println("s= "+s+" char="+node.c);
		
       if(node.left==null && node.right==null && Character.isLetter(node.c))
       {
    	   System.out.println(node.c+"  "+s);
       }
       printHuffmanCoding(node.left,s+"0");
       printHuffmanCoding(node.right,s+"1");
		
	}

}

class compareNode implements Comparator<HuffmanNode> {

	@Override
	public int compare(HuffmanNode n0, HuffmanNode n1) {
		return n0.data - n1.data;
	}

}

class HuffmanNode {
	int data;
	char c;
	HuffmanNode left, right;

	public HuffmanNode(int data, char c) {
		this.left = null;
		this.right = null;
		this.data = data;
		this.c = c;

	}

}
