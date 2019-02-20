package DynamicProgramming;

import java.util.Arrays;

public class FindMinimumNumberOfCoinsThatMakeAGivenValueUsingDP {
	public static void main(String[] args) {

		int coins[] = { 9, 6, 5, 1 };
		int m = coins.length;
		int V = 11;
		System.out.println("Minimum coins required is " + minCoins(coins, m, V));

	}

	private static int minCoins(int[] coins, int m, int v) {
		int[] value = new int[v + 1];

		Arrays.fill(value, Integer.MAX_VALUE);

		value[0] = 0;

		for (int i = 1; i <= v; i++) {
			for (int j = 0; j < m; j++) {
				if (coins[j] <= i) {
					value[i] = Math.min(value[i], 1 + value[i - coins[j]]);

				}

			}

		}

		// for(int i=0;i<=v;i++)
		// {
		// System.out.print(value[i]+" ");
		// }

		return value[v];
	}

}
