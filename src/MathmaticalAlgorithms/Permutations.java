package MathmaticalAlgorithms;

public class Permutations {

	public static void main(String[] args) {
		String str = "ABCD";
		int n = str.length();
		char[] arr = str.toCharArray();
		// System.out.println("n= "+n);
		permute(arr, 0, n - 1);
	}

	private static void permute(char[] arr, int l, int r) {

		// System.out.println(String.valueOf(arr)+" ");

		if (l == r) {
			System.out.println(String.valueOf(arr) + " ");
		}
		else
		{
		for (int i = l; i <= r; i++) {
			swap(arr, i, l);
			permute(arr, l + 1, r);
//			System.out.println("i= " + i + "v= " + r);

			swap(arr, i, l);

		}
		}
	}

	private static void swap(char[] arr, int i, int j) {
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;

	}

}
