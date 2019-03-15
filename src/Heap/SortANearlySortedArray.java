package Heap;

import java.util.Arrays;

public class SortANearlySortedArray {
	public static void main(String[] args) {
		int k = 3;
		int arr[] = { 6, 5, 3, 2, 8, 10, 9 };
		int n = arr.length;
		// System.out.println("n= "+n);
		sortK(arr, n, k);

		for (int i : arr) {
			System.out.print(i + " ");
		}

	}

	private static void sortK(int[] arr, int n, int k) {
		int[] temp = new int[k + 1];

		for (int i = 0; i <= k; i++) {
			temp[i] = arr[i];
		}
		for (int i = k / 2; i >= 0; i--) {
			heapify(temp, i, k + 1);
		}

		System.out.println(Arrays.toString(temp));
		int index = 0;
		for (int i = k + 1; i < n; i++) {
			arr[index++] = replaceAndExtract(temp, arr[i], k + 1);

		}
		for (int i = 0; i <= k; i++) {
			arr[index++] = extractmin(temp, k + 1 - i);

			// System.out.println(Arrays.toString(temp));
			// System.out.println("i+k= "+(i+k));
		}
	}

	private static int extractmin(int[] temp, int n) {
		int x = temp[0];
		temp[0] = temp[n - 1];
		heapify(temp, 0, n - 1);
		System.out.println("extractmin " + x);
		return x;
	}

	private static int replaceAndExtract(int[] temp, int value, int n) {
		int x = temp[0];
		temp[0] = value;
		heapify(temp, 0, n);
		System.out.println("replaceAndExtract " + x);

		return x;
	}

	private static void heapify(int[] temp, int i, int k) {
		int r = right(i);
		int l = left(i);
		// System.out.println("l= " + l + " r= " + r);
		int smallest = i;
		if (l < k && temp[l] < temp[i]) {
			smallest = l;
		}
		if (r < k && temp[r] < temp[smallest]) {
			smallest = r;
		}

		if (smallest != i) {
			int x = temp[i];
			temp[i] = temp[smallest];
			temp[smallest] = x;
			// System.out.println("smallest =" + smallest);
			heapify(temp, smallest, k);
		}

	}

	private static int left(int i) {
		return (2 * i) + 1;
	}

	private static int right(int i) {
		return (2 * i) + 2;
	}

}
