package Array;

public class countInversionsInAnArray {
	public static void main(String[] args) {
		int arr[] = new int[] {1, 20, 6, 4, 5,1,3,4,21,31,1,67};
		System.out.println("Number of inversions are " + mergeSort(arr, 12));
		for (int x=0;x<12;x++)
		{
			System.out.print(arr[x]+" ");
		}
	}

	private static int mergeSort(int[] arr, int i) {
		int l = arr.length;
		System.out.println("length= " + l);
//		int inv = 0;
		
		

		return _mergeSort(arr, 0, l - 1);
	}

	private static int _mergeSort(int[] arr, int l, int r) {
		int inv=0;
		
		if (l < r) {
			int mid = l + (r - l) / 2;
			inv += _mergeSort(arr, l, mid);
			inv += _mergeSort(arr, mid + 1, r);

			inv+= merge(arr, l, mid + 1, r);

		}

		return inv;
	}

	private static int merge(int[] arr, int l, int mid, int r) {
		int[] temp = new int[r - l + 1];

		int i = l;
		int j = mid;
		int k = 0;
		int inv=0;

//		System.out.println("l= " + l + " r=" + r + " mid= " + mid);

		while (i < mid && j <= r) {
			if (arr[i] <= arr[j]) {
				temp[k++] = arr[i++];

			} else {
				temp[k++] = arr[j++];
				inv += (mid - i);
			}
		}
		while (i < mid) {
			temp[k++] = arr[i++];
//			inv += (mid - i);

		}
		while (j <= r) {
			temp[k++] = arr[j++];
		}
		int y = 0;
		for (int x = l; x <= r; x++) {
			arr[x] = temp[y++];

		}

		return inv;
	}

}
