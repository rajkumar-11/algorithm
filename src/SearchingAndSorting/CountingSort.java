package SearchingAndSorting;

public class CountingSort {
	public static void main(String[] args) {

		char arr[] = { 'g', 'e', 'e', 'k', 's', 'f', 'o', 'r', 'g', 'e', 'e', 'k', 's' };

		sort(arr);

		System.out.print("Sorted character array is ");
		for (int i = 0; i < arr.length; ++i)
			System.out.print(arr[i]);

	}

	private static void sort(char[] arr) {
		int[] count = new int[256];

		for (int i = 0; i < arr.length; i++) {
			count[arr[i]]++;

		}

		for (int i = 1; i < 256; i++) {
			count[i] += count[i - 1];
		}
//		int x = 0;

		char[] output = new char[arr.length];

		for (int i = arr.length - 1; i >= 0; i--) {
			output[count[arr[i]] - 1] = arr[i];

			count[arr[i]]--;

		}
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(output[i]+" ");
		}
		

	}
}
