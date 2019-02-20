package Misc;

public class CheckIfCharactersOfaGivenStringCanBeRearrangedToFormaPalindrome {
	public static void main(String[] args) {
		if (canFormPalindrome("geeksforgeeks"))
			System.out.println("Yes");
		else
			System.out.println("No");

		if (canFormPalindrome("geeksogeeks"))
			System.out.println("Yes");
		else
			System.out.println("No");

	}

	private static boolean canFormPalindrome(String string) {
		int[] charVal = new int[26];

		for (int i = 0; i < string.length(); i++)
		{
			
			charVal[string.charAt(i) - 'a']++;

		}
		int count = 0;
		int oddCount = 0;
		int evenCount = 0;

		for (int i = 0; i < 26; i++)
		{
			if (charVal[i] == 0)
				continue;
			if (charVal[i] % 2 == 1) 
			{
				oddCount++;
				count++;
			} else {
				evenCount++;
				count++;
			}

		}
		if (oddCount == 1 && count % 2 != 0)
			return true;
		else if (oddCount == 0 && count % 2 == 0)
			return true;

		return false;
	}
}
