import java.util.Scanner;

public class NumberOfPies {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int t = s.nextInt();

		for (int i = 0; i < t; i++) {
			int m = s.nextInt();
			int[] arr = new int[m];

			// int m = s.nextInt();

			for (int j = 0; j < m; j++) {
				arr[j] = s.nextInt();
			}
			int n = s.nextInt();

			if (findIfPossible(arr, m, n)) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}

	}

	private static boolean findIfPossible(int[] arr, int m, int n) {

		return findIf(arr, m, n - arr[0], 1) || findIf(arr, m, n, 1);

	}

	private static boolean findIf(int[] arr, int m, int n, int j) {
		if (n == 0)
			return true;
		if (n < 0)
			return false;

		if (m == j)
			return false;

		return findIf(arr, m, n - arr[j], j + 1) || findIf(arr, m, n, j + 1);
	}
}
