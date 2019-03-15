package Heap;

import java.util.Arrays;

public class HeapSort {
	public static void main(String[] args) {

		int arr[] = { 10, 11, 1, 12, 7, 6 };
		// int n = arr.length;

		System.out.println("Before sorting");

		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
		sort(arr);

		System.out.println("After sorting");

		for (int i : arr) {
			System.out.print(i + " ");
		}

	}

	private static void sort(int[] arr) 
	{

		int n = arr.length;

		for (int i = (n / 2) - 1; i >= 0; i--) {
			Heapify(arr, i, n);
		}
		System.out.println("here= "+Arrays.toString(arr));

		for (int i = n - 1; i > 0; i--) {

			Heapify(arr, 0, i + 1);
			System.out.println(Arrays.toString(arr));
			int temp = arr[i];
			arr[i] = arr[0];
			arr[0] = temp;
//			System.out.println("After=" + Arrays.toString(arr));

		}

	}

	private static void Heapify(int[] arr, int i, int n) {
		int largest = i;

		int l = left(i);
		int r = right(i);
		// int n = arr.length;

		if (l < n && arr[l] > arr[i]) {
			largest = l;
		}

		if (r < n && arr[r] > arr[largest]) {
			largest = r;

		}

		if (i != largest) {
			int temp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = temp;
			Heapify(arr, largest, n);
		}

	}

	private static int right(int i) {
		return 2 * i + 2;
	}

	private static int left(int i) {
		return 2 * i + 1;
	}
}
