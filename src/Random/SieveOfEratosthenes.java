package Random;

public class SieveOfEratosthenes {
	public static void main(String[] args)
	{
		int n = 30;
		System.out.print("Following are the prime numbers ");
		System.out.println("smaller than or equal to " + n);
		sieveOfEratosthenes(n);

	}

	private static void sieveOfEratosthenes(int n)
	{
		int[] temp = new int[n + 1];
		
		for (int i = 2; i*i <= n; i++) 
		{
			if (temp[i] == 0) 
			{
				for (int j = 2; j <= n/i;j++ ) {
					temp[j*i] = 1;

//					J=J*2;
				}

			}

		}

		for (int i = 2; i <= n; i++) 
		{
			if (temp[i] == 0)
				System.out.print(i + " ");

		}

	}
}
