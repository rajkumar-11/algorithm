package SearchingAndSorting;

public class MergeSortForLinkedLists {
	public static void main(String[] args) {
		LinkedList1 list = new LinkedList1();
		list.push(15);
		list.push(10);
		list.push(5);
		list.push(20);
		list.push(3);
		list.push(2);
		System.out.println("Linked list without sorting is : ");
		list.printList(list.head);

		list.head = list.mergeSort(list.head);
		System.out.println("Sorted linked list is ");

		list.printList(list.head);

	}
}
