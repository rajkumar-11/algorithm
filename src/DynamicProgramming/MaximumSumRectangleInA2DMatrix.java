package DynamicProgramming;

public class MaximumSumRectangleInA2DMatrix {

	public static void main(String[] args) throws java.lang.Exception {
		findMaxSubMatrix(
				new int[][] { { 1, 2, -1, -4, -20 }, { -8, -3, 4, 2, 1 }, { 3, 8, 10, 1, 3 }, { -4, -1, 1, 7, -6 } });
	}

	private static void findMaxSubMatrix(int[][] a) {
		int cols = a[0].length;
		int rows = a.length;
		int[] currentResult;
		int maxSum = Integer.MIN_VALUE;
		int left = 0;
		int top = 0;
		int right = 0;
		int bottom = 0;

		for (int left_col = 0; left_col < cols; left_col++) {
			int[] temp = new int[rows];

			for (int right_col = left_col; right_col < cols; right_col++) {
				for (int i = 0; i < rows; i++) {
					temp[i] += a[i][right_col];
				}

				currentResult = kadane(temp);

				if (currentResult[0] > maxSum) {
					maxSum = currentResult[0];
					left = left_col;
					right = right_col;
					top = currentResult[1];
					bottom = currentResult[2];

				}

			}

		}

		System.out.println("The maximum sum will be = " + maxSum + "  from row " + top + "  to row " + bottom
				+ "  and from column " + left + "  to column " + right);

	}

	private static int[] kadane(int[] temp) {
		int[] result = new int[3];

		int max = Integer.MIN_VALUE;
		int max_till_now = 0;

		int l = temp.length;
		int start = 0, s = 0, end = 0;

		for (int i = 0; i < l; i++) {
			max_till_now += temp[i];

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
		result[0] = max;
		result[1] = start;
		result[2] = end;

		System.out.println("max= " + result[0] + " top= " + result[1] + "  bottom= " + result[2]);

		return result;
	}

}
