package DynamicProgramming;

public class BinomialCoefficient {
	public static void main(String[] args) {
		int n = 10, k = 5;
		System.out.printf("Value of C(%d, %d) is %d ", n, k, binomialCoeff(n, k));
	}

	private static int binomialCoeff(int n, int k) {

		if (k == n || k == 0)
			return 1;
		
		
		else
			return binomialCoeff(n-1,k-1)+binomialCoeff(n-1,k);
	}

}
