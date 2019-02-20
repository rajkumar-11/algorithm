package PatternSearching;

public class OptimizedNaiveAlgorithmForPatternSearching {
	public static void main(String[] args) {
		char txt[] = "ABCEABCDABCEABCD".toCharArray();
		char pat[] = "ABCD".toCharArray();
		search(pat, txt);

	}

	private static void search(char[] pat, char[] txt) {
		int N = txt.length;
		int M = pat.length;

		int i = 0;

		while (i <= N - M)
		{
//			System.out.println();
			
			int j;
			for (j = 0; j < M; j++) 
			{
				if (pat[j] != txt[i + j]) 
				{
					break;
				}

			}
			if (j == M) {

				System.out.println("Pattern is matched at  " + i);

				i = i + M;

			}

			else if (j == 0) {
				i = i + 1;
			} else {
				i = i + j;
			}

		}

	}
}
