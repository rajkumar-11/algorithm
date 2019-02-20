package MathmaticalAlgorithms;

public class NumberIsMultipleOf3 {
	public static void main(String[] args) {
		int num = 612;

		if (isMultipleOf3(num)) {
			System.out.println("yes multiple of 3");

		} else {
			System.out.println("Not a multiple");
		}

	}

	private static boolean isMultipleOf3(int num) {

		if (num < 0)
			num = num * -1;

		if (num == 0)
			return true;
		else if (num == 1)
			return false;

		int oddCount = 0, even_count = 0;

		while (num > 0) {
			if ((num & 1) == 1)
				oddCount++;
			num = num >> 1;
			if ((num & 1) == 1)
				even_count++;
		}
		if (Math.abs(oddCount - even_count) % 3 == 0)
			return true;
		return false;

	}

}
