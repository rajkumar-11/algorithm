package PatternSearching;

public class KMP {
	public static void main(String[] args) {
		String txt = "ABABDABACDABABCABAB";
		String pat = "ABABCABAB";

		searching(txt, pat);

	}

	private static void searching(String txt, String pat) {
		int N = txt.length();
		int M = pat.length();

		int[] lps = new int[M];

		fillLps(pat, M, lps);

		int i = 0;

		int j = 0;

		for (int x = 0; x < M; x++) {
			System.out.print(lps[x] + " ");

		}

		while (i < N) {
			// System.out.println("here");

			if (pat.charAt(j) == txt.charAt(i)) {
				i++;
				j++;

			}

			if (j == M) {
				System.out.println("found pattern at index =" + (i - j));
				j = lps[j - 1];
			} else if (i < N && pat.charAt(j) != txt.charAt(i)) {
				if (j != 0) {
					j = lps[j - 1];
				} else
					i = i + 1;

			}

		}

	}

	private static void fillLps(String pat, int m, int[] lps) {
		int i = 1;

		lps[0] = 0;
		int len = 0;

		while (i < m) {
			if (pat.charAt(i) == pat.charAt(len)) {
				len++;
				lps[i] = len;
				i++;

			} else {
				if (len != 0) {
					len = lps[len - 1];

				} else {
					lps[i] = 0;
					i++;

				}

			}

		}

	}
}
