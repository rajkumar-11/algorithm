package SearchingAndSorting;

import java.util.Arrays;
import java.util.Scanner;

public class InsertionSortAdvancedAnalysis {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int t = s.nextInt();
		for (int k = 0; k < t; k++) {
			int n = s.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = s.nextInt();
			}
			long result = 0;

//			System.out.println(result);
			result += mergeSort(arr, 0, n - 1);
			System.out.println(result);
		}

	}

	private static long mergeSort(int[] arr, int l, int r)
	{
		long result = 0;
		if (l < r) {

			int mid = l + (r - l) / 2;
			result += mergeSort(arr, l, mid);
			result += mergeSort(arr, mid + 1, r);
			result += merge(arr, l, mid + 1, r);
			// return result;

		}
		return result;
	}

	private static long merge(int[] arr, int l, int mid, int r) {
		int index = l;
		int n1 = mid - l;
		int n2 = r - mid+1;
//		System.out.println("here32sdfa");
		int[] arr1 = new int[n1];
		int[] arr2 = new int[n2];
		long result = 0;

		for (int i = 0; i < n1; i++) {
			arr1[i] = arr[l+i];
		}
		for (int i = 0; i < n2; i++) {
			arr2[i] = arr[mid + i];
		}

//		System.out.println(Arrays.toString(arr1));
//		System.out.println(Arrays.toString(arr2));
		int i = 0;
		int j = 0;
//		 System.out.println("n1= " + n1 + " n2= " + n2);
		while (i < n1 && j < n2) {
			if (arr1[i] <= arr2[j]) {
				arr[index] = arr1[i];
				index++;
				i++;
				// result++;
			} else {
//				System.out.println("here");
				arr[index] = arr2[j];
				j++;
				index++;
				result += n1 - i;
			}

		}
		if (i < n1) {
			while (i < n1) {
				arr[index++] = arr1[i++];
			}
		}
		if (j < n2) {
			while (j < n2) {
				arr[index++] = arr2[j++];
			}
		}

		// for (int x = l; x <= r; x++) {
		// System.out.print(arr[x] + " ");
		// }
		// System.out.println();
//		System.out.println("result= " + result);

		return result;
	}

}
