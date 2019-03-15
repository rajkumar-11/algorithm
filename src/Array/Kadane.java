package Array;

public class Kadane {
	public static void main(String[] args) {
		int[] arr = { -1, 2, 3, -1, 4, 3, -10, -5, -4 };
		System.out.println(Kadane(arr));

	}

	private static int Kadane(int[] sum) {
		int[] result = new int[3];

		result[0] = sum[0];
		int start = 0;
		int end = 0;
		result[1] = 0;
		result[2] = 0;
		int tempmax = sum[0];
		for (int i = 1; i < sum.length; i++)
		{
			if (tempmax <= 0) 
			{
				start = i;
//				end = i;
				tempmax = sum[i];
			} else {
				tempmax += sum[i];
				end=i;
			}

			if (tempmax > result[0]) {
				result[0] = tempmax;
				result[1] = start;
				result[2] = end;
			}

		}

		System.out.println("start= " + result[1] + " end= " +result[2]);

		return result[0];

		// return 0;
	}
}
