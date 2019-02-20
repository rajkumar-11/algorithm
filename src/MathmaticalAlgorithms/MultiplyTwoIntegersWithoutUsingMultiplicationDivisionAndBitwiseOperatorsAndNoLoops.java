package MathmaticalAlgorithms;

public class MultiplyTwoIntegersWithoutUsingMultiplicationDivisionAndBitwiseOperatorsAndNoLoops {

	public static void main(String[] args) {

		System.out.print(multiply(5, -11));

	}

	private static int multiply(int x, int y) {
		if (y == 0)
			return 0;

		if (y > 0) {
			return x + multiply(x, y - 1);
		} else {
			return -multiply(x, -y);

		}
	}
}
