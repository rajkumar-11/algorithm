package SearchingAndSorting;

public class DoublyLinkedList {
	DoubleNode head;

	public DoublyLinkedList() {
		this.head = null;

	}

	public void push(DoubleNode head, int i) {

		DoubleNode node = new DoubleNode(i);
		node.next = head;
		this.head = node;

		// return node;
	}

	public void print(DoubleNode head) {
		while (head.next != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println();
	}

	public DoubleNode mergeSort(DoubleNode node) {
		if (node == null || node.next == null) {
			return node;
		}
		DoubleNode second = split(node);
		
		node=mergeSort(node);
		second=mergeSort(second);
		

		return merge(node,second);
	}

	private DoubleNode merge(DoubleNode first,DoubleNode second)
	{
	  if(first==null)
	  { return second;
	  }
	  if(second==null)
	  {
		  return first;
	  }
	  if (first.data < second.data) { 
          first.next = merge(first.next, second); 
          first.next.prev = first; 
          first.prev = null; 
          return first; 
      } else { 
          second.next = merge(first, second.next); 
          second.next.prev = second; 
          second.prev = null; 
          return second; 
      } 
	  
		
		
//		return null;
	}

	private DoubleNode split(DoubleNode node) {
		DoubleNode slow = node, fast = head;

		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;

		}
		DoubleNode temp = slow.next;
		slow.next = null;

		return temp;
	}

}
