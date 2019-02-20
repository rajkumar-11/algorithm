package MathmaticalAlgorithms;

public class PermutationsOfAGivenString {
	public static void main(String[] args) {
		char[] arr = { 'A', 'B', 'C' };

		printpermutations(arr, 0, 2);

	}

	private static void printpermutations(char[] arr, int l, int r) {
		if (l == r) {
			System.out.println(String.valueOf(arr));

		}
		for (int i = l; i <= r; i++)
		{
			swap(arr, l, i);
			printpermutations(arr, l + 1, r);
			swap(arr, l, i);

		}

	}

	private static void swap(char[] arr, int i, int l)
	{
		char temp = arr[i];
		arr[i] = arr[l];
		arr[l] = temp;

	}
}
