import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AutomaticEditing {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		Map<String, String> map = new HashMap<String, String>();
		String[] arr = new String[n];
//	System.out.println("n= "+n);
		s.nextLine();
		for (int i = 0; i < n; i++) {
			String s1 = s.nextLine();
			String s2 = s.nextLine();
//		System.out.println("s1= "+s1);
			arr[i] = s1;
			map.put(s1, s2);
		}
		String string = s.nextLine();
//	System.out.println("String= "+string);
		for (int i = 0; i < n; i++) {
			while (string.contains(arr[i])) {
				string = string.replace(arr[i], map.get(arr[i]));
//			System.out.println(string);

			}
		}
		System.out.println(string);

	}

}
