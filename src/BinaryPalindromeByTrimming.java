import java.util.Arrays;

public class BinaryPalindromeByTrimming {
	public static void main(String[] args) {
		int n = 10, k =4;

		palindrome(n, k);

	}

	private static void palindrome(int n, int k) {
		int[] arr = new int[n];

		arr[0] = 1;
		arr[n - 1] = 1;

		int x = (n % k) - 1;

		for(int y=k;y<n;)
		{
			arr[y]=1;
			y=y+k;
		}
		
		while (x < n && x>0) {
			arr[x] = 1;
			x = x + k;
		}
		System.out.println(Arrays.toString(arr));

	}
}
