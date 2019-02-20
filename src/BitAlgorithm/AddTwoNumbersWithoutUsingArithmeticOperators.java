package BitAlgorithm;

public class AddTwoNumbersWithoutUsingArithmeticOperators {
	public static void main(String[] args) {
		System.out.println(Add(15, 32));

	}

	private static int Add(int x, int y) {

		while (y != 0) {
			int carry = x & y;

			x = x ^ y;

			y = carry << 1;

		}

		return x;
	}
}
