package BitAlgorithm;

public class FindWhetherAGivenNumberIsaPowerOf4OrNot {
	public static void main(String[] args) {
		int test_no = 342;
		if (isPowerOfFour(test_no) == 1)
			System.out.println(test_no + " is a power of 4");
		else
			System.out.println(test_no + "is not a power of 4");

	}

	private static int isPowerOfFour(int n) {
		int count = 0;

		int x = n & (n - 1);

		if (n > 0 && x == 0) {
			while (n > 1) {
				n >>= 1;

				count++;

			}

			return (count % 2 == 0) ? 1 : 0;

		}

		return 0;

	}
}
