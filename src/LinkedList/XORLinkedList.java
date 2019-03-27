package LinkedList;

public class XORLinkedList {
	public static void main(String[] args)
	{
      ListNode head=null;
      head=insert(head, 10);  
      head=insert(head, 20);  
      head=insert(head, 30);  
      head=insert(head, 40);  
		
	}

	private static ListNode insert(ListNode head, int i) 
	{
	    ListNode newNode=new ListNode(i);
	    newNode.npx=XOR(head,null);
		
		
		return null;
	}

	private static ListNode XOR(ListNode head, ListNode node) 
	{
		
		return null;
	}
}

class ListNode
{
	int data;
	ListNode npx;

	public ListNode(int data) {
		this.data = data;
		this.npx = null;
	}

}
