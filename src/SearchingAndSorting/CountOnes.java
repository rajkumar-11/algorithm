package SearchingAndSorting;

public class CountOnes {
	public static void main(String[] args) {
		int arr[] = {1,0,0,0, 0, 0, 0 };
		int n = arr.length;
		System.out.println("Count of 1's in given array is " + countOnes(arr, 0, n - 1));

	}

	private static int countOnes(int[] arr, int low, int high) {
		if (low <= high) {
			int mid = low+((high-low)/2);

			if ((mid == high || arr[mid + 1] == 0) && arr[mid] == 1) {
				return mid + 1;
			}
			if (arr[mid] == 1)
				return countOnes(arr,mid+1,high);

			return countOnes(arr, low, mid - 1);

		}

		return 0;
	}
}
