package SearchingAndSorting;

import java.util.Stack;

public class IterativeQuickSort {
	public static void main(String[] args) {
		int arr[] ={4, 3, 5, 2, 1, 3, 2, 3}; 
		int n = 8;

		// Function calling
		quickSortIterative(arr, 0, n - 1);

		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}

	}

	private static void quickSortIterative(int[] arr, int l, int h) {
		Stack<Integer> stack = new Stack<>();
		stack.add(l);
		stack.add(h);

		while (!stack.isEmpty()) {

			int upper = stack.pop();
			int lower = stack.pop();
//			System.out.println("lower =" + lower + "upper = " + upper);
			int p = partition(arr, lower, upper);

			if (p - 1 > lower) {
				stack.add(lower);
				stack.add(p - 1);
			}
			if (p + 1 < upper) {
				stack.add(p + 1);
				stack.add(upper);
			}

		}

	}

	private static int partition(int[] arr, int l, int h) {
		int j = l;
		int pivot = arr[h];

		if (l < h) {
			for (int i = l; i < h; i++) {
				if (arr[i] < pivot) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;

					j++;
//					i--;

				}

			}

		}
//		System.out.println("j= "+j);
		
		int temp = arr[j];
		arr[j] = arr[h];
		arr[h] = temp;

		return j;
	}
}
