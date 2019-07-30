import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MissingCharacter {
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		String charSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";

		Map<Character, Integer> map = new HashMap<>();

//		System.out.println("length= " + charSet.length());

		for (int i = 0; i < charSet.length(); i++) {
			map.put(charSet.charAt(i), i);
		}

		int t = s.nextInt();

		for (int j = 0; j < t; j++) {
			int n = s.nextInt();

			String string = s.next();

			int length = string.length();
			int[] arr = new int[length];
			int result = 0;

			for (int i = length - 1; i >= 0; i--)
			{
				if ((length - i) % 2 != 0) {
					arr[i] = 2 * map.get(string.charAt(i));

				} else {
					arr[i] = map.get(string.charAt(i));

				}
				if (arr[i] >= 64) {
					int x = arr[i] % 64;
					int y = arr[i] / 64;
					arr[i] = x + y;
				}
//				System.out.println("arr[i]= "+arr[i]);

				result += arr[i];
				result = result % 64;

			}
//			System.out.println("result= " + result);
			
			if(result==0)
			{
				System.out.println("A");
			}
			else
			{
			System.out.println(charSet.charAt(64 - result));
			}

		}

	}
}
