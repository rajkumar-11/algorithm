package DynamicProgramming;

public class WeightedJobScheduling {
	public static void main(String[] args) {
		TimeProfit[] arr = { new TimeProfit(3, 5, 400), new TimeProfit(5, 6, 20), new TimeProfit(4, 7, 50) };

		int n = 3;
		System.out.println("The optimal profit is " + findMAxProfit(arr, n));

	}

	private static int findMAxProfit(TimeProfit[] arr, int n) {
		int maxProfit = Integer.MIN_VALUE;

		for (int i = 0; i < n; i++) {
			int profit = 0;
			for (int j = 0; j < i; j++) {
				if (arr[j].end <= arr[i].start && arr[j].profit + arr[i].profit > profit) {
					profit = arr[j].profit + arr[i].profit;

				}

			}

			if (profit > maxProfit) {
				maxProfit = profit;
			}

		}

		System.out.println("maxProfit " + maxProfit);
		return 0;
	}
}

class TimeProfit {
	int start, end, profit;

	public TimeProfit(int start, int end, int profit) {
		this.start = start;
		this.end = end;
		this.profit = profit;

	}

}