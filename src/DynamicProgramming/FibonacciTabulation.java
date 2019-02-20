package DynamicProgramming;

public class FibonacciTabulation {
	public static void main(String[] args) 
	{
		int n = 21;
		int[] arr = new int[n + 1];
		arr[1] = 0;
		arr[2] = 1;

		System.out.println(fibonnaci(arr, n, 3));

	}

	private static int fibonnaci(int[] arr, int n, int i)
	{
		for (; i <= n; i++) {
			arr[i] = arr[i - 1] + arr[i - 2];
//			System.out.println(arr[i]);

		}

		return arr[n];
	}
}
