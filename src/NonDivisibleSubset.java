import java.util.Arrays;
import java.util.Scanner;

public class NonDivisibleSubset {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int k = s.nextInt();
		int[] count = new int[k];
		for (int i = 0; i < n; i++) {
			int x = s.nextInt();
			count[x % k]++;
		}
		// System.out.println(Arrays.toString(count));

		int result = Math.min(1, count[0]);

		for (int i = 1; i <= k / 2; i++) {
			if (i != k - i) {
				result += Math.max(count[i], count[k - i]);
			}
		}
		if(k%2==0 && count[k/2]>0)
		{
			result+=1;
		}
		System.out.println(result);

	}
}
