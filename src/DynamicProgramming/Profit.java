package DynamicProgramming;

import java.util.Arrays;

public class Profit {
	public static void main(String[] args) {
		int price[] = { 2, 30, 15, 10, 8, 25, 80 };
		int n = price.length;
		System.out.println("Maximum Profit = " + maxProfit(price, n));

	}

	private static int maxProfit(int[] price, int n) {
		int[] profit = new int[n];

		Arrays.fill(profit, 0);

		int max = price[n - 1];

		for (int i = n - 2; i >= 0; i--) {
			if (price[i] > max) {
				max = price[i];

			}

			profit[i] = Math.max(profit[i + 1], (max - price[i]));

		}

		int min = price[0];

		for (int i = 1; i < n; i++) {
			if (min > price[i]) {
				min = price[i];

			}

			profit[i] = Math.max(profit[i - 1], (profit[i] + (price[i] - min)));

		}

		int result = profit[n - 1];

		return result;
	}
}
