	package DynamicProgramming;
	
	import java.util.ArrayList;
	import java.util.Arrays;
	import java.util.Collections;
	
	public class FindMinimumNumberOfCoinsThatMakeAGivenValue {
		// static int min=Integer.MAX_VALUE;
	
		public static void main(String[] args) {
	
			int coins[] = { 9, 6, 5, 1 };
			int m = coins.length;
			int V = 11;
			System.out.println("Minimum coins required is " + minCoins(coins, m, V));
	
		}
	
		private static int minCoins(int[] coins, int m, int v) {
			if (v <= 0)
				return 0;
	
			int res = Integer.MAX_VALUE;
	
			for (int i = 0; i < m; i++) {
	
				if (coins[i] <= v) {
					int temp = minCoins(coins, m, v - coins[i]);
					// System.out.println("temp= "+temp);
					if (1 + temp < res)
						res = 1 + temp;
				}
	
			}
	
			return res;
	
		}
	}
