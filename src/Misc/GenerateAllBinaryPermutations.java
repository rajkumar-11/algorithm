package Misc;

public class GenerateAllBinaryPermutations {
	public static void main(String[] args) {
		generate(0, 0, "", 6);

	}

	private static void generate(int i, int j, String string, int n) {
		// System.out.println("i= "+i+"j= "+j);

		if (i + j >= n) {
			if (j >= i && j + i == n)
				System.out.println(string);
			else
				return;
		}

		generate(i, j + 1, string + "1", n);

		if (j > i)
			generate(i + 1, j, string + "0", n);

	}
}
