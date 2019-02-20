package DynamicProgramming;

import java.util.Scanner;

public class LongestDividingSubsequence {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int n = s.nextInt();

		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = s.nextInt();

		}
		int[] dp = new int[n];

		dp[0] = 1;
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (dp[j] != 0 && arr[i] % arr[j] == 0) {
					dp[i] = Math.max(dp[i], dp[j] + 1);

				}

			}

		}
		int max = 1;

		for (int i = 0; i < n; i++) {
			if (dp[i] > max)
				max = dp[i];

		}

		System.out.println(max);

	}
}
