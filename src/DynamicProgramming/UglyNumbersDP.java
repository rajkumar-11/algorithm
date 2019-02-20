package DynamicProgramming;

public class UglyNumbersDP {
	public static void main(String[] args) {
		int no = getNthUglyNo(150);
		System.out.println("150th ugly " + "no. is " + no);
	}

	private static int getNthUglyNo(int n) {
		int[] dp = new int[n];

		int i2 = 0, i3 = 0, i5 = 0;

		int count = 1;
		int next_multiple_2 = 2;
		int next_multiple_3 = 3;
		int next_multiple_5 = 5;

		dp[0] = 1;

		int x = 1;

		while (count < n) {
			x = min(next_multiple_2, next_multiple_3, next_multiple_5);
//			System.out.println("x= " + x);

			dp[count] = x;
			if (x == next_multiple_2) {

				i2 = i2 + 1;
				next_multiple_2 = dp[i2] * 2;

			}

			if (x == next_multiple_3) {

				i3 = i3 + 1;
				next_multiple_3 = dp[i3] * 3;

			}

			if (x == next_multiple_5) {

				i5 = i5 + 1;
				next_multiple_5 = dp[i5] * 5;

			}
			count = count + 1;
		}
		return x;
	}

	private static int min(int next_multiple_2, int next_multiple_3, int next_multiple_5) {
		return Math.min(next_multiple_2, Math.min(next_multiple_3, next_multiple_5));
	}
}
