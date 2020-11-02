
public class SieveOfEratosthenes {
	public static void main(String[] args) {
		int n = 10000;
		sieveOfEratosthenes(n);

	}

	private static void sieveOfEratosthenes(int n) {
		boolean[] prime = new boolean[n + 1];

		for (int p = 2; p * p <= n; p++) {
			if (prime[p] == false) {
				// System.out.println("p= "+p);
				int x = 2;
				for (int i = 2; i * p <= n;) {

					prime[i * p] = true;
					i++;
				}

			}

		}

		for (int i = 1000; i <= n; i++) {
			if (prime[i] == false)
				System.out.println(i);
		}

	}
}
