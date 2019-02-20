package PatternSearching;

public class SearchingForPatterns {

	public static void main(String[] args) {
		String txt = "AAABAA";
		String pat = "AABA";
		search(txt, pat);
	}

	private static void search(String txt, String pat) {

		for (int i = 0; i <= txt.length() - pat.length(); i++) {
			boolean flag = true;

			for (int j = 0; j < pat.length(); j++) {
				if (txt.charAt(i + j) == pat.charAt(j)) {
					continue;
				} else {
					flag = false;
					break;
				}

			}
			// System.out.println("flag= "+flag);
			if (flag == true) {
				System.out.println("At the position = " + i);
			}

		}

	}

}
