package BackTracking;

public class tugOfWar {
	static int[] result = new int[11];
	static int minDiff = Integer.MAX_VALUE;

	public static void main(String[] args) {
		int arr[] = { 23, 45, -34, 12, 0, 98, -99, 4, 189, -1, 4 };
		tugOfwar(arr, 0, 11);

		System.out.println("min diff= " + minDiff);
		for (int i = 0; i <= 5; i++) {
			System.out.print(result[i] + " ");
		}
		System.out.println();

		for (int i = 6; i < 11; i++) {
			System.out.print(result[i] + " ");
		}

	}

	private static void tugOfwar(int[] arr, int l, int r) {
		if (l == r) {
			int diff = arr[0] + arr[1] + arr[2] + arr[3] + arr[4] + arr[5] - arr[6] - arr[7] - arr[8] - arr[9]
					- arr[10];

			if (Math.abs(diff) < minDiff) {
				minDiff = diff;

				for (int x = 0; x < 11; x++) {
					result[x] = arr[x];
				}

			}

			return;

		}

		for (int i = l; i < r; i++) {
			swap(arr, i, l);
			tugOfwar(arr, l + 1, r);
			swap(arr, l, i);

		}

	}

	private static void swap(int[] arr, int i, int l) {
		int temp = arr[i];
		arr[i] = arr[l];
		arr[l] = temp;

	}
}
