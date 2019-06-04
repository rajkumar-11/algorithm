package SearchingAndSorting;

public class LinkedList1 {
	Node head;

	public LinkedList1() {
		this.head = null;

	}

	public void push(int i) {
		Node node = new Node(i);

		node.next = head;

		head = node;

	}

	public void printList(Node node) {
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;

		}

	}

	public Node mergeSort(Node head) {
		if (head == null || head.next == null)
			return head;

		Node middle = getMiddle(head);

		Node nextOfMiddle = middle.next;

		middle.next = null;

		Node left = mergeSort(head);

		Node right = mergeSort(nextOfMiddle);

		Node sortedList = SortedMerge(left, right);

		return sortedList;
	}

	private Node SortedMerge(Node a, Node b) {
		Node result = null;

		if (a == null)
			return b;

		if (b == null)
			return a;

		if (a.data <= b.data) {
			result = a;
			a.next = SortedMerge(a.next, b);
		} else {
			result = b;
			b.next = SortedMerge(a, b.next);

		}

		return result;
	}

	private Node getMiddle(Node head) {
		if (head == null)
			return null;

		Node prev = head;
		Node node = head.next;

		while (node != null) {
			node = node.next;

			if (node != null) {
				node = node.next;
				prev = prev.next;

			}

		}

		return prev;
	}

}
