package DynamicProgramming;

public class UglyNumbers {
	public static void main(String[] args) {
		int no = getNthUglyNo(150);
		System.out.println("150th ugly " + "no. is " + no);

	}

	private static int getNthUglyNo(int n) {
		if (n == 1)
			return 1;
		int count = 1;
		int i = 1;
		int num = 1;

		while (count < n) {
			i = i + 1;

			if (isUgly(i)) {
				count += 1;
				num = i;
			}
//			System.out.println(count + " " + i);

		}
		return num;
	}

	private static boolean isUgly(int n) {
		n = divide(n, 2);
		n = divide(n, 3);
		n = divide(n, 5);

		return n == 1 ? true : false;
	}

	private static int divide(int a, int b) {
		if (a == 0)
			return 0;

		while (a % b == 0) {
			a = a / b;

		}

		return a;
	}
}
