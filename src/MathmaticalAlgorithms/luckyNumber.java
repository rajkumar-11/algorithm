package MathmaticalAlgorithms;

public class luckyNumber {
	public static int counter = 2;

	public static void main(String[] args) {
		int n = 19;
		if (islucky(n))
			System.out.println("yes the number is lucky");
		else
			System.out.println("no the number is not lucky");

	}

	private static boolean islucky(int n) {

		if (counter > n) {
			return true;
		} else if (n % counter == 0)
			return false;

		n = n - (n / counter);
		counter++;

		return islucky(n);

	}
}
