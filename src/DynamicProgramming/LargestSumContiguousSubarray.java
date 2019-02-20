package DynamicProgramming;

public class LargestSumContiguousSubarray {
	public static void main(String[] args) {
		int[] a = { -2, -3, -4, -1, -2, -1, -5, -3 };
		System.out.println("Maximum contiguous sum is " + maxSubArraySum(a));
	}

	private static int maxSubArraySum(int[] a) {
		int n = a.length;

		int max = Integer.MIN_VALUE;
		int max_till_now = 0;
		int s = 0, start = 0, end = 0;

		for (int i = 0; i < n; i++) {
			max_till_now += a[i];

			if (max_till_now > max) {
				max = max_till_now;
				end = i;
				start = s;

			}

			if (max_till_now < 0) {
				max_till_now = 0;
				s = i + 1;
			}

		}

		System.out.println("start= " + start + " end= " + end);

		return max;
	}

}
