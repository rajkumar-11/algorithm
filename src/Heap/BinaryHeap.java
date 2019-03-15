package Heap;

import java.util.Arrays;

public class BinaryHeap {
	int[] arr;
	int capacity;
	int heapSize;

	public BinaryHeap(int n) {
		this.arr = new int[n];
		this.capacity = n;
		this.heapSize = 0;

	}

	public static void main(String[] args) {
		BinaryHeap heap = new BinaryHeap(11);
		heap.insert(3);
		System.out.println(Arrays.toString(heap.arr));
		heap.insert(2);
		System.out.println(Arrays.toString(heap.arr));
		heap.delete(1);
		System.out.println(Arrays.toString(heap.arr));
		heap.insert(15);
		System.out.println(Arrays.toString(heap.arr));
		heap.insert(5);
		System.out.println(Arrays.toString(heap.arr));
		heap.insert(4);
		System.out.println(Arrays.toString(heap.arr));
		heap.insert(45);
		System.out.println(Arrays.toString(heap.arr));
		System.out.println("minimum= " + heap.extractMinimum());
		// System.out.println("minimum= " + heap.getMinimum());
		heap.decreaseKey(2, 1);
		// System.out.println("minimum= " + heap.getMinimum());
		System.out.println("minimum= " + heap.extractMinimum());
		System.out.println("minimum= " + heap.extractMinimum());
		System.out.println("minimum= " + heap.extractMinimum());
		System.out.println("minimum= " + heap.extractMinimum());
		System.out.println("minimum= " + heap.extractMinimum());

	}

	private void delete(int i) {
		decreaseKey(i, Integer.MIN_VALUE);
		extractMinimum();

	}

	private void decreaseKey(int i, int j) {
		arr[i] = j;
		while (i != 0 && arr[parent(i)] > arr[i]) {
			int temp = arr[i];
			arr[i] = arr[parent(i)];
			arr[parent(i)] = temp;
			i = parent(i);

		}

	}

	private int getMinimum() {
		if (heapSize <= 0)
			return Integer.MAX_VALUE;
		return arr[0];
	}

	private int extractMinimum() {
		if (heapSize <= 0)
			return Integer.MAX_VALUE;

		if (heapSize == 1) {
			heapSize--;
			return arr[0];
		}

		int root = arr[0];
		arr[0] = arr[heapSize - 1];
		heapSize--;
		MinHeapify(0);

		return root;
	}

	private void MinHeapify(int i) {
		int l = left(i);
		int r = right(i);
		int smallest = i;
		if (l < heapSize && arr[l] < arr[i]) {
			smallest = l;
		}
		if (r < heapSize && arr[r] < arr[smallest]) {
			smallest = r;
		}
		if (smallest != i) {
			int temp = arr[i];
			arr[i] = arr[smallest];
			arr[smallest] = temp;

			MinHeapify(smallest);

		}

	}

	private int right(int i) {
		return (2 * i + 2);
	}

	private int left(int i) {

		return (2 * i + 1);
	}

	private void insert(int k) {

		if (heapSize > capacity) {
			System.out.println("Overflow:Could not insert the key");
			return;
		}
		heapSize++;

		arr[heapSize - 1] = k;
		int i = heapSize - 1;

		while (i != 0 && arr[i] < arr[parent(i)]) {
			int temp = arr[i];
			arr[i] = arr[parent(i)];
			arr[parent(i)] = temp;

		}

	}

	private int parent(int i) {

		return (i - 1) / 2;
	}

}
