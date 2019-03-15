package Array;

public class SearchAnElementInASortedAndRotatedArray
{
	public static void main(String[] args) 
	{
		int arr1[] = { 5, 6, 7, 8, 9, 10, 1, 2, 3};
		int n = arr1.length;
		int key = 30;
		System.out.println("Index of the element is : " + pivotedBinarySearch(arr1, n, key));

	}

	private static int pivotedBinarySearch(int[] arr, int n, int key) 
	{
		int index = 0;
		for (int i = 0; i < n - 1; i++) 
		{
			if (arr[i + 1] < arr[i]) 
			{
				index = i;
				break;
			}
		}
		if (index == 0) {
			return getPosition(arr, n, key);
		} else {
			int[] tempArr = new int[n];
			int i = 0;
			for (int j = index + 1; j < n; j++) {
				tempArr[i] = arr[j];
				i += 1;
			}
			for (int j = 0; j < index; j++) {
				tempArr[i] = arr[j];
				i += 1;
			}
			int x = getPosition(tempArr, n, key);
			if(x==-1)
				return -1;
			return (x + (index + 1)) % n;

		}
	}

	private static int getPosition(int[] arr, int n, int key) {
		int l = 0, r = n - 1;
		while (l < r) {
			int mid = l + (r - l) / 2;
			if (arr[mid] == key)
				return mid;
			else if (arr[mid] < key) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}

		}
//		System.out.println("here");

		return -1;
	}
}
