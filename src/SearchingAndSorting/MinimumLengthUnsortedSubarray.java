package SearchingAndSorting;

import java.util.Arrays;

public class MinimumLengthUnsortedSubarray {
	public static void main(String[] args) {
		int arr[] = { 10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60, 5 };
		int arr_size = arr.length;
		printUnsorted(arr, arr_size);

	}

	private static void printUnsorted(int[] arr, int arr_size) {
		int s;
		int e;
		// System.out.println("jaoi");

		for (s = 0; s < arr_size - 1; s++) {
			if (arr[s + 1] < arr[s]) {
				// s = i;
				break;

			}

		}

		if (s == arr_size - 1) {
			System.out.println("The array is already sorted");
			return;

		}

		for (e = arr_size - 1; e > 0; e--) {
			if (arr[e - 1] > arr[e]) {
				// e = i;
				// System.out.println("arr[i]= "+arr[i] );
				break;
			}

		}
		// System.out.println("s= " + s + " e =" + e);

		int min = arr[s];
		// int index_min=0;
		int max = arr[s];

		for (int i = s; i <= e; i++) {
			if (arr[i] < min) {
				min = arr[i];

			}

			if (arr[i] > max) {
				max = arr[i];
			}

		}
		for (int i = 0; i <= s; i++) {
			if (arr[i] > min) {
				s = i;
				break;
			}

		}

		for (int i = arr_size - 1; i >= e + 1; i--) {
			if (arr[i] < max) {
				e = i;
				break;
			}

		}

		System.out.println("The smallest window is from  " + s + " to " + e);

		Arrays.sort(arr, s, e + 1);
		// Arrays.sort

		System.out.println();
		for (int i : arr) {
			System.out.print(i + " ");
		}

	}
}
