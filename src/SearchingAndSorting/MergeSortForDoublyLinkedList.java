package SearchingAndSorting;

public class MergeSortForDoublyLinkedList {
	public static void main(String[] args)
	{
		DoublyLinkedList list = new DoublyLinkedList();
		list.push(list.head, 10);
		list.push(list.head, 30);
		list.push(list.head, 3);
		list.push(list.head, 4);
		list.push(list.head, 20);
		list.push(list.head, 5);

		list.print(list.head);
		
		list.head=list.mergeSort(list.head);
		
		System.out.println("After sorting");

		list.print(list.head);
		

	}
}
