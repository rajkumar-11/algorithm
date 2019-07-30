package DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class SubstringDiff {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		for (int x = 0; x < t; x++) {
			int k = s.nextInt();
			String s1 = s.next();
			String s2 = s.next();
			int l = s1.length();
			int[][] arr = new int[l + 1][l + 1];
			for (int i = 0; i < l; i++) {
				for (int j = 0; j < l; j++) {
					if (s1.charAt(i) == s2.charAt(j)) {
						arr[i + 1][j + 1] = arr[i][j];
					} else {
						arr[i + 1][j + 1] = arr[i][j] + 1;
					}
				}
			}

			int low = 0;
			int high = l;
			int mid = 0;

			while (low < high) {
				mid = (low + high + 1) / 2;
				if (solve(mid, l, arr, k)) {
					low = mid;
				} else {
					high = mid - 1;
				}

			}
			System.out.println(l - low);
		}

	}

	private static boolean solve(int mid, int l, int[][] arr, int s) {
		for (int i = mid; i <= l; i++) {
			for (int j = mid; j <= l; j++) {
				int temp = arr[i][j] - arr[i - mid][j - mid];
				if (temp <= s) {
					return true;
				}
			}
		}

		return false;
	}
}
