package SearchingAndSorting;

public class InsertionSortForSinglyLinkedList {
	static Node front;

	public static void main(String[] args) {
		LinkedList1 list = new LinkedList1();
		list.push(5);
		list.push(20);
		list.push(4);
		list.push(3);
		list.push(30);
		System.out.println("Linked List before Sorting..");
		list.printList(list.head);
		list.head = insertionSort(list.head);
		System.out.println("\nLinkedList After sorting");
		list.printList(list.head);

	}

	private static Node insertionSort(Node head) {
		front = null;
		Node current = head;

		while (current != null) {

			Node next = current.next;

			sortedInsert(current);

			current = next;

		}
		head = front;

		return head;
	}

	private static void sortedInsert(Node newNode) {
		if (front == null || front.data >= newNode.data) {
			newNode.next = front;
			front = newNode;

		} else {
			Node curr = front;
			while (curr.next != null && curr.next.data < newNode.data) {
				curr = curr.next;
			}
			newNode.next = curr.next;
			curr.next = newNode;

		}

	}
}
