package Matrix;

import java.util.Arrays;

public class MergeKSortedArraysDifferentSizedArrays {
	public static void main(String[] args) {
		int arr[][] = { { 2, 6, 12,17,18,19,56 }, { 1, 9 }, { 23, 34, 90, 2000 } };
		printSortedArray(arr);

	}

	private static void printSortedArray(int[][] arr) {
		int k = arr.length;
		int total = 0;
		for (int i = 0; i < k; i++) {
			total += arr[i].length;
		}
		int[] result = new int[total];
		NodeMatrix[] heap = new NodeMatrix[k];
		for (int i = 0; i < k; i++) {
			heap[i] = new NodeMatrix(arr[i][0], i, 1);
		}
		for (int i = k / 2 - 1; i >= 0; i--) {
			heapify(heap, i, k);
		}
		
		
		for (int i = 0; i < total; i++) {
			result[i] = heap[0].element;

			if (heap[0].nextIndex >=arr[heap[0].index].length) {
				// heap[0].nextIndex+=1;
				replaceTopElement(heap, Integer.MAX_VALUE, k);

			} else {
				heap[0].nextIndex += 1;
				replaceTopElement(heap, arr[heap[0].index][heap[0].nextIndex - 1], k);

			}

		}
		System.out.println(Arrays.toString(result));
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

	private static void replaceTopElement(NodeMatrix[] heap, int maxValue, int k) {
		heap[0].element = maxValue;
		heapify(heap, 0, k);
	}

	private static void heapify(NodeMatrix[] heap, int index, int k) {
		int l = left(index);
		int r = right(index);
		int smallest = index;

		if (l < k && heap[l].element < heap[index].element) {
			smallest = l;
		}
		if (r < k && heap[r].element < heap[smallest].element) {
			smallest = r;
		}
		if (smallest != index) {
			NodeMatrix node = heap[smallest];
			heap[smallest] = heap[index];
			heap[index] = node;
			heapify(heap, smallest, k);
		}

	}

	private static int left(int index) {
		return 2 * index + 1;
	}

	private static int right(int index) {

		return 2 * index + 2;
	}

}
