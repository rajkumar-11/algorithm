package PatternSearching;

public class RabinKarp {

	static int d = 256;

	public static void main(String[] args) {
		String txt = "GEEKS FOR GEEKS";
		String pat = "GEEK";
		int q = 101; // A prime number
		search(pat, txt, q);

	}

	private static void search(String pat, String txt, int q) {
		int M = pat.length();
		int N = txt.length();

		if (N < M)
			return;
		long p = 0;
		long t = 0;

		for (int i = 0; i < M; i++) {
			p += (long) ((pat.charAt(i)) * Math.pow(q, i));
			t += (long) ((txt.charAt(i)) * Math.pow(q, i));

		}

		for (int i = 0; i <= N - M; i++) {

			if (p == t) {
				boolean flag = true;

				for (int j = 0; j < M; j++) {

					if (pat.charAt(j) == txt.charAt(i + j)) {
						continue;

					} else {
						flag = false;
						break;
					}

				}

				if (flag == true) {
					System.out.println("Pattern is matched at =" + (i));

				}

			}

			if (i < N - M) {
				t = (t - (txt.charAt(i))) / q + (txt.charAt(i + M)) * ((int) Math.pow(q, M - 1));
			}

		}

	}
}
