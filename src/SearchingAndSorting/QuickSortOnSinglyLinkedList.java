package SearchingAndSorting;

public class QuickSortOnSinglyLinkedList {
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.push(5);
		list.push(20);
		list.push(4);
		list.push(3);
		list.push(30);

		System.out.println("Linked List Before sorting");

		list.printList(list.head);

		System.out.println();
		Node end = getEnd(list.head);

		list.head = quicksort(list.head, end);

		System.out.println("LinkedLista After Sorting");

		list.printList(list.head);

	}

	private static Node getEnd(Node head) {
		if (head == null)
			return null;

		while (head.next != null) {
			head = head.next;
		}

		return head;
	}

	private static Node quicksort(Node head, Node end) {

		if (head == null || head == end)
			return head;

		Node newHead = null, newEnd = null;

		Node[] nodes = partition(head, end, newHead, newEnd);

		Node pivot = nodes[0];
		newHead = nodes[1];
		newEnd = nodes[2];
		// System.out.println("newHead " + newHead);
		// System.out.println("newEnd " + newEnd);
		if (newHead != pivot) {
			Node temp = newHead;

			// System.out.println(temp);
			while (temp.next != pivot) {
				temp = temp.next;
			}
			temp.next = null;
			newHead = quicksort(newHead, temp);

			temp = getEnd(newHead);
			temp.next = pivot;

		}
		pivot.next = quicksort(pivot.next, newEnd);

		return newHead;

	}

	private static Node[] partition(Node head, Node end, Node newHead, Node newEnd) {
		Node prev = null;
		Node[] nodelist = new Node[3];

		Node pivot = end;

		Node cur = head;

		Node tail = pivot;

		while (cur != pivot) {
			if (cur.data < pivot.data) {
				if (newHead == null) {
					newHead = cur;

				}
				prev = cur;
				cur = cur.next;

			} else {
				if (prev != null) {
					prev.next = cur.next;
				}
				Node temp = cur.next;
				cur.next = null;
				tail.next = cur;
				tail = cur;
				cur = temp;

			}

		}
		if (newHead == null)
			newHead = pivot;

		newEnd = tail;

		// System.out.println("newHead= " + newHead.data);
		// System.out.println("newTail= " + newEnd.data);

		nodelist[0] = pivot;
		nodelist[1] = newHead;
		nodelist[2] = newEnd;

		return nodelist;
	}

}
