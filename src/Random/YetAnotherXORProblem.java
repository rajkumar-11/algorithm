import java.util.Scanner;

public class YetAnotherXORProblem {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		for (int i = 0; i < t; i++) {
			int n = s.nextInt();
			int k = s.nextInt();
			int[] arr = new int[n];
			for (int j = 0; j < n; j++) {
				arr[i] = s.nextInt();
			}
			long result = fun(arr, k);
			System.out.println(result);

		}

	}

	private static long fun(int[] arr, int k) {
		long n = arr.length;
		long max = -1;
		for (int i = 0; i < n; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		long x = (long) (Math.log(max) / Math.log(2));
//		System.out.println("x= "+x);
		long m = (long) Math.pow(2, x+1);
		m=m-1;
//		System.out.println("m= "+m);
		long[][] temp = new long[(int) (n + 1)][(int) (m + 1)];
		
		temp[0][0]=1;

		for (int i = 1; i < n + 1; i++) {
			for (int j = 0; j < m + 1; j++) {
				temp[i][j]=temp[i-1][j]+temp[i-1][j^arr[i-1]];
			}
		}
		long a = 0;
		long b = 0;
		long c = 0;
		for (int i = 0; i < m + 1; i++) {
			if (i < k)
				a = a + temp[(int) n][i];
			else if (i == k)
				b = b + temp[(int) n][i];
			else
				c = c + temp[(int) n][i];
		}
		long MOD=1000000007;
		long q=(a+b)%MOD;
		long   r=(b+c)%MOD;
		long   s=(c+a)%MOD;
		long   t=(a+b+c)%MOD;
		long result=(q*q)%MOD+(r*r)%MOD+(s*s)%MOD-(t*t)%MOD;

		return result;
	}

}
