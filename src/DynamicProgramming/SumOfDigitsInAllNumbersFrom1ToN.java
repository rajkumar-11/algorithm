package DynamicProgramming;

public class SumOfDigitsInAllNumbersFrom1ToN {
	public static void main(String[] args) {
		int n = 328;
		System.out.println("Sum of digits in numbers  " + sumOfDigitsFrom1ToN(n));

	}

	private static int sumOfDigitsFrom1ToN(int n) {
		if (n <= 9)
			return (n * (n + 1)) / 2;
		int d = 0;
		int num = n;
		while (num > 0) {
			num = num / 10;
			d++;

		}
		int[] arr = new int[d + 1];

		arr[1] = 45;
		int p = (int) Math.pow(10, d - 1);

		int msd = n / p;

		for (int i = 2; i <= d; i++) {
			arr[i] = arr[i - 1] * 10 + 45 * ((int) Math.pow(10, i - 1));

		}
		System.out.println("msd= " + msd);

		return msd * arr[d - 1] + (((msd) * (msd - 1)) / 2) * p + (((n % p) + 1) * msd) + sumOfDigitsFrom1ToN(n % p);

	}
}
