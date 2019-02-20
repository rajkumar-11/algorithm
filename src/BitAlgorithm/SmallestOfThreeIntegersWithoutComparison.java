package BitAlgorithm;

public class SmallestOfThreeIntegersWithoutComparison {
	public static void main(String[] args) {
		int x = 12, y = 15, z = 235;

		System.out.printf("Minimum of 3" + " numbers is %d", smallest2nd(x, y, z));

	}

	private static int smallest2nd(int x, int y, int z) {

		if ((x / z != 0)) {
			return (z / y) != 0 ? y : z;

		} else {
			return (x / y) != 0 ? y : x;

		}

		// return 0;
	}

	private static int smallest(int x, int y, int z) {
		// int c=0;

		return min(x, min(y, z));
	}

	private static int min(int x, int y) {
		return y + ((x - y) & ((x - y) >> (64 - 1)));
	}

}
