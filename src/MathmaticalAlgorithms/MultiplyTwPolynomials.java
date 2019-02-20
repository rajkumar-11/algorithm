package MathmaticalAlgorithms;

public class MultiplyTwPolynomials {
	public static void main(String[] args) {
		int A[] = { 5, 0, 10, 6 };
		int B[] = { 1, 2, 4 };

		multiply(A, B);

	}

	private static void multiply(int[] a, int[] b) {
		int l1 = a.length;
		int l2 = b.length;

		System.out.println("l1= " + l1);
		System.out.println("l2= " + l2);

		int l = l1 + l2 - 2;

		int[] c = new int[l + 1];

		for (int i = 0; i <= l1 - 1; i++) {
			for (int j = 0; j <= l2 - 1; j++) {
				c[i + j] += a[i] * b[j];

			}

		}
		for (int i = 0; i <= l; i++) {
			System.out.print(c[i] + " ");
		}

	}

}
