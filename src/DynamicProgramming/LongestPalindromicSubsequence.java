package DynamicProgramming;

public class LongestPalindromicSubsequence {
	public static void main(String[] args) {
		String seq = "BBBBB";
		int n = seq.length();
		System.out.println("The lnegth of the lps is " + lps(seq, 0, n - 1));

	}

	private static int lps(String seq, int i, int j) {
		if (j == i)
			return 1;

		if (j - i == 1 && seq.charAt(i) == seq.charAt(j))
			return 2;

		if (seq.charAt(i) == seq.charAt(j)) {
			return lps(seq, i + 1, j - 1) + 2;
		} else
			return Math.max(lps(seq, i + 1, j), lps(seq, i, j - 1));
	}
}
