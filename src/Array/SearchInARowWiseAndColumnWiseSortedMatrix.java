package Array;

public class SearchInARowWiseAndColumnWiseSortedMatrix {
	public static void main(String[] args) {
		int mat[][] = { { 10, 20, 30, 40 }, { 15, 25, 35, 45 }, { 27, 29, 37, 48 }, { 32, 33, 39, 50 } };

		search(mat, 4, 38);

	}

	private static void search(int[][] mat, int n, int k) {
		if (mat[0][0] > k)
			System.out.println("Not possible");

		if (mat[n - 1][n - 1] < k)
			System.out.println("Not possible");

		for (int i = 0; i < n - 1; i++) {
			if (mat[i + 1][i + 1] >= k && mat[i][i] <= k) {
				for (int j = i; j < n; j++) {
					if (mat[i][j] == k) {
						System.out.println("found at indexes " + i + ", " + j);
						return;
					}

				}
				for (int j = i; j < n; j++) {
					if (mat[j][i] == k) {
						System.out.println("found at indexes " + i + ", " + j);
						return;
					}

				}

			}

		}
		System.out.println("sorry was not able to find");

	}
}
