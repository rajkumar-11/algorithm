package Misc;

import java.util.Arrays;

public class LexicographicallyMinimumStringRotation {
	public static void main(String[] args) {
		char[] arr = "BCABDADAB".toCharArray();

		System.out.println(minLexRotation("BCABDADAB", arr));

	}

	private static String minLexRotation(String string, char[] arr) {
		int n = string.length();
		String[] strarr = new String[n];

		String str = string + string;

		System.out.println(str);

		for (int i = 0; i < n; i++)
		{
			strarr[i] = str.substring(i, i + n - 1);
		}

		Arrays.sort(strarr);

		return strarr[0];
	}
}
